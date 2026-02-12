Feature: WordPress Photo Directory Search

  Scenario: Verify WordPress photo directory image search
    Given I launch WordPress
    Then I verify the title contains "WordPress"

    When I hover on Extend and click Get WordPress
    Then I verify Get WordPress header text is "Get WordPress"

    When I click on Community and select Photo Directory
    And I search photo with keyword "Nature"
    Then I verify photos are displayed
