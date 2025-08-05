package likelion13th.shop.domain;

import jakarta.persistence.*;
import likelion13th.shop.domain.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Table(name = "categories") // 예약어 회피
@NoArgsConstructor
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // 연관관계 (추후 필요 시 상품 리스트 추가)
    // @OneToMany(mappedBy = "category")
    // private List<Item> items = new ArrayList<>();

    // 생성자
    public Category(String name) {
        this.name = name;
    }

    // 수정 메서드
    public void updateName(String name) {
        this.name = name;
    }
}