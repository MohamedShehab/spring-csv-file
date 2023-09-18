package com.example.springbootuploadcsv.service;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadFile {

    public static void main(String[] args) {
        char[] array = new char[14];
        var fileName = "F:/Book1.csv";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8))) {

            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                System.out.println(stringBuilder);
            }

        } catch (Exception e) {
            System.out.println("=========================================");
        }
    }
}
