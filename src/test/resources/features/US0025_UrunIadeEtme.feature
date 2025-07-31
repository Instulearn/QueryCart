Feature: US_025

Background:
* User makes driver adjustments
* User confirms to be on the homepage

@Tugba
Scenario: As a registered user, I would like to have a page about the orders I want to return and be able to manage my product returns.

  When User clicks the button with description "Profile"
  And User clicks the button with description "Sign In"
  And As a user, I want to use the Use email instead option to log in with my email and password.
  And As a user muss be "tugbaCustomerMail" mail and "customerpassword" password Login
  And buy a product and pay for it
  Then Verify that Return Request Button is displayed
  Then Verify that the product has been sent

 # CHROME ICIN STEPLER (DAHA SONRA BAK TEKRAR)
 # And switch to chrome
 # And As a user muss be "tugbaManagerMail" mail and "managerpassword" password Login.
 # And manager ships the product
 # And Returns to the Query Cart app as the user
