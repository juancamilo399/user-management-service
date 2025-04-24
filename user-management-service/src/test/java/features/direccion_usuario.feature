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
