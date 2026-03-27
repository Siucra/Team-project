package application;

import java.util.List;

public class SubjectService {
	public SubjectService() {
        SubjectManager.subjects = SubjectFileHandler.loadSubjects();
    }

    public List<Subject> getSubjects() {
        return SubjectManager.subjects;
    }

    public boolean addSubject(String name, String level) {
    	if(SubjectManager.subjects.size() >= 7) {
    		return false;
    	}
        String fixedName = name.trim().toUpperCase().replace(" ", "_");
        
        //if valid 
        SubjectName validSubject;
        try {
            validSubject = SubjectName.valueOf(fixedName);
        } catch (IllegalArgumentException e) {
            return false; 
        }
        
        //if duplicates
        for (Subject s : SubjectManager.subjects) {
            if (s.getName().equalsIgnoreCase(name.trim())) {
                return false;
            }
        }

        Subject subject = new Subject(validSubject.name(), level);
        SubjectManager.subjects.add(subject);
        SubjectFileHandler.saveSubjects(SubjectManager.subjects);
        return true;
    }
    public void deleteSubject(Subject subject) {
        SubjectManager.subjects.remove(subject);
        SubjectFileHandler.saveSubjects(SubjectManager.subjects);
    }
}
 
