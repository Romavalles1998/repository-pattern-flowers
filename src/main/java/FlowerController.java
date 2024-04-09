import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class FlowerController {

    /**
     * Imprime por pantalla todas las flores
     * @throws SQLException
     */
    public static void printAllFlowers() throws SQLException {
        FlowerRepositoryImpl flowerRepository = new FlowerRepositoryImpl();
        List<Flower> flowers = flowerRepository.findAll();
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }

    /**
     * Muestra una interfaz de usuario para añadir una flor
     * @throws SQLException
     */
    public static void addFlower() throws SQLException {
        FlowerRepositoryImpl flowerRepository = new FlowerRepositoryImpl();
        Scanner sc = new Scanner(System.in);
        System.out.print("ID de la flor: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("Nombre de la flor: ");
        String name = sc.nextLine();
        Flower flower = new Flower(id, name);
        flowerRepository.save(flower);
        System.out.println("Flor añadida correctamente.");
    }

    /**
     * Muestra la UI para modificar una flor
     * @throws SQLException
     */
    public static void modifyFlower() throws SQLException {
        FlowerRepositoryImpl flowerRepository = new FlowerRepositoryImpl();
        printAllFlowers();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la flor que desea modificar: ");
        int flowerId = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo nombre de la flor: ");
        String name = sc.nextLine();
        Flower modifiedFlower = new Flower(flowerId, name);
        flowerRepository.save(modifiedFlower);
        System.out.println("Flor modificada exitosamente.");
    }

    /**
     * Muestra la UI para borrar una flor
     * @throws SQLException
     */
    public static void deleteFlower() throws SQLException {
        FlowerRepositoryImpl flowerRepository = new FlowerRepositoryImpl();
        printAllFlowers();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la flor que desea eliminar: ");
        int flowerId = sc.nextInt();
        Flower flowerToDelete = flowerRepository.findById(flowerId);
        if (flowerToDelete != null) {
            flowerRepository.delete(flowerToDelete);
            System.out.println("Flor eliminada exitosamente.");
        } else {
            System.out.println("No se encontró ninguna flor con ese ID.");
        }
    }
}
