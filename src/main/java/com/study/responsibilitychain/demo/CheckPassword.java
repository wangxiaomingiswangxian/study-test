package com.study.responsibilitychain.demo;

import com.study.responsibilitychain.AbstractHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 王贤
 */
@Component
@Order(value = 1)
public class CheckPassword extends AbstractHandler<User> {
    @Override
    protected void doFilter(User object) {
        System.out.println("校验密码");
    }
}
