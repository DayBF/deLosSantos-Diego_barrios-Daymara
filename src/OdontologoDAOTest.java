import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OdontologoDAOTest {
    private OdontologoDAO odontologoDAO;

    @BeforeEach
    public void setUp() {
        odontologoDAO = new OdontologoDAOImpl();
    }

    @Test
    public void testListarOdontologosDespuesDeGuardar() {

        odontologoDAO.guardarOdontologo(new Odontologo(1, "Juan", "Perez"));
        odontologoDAO.guardarOdontologo(new Odontologo(2, "María", "López"));
        odontologoDAO.guardarOdontologo(new Odontologo(3, "Carlos", "García"));

        List<Odontologo> listaOdontologos = odontologoDAO.listarOdontologos();
        assertEquals(3, listaOdontologos.size());
    }
}
