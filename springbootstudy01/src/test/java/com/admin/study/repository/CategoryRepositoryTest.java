package com.admin.study.repository;


import com.admin.study.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class CategoryRepositoryTest{

    @Autowired
    private  CategoryRepository categoryRepository;


    @Test
    public void create(){
        String type = "Computer";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);


        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(), type);
        Assertions.assertEquals(newCategory.getTitle(), title);
    }
//
//    @Test
//    public void read(){
//
////        String type =
////
////        Optional<Category> optionalCategory = categoryRepository.findByType("COMPUTER");
////
////        optionalCategory.ifPresent(c ->{
////            a
////            System.out.println((c.getId()));
////            System.out.println(c.getType());
////            System.out.println(c.getTitle());
//
//        });

//    }

}
