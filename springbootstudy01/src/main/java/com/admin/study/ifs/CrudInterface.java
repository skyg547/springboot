package com.admin.study.ifs;

import com.admin.study.model.newtwork.Header;

public interface CrudInterface<Req,Res> {

    Header<Res> create(Header<Req> requset); //todo 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> reqest);

    Header delete(Long id);
}
