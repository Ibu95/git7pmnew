@chrome_Ing
Feature: Facebook login function In Chrome incognito

  Background: 
    When User Load the Facebook login page

  Scenario: Login with Valid Inputs
    And User Enter the Valid Username "Shivin"
    And User Enter the Valid  Password "Tech"
    And User Click the Login button
    Then it should accept the Login and Load home Page
    

 
