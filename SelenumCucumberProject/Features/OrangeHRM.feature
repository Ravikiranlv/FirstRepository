Feature: Login 

  Scenario: succesful Login with Valid credentials
    Given User Launch Crome browser
    When User open URL"https://demo.nopcommerce.com/login"
    And User enters Email as "ravikiranlv16@gmail.com" and password as "9353608818"
    And  Click on Loin 
    Then page Title should be "nopCommerce demo store"
    When user Click on Log out link
    Then Page Title Should be "About login / registration"
    And Close Browser