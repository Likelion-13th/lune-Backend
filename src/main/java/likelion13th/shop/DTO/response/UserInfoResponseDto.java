package likelion13th.shop.DTO.response;

import likelion13th.shop.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponseDto {
    private String nickname;
    private String phoneNumber;

    public static UserInfoResponseDto from(User user) {
        return new UserInfoResponseDto(
            user.getNickname(),
            user.getPhoneNumber()
        );
    }
}

// 사용자 정보를 반환하기 위한 DTO
// 사용자 닉네임과 전화번호를 포함하고 있음.