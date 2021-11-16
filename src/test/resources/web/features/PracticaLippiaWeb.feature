Feature: Como alumno de QA automation, quiero resolver el ejercicio de Practica Lippia We

  @Smoke
  Scenario Outline: Se alumno realiza una búsqueda en el campo "SEARCH"
    Given el alumno navega a la web de Automation Practice
    When el alumno realiza una busqueda del "<producto>"
    Then el alumno verifica que el resultado de la busqueda en search sea el mismo ingresado en el input "<producto>"

    Examples:
      |producto    |
      |dress       |


  @Smoke
  Scenario Outline: el alumno realiza un login en "Sign in"
    Given el alumno navega a la web de Automation Practice
    When el alumno pulsa el boton Sign in
    And el alumno carga el email "<email>" en el campo email address
    And el alumno carga el password "<password>" en el campo password
    And el alumno pulsa el boton de submit Sign in
    Then el alumno verifica que el usuario ingreso a su cuenta

    Examples:
      | email                          | password      |
      | alejandro.aquino1988@gmail.com | Dante08022019 |


  @Smoke
  Scenario Outline: Se alumno realiza una búsqueda en el campo "SEARCH" y se ordena de menor a mayor
    Given el alumno navega a la web de Automation Practice
    When el alumno realiza una busqueda del "<producto>"
    And el alumno presiona el boton view list
    And el alumno presiona el boton de ordenar por "<sortby>"
    Then el alumno verifica que el orden de los productos

    Examples:
      | producto | sortby              |
      | dress    | Price: Lowest first |
      | short    | Price: Lowest first |