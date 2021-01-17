package com.admin.study.controller.api;


import com.admin.study.controller.CrudController;
import com.admin.study.model.entity.Partner;
import com.admin.study.model.newtwork.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiController, PartnerApiResponse, Partner> {

}
