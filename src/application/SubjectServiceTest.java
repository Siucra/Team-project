package application;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SubjectServiceTest {

    private SubjectService subjectService;

    @Before
    public void setUp() {
        // Reset shared data
        SubjectManager.subjects = new ArrayList<>();

        subjectService = new SubjectService();
        // Override file-loaded data to keep tests predictable
        SubjectManager.subjects = new ArrayList<>();
    }
    @Test
    public void testGetSubjectsReturnsList() {
        Subject subject1 = new Subject("MATHS", "Higher");
        Subject subject2 = new Subject("ENGLISH", "Ordinary");

        SubjectManager.subjects.add(subject1);
        SubjectManager.subjects.add(subject2);

        assertEquals(2, subjectService.getSubjects().size());
        assertTrue(subjectService.getSubjects().contains(subject1));
    }

    @Test
    public void testAddValidSubjectReturnsTrue() {
        boolean result = subjectService.addSubject("MATHS", "Higher");

        assertTrue(result);
        assertEquals(1, SubjectManager.subjects.size());
    }

    @Test
    public void testAddInvalidSubjectReturnsFalse() {
        boolean result = subjectService.addSubject("INVALID_SUBJECT", "Higher");

        assertFalse(result);
        assertEquals(0, SubjectManager.subjects.size());
    }

    @Test
    public void testAddDuplicateSubjectReturnsFalse() {
        SubjectManager.subjects.add(new Subject("MATHS", "Higher"));

        boolean result = subjectService.addSubject("MATHS", "Ordinary");

        assertFalse(result);
    }

    @Test
    public void testAddMoreThanSevenSubjectsFails() {
        for (int i = 0; i < 7; i++) {
            SubjectManager.subjects.add(new Subject("SUB" + i, "Higher"));
        }

        boolean result = subjectService.addSubject("MATHS", "Higher");

        assertFalse(result);
    }

    @Test
    public void testDeleteSubjectRemovesIt() {
        Subject subject = new Subject("MATHS", "Higher");
        SubjectManager.subjects.add(subject);

        subjectService.deleteSubject(subject);

        assertEquals(0, SubjectManager.subjects.size());
    }
}
}