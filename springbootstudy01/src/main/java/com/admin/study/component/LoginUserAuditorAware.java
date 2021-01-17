package com.admin.study.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component // 컴포넌트란 표시
public class LoginUserAuditorAware implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("AdminServer");

    }
}
