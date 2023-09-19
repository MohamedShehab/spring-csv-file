package com.example.springbootuploadcsv.service;

import com.example.springbootuploadcsv.model.Tutorial;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriteFile {

    public static void main(String[] args) {
        var fileName = "F:/Book1.txt";
        try (OutputStream fileInputStream = new FileOutputStream(fileName);
             BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fileInputStream ,
                     StandardCharsets.UTF_8))) {
            Tutorial tutorial = new Tutorial();
            tutorial.setId(1L);
            tutorial.setTitle("Java");
            tutorial.setDescription("Java");
            tutorial.setPublished(true);
            br.write(tutorial.toString());
        } catch (Exception e) {
            System.out.println("=========================================");
        }
    }
}
