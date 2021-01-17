package com.admin.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 설정파이에 대한것
@EnableJpaAuditing // 감시 활성하 시키 겠다
public class JpaConfig {
}
