#Author: Rahul Sharma

Feature: Reset functionality on login page of Application

Scenario Outline: verification of reset button with numbers of credentials

Given Open the firefox and launch the application

When Enter the Username <username> and Password <password>

Then Reset the credential

Examples: 

|username  |password		|
|"User11"  |"password11"		|
|"user22"  |"password22"		|
|"user33"  |"password33"	|