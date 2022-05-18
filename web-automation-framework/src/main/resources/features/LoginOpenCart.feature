Feature: Login Prueba de OpenCart

  @LoginOpenCart
  Scenario Outline: Login Prueba de OpenCart
    Given Usuario ingresa url"<caso_prueba>"
    When  Usuario ingresa datos de email y contrasenia "<caso_prueba>"
    Then  Se valida el ingreso correcto
    Examples:
      | caso_prueba |
      |           1 |