package writer.impl;

import writer.Writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriterImpl implements Writer, Runnable {

    private final Path path;
    private final String message;

    public WriterImpl(Path path, String message) {
        this.path = path;
        this.message = message;
    }

    @Override
    public void write(String message) {
        synchronized (path) {
            try (BufferedWriter writer = Files.newBufferedWriter(path.toAbsolutePath(), StandardOpenOption.APPEND)) {
                int counter = 0;

                while (counter < 5) {
                    writer.write(counter++ + " " + message);
                    writer.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        write(message);
    }
}

