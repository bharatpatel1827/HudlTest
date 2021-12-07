@runalltest
Feature: Hudl login function test 

	Background: Intial step follows
			Given User is on Login Page

	@loginSuccess
		Scenario: Login success
			When User entered valid credentials
			Then User should be login successfully
	
	@loginUnsuccess		
		Scenario Outline: Login unsuccess
			When User entered invalid credentials "<Username>" and "<Password>"
			Then User should be unsuccessfully login
			Examples: 
							| Username							| Password	|
							| patel123@test.com			|	hiiiiiii	|
							|												| Hudl123		|
							| test12@testmail.com		|  					|
							
	@yourteam
		Scenario: User view video in your team page
			And User entered valid credentials
			And User should be login successfully
			When User click on "Your Team" 
			Then User view the list of videos
			
	@searchTextBar
		Scenario: User search football using search text bar
			And User entered valid credentials
			And User should be login successfully
			When User search football from search text bar
			Then User should be navigate to search list page