package com.admin.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // 기본 적인 get,set 생성자 추가
@AllArgsConstructor // 모든 생성자에  파라미터별  추가
public class SearchParam {
    //{"account" : "", "email" : "", "page" : 0}
    private String account;
    private String email;
    private int page;

//    public SearchParam(){
//
//
//    }
//
//    public SearchParam(String account){
//        this.account = account;
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
