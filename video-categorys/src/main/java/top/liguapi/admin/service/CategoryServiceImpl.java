package top.liguapi.admin.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liguapi.admin.entity.dto.CategoryDTO;
import top.liguapi.admin.entity.pojo.Category;
import top.liguapi.admin.entity.pojo.CategoryExample;
import top.liguapi.admin.mapper.CategoryMapper;

import java.util.Date;
import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/13 20:46
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> query() {
        return categoryMapper.queryCategoryList();
    }

    @Override
    public Category update(Category category) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andIdEqualTo(category.getId());
        category.setUpdatedAt(new Date());
        categoryMapper.updateByExampleSelective(category, categoryExample);
        return categoryMapper.selectByPrimaryKey(category.getId());
    }

    @Override
    public CategoryDTO insert(Category category) {
        Date date = new Date();
        category.setCreatedAt(date);
        category.setUpdatedAt(date);
        categoryMapper.insertSelective(category);
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category, categoryDTO);
        return categoryDTO;
    }

    @Override
    public void delete(Integer id) {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andIdEqualTo(id);
        example.or().andParentIdEqualTo(id);
        categoryMapper.deleteByExample(example);
    }
}
