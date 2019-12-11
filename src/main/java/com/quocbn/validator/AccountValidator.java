package com.quocbn.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.quocbn.dao.AccountDAO;
import com.quocbn.model.Account;

@Service
public class AccountValidator implements Validator {
	
	@Autowired(required = true)
	@Qualifier(value = "accountDao")
	private AccountDAO accountDao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName","Field is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passWord", "required.passWord","Field is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required.confirmPassword","Field is required");
		
		Account acc = (Account) target;
		if (acc.getUserName().length() < 6 || acc.getUserName().length() > 32) {
            errors.rejectValue("userName", "length.userName");
        }
		if (acc.getPassWord().length() < 6 || acc.getUserName().length() > 32) {
            errors.rejectValue("passWord", "length.passWord");
        }
		if(!(acc.getPassWord().equals(acc.getConfirmPassword()))){
			errors.rejectValue("passWord","notmatch.passWord");
		}
		
		Account username = accountDao.findAccountByName(acc.getUserName());
		if(username!=null){
			errors.rejectValue("userName","exist.userName");
		}
	}

}
