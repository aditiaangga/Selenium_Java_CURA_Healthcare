Feature: Login CURA Healthcare

  Scenario: User want to Login CURA
    Given User Open website CURA Healthcare with browser
    When User input username "John Doe", password "ThisIsNotAPassword" and Click Sign In
    Then User verify Homepage