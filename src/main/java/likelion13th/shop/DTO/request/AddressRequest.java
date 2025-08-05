package likelion13th.shop.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private String zipcode;
    private String address;
    private String addressDetail;

    public AddressRequest(String zipcode, String address) {
        this.zipcode = zipcode;
        this.address = address;
        this.addressDetail = addressDetail;
    }
}
