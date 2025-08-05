package likelion13th.shop.DTO.response;

import likelion13th.shop.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressResponseDto {
    private String zipcode;
    private String address;
    private String addressDetail;

    public static AddressResponseDto from(Address address) {
        return new AddressResponseDto(
            address.getZipcode(),
            address.getAddress(),
            address.getAddressDetail()
        );
    }
}

// 사용자의 주소 정보를 반환하기 위한 응답 DTO
// 어노테이션을 사용해 생성자와 getter 메서드를 자동으로 생성함.