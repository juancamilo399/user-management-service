Feature: Gestión de Usuario

  Como visitante de la plataforma
  Quiero poder crear una cuenta con mi correo y contraseña
  Para guardar mis datos personales y realizar compras

  Scenario: Registro exitoso
    Given que no tengo una cuenta previa
    When ingreso un correo válido y una contraseña segura
    Then mi cuenta se registra exitosamente
    And recibo una notificación de bienvenida

  Scenario: Registro fallido por correo duplicado
    Given que ya existe un usuario registrado con el correo "sebastian@eci.edu.co"
    When intento registrarme con ese mismo correo
    Then el sistema me muestra un mensaje de error indicando "correo ya registrado"

Feature: Gestión de Direcciones

  Como usuario autenticado
  Quiero poder agregar una dirección de envío válida
  Para recibir mis pedidos correctamente

  Scenario: Agregar una dirección de envío válida
    Given que estoy autenticado como "Usuario1"
    When ingreso una dirección completa con calle, ciudad, código postal y país
    Then la dirección se asocia a mi perfil de usuario

  Scenario: Agregar dirección con datos incompletos
    Given que estoy autenticado como "Usuario1"
    When intento agregar una dirección sin código postal
    Then el sistema me muestra un error indicando "dirección inválida"
