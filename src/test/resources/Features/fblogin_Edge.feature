@edge
Feature: Facebook login function In Edge

  Background: 
    When User Load the Facebook login page

  Scenario Outline: Login with Seq Valid Inputs
    And User Enter the Valid Username "<user>"
    And User Enter the Valid  Password "<pass>"
    And User Click the Login button
    Then it should accept the Login and Load home Page


    Examples: 
      | user | pass |
      | Shv1 | Tec1 |
      | Shv2 | Tec2 |
      | Shv3 | Tec3 |
      | Shv4 | Tec4 |
