package application;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

//import loginAndSignUpTests.SignUp;

class SignUpControllerTest {

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	

    userLogin instance;
    int i = 0;

    @Before
    public void setUp() throws Exception {
        instance = new userLogin();
        i += 1;
        System.out.println("Run: " + i);
    }


    // Testing for an empty email field
    @Test
    public void testEmail_is_Empty() {
        System.out.println("Email is empty");
        String email = "";
        String password = "Qwer1234.";
        String expectedResult = "Please enter an email.";
        String actualResult = instance.SignUp_Verifications(email, password);
        assertEquals(expectedResult, actualResult);
        
    }


    // Testing for an invalid email
    @Ignore
    @Test
    public void testEmailInvalid() {
        System.out.println("Email not valid");
        String email = "emailgmailcom";
        String password = "Qwer1234.";
        String expectedResult = "Email is invalid. Please Enter a valid email address";
        String actualResult = instance.SignUp_Verifications(email, password);
        assertEquals(expectedResult, actualResult);
    }

    // Testing for an empty password field
    @Ignore
    @Test
    public void testPasswordEmpty() {
        System.out.println("Password is empty");
        String email = "email@gmail.com";
        String password = "";
        String expectedResult = "Please create a password";
        String actualResult = instance.SignUp_Verifications(email, password);
        assertEquals(expectedResult, actualResult);
    }

    // Testing if a password is too short
    @Ignore
    @Test
    public void testLengthOfPassword() {
        System.out.println("Password length is short or too long");
        String email = "email@gmail.com";
        String password = "qwer";
        String expectedResult = "Password must be between 6 and 10 characters";
        String actualResult = instance.SignUp_Verifications(email, password);
        assertEquals(expectedResult, actualResult);
    }

    // Testing for is a password is to weak
    @Test
    public void testPasswordIsWeak() {
        System.out.println("Password is weak");
        String email = "email@gmail.com";
        String password = "qwertyu";
        String expectedResult = "Password is too Weak, must include upper, lower, number and special character";
        String actualResult = instance.SignUp_Verifications(email, password);
        assertEquals(expectedResult, actualResult);
    }

    //Testing if signup is valid and successful
    @Ignore
    @Test
    public void testSignUpSuccessful() {
        System.out.println("Sign up is Successful");
        String email = "email@gmail.com";
        String password = "Qwer1234.";
        String expectedResult = "Sign Up successful";
        String actualResult = instance.SignUp_Verifications(email, password);
        assertEquals(expectedResult, actualResult);
    }
}


