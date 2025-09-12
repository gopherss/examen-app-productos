package com.nttdata.product_ms.mapper;

import com.nttdata.product_ms.model.dto.CategoryDto;
import com.nttdata.product_ms.model.dto.CategorySaveRequestDto;
import com.nttdata.product_ms.model.dto.CategorySaveResponseDto;
import com.nttdata.product_ms.model.dto.CategoryUpdateRequestDto;
import com.nttdata.product_ms.model.entity.Category;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto map(Category category);

    List<CategoryDto> map(List<Category> categories);

    Category toEntity(CategorySaveRequestDto dto);

    Category toEntity(CategoryUpdateRequestDto dto);

    CategorySaveResponseDto toCategorySaveResponseDto(Category category);

    @AfterMapping
    default void setRemainingValues(Category category, @MappingTarget CategoryDto dto) {
        dto.setId(category.getId());
    }
}
