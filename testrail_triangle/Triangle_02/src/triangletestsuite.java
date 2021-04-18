//triangletesstsuite.java
//By Matthew Heusser Matt@xndev.com
//Redistributed under Creative commons share-alike license
//https://creativecommons.org/licenses/by-sa/4.0/
//
// A Junit4 style suite for all the test cases.
// In the testrail example we actually run them separately from the command line.
//


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({triangleTest.class, triangleSpecialCasesTest.class})
public class triangletestsuite {
}

