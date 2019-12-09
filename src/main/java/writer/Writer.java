package writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Writer implements Runnable {

    private final String relativePath;

    private final String message;

    public Writer(String path, String message) {
        this.relativePath = path;
        this.message = message;
    }

    @Override
    public void run() {
        write(relativePath, message);
    }

    private static void write(String relativePath, String message) {
        synchronized (Writer.class) {
            String absolutePath = new File(relativePath).getAbsolutePath();

            try (BufferedWriter bufferedWriter
                         = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(absolutePath, true)))) {
                int counter = 0;

                while (counter < 5){
                    bufferedWriter.write(counter++ + " " + message);
                    bufferedWriter.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
