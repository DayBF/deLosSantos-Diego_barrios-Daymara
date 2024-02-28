import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOImpl implements OdontologoDAO {
    private Connection connection;

    public OdontologoDAOImpl() {
        try {

            connection = DriverManager.getConnection("jdbc:h2:mem:odontoDB");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS odontologos (" +
                    "matricula INT PRIMARY KEY," +
                    "nombre VARCHAR(100)," +
                    "apellido VARCHAR(100))");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void guardarOdontologo(Odontologo odontologo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO odontologos (matricula, nombre, apellido) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Odontólogo guardado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Odontologo> listarOdontologos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM odontologos");
            while (resultSet.next()) {
                int matricula = resultSet.getInt("matricula");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                Odontologo odontologo = new Odontologo(matricula, nombre, apellido);
                odontologos.add(odontologo);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontologos;
    }
}
