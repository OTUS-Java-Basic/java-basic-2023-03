import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Bank {
    private Map<Client, List<Account>> clientAccountsMap;
    private Map<Account, Client> accountClientMap;

    public Bank() {
        clientAccountsMap = new HashMap<>();
        accountClientMap = new HashMap<>();
    }

    public void addClient(Client client) {
        clientAccountsMap.put(client, new ArrayList<>());
    }

    public void addAccount(Client client, Account account) {
        List<Account> clientAccounts = clientAccountsMap.get(client);
        if (clientAccounts != null) {
            clientAccounts.add(account);
            accountClientMap.put(account, client);
        }
    }

    public List<Account> getAccounts(Client client) {
        return clientAccountsMap.getOrDefault(client, new ArrayList<>());
    }

    public Client findClient(Account account) {
        return accountClientMap.get(account);
    }
}

class Client {
    private String name;
    private int age;

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Client client = (Client) obj;
        return age == client.age && name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return accountNumber == account.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}

public class AccountBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Создание клиентов
        Client client1 = new Client("Андрей", 31);
        Client client2 = new Client("Милена", 24);
        Client client3 = new Client("Алексей", 40);

        // Добавление в банк
        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);

        // Создание счетов
        Account account1 = new Account(1001, 500_000);
        Account account2 = new Account(1002, 100_000);
        Account account3 = new Account(2001, 750_000);
        Account account4 = new Account(2002, 20_000);
        Account account5 = new Account(3001, 100_000);

        // Привязка счетов к клиентам
        bank.addAccount(client1, account1);
        bank.addAccount(client1, account2);
        bank.addAccount(client2, account3);
        bank.addAccount(client2, account4);
        bank.addAccount(client3, account5);

        // Поиск счетов по клиенту
        List<Account> client1Accounts = bank.getAccounts(client1);
        System.out.println("Счета клиента " + client1.getName() + ":");
        for (Account account : client1Accounts) {
            System.out.println("Номер счета: " + account.getAccountNumber() + ", Баланс: " + account.getBalance());
        }

        // Поиск клиента по счету
        account3 = new Account(2001, 750_000);
        Client account3Client = bank.findClient(account3);
        if (account3Client != null) {
            System.out.println("Клиент, чей счет №" + account3.getAccountNumber() + ": " + account3Client.getName());
        } else {
            System.out.println("Счет " + account3.getAccountNumber() + " не привязан к клиенту.");
        }
    }
}