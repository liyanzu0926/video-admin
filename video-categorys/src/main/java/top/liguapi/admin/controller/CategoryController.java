package top.liguapi.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.liguapi.admin.entity.dto.CategoryDTO;
import top.liguapi.admin.entity.pojo.Category;
import top.liguapi.admin.service.CategoryService;
import top.liguapi.admin.utils.JSONUtils;

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

    // 获取分类列表
    @RequestMapping
    public List<CategoryDTO> categories(String token) {
        return categoryService.query();
    }

    // 修改
    @RequestMapping("{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category, String token) {
        category.setId(id);
        log.info("更新类别信息：{}", JSONUtils.writeValueAsString(category));
        return categoryService.update(category);
    }

    // 添加
    @PostMapping
    public CategoryDTO insert(String token, @RequestBody Category category) {
        log.info("添加类别信息：{}", JSONUtils.writeValueAsString(category));
        return categoryService.insert(category);
    }

    // 删除
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id, String token) {
        log.info("删除类别id：{}", id);
        categoryService.delete(id);
    }
}
