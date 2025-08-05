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
