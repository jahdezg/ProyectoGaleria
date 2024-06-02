package test;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

public class UsuarioTipoTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testIniciarSesionUsuarioExistenteContrasenaCorrecta() {
        // Preparar datos de prueba
        usuarios.put("testUser", "testPassword:Comprador");
        
        // Llamar al método que se quiere probar
        iniciarSesion(new Scanner("testUser\ntestPassword\n"));

        // Verificar resultado esperado
        Assertions.assertTrue(outContent.toString().contains("Inicio de sesión exitoso como testUser"));
    }

    @Test
    public void testIniciarSesionUsuarioExistenteContrasenaIncorrecta() {
        // Preparar datos de prueba
        usuarios.put("testUser", "testPassword:Comprador");
        
        // Llamar al método que se quiere probar
        iniciarSesion(new Scanner("testUser\nwrongPassword\n"));

        // Verificar resultado esperado
        Assertions.assertTrue(outContent.toString().contains("Contraseña incorrecta."));
    }

    @Test
    public void testRegistrarUsuarioYIniciarSesion() {
        // Llamar al método que se quiere probar
        registrarUsuario(new Scanner("newUser\nnewPassword\n1\n"));

        // Verificar resultado esperado
        Assertions.assertTrue(outContent.toString().contains("Usuario registrado exitosamente como Comprador"));
    }

    @Test
    public void testMostrarMenuPorRolComprador() {
        // Llamar al método que se quiere probar
        mostrarMenuPorRol("Comprador", new Scanner(System.in), "testUser");

        // Verificar resultado esperado
        Assertions.assertTrue(outContent.toString().contains("Menú para Comprador"));
    }

    @Test
    public void testMostrarMenuPorRolPropietario() {
        // Llamar al método que se quiere probar
        mostrarMenuPorRol("Propietario", new Scanner(System.in), "testUser");

        // Verificar resultado esperado
        Assertions.assertTrue(outContent.toString().contains("Menú para Propietario"));
    }

    // Restaurar los flujos estándar después de cada prueba
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
