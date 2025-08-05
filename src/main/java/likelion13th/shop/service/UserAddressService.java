package likelion13th.shop.service;

import jakarta.transaction.Transactional;
import likelion13th.shop.DTO.request.AddressRequest;
import likelion13th.shop.DTO.response.AddressResponseDto;
import likelion13th.shop.domain.Address;
import likelion13th.shop.domain.User;
import likelion13th.shop.global.exception.GeneralException;
import likelion13th.shop.global.api.ErrorCode;
import likelion13th.shop.login.auth.jwt.CustomUserDetails;
import likelion13th.shop.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserAddressService {
    private final UserRepository userRepository;

    // 사용자 주소 조회
    public AddressResponseDto getUserAddress(CustomUserDetails userDetails) {
        User user = userRepository.findById(userDetails.getUserId())
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        return AddressResponseDto.from(user.getAddress());
    }

    // 사용자 주소 수정
    public AddressResponseDto updateUserAddress(CustomUserDetails userDetails, AddressRequest addressRequest) {
        User user = userRepository.findById(userDetails.getUserId())
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        Address newAddress = new Address(
                addressRequest.getZipcode(),
                addressRequest.getAddress(),
                addressRequest.getAddressDetail()
        );

        user.updateAddress(newAddress);
        return AddressResponseDto.from(user.getAddress());
    }
}

// 사용자 주소 조회 및 수정 기능을 제공하는 클래스
// 사용자의 인증된 정보를 기반으로 해당하는 사용자의 주소를 조회 및 수정할 수 있음.