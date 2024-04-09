import java.sql.SQLException;
import java.util.Scanner;

public class MenuFlower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlowerRepositoryImpl flowerRepository = new FlowerRepositoryImpl();

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("0 - Exit");
            System.out.println("1 - All Flowers");
            System.out.println("2 - Register Flower by ID");
            System.out.println("3 - Delete Flower by ID");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    case 1:
                        FlowerController.printAllFlowers();
                        break;
                    case 2:
                        FlowerController.addFlower();
                        break;
                    case 3:
                        FlowerController.deleteFlower();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error executing operation: " + e.getMessage());
            }
        } while (choice != 0);

        scanner.close();
    }
}
