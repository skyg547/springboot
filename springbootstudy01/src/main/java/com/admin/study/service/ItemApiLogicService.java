package com.admin.study.service;


import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.entity.Item;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.request.ItemApiRequest;
import com.admin.study.model.newtwork.response.ItemApiResponse;
import com.admin.study.repository.ItemRepository;
import com.admin.study.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item> {


    @Autowired
    private PartnerRepository partnerRepository;


    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> requset) {


        ItemApiRequest body = requset.getData();
//      안전하게 확인

//        if(body != null){
//
//        }

        Item item = Item.builder()
                .status(body.getStatus())
                .name(body.getName())
                .title(body.getTitle())
                .content(body.getContent())
                .price(body.getPrice())
                .brandName(body.getBrandName())
                .registeredAt(LocalDateTime.now())
                .partner(partnerRepository.getOne(body.getPartnerId()))
                .build();

        Item newItem = baseRepository.save(item);
        return response(newItem);
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(item -> response(item))
                .orElseGet(()-> Header.ERROR("데이터 없음"));


    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> reqest) {

            ItemApiRequest body = reqest.getData();

            return baseRepository.findById(body.getId())
                    .map(entityItem -> {
                        entityItem
                                .setStatus(body.getStatus())
                                .setName(body.getName())
                                .setTitle(body.getTitle())
                                .setContent(body.getContent())
                                .setBrandName(body.getBrandName())
                                .setRegisteredAt(body.getRegisteredAt())
                                .setUnregisteredAt(body.getUnregisteredAt());

                        return entityItem;

                    })
                    .map(newEntityItem -> {
                        baseRepository.save(newEntityItem);
                        return newEntityItem;
                    })
                    .map(item -> response(item))
                    .orElseGet(()->Header.ERROR("데이터가 없다"));


    }

    @Override
    public Header delete(Long id) {
       return baseRepository.findById(id)
                .map(item -> {
                    baseRepository.delete(item);
                    return Header.Ok();
                })
                .orElseGet(()->Header.ERROR("데이터없음"));
    }


    public Header<ItemApiResponse> response(Item item){

        ItemApiResponse body = ItemApiResponse.builder()
                                .id(item.getId())
                                .status(item.getStatus())
                                .name(item.getName())
                                .title(item.getTitle())
                                .content(item.getContent())
                                .price(item.getPrice())
                                .brandName(item.getBrandName())
                                  .registeredAt(item.getRegisteredAt())
                                .unregisteredAt(item.getUnregisteredAt())
                                 .partnerId(item.getPartner().getId())
                                 .build();

        return Header.Ok(body);
    }
}
