package org.example.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessorService {
    public String readAndReverseContent(String inputFile) {
        try {
            byte[] originalContent = Files.readAllBytes(Paths.get(inputFile));
            if(originalContent != null) {
                byte[] reverseContent = new byte[originalContent.length];

                for(int i = 0; i < originalContent.length; i++) {
                    System.arraycopy(originalContent, originalContent.length-1-i, reverseContent, i, 1);
                }
                return new String(reverseContent);
            }
        } catch (IOException e) {
            System.err.println("File read/reverse operation failed"+e.getMessage());
        }
        return null;
    }

    public String writeContent(String outputFile, String fileContentInReverse) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            bufferedWriter.write(fileContentInReverse);
        } catch (IOException e) {
            System.err.println("File write operation failed"+e.getMessage());
        }
        return "true";
    }
}
