package org.example;

import org.example.service.FileProcessorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;

import java.nio.file.Path;

import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

//@ExtendWith(PowerMockExtension.class)
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
        whenNew(FileProcessorService.class).withNoArguments().thenReturn(fileProcessorServiceMock);

        when(fileProcessorServiceMock.readAndReverseContent(anyString())).thenReturn("RQP");
        when(fileProcessorServiceMock.writeContent(anyString(),anyString())).thenReturn("");

        Main.main(args);
    }
}
