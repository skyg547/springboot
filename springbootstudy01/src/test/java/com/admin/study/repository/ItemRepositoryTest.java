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

public class ItemRepositoryTest extends StudyApplication {

    @Autowired
    private  ItemRepository itemRepository = new ItemRepository() {
        @Override
        public List<Item> findAll() {
            return null;
        }

        @Override
        public List<Item> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Item> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Item> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Item> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<Item> entities) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Item getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends Item> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Item> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Item> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Item> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Item> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Item entity) {

        }

        @Override
        public void deleteAll(Iterable<? extends Item> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Item> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Item> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Item> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Item> boolean exists(Example<S> example) {
            return false;
        }
    };

    @Test
    public  void create(){

        Item item = new Item();
        item.setName("노트북");
        item.setPrice(10000);
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
