package application;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AddGradeControllerTest{

    private AddGradeController controller;

    @Before
    public void setUp(){
        controller = new AddGradeController();
    }

    @Test
    public void testValidGradeInputReturnsTrue(){
        boolean result = controller.isValidGradeInput(GradeType.EXAM, "50");
        assertTrue(result);
    }

    @Test
    public void testMissingGradeTypeReturnsFalse(){
        boolean result = controller.isValidGradeInput(null, "50");
        assertFalse(result);
    }

    @Test
    public void testEmptyGradeInputReturnsFalse(){
        boolean result = controller.isValidGradeInput(GradeType.EXAM, "");
        assertFalse(result);
    }

    @Test
    public void testInvalidNumberInputReturnsFalse(){
        boolean result = controller.isValidGradeInput(GradeType.EXAM, "ABCD");
        assertFalse(result);
    }

    @Test
    public void testGradeBelowZeroReturnsFalse(){
        boolean result = controller.isValidGradeInput(GradeType.EXAM, "-10");
        assertFalse(result);
    }

    @Test
    public void testGradeAboveHundredReturnsFalse(){
        boolean result = controller.isValidGradeInput(GradeType.EXAM, "150");
        assertFalse(result);
    }
}
