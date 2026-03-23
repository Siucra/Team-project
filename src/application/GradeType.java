package application;

public enum GradeType {

    EXAM("Exam"),
    CLASS_TEST("Class Test"),
    MOCK_EXAM("Mock Exam"),
    ASSIGNMENT("Assignment");

    private final String displayName;

    GradeType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
