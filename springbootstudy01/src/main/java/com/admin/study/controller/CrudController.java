package com.admin.study.controller;

import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.newtwork.Header;
import com.admin.study.service.BaseService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req,Res> {

    protected BaseService<Req, Res, Entity> baseService;

    @Override
    @PostMapping("")
    public Header<Res> create(@RequestBody Header<Req> requset) {
        return baseService.create(requset);
    }

    @Override
    @GetMapping("{id}")
    public Header<Res> read( @PathVariable Long id) {
        return baseService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<Res> update(@RequestBody  Header<Req> reqest) {
        return baseService.update(reqest);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return baseService.delete(id);
    }
}
