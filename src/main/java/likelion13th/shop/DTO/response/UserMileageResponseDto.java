package likelion13th.shop.DTO.response;

import likelion13th.shop.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserMileageResponseDto {
    private int mileage;

    public static UserMileageResponseDto from(User user) {
        return new UserMileageResponseDto(user.getMileage());
    }
}
