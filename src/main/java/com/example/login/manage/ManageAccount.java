package com.example.login.manage;

import com.example.login.file.FileAccountCSV;
import com.example.login.model.Account;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ManageAccount {
    List<Account> accountList = new ArrayList<>();

    public static Account currentAccount = null;

    public ManageAccount() {
        FileAccountCSV.readFile(accountList);
    }

    public boolean login(String username, String password) {
        for (Account account: accountList) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                currentAccount = account ;
                return true;
            }
        }
        return false;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public int findByUsername(String name) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUsername().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int findById(String usn) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUsername().equals(usn)) {
                return i;
            }
        }
        return -1;
    }

    public void add(Account account) {
        accountList.add(account);
    }

    public void edit(Account account, String usn) {
        accountList.set(findById(usn), account);
    }

    public void deleteById(String usn) {
        accountList.remove(findById(usn));
    }

    public void print() {
        for (Account a : accountList) {
            System.out.println(a);
        }
    }
}
