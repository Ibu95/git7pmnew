@chrome
Feature: Facebook login function In Chrome
  Background: 
    When User Load the Facebook login page

@smoke
  Scenario: Login with Valid Inputs
    And User Enter the Valid Username "Shivin"
    And User Enter the Valid  Password "Tech"
    And User Click the Login button
    Then it should accept the Login and Load home Page
@reg
  Scenario: Login with InValid Inputs
    And User Enter the Valid Username "123324"
    And User Enter the Valid  Password "Te3432ch"
    And User Click the Login button
    Then it should accept the Login and Load home Page

@seqlogin
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
