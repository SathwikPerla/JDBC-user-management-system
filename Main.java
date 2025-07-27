import java.util.Scanner;
import operations.DeleteUser;
import operations.FetchUsers;
import operations.InsertUser;
import operations.UpdateUser;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------- MENU -----------");
        System.out.println("1. Insert User");
        System.out.println("2. Fetch All Users");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");
        System.out.println("5. Exit");
        System.out.println("6. Fetch User by ID");

        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                InsertUser.main(null);
                break;
            case 2:
                FetchUsers.main(null);
                break;
            case 3:
                UpdateUser.main(null);
                break;
            case 4:
                DeleteUser.main(null);
                break;
            case 5:
                System.out.println("✅ Exiting...");
                break;
            case 6:
                operations.FetchUserById.main(null);
                break;

            default:
                System.out.println("❌ Invalid choice, please try again.");
        }

        sc.close();
    }
}
