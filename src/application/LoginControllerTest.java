package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.Ignore;


class LoginControllerTest {

	 Login instance;
	    int i = 0;
	    
	@Before
 public void setUp() throws Exception {
     instance = new Login();
     i += 1;
     System.out.println("Run: " + i);
 }
	
	
  //Testing for an empty email field
 @Test
 public void testEmailIsEmpty() {
     System.out.println("Email is Empty");
     String email = "";
     String password = "Qwer1234.";
     String expectedResult = "Please enter an email.";
     String actualResult = instance.loginVerification(email, password);
     assertEquals(expectedResult, actualResult);
 }
 
  //Testing for invalid Email formatting  
 //@Ignore
 @Test
 public void testEmailIsInvalid() {
     System.out.println("Email is not valid");
     String email = "emailgmailcom";
     String password = "Qwer1234.";
     String expectedResult = "Sorry, your email doesn't contain @ and .";
     String actualResult = instance.loginVerification(email, password);
     assertEquals(expectedResult, actualResult);
 }
 
  //Testing for empty password field
 //@Ignore
 @Test
 public void testEmptyPassword() {
     System.out.println("Password is empty");
     String email = "email@gmail.com";
     String password = "";
     String expectedResult = "Please enter a password";
     String actualResult = instance.loginVerification(email, password);
     assertEquals(expectedResult, actualResult);
 }

  //Testing for wrong login information
// @Ignore
 @Test
 public void testForWrongLogin() {
     System.out.println("Login is wrong");
     String email = "email@gmail.com";
     String password = "qwer12";
     String expectedResult = "Soryy, you have entered wrong email or password";
     String actualResult = instance.loginVerification(email, password);
     assertEquals(expectedResult, actualResult);
 }

  //Testing for successful login
  
 @Test
// @Ignore
 public void testIfLoginIsSuccessful() {
     System.out.println("Login is successful");
     String email = "email@gmail.com";
     String password = "Qwer1234.";
     String expectedResult = "Login successful!";
     String actualResult = instance.loginVerification(email, password);
     assertEquals(expectedResult, actualResult);
 }




}
