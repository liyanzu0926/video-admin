package top.liguapi.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.liguapi.admin.entity.dto.CategoryDTO;
import top.liguapi.admin.entity.pojo.Category;
import top.liguapi.admin.service.CategoryService;

import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/13 20:46
 */
@RestController
@RequestMapping("admin/categories")
@Slf4j
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping
    public List<CategoryDTO> categories(String token){
        return categoryService.query();
    }

    @RequestMapping("{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category, String token){
        return categoryService.update(id, category);
    }

    @PostMapping
    public CategoryDTO insert(String token, @RequestBody Category category){
        return categoryService.insert(category);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Integer id, String token){
        categoryService.delete(id);
    }
}
