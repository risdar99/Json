package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("files/file.txt");
        List<User> userList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file)) {
            Scanner scanner = new Scanner(fis);

            String[] headers = scanner.nextLine().split(" ");

            while (scanner.hasNext()) {
                String[] values = scanner.nextLine().split(" ");
                String name = values[0];
                int age = Integer.parseInt(values[1]);
                User user = new User(name, age);
                userList.add(user);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);
        System.out.println(json);

        }
    }



