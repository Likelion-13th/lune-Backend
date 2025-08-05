package likelion13th.shop.login.auth.service;

import likelion13th.shop.domain.User;
import likelion13th.shop.global.api.ErrorCode;
import likelion13th.shop.global.exception.GeneralException;
import likelion13th.shop.login.auth.jwt.CustomUserDetails;
import likelion13th.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    //providerId를 기준으로 사용자 인증 정보를 로드
    @Override
    public UserDetails loadUserByUsername(String providerId) throws UsernameNotFoundException {
        log.info("✅ [CustomUserDetailsService] loadUserByUsername 호출: providerId = {}", providerId);

        User user = userRepository.findByProviderId(providerId)
                .orElseThrow(() -> {
                    log.error("❌ 사용자 정보를 찾을 수 없습니다: providerId = {}", providerId);
                    return new GeneralException(ErrorCode.USER_NOT_FOUND);
                });

        return new CustomUserDetails(user);
    }
}

// 사용자가 로그인 시, 사용자 정보를 찾기 위함.