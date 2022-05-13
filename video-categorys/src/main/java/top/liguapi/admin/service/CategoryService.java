package top.liguapi.admin.service;

import top.liguapi.admin.entity.dto.CategoryDTO;
import top.liguapi.admin.entity.pojo.Category;

import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/13 20:45
 */
public interface CategoryService {
    List<CategoryDTO> query();

    Category update(Integer id, Category category);

    CategoryDTO insert(Category category);

    void delete(Integer id);
}
