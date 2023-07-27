package io.kapil.springdemo;

public class HappyFortuneService {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	// init-method for bean life cycle
	public void doInit() {
		System.out.println("setting title to default for initial value");
		this.title = "Default";
	}
	
	
	// destroy-method for bean life cycle
	public void doDestroy() {
		System.out.println("this is destroy method for ending bean");
	}	

}
