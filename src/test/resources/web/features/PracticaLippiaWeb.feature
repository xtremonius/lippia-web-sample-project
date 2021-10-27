#Feature: Como usuario, quiero navegar al sign in de la web Automation practice
#
#  @Smoke
#  Scenario: El usuario navega a "Sign in"
#    Given el usuario navega a la web de Automation Practice
#    When el usuario pulsa el botón "Sign in"
#    Then el usuario verifica que se enseña la pagina de Sign in
#

Feature: Como alumno de QA automation, quiero resolver el ejercicio de Practica Lippia Web

  @Smoke
  Scenario: Se alumno realiza una búsqueda en el campo "SEARCH"
    Given el alumno navega a la web de Automation Practice
    When el alumno realiza una busqueda del producto "HAT"
    And el alumno presiona el boton "SEARCH"
    Then el alumno verifica que el resultado de la busqueda en search sea el mismo ingresado en el input

  @Smoke
  Scenario: el alumno realiza un login en "Sign in"
    Given el alumno navega a la web de Automation Practice
    When el alumno pulsa el boton "Sign in"
    And el alumno carga el email "alejandro.aquino1988@gmail.com" en el campo email address
    And el alumno carga el password "Dante08022019" en el campo password
    And el alumno pulsa el boton de submit Sign in
    Then el alumno verifica que el usuario ingreso a su cuenta

#    @Smoke
#    Scenario: Se alumno realiza una búsqueda en el campo "SEARCH" y se ordena de menor a mayor
#      Given el alumno navega a la web de Automation Practice
#      When el alumno realiza una busqueda del producto "DRESS"
#      And el alumno presiona el boton "SEARCH"
#      And el alumno presiona el boton de ordenar "Price: Lowest first"
#      Then el alumno verifica que el resultado de la busqueda en search sea el mismo ingresado en el input