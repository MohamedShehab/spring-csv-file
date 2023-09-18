package com.example.springbootuploadcsv.service;

import com.example.springbootuploadcsv.model.Tutorial;
import com.example.springbootuploadcsv.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    public TutorialRepository tutorialRepository;

    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = CSVHelper.parseCSVToTutorial(file.getInputStream());
            tutorialRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = tutorialRepository.findAll();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }
}
