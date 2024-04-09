import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlowerRepositoryImpl implements IRepository<Flower>{
    private java.sql.Connection con;
    public FlowerRepositoryImpl(){
        this.con = FlowerService.getConnection();
    }
    public Flower bdToEntity(ResultSet rs) throws SQLException {
        return new Flower(rs.getInt("id"), rs.getString("name"));
    }
    public void save(Flower flower) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO flor (id, name) VALUES (?, ?)";
            statement = con.prepareStatement(query);
            statement.setInt(1, flower.getId());
            statement.setString(2, flower.getName());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    public void delete(Flower flower) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM flor WHERE id = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, flower.getId());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    public List<Flower> findAll () throws SQLException{
        List<Flower> flowers = new ArrayList<>();

        Statement st = this.con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM flor");

        while (rs.next()){
            Flower flower = bdToEntity(rs);
            flowers.add(flower);
        }
        return flowers;
    }

    public Flower findById(int id) throws SQLException{
        Flower flower = null;
        PreparedStatement st = con.prepareStatement("SELECT * FROM flor WHERE id = ? ");
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        if (rs.next()){
            flower = bdToEntity(rs);
        }
        return flower;
    }
}
