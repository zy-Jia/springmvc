package com.gyofu.validator;

import com.gyofu.entity.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AccountValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Account.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", null, "姓名不能为空");
        ValidationUtils.rejectIfEmpty(errors, "password", null, "密码不能为空 ");
    }
}
