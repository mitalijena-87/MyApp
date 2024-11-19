package org.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@ExtendWith(MockitoExtension.class)
public class FileProcessorServiceTest {

    @InjectMocks
    private FileProcessorService fileProcessorService;

    @TempDir
    private Path tempDir;

    @Test
    public void testReadAndReverseContentMethodSuccess() {
        try(MockedStatic<Files> mockedStatic = Mockito.mockStatic(Files.class)) {
            File file = tempDir.resolve("test.txt").toFile();
            mockedStatic.when(() -> Files.readAllBytes(Mockito.any())).thenReturn(new byte[]{Byte.parseByte("65")});
            fileProcessorService.readAndReverseContent(file.getAbsolutePath());
        }
    }

    @Test
    public void testReadAndReverseContentMethodWithNullContent() {
        try(MockedStatic<Files> mockedStatic = Mockito.mockStatic(Files.class)) {
            File file = tempDir.resolve("test.txt").toFile();
            mockedStatic.when(() -> Files.readAllBytes(Mockito.any())).thenReturn(null);
            fileProcessorService.readAndReverseContent(file.getAbsolutePath());
        }
    }

    @Test
    public void testWriteContentMethodSuccess() {
        try(MockedStatic<Files> mockedStatic = Mockito.mockStatic(Files.class)) {
            File file = tempDir.resolve("test.txt").toFile();
            BufferedWriter bufferedWriterMock = Mockito.mock(BufferedWriter.class);
            mockedStatic.when(() -> Files.newBufferedWriter(Path.of(file.getAbsolutePath()))).thenReturn(bufferedWriterMock);
            fileProcessorService.writeContent(file.getAbsolutePath(), new String(new byte[]{Byte.parseByte("65")}));
        }
    }
}
