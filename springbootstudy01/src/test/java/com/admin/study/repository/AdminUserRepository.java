package com.admin.study.repository;

import com.admin.study.StudyApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

public class AdminUserRepository extends StudyApplication {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create(){}

}
