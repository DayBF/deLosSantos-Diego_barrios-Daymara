import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancia del DAO
        OdontologoDAO odontologoDAO = new OdontologoDAOImpl();

        // Crear algunos odontólogos
        Odontologo odontologo1 = new Odontologo(1, "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2, "María", "López");

        // Guardar los odontólogos
        odontologoDAO.guardarOdontologo(odontologo1);
        odontologoDAO.guardarOdontologo(odontologo2);

        // Listar todos los odontólogos
        List<Odontologo> listaOdontologos = odontologoDAO.listarOdontologos();
        System.out.println("Lista de odontólogos:");
        for (Odontologo odontologo : listaOdontologos) {
            System.out.println(odontologo.getNumeroMatricula () + " - " + odontologo.getNombre() + " " + odontologo.getApellido());
        }
    }
}