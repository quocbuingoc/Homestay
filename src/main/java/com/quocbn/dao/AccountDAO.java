package com.quocbn.dao;

import java.util.List;

import com.quocbn.model.Account;

public interface AccountDAO {
	public List<Account> listAll();
	public Account findAccountByName(String name);
	public void addAccount(Account account);
	public void updateAccount(Account acc);
	public List<Account> listAccountByUsername(String username);
	public List<Account> listHostAccount();
}
