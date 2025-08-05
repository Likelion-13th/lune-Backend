package likelion13th.shop.DTO.response;

import likelion13th.shop.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemResponseDto {
    private Long id;
    private String name;
    //private String description;
    private int price;
    //private int stockQuantity;

    public static ItemResponseDto from(Item item) {
        return new ItemResponseDto(
            item.getId(),
            item.getName(),
            item.getPrice()
        );
    }
}

// 상품 정보를 반환하기 위힌 DTO
// 상품의 고유 ID, 이름, 가격을 포함하고 있음.
// 추가적으로 상품 설명(description)과 재고 수량(stockQuantity)을 포함할 수 있음.
// 현재는 주석 처리되어 있음.