#Author: Rahul Sharma

Feature: Login page testing

Background: Check the username and password before logged in


Scenario: Check the valid data for login
Given user is on login page
When enter the valid data for login
Then Navigate to registration Page

Scenario: Check the error on entering invalid data for login
Given user is on login page
When enter the incorrect data and clicks the button
|capgemnih|capg2312|
|trasydgh	|capge2135|
Then display alert msg

Scenario: Failure on leaving the username empty
Given user is on login page
When Leaving the username empty and clicks the button
Then display usererror msg

Scenario: Failure on leaving the password empty
Given user is on login page
When Leaving the password empty and clicks the button
Then display pwderror msg
