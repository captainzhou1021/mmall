package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(String categoryName,Integer categoryId);
    ServerResponse<List<Category>> getChildrentParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>>selectCategoryAndChildrentById(Integer categoryId);
}
