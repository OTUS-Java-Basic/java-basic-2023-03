
class Client {
    final String name;

    private java.util.List<Account> accounts;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return java.util.Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        System.out.println("Client::hashCode");
        return java.util.Objects.hash(name);
    }
}

class Account {
     final String id;

    public Account(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return java.util.Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
}

public class Bank {

    private static java.util.Map<Client, java.util.List<Account>> map = new java.util.HashMap<>();
    // O(1)
    // O()

    public static void main(String[] args) {
        var client1 = new Client("1");
        var account1 = new Account("1");
        var account2 = new Account("2");

        map.put(client1, java.util.List.of(account1, account2));

        map.get(new Client("1")).forEach(it -> System.out.println(it.id));

//        map.values()
    }
}
