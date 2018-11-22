package testcases;

import org.testng.annotations.Test;

public class learnAnnotation {

	@Test(groups="sanity")
	public void Aclass() {
		System.out.println("a");
		
		
	}
	@Test(dependsOnGroups="sanity", alwaysRun=true)
	public void Bclass() {
		
		System.out.println("b");
		throw new RuntimeException();
	}
	@Test(dependsOnMethods="Bclass")
	public void Cclass() {
		
		System.out.println("c");
	}
}
