public class Exceptions {
    public static void main(String[] args) {
        Exception exception = new Exception("");
        exception.printStackTrace();
        System.out.println(new ClientNotFoundException().getMessage());
        System.out.println(new ClientNotFoundException("client not found", new Client("FIO")).getMessage());

        try (
                var br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
                var cl = new Cl();
        ) {

        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Cl implements java.io.Closeable {

    @Override
    public void close() throws java.io.IOException {

    }
}

class ClientNotFoundException extends Exception {
    private Client client;

    public ClientNotFoundException(String message, Client client) {
        super(message + client.name);
        this.client = client;
    }

    public ClientNotFoundException() {
        super("client not found");
    }
}