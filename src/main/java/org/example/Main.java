package org.example;

import org.example.service.FileProcessorService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static String inputFile = "D:\\ProjectRepo\\MyApp\\Input.txt";

    private static String outputFile = "D:\\ProjectRepo\\MyApp\\Output.txt";

    private FileProcessorService fileProcessorService;

    public Main(FileProcessorService fileProcessorService) {
        this.fileProcessorService = fileProcessorService;
    }

    public static void main(String[] args) throws IOException {

        FileProcessorService fileProcessorService1 = new FileProcessorService();
        Main main = new Main(fileProcessorService1);
        main.fileContentProcessing();
    }

    public void fileContentProcessing() {
        String fileContentInReverse = fileProcessorService.readAndReverseContent(inputFile);
        if(fileContentInReverse != null) {
            fileProcessorService.writeContent(outputFile, fileContentInReverse);
        }
    }
}