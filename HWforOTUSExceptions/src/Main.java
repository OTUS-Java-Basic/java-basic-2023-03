import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        FileProcessor fileProcessor = new FileProcessor();
        try {                                                                                                           // Пример использования вывода ошибки
            fileProcessor.readFile("src/test/1.txt");
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        try {
            fileProcessor.processFile("src/test/1.txt1.txt");                                                   // Пример использования rethrow
        } catch (CustomExceptionWrapper e) {
            throw e.getOriginalException();
        }
        try {
            fileProcessor.copyFile("src/test/1.txt", "src/test/2.txt");                             // Пример использования подавления ошибки
        } catch (IOException ignored) {
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/1.txt"))) {                    // Пример использования try-with-resources
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}

class FileProcessor {
    public void readFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public void processFile(String fileName) throws CustomExceptionWrapper {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Неподходящие данные");
        }
    }

    public void copyFile(String sourceFile, String destinationFile) throws IOException {
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream(sourceFile);
            output = new FileOutputStream(destinationFile);

            int character;
            while ((character = input.read()) != -1) {
                output.write(character);
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}

class CustomExceptionWrapper extends Exception {
    private final Exception originalException;

    public CustomExceptionWrapper(Exception originalException) {
        this.originalException = originalException;
    }

    public Exception getOriginalException() {
        return originalException;
    }
}