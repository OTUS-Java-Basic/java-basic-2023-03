import java.util.*;

public class Bank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String typed;
        String nameOrID;
        List<Client> clientsList = new ArrayList<>();                                                                   //Создаю листы
        List<Account> accountsList = new ArrayList<>();
        Client oleg = new Client("Олег", 27);                                                                 //Создаю клиентов и добавляю в лист
        Client petr = new Client("Петр", 31);
        Client ilya = new Client("Илья", 17);
        Client egor = new Client("Егор", 12);
        clientsList.add(oleg);
        clientsList.add(petr);
        clientsList.add(ilya);
        clientsList.add(egor);
        Account acc1 = new Account(1, oleg);                                                                         //Создаю счета и добавляю в лист
        Account acc2 = new Account(2, oleg);
        Account acc3 = new Account(3, oleg);
        Account acc4 = new Account(4, petr);
        Account acc5 = new Account(5, petr);
        Account acc6 = new Account(6, petr);
        Account acc7 = new Account(7, ilya);
        Account acc8 = new Account(8, ilya);
        Account acc9 = new Account(9, ilya);
        Account acc10 = new Account(10, ilya);
        accountsList.add(acc1);
        accountsList.add(acc2);
        accountsList.add(acc3);
        accountsList.add(acc4);
        accountsList.add(acc5);
        accountsList.add(acc6);
        accountsList.add(acc7);
        accountsList.add(acc8);
        accountsList.add(acc9);
        accountsList.add(acc10);
        Map<Account, Client> accountClientMap = createClientAccountMap(accountsList);                                   //Создаю hash-map для дальнейшего использования
        Map<Integer, Account> accountsIDMap = createAccountIDMap(accountsList);
        Map<String, Client> nameClientsMap = createNameClientMap(clientsList);
        System.out.println("Поиск в системе банка. Введите номер желаемой функции:");
        System.out.println("1) Найти список счетов клиента");
        System.out.println("2) Найти клиента по id счета");
        do {
            typed = input.nextLine();
            if (isNumeric(typed) || Integer.parseInt(typed) > 3 || Integer.parseInt(typed) < 1) {
                System.out.println("Неверный номер. Повторите ввод");
            }
        }
        while(isNumeric(typed) || Integer.parseInt(typed) > 3 || Integer.parseInt(typed) < 1);
        if (Integer.parseInt(typed) == 1) {
            System.out.println("Введите имя клиента");
            nameOrID = input.nextLine();
            Set<Account> accountsOfClient = getAccountsOfClient(nameOrID, accountClientMap,nameClientsMap);
            assert accountsOfClient != null;
            if (!accountsOfClient.isEmpty()) {
                System.out.println("ID счетов клиента:");
                for (Account account : accountsOfClient) {
                System.out.println(account.getId());
                }
            }
            else {
                System.out.println("Данный клиент не имеет открытых счетов");
            }
        }
        if (Integer.parseInt(typed) == 2) {
            System.out.println("Введите ID счета");
            do {
                nameOrID = input.nextLine();
                if (isNumeric(nameOrID)) {
                    System.out.println("Неверный формат ввода. Повторите");
                }
            }
            while(isNumeric(nameOrID));
            Client client = getClientByAccount(Integer.parseInt(nameOrID),accountsIDMap);
            if (client == null) {
                System.out.println("Данный ID не обнаружен");
            }
            else {
                System.out.println("Обладатель счета с этим ID: "+client.getName());
            }
        }
    }
    public static <Account, Client> Set<Account> getAccountsOfClient (String typed, Map<Account, Client> accountClientMap, Map<String, Client> nameClientsMap) {
        Set<Account> accountsOfClient = new HashSet<>();                                                                //Получение списка счетов клиента
        if (nameClientsMap.containsKey(typed)) {
            Client client = nameClientsMap.get(typed);
            for (Map.Entry<Account, Client> entry : accountClientMap.entrySet()) {
                if (client.equals(entry.getValue())) {
                    accountsOfClient.add(entry.getKey());
                }
            }
            return accountsOfClient;
        }
        else {
            System.out.println("Имя клиента в базе отсутствует");
            return null;
        }
    }
    private static Client getClientByAccount (int nameOrID,Map<Integer, Account> accountIDMap) {                           //Получение клиента по счету
        if (accountIDMap.containsKey(nameOrID)) {
            return accountIDMap.get(nameOrID).getOwner();
        }
        else {
            return null;
        }
    }
    public static boolean isNumeric(String string) {                                                                    //Проверка ввода на отсутствие чего-либо кроме чисел
        try {
            Integer.parseInt(string);
            return false;
        } catch(NumberFormatException e){
            return true;
        }
    }
    private static Map<String, Client> createNameClientMap (java.util.List<Client> clientsList) {                       //Создание Map Имя-Клиент
        Map<String, Client> clientsMap = new HashMap<>();
        for (Client client: clientsList){
            clientsMap.put(client.name, client);
        }
        return clientsMap;
    }
    private static Map<Integer, Account> createAccountIDMap (java.util.List<Account> accountsList) {                    //Создание Map ID-Счет
        Map<Integer, Account> accountsIDMap = new HashMap<>();
        for (Account account: accountsList){
            accountsIDMap.put(account.getId(), account);
        }
        return accountsIDMap;
    }
    private static Map<Account, Client> createClientAccountMap(java.util.List<Account> accountsList) {                  //Создание Map Счет-Клиент
        Map<Account, Client> accountsMap = new HashMap<>();
        for (Account account: accountsList){
            accountsMap.put(account, account.getOwner());
        }
        return accountsMap;
    }
}
class Account {                                                                                                         //Класс Счет
    private final Integer id;
    private final Client owner;
    public Account(Integer id, Client owner) {
        this.id = id;
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(owner, account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner);
    }
    public Client getOwner() {
        return owner;
    }
    public Integer getId() {
        return id;
    }
}
class Client {                                                                                                          //Класс клиент
    final String name;
    private final int age;
    public  Client (String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName () {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

