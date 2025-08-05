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

// 사용자 마일리지 정보를 반환하기 위한 DTO
// 사용자 객체에서 마일리지 정보를 추출하여 반환함.
// User 객체의 getMileage()를 통해 마일리지 값을 가져옴.