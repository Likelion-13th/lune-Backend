package likelion13th.shop.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private String zipcode; // 우편번호
    private String address; // 기본 주소
    private String addressDetail; // 상세 주소

    public AddressRequest(String zipcode, String address) {
        this.zipcode = zipcode;
        this.address = address;
        this.addressDetail = "";
    }
}

// 사용자 주소 정보를 받아오기 위한 요청 DTO
// 우편번호, 기본 주소, 상세 주소를 포함하고 있음.