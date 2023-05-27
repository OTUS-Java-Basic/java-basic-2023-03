import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Bank {
    private Map<Client, List<Account>> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addClient(Client client) {
        accounts.put(client, new ArrayList<>());
    }

    public void addAccount(Client client, Account account) {
        List<Account> clientAccounts = accounts.get(client);
        if (clientAccounts != null) {
            clientAccounts.add(account);
        }
    }

    public List<Account> getAccounts(Client client) {
        return accounts.getOrDefault(client, new ArrayList<>());
    }

    public Client findClient(Account account) {
        for (Map.Entry<Client, List<Account>> entry : accounts.entrySet()) {
            if (entry.getValue().contains(account)) {
                return entry.getKey();
            }
        }
        return null;
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
}

public class AccountBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // создаем клиентов в банке
        Client client1 = new Client("Андрей", 31);
        bank.addClient(client1);

        Client client2 = new Client("Милена", 24);
        bank.addClient(client2);

        // создаем счета и подвязываем к клиентам
        Account account1 = new Account(1, 100_000);
        bank.addAccount(client1, account1);

        Account account2 = new Account(2, 300_000);
        bank.addAccount(client1, account2);

        Account account3 = new Account(3, 200_000);
        bank.addAccount(client2, account3);

        List<Account> client1Accounts = bank.getAccounts(client1);
        System.out.println("Счета клиента №1: ");
        for (Account account : client1Accounts) {
            System.out.println("Номер счета: " + account.getAccountNumber() + ", Баланс счета: " + account.getBalance());
        }

        //поиск клиента по его счету
        Client client = bank.findClient(account3);
        if (client != null) {
            System.out.println("Владелец счета №3: " + client.getName() + ", Возраст: " + client.getAge());
        } else {
            System.out.println("Клиент не найден");
        }
    }
}