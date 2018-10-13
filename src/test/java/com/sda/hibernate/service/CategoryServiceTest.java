package com.sda.hibernate.service;

import com.sda.hibernate.dao.CategoryDao;
import com.sda.hibernate.entity.Category;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryServiceTest {

    private static CategoryDao categoryDao;

    @BeforeEach
    public void beforeTests(){
        categoryDao = new CategoryDao();
        categoryDao.openCurrentSession();
    }

    @org.junit.jupiter.api.Test
    public void save() {
        Category category = new Category();
        category.setName("Testowa Kategoria");
        assertNotNull(categoryDao.save(category));
    }
}