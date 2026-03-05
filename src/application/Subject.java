package application;

import java.util.ArrayList;

public class Subject {
	private String name;
	private String level;
	private ArrayList<Grade> grades;
	
	public Subject(String name, String level) {
		this.name = name;
		this.level = level;
		this.grades = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public String getLevel() {
		return level;
	}
	
	public ArrayList<Grade> getGrades(){
		return grades;
	}
	public void addGrade(Grade grade) {
		grades.add(grade);
	}
}
