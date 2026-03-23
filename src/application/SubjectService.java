package application;

import java.util.List;

public class SubjectService {

    public List<Subject> getSubjects() {
        return SubjectManager.subjects;
    }

    public void addSubject(String name, String level) {
        Subject subject = new Subject(name, level);
        SubjectManager.subjects.add(subject);
    }

    public void addExampleData() {
        if (!SubjectManager.subjects.isEmpty()) {
            return;
        }

        Subject maths = new Subject("Maths", "Higher");
        maths.addGrade(new Grade(GradeType.CLASS_TEST, 80));
        maths.addGrade(new Grade(GradeType.EXAM, 90));

        Subject english = new Subject("English", "Ordinary");
        english.addGrade(new Grade(GradeType.MOCK_EXAM, 60));
        english.addGrade(new Grade(GradeType.ASSIGNMENT, 70));

        SubjectManager.subjects.add(maths);
        SubjectManager.subjects.add(english);
    }
    
    enum SubjectName {
        CONSTRUCTION_TECHNOLOGY,
        ENGINEERING,
        PHYSICAL_EDUCATION,
        TECHNOLOGY,
        AGRICULTURAL_SCIENCE,
        APPLIED_MATHS,
        BIOLOGY,
        CHEMISTRY,
        MATHEMATICS,
        MATHS,
        PHYSICS,
        PHYSICS_AND_CHEMISTRY,
        COMPUTER_SCIENCE,
        ART,
        DRAMA_FILM_AND_THEATRE_STUDIES,
        MUSIC,
        DESIGN_AND_COMM_GRAPHICS,
        ARABIC,
        CLASSICAL_STUDIES,
        ENGLISH,
        FRENCH,
        IRISH,
        GERMAN,
        HEBREW_STUDIES,
        HISTORY,
        UKRAINIAN,
        ITALIAN,
        JAPANESE,
        LATIN,
        RUSSIAN,
        SPANISH,
        OTHER_LANGUAGE,
        ANCIENT_GREEK,
        MANDARIN_CHINESE,
        POLISH,
        LITHUANIAN,
        PORTUGUESE,
        GEOGRAPHY,
        CLIMATE_ACTION_AND_SUSTAINABLE_DEVELOPMENT,
        HOME_ECONOMICS,
        RELIGIOUS_EDUCATION,
        POLITICS_AND_SOCIETY,
        ACCOUNTING,
        BUSINESS,
        ECONOMICS,
        LCVP
    }

}