package com.admin.study.repository;

import com.admin.study.StudyApplication;
import com.admin.study.model.entity.Item;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class ItemRepositoryTest   {

    @Autowired
    private  ItemRepository itemRepository;
    @Test
    public  void create(){

        Item item = new Item();
        item.setName("노트북");
        item.setContent("삼성 노트북");

        Item newItem = itemRepository.save(item);

    }
    @Test
    public  void read(){
            Long id = 1L;

            Optional<Item> item = itemRepository.findById(id);

            //Assert.assertTrue(item.)
    }
}
