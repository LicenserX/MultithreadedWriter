import writer.impl.WriterImpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String relativePath = "1.txt";
        Path path = Paths.get(relativePath);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new WriterImpl(path, "Dimon"));
        executorService.submit(new WriterImpl(path, "Darth Vader"));
        executorService.submit(new WriterImpl(path, "Uncle Donald"));
        executorService.submit(new WriterImpl(path, "Batman"));
        executorService.shutdown();
    }
}
