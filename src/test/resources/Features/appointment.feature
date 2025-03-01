Feature: Check Appointment CURA

  Scenario: User want to Click Make Appointment
    Given User Open website CURA Healthcare with browser
    When User input username "John Doe", password "ThisIsNotAPassword" and Click Sign In
    Then User verify Homepage
    And User Click Appointment

  Scenario: User want to Click Make Appointment
    Given User Open website CURA Healthcare with browser
    When User input username "John Doe", password "ThisIsNotAPassword" and Click Sign In
    Then User verify Homepage
    And User Go To Make Appointment

  Scenario Outline: User want to Appointment Success All Field
    Given User Open website CURA Healthcare with browser
    When User input username "John Doe", password "ThisIsNotAPassword" and Click Sign In
    And User fill the Data "<City>", "<Healthcare>", "<Date>", "<Comment>" about Appointment
    Then User verify Appointment
    Examples:
      | City      | Healthcare  | Date        | Comment     |
      | Tokyo     | Medicare    | 20/12/2025  | Thank You   |
      | Hongkong  | Medicaid    | 20/03/2025  | Danke       |
      | Seoul     | None        | 23/03/2025  | Terimakasih |
      | Hongkong  | Medicare    | 29/03/2025  | Matursuwun  |

  Scenario: User want to Appointment Success Required Field
    Given User Open website CURA Healthcare with browser
    When User input username "John Doe", password "ThisIsNotAPassword" and Click Sign In
    And User fill the Date "02/02/2024" about Appointment
    Then User verify Appointment
