import java.io.*;

class Resource implements AutoCloseable {
    public void open() throws IOException {
        System.out.println("Открытие ресурса");
        throw new IOException("Ошибка при открытии ресурса");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Закрытие ресурса");
        throw new Exception("Ошибка при закрытии ресурса");
    }
}

class ResourceProcessor {
    public void process() throws CustomException {
        try (Resource resource = new Resource()) {
            resource.open();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
            throw new CustomException("Ошибка обработки ресурса", e);
        } catch (Exception e) {
            System.out.println("Ошибка при закрытии ресурса: " + e.getMessage());
            throw new CustomException("Ошибка при закрытии ресурса", e);
        }
    }
}

class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            ResourceProcessor processor = new ResourceProcessor();
            processor.process();
        } catch (CustomException e) {
            System.out.println("Произошла ошибка при обработке ресурса: " + e.getMessage());
            Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println("Причина: " + cause.getMessage());
            }
        }
    }
}