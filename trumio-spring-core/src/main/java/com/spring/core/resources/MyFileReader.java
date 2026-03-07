package com.spring.core.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class MyFileReader {

    @Autowired
    private ResourceLoader resourceLoader;

    public void readFile(String location) {
        try {
            // 1. Get the Resource handle
            Resource resource = resourceLoader.getResource(location);

            // This is where the actual network connection happens!
            if (resource.exists() && resource.isReadable()) {
                // 2. Read the content
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(resource.getInputStream()))) {
                    String content = reader.lines().collect(Collectors.joining("\n"));

                    System.out.println("--- Reading from: " + location + " ---");
                    System.out.println("File exists: " + resource.exists());
                    System.out.println("Content: " + content);
                    System.out.println("------------------------------------------");
                }
            }else {
                System.out.println("File does not exist or is not readable!");
            }


        } catch (Exception e) {
            System.err.println("Could not read file: " + e.getMessage());
        }
    }
}