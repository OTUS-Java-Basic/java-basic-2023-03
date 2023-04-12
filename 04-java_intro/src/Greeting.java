import java.util.Scanner;

public class Greeting {
   public static void main(String[] args) {
       String potentialFriendName = getPotentialFriendName();
       greetNewFriend(potentialFriendName);
   }
   public static String getPotentialFriendName() {
       Scanner sc = new Scanner(System.in);
       System.out.println("Как вас зовут?");
       return sc.nextLine();
   }
   public static void greetNewFriend(String potentialFriendName) {
       System.out.println("Здравствуйте, " + potentialFriendName + ". Рад знакомству!");
   }
}
