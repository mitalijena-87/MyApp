package org.example;

import org.example.service.FileProcessorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Path;

import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MainTest {

    @InjectMocks
    Main main;

    @TempDir
    private Path tempDir;

    @Test
    public void testMainMethodSuccess() throws Exception {
        String[] args = new String[] {};

        FileProcessorService fileProcessorServiceMock = mock(FileProcessorService.class);
        Main main = new Main(fileProcessorServiceMock);

        when(fileProcessorServiceMock.readAndReverseContent(anyString())).thenReturn("RQP");
        when(fileProcessorServiceMock.writeContent(anyString(),anyString())).thenReturn("");

        main.fileContentProcessing();
    }

    @Test
    public void testMainMethodWithNullContent() throws Exception {
        String[] args = new String[] {};

        FileProcessorService fileProcessorServiceMock = mock(FileProcessorService.class);
        Main main = new Main(fileProcessorServiceMock);

        when(fileProcessorServiceMock.readAndReverseContent(anyString())).thenReturn(null);
        when(fileProcessorServiceMock.writeContent(anyString(),anyString())).thenReturn("");

        main.fileContentProcessing();
    }
}
