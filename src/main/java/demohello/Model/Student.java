package demohello.Model;

public class Student {
	String name;
	float mark;
	public Student() {		
	}
	public Student(String name, float mark) {
		this.name=name;
		this.mark=mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	
}
