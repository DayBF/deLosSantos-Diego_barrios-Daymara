import java.util.List;

public class Main {
    public static void main(String[] args) {
        OdontologoDAO odontologoDAO = new OdontologoDAOImpl();

        Odontologo odontologo1 = new Odontologo(6, "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(7, "María", "López");

        odontologoDAO.guardarOdontologo(odontologo1);
        odontologoDAO.guardarOdontologo(odontologo2);

        List<Odontologo> listaOdontologos = odontologoDAO.listarOdontologos();
        System.out.println("Lista de odontólogos:");
        for (Odontologo odontologo : listaOdontologos) {
            System.out.println(odontologo.getNumeroMatricula () + " - " + odontologo.getNombre() + " " + odontologo.getApellido());
        }
    }
}