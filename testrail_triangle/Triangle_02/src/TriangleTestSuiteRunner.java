//triangletesstsuite.java
//By Matthew Heusser Matt@xndev.com
//Redistributed under Creative commons share-alike license
//https://creativecommons.org/licenses/by-sa/4.0/
//
// A Junit4 style test suite runner for all the test cases.
// In the testrail example we actually run them separately from the command line.
//

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
 
public class TriangleTestSuiteRunner {
 
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(triangletestsuite.class);
 
 
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            failure.getException().printStackTrace();
        }
 
         
System.out.println("Test successful? " + result.wasSuccessful());
    }
}