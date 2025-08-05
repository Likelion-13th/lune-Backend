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
