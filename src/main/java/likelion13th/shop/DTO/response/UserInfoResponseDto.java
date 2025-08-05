package likelion13th.shop.DTO.response;

import likelion13th.shop.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponseDto {
    private String nickname;
    private String phoneNumber;

    public UserInfoResponseDto from(User user) {
        return new UserInfoResponseDto(
            user.getNickname(),
            user.getPhoneNumber()
        );
    }
}
