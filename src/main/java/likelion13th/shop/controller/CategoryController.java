package likelion13th.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import likelion13th.shop.domain.Category;
import likelion13th.shop.global.api.ApiResponse;
import likelion13th.shop.global.api.SuccessCode;
import likelion13th.shop.global.exception.GeneralException;
import likelion13th.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // ✅ 카테고리 전체 조회
    @GetMapping
    @Operation(summary = "전체 카테고리 조회", description = "모든 카테고리를 조회합니다.")
    public ApiResponse<?> getAllCategories() {
        log.info("카테고리 전체 조회 요청 수신");
        List<Category> categories = categoryService.getAllCategories();

        return ApiResponse.onSuccess(SuccessCode.CATEGORY_ITEMS_GET_SUCCESS, categories);
    }

    // ✅ 개별 카테고리 조회
    @GetMapping("/{categoryId}")
    @Operation(summary = "카테고리 단일 조회", description = "ID에 해당하는 카테고리를 조회합니다.")
    public ApiResponse<?> getCategoryById(@PathVariable Long categoryId) {
        log.info("카테고리 단일 조회 요청 수신: ID = {}", categoryId);

        Category category = categoryService.getCategoryById(categoryId);

        return ApiResponse.onSuccess(SuccessCode.CATEGORY_ITEMS_GET_SUCCESS, category);
    }

    // ✅ 카테고리 생성
    @PostMapping
    @Operation(summary = "카테고리 생성", description = "새로운 카테고리를 생성합니다.")
    public ApiResponse<?> createCategory(@RequestBody Category request) {
        log.info("카테고리 생성 요청 수신");

        try {
            Category newCategory = categoryService.createCategory(request.getName());
            return ApiResponse.onSuccess(SuccessCode.CATEGORY_ITEMS_GET_SUCCESS, newCategory);
        } catch (GeneralException e) {
            log.error("❌ [ERROR] 카테고리 생성 실패: {}", e.getReason().getMessage());
            throw e;
        }
    }

    // ✅ 카테고리 수정
    @PutMapping("/{categoryId}")
    @Operation(summary = "카테고리 수정", description = "카테고리 이름을 수정합니다.")
    public ApiResponse<?> updateCategory(@PathVariable Long categoryId, @RequestBody Category request) {
        log.info("카테고리 수정 요청 수신");

        try {
            Category updated = categoryService.updateCategory(categoryId, request.getName());
            return ApiResponse.onSuccess(SuccessCode.CATEGORY_ITEMS_GET_SUCCESS, updated);
        } catch (GeneralException e) {
            log.error("❌ [ERROR] 카테고리 수정 실패: {}", e.getReason().getMessage());
            throw e;
        }
    }

    // ✅ 카테고리 삭제
    @DeleteMapping("/{categoryId}")
    @Operation(summary = "카테고리 삭제", description = "카테고리를 삭제합니다.")
    public ApiResponse<?> deleteCategory(@PathVariable Long categoryId) {
        log.info("카테고리 삭제 요청 수신");

        try {
            categoryService.deleteCategory(categoryId);
            return ApiResponse.onSuccess(SuccessCode.CATEGORY_DELETE_SUCCESS, "카테고리 삭제 완료");
        } catch (GeneralException e) {
            log.error("❌ [ERROR] 카테고리 삭제 실패: {}", e.getReason().getMessage());
            throw e;
        }
    }
}

// 카테고리 관련 CRUD API 구현
// orderApi 패턴 참고하여서 구현함.
// 일관된 응답 형식 유지와 @Operation 어노테이션을 사용하여 Swagger 문서화.
