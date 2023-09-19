package com.example.springbootuploadcsv.service;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadFile {

    public static void main(String[] args) {
        char[] array = new char[14];
        var fileName = "F:/Book.txt";
        try (InputStream fileInputStream = new FileInputStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(
                     fileInputStream, StandardCharsets.UTF_8))) {

            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            System.out.println(stringBuilder);
        } catch (Exception e) {
            System.out.println("=========================================");
        }
    }
}
