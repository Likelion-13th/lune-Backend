package likelion13th.shop.service;

import jakarta.transaction.Transactional;
import likelion13th.shop.domain.Category;
import likelion13th.shop.global.api.ErrorCode;
import likelion13th.shop.global.exception.GeneralException;
import likelion13th.shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //모든 카테고리 조회
    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    //카테고리 생성
    @Transactional
    public Category createCategory(String name) {
        if(categoryRepository.existsByName(name)){
            throw new GeneralException(ErrorCode.CATEGORY_ALREADY_EXISTS);
        }

        Category category = new Category(name);
        return categoryRepository.save(category);
    }

    //카테고리 단일 조회 (Optional 활용)
    @Transactional
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new GeneralException(ErrorCode.CATEGORY_NOT_FOUND));
    }

    //카테고리 수정
    @Transactional
    public Category updateCategory(Long id, String newName) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new GeneralException(ErrorCode.CATEGORY_NOT_FOUND));
        category.updateName(newName);
        return categoryRepository.save(category);
    }

    //카테고리 삭제
    @Transactional
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new GeneralException(ErrorCode.CATEGORY_NOT_FOUND));
        categoryRepository.delete(category);
    }
}

// 비즈니스 로직을 처리하는 클래스
// 조회, 생성, 수정, 삭제 기능 구현과 예외처리를 일관성 있게함.