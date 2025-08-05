package likelion13th.shop.repository;

import likelion13th.shop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCategory_Id(Long categoryId);
}

// 상품을 카테고리별로 조회하기 위함.
// 기본 메서드를 사용함.