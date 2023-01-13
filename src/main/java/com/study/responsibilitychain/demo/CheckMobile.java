package com.study.responsibilitychain.demo;

import com.study.responsibilitychain.AbstractHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class CheckMobile extends AbstractHandler<User> {
    @Override
    protected void doFilter(User object) {
        System.out.println("校验手机");
    }
}
