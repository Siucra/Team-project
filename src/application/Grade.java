package application;

import java.io.Serializable;

public class Grade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private GradeType type;
	private double score;
	
	public Grade(GradeType type, double score){
		this.type = type;
		this.score = score;
	}
	
	public GradeType getType(){
		return type;
	}
	
	public void setType(GradeType type){
		this.type = type;
	}
	
	public double getScore(){
		return score;
	}

	public void setScore(double score){
		this.score = score;
	}
}
