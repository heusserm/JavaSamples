
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
