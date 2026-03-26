package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
	
	public double getAverage() {
	    if (grades.isEmpty()) return 0;
	    double total = 0;

	    for (Grade g : grades) {
	        total += g.getScore();
	    }

	    return total / grades.size();
	}
}
