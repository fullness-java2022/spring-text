package com.example.demo.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemFormValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return ItemForm.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ItemForm form = (ItemForm)target;
		// 相関チェックする項目がnullだヌルポの例外が発生するので早期退出させる
		if(form.getName() == null || form.getPrice() == null) return;
		if(form.getPrice() < 1000 && form.getName().equals("パソコン")) {
			errors.reject("com.example.demo.form.ItemForm.message");
		}
	}
}
