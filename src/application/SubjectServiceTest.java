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
    public void testDeleteSubjectRemovesIt() {
        Subject subject = new Subject("MATHS", "Higher");
        SubjectManager.subjects.add(subject);

        subjectService.deleteSubject(subject);

        assertEquals(0, SubjectManager.subjects.size());
    }
}
