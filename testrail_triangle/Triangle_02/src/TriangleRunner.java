//triangleRunner.java
//By Matthew Heusser Matt@xndev.com
//Redistributed under Creative commons share-alike license
//https://creativecommons.org/licenses/by-sa/4.0/
//
// This it the main java program that uses the triangle class.
//
// Eventually it should take an input (typed in or command line) and return with triangle information
// As-written on 4/18/21 we can currently test the business logic but the main app does not exist yet
// It might be repackaged as an API, for example.
//
public class TriangleRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		triangle t = new triangle();
        String result = t.gettriangletype(1,1,1);	
		System.out.println("Calculated value is " + result);
	}

	
}
