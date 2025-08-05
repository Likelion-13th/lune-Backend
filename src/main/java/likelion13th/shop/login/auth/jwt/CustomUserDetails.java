package likelion13th.shop.login.auth.jwt;

import likelion13th.shop.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class CustomUserDetails implements UserDetails {

    private final Long userId;        // 실제 DB상의 ID
    private final String providerId;  // 카카오에서 온 식별자

    private final User user;

    public CustomUserDetails(User user) {
        this.userId = user.getId();
        this.providerId = user.getProviderId();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    // ✅ 사용자 식별자 반환
    public String getProviderId() {
        return providerId;
    }

    public Long getUserId() {
        return userId;
    }

    // ✅ 권한은 필요시 수정
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // 권한 없음
    }

    // ✅ 패스워드 로그인 안 쓰면 null 가능
    @Override
    public String getPassword() {
        return null;
    }

    // ✅ providerId를 username처럼 사용
    @Override
    public String getUsername() {
        return providerId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}