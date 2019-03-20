#Author: Rahul Sharma


Feature: Verification of Username password

  Scenario: Verification of Valid data
    Given Open the firefox and lauch the application
    When Enter the Valid Data
    |Fields 					|Values		|
		|User Name 				|Rahul		|
		|Password 				|asd			|
		|Confirm Password	|asd			|	
		|First Name 			|Rahul		|	
		|Last Name				|Sharma		|	
		|Email						|rs9858266@gmail.com			|	
		|Address 					|deep puram,aurangabad,Mathura			|	
		|Phone 						|7894561239			|	
		
		Then User registrattion should be successfull

