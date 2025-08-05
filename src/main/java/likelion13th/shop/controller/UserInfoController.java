package likelion13th.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import likelion13th.shop.domain.User;
import likelion13th.shop.DTO.response.*;
import likelion13th.shop.global.api.SuccessCode;
import likelion13th.shop.global.api.ApiResponse;
import likelion13th.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserInfoController {
    private final UserRepository userRepository;

    private final Long mockUserId = 1L; //jwt 연동이 아직 안되어 임시 로그인 아이디.

    // ✅ 사용자 정보 조회
    @GetMapping("/info")
    @Operation(summary = "사용자 정보 조회", description = "로그인한 사용자의 정보를 조회합니다.")
    public ResponseEntity<ApiResponse<UserInfoResponseDto>> getUserInfo(@RequestParam Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        UserInfoResponseDto responseDto = new UserInfoResponseDto(
                user.getNickname(),
                user.getPhoneNumber()
        );

        return ResponseEntity.ok(ApiResponse.onSuccess(SuccessCode.USER_INFO_GET_SUCCESS, responseDto));
    }

    // ✅ 사용자 마일리지 조회
    @GetMapping("/mileage")
    @Operation(summary = "사용자 마일리지 조회", description = "로그인한 사용자의 마일리지를 조회합니다.")
    public ResponseEntity<ApiResponse<UserMileageResponseDto>> getUserMileage(@RequestParam Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        UserMileageResponseDto responseDto = UserMileageResponseDto.from(user);

        return ResponseEntity.ok(ApiResponse.onSuccess(SuccessCode.USER_MILEAGE_GET_SUCCESS, responseDto));
    }

    // ✅ 사용자 주소 조회
    @GetMapping("/address")
    @Operation(summary = "사용자 주소 조회", description = "로그인한 사용자의 주소를 조회합니다.")
    public ResponseEntity<ApiResponse<AddressResponseDto>> getUserAddress(@RequestParam Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        AddressResponseDto responseDto = AddressResponseDto.from(user.getAddress());

        return ResponseEntity.ok(ApiResponse.onSuccess(SuccessCode.USER_ADDRESS_GET_SUCCESS, responseDto));
    }
}

// 사용자 관련 정보(이름, 주소, 보유 마일리지) 조회 기능을 제공함.
//@Operation 어노테이션을 사용하여 Swagger 문서화
//일관된 응답 포맷 + jwt 연동이 아직 안되어 임시 로그인 아이디를 추가함.