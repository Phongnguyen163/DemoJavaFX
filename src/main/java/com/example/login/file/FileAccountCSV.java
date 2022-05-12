package com.example.login.file;

import com.example.login.model.Account;

import java.io.*;
import java.util.List;

public class FileAccountCSV {

    public static void writeFile(List<Account> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\main\\java\\com\\example\\login\\database\\account.csv"))) {
            bufferedWriter.write("USERNAME, PASSWORD");
            bufferedWriter.newLine();
            for (Account account: list) {
                bufferedWriter.write(account.getUsername() + "," + account.getPassword());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile(List<Account> list) {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\com\\example\\login\\database\\account.csv"))){
//            bufferedReader.readLine();
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] arr = line.split(",");
                String username = arr[0];
                String password = arr[1];
                list.add(new Account(username, password));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
