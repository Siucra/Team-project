package application;

public class Grade {
	private GradeType type;
	private double score;
	
	public Grade(GradeType type, double score) {
		this.type = type;
		this.score = score;
	}
	
	public GradeType getType() {
		return type;
	}
	
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
