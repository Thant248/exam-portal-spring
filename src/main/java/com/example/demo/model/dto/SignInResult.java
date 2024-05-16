package com.example.demo.model.dto;

import com.example.demo.model.entity.Account.Role;

public record SignInResult(
		int id,
		String name,
		String email,
		Role role,
		String token
		) {

	public static SignInResult from(AccountDto account, String token) {
		return new SignInResult(account.id(), 
				account.name(), 
				account.email(), 
				account.role(), 
				token);
	}

}
