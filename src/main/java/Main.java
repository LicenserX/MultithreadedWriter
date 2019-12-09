import writer.Writer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String relativePath = "1.txt";

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new Writer(relativePath, "Dimon"));
        executorService.submit(new Writer(relativePath, "Darth Vader"));
        executorService.submit(new Writer(relativePath, "Uncle Donald"));
        executorService.submit(new Writer(relativePath, "Batman"));
        executorService.shutdown();
    }

}
