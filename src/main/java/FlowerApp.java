import java.sql.SQLException;
import java.util.List;

public class FlowerApp {
    private static final FlowerRepositoryImpl flowerRepository = new FlowerRepositoryImpl();
    public static void main(String[] args) throws SQLException {
        List<Flower> animals = flowerRepository.findAll();
        animals.forEach(System.out::println);
    }
}

