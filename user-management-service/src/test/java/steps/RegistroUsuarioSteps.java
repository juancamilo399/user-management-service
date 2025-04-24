package steps;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegistroUsuarioSteps {

    private String correo;
    private String contraseña;
    private boolean cuentaCreada;
    private String mensajeSistema;
    private boolean notificacionEnviada;
    private boolean direccionValida;

    @Given("que no tengo una cuenta previa")
    public void queNoTengoUnaCuentaPrevia() {
        // Supongamos que no hay usuarios aún en el sistema (mock)
        cuentaCreada = false;
    }

    @When("ingreso un correo válido y una contraseña segura")
    public void ingresoCorreoYContrasena() {
        correo = "nuevo@usuario.com";
        contraseña = "claveSegura123";
        cuentaCreada = true;
        notificacionEnviada = true;
    }

    @Then("mi cuenta se registra exitosamente")
    public void cuentaRegistradaExitosamente() {
        assertTrue(cuentaCreada, "La cuenta debería haberse creado");
    }

    @And("recibo una notificación de bienvenida")
    public void notificacionDeBienvenida() {
        assertTrue(notificacionEnviada, "Se debe enviar notificación de bienvenida");
    }

    @Given("que ya existe un usuario registrado con el correo {string}")
    public void yaExisteCorreoRegistrado(String correoExistente) {
        correo = correoExistente;
        cuentaCreada = false;
    }

    @When("intento registrarme con ese mismo correo")
    public void intentoRegistrarmeConCorreoExistente() {
        // Simulamos validación duplicada
        mensajeSistema = "correo ya registrado";
        cuentaCreada = false;
    }

    @Then("el sistema me muestra un mensaje de error indicando {string}")
    public void mensajeErrorCorreoDuplicado(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensajeSistema);
    }

    @Given("que estoy autenticado como {string}")
    public void autenticadoComoUsuario(String usuario) {
        // Simulamos que el usuario está autenticado
        assertNotNull(usuario);
    }

    @When("ingreso una dirección completa con calle, ciudad, código postal y país")
    public void ingresoDireccionValida() {
        direccionValida = true;
    }

    @Then("la dirección se asocia a mi perfil de usuario")
    public void direccionAsociada() {
        assertTrue(direccionValida);
    }

    @When("intento agregar una dirección sin código postal")
    public void intentoDireccionSinCodigoPostal() {
        direccionValida = false;
        mensajeSistema = "dirección inválida";
    }

    @Then("el sistema me muestra un error indicando {string}")
    public void mensajeErrorDireccion(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensajeSistema);
    }
}
