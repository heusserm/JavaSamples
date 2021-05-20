rm *.class
rm triangle.jar
rm testResult*.txt
javac -d . ../src/triangle.java
javac -d . -cp . ../src/TriangleRunner.java
jar cfm triangle.jar manifest.txt TriangleRunner.class triangle.class
javac -d . -cp junit-4.13.2.jar:. ../src/triangleTest.java
javac -d . -cp junit-4.13.2.jar:. ../src/triangleSpecialCasesTest.java
javac -d . -cp junit-4.13.2.jar:. ../src/triangletestsuite.java
javac -d . -cp junit-4.13.2.jar:. ../src/TriangleTestSuiteRunner.java
java -cp junit-4.13.2.jar;hamcrest-2.2.jar;. org.junit.runner.JUnitCore triangleTest > testResults1.txt
java -cp junit-4.13.2.jar;hamcrest-2.2.jar;. org.junit.runner.JUnitCore triangleSpecialCasesTest > testResults2.txt
#In Eclipse, once you have added your userid, password, url, and directory into ReportJUnitResults.java
#You can do a file->export runnable Jar file  

#UNCOMMENT THE LINE BELOW ONCE YOU HAVE PUT YOUR OWN JAR FILE IN PLACE 
#java -jar ReportJUnitResults.jar
~                                      
