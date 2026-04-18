package application;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class SubjectServiceCMTest{
    private SubjectService subjectService;

    @Before
    public void setUp() {
        //to reset the shared subject list before each test
        SubjectManager.subjects = new ArrayList<>();
        subjectService = new SubjectService();
        //clearing again in case the constructor loads old file data
        SubjectManager.subjects.clear();
    }

    @Test 
    public void testAddValidSubject() { 
    	boolean result = subjectService.addSubject("Maths", "Higher"); 
    	assertTrue(result); 
    } 
    
    @Test 
    public void testAddInvalidSubject() { 
    	boolean result = subjectService.addSubject("InvalidSubject", "Higher"); 
    	assertFalse(result); 
    } 
    
    @Test 
    public void testAddDuplicateSubject() { 
    	subjectService.addSubject("English", "Higher"); 
    	boolean result = subjectService.addSubject("English", "Higher"); 
    	assertFalse(result); 
    } 
    @Test 
    public void testMaxSubjectLimit() { 
    	subjectService.addSubject("Maths", "Higher"); 
    	subjectService.addSubject("English", "Higher"); 
    	subjectService.addSubject("Irish", "Higher"); 
    	subjectService.addSubject("Biology", "Higher"); 
    	subjectService.addSubject("Chemistry", "Higher"); 
    	subjectService.addSubject("Physics", "Higher"); 
    	subjectService.addSubject("History", "Higher"); 
    	
    	boolean result = subjectService.addSubject("French", "Higher"); 
    	assertFalse(result); 
    } 
}
