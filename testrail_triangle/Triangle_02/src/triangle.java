//triangle.java
//By Matthew Heusser Matt@xndev.com
//Redistributed under Creative commons share-alike license
//https://creativecommons.org/licenses/by-sa/4.0/
//
// This file contains the Software Under Test ("SUT") used as an example
// It takes 3 integers and tells you if the value is:
//  - Equilateral (All sides the same)
//  - Scalene (No sides the same)
//  - Isoseles (Two sides the same)
//  - Not a Triangle (Negative Numbers, two sides are less than the third side)
//
public class triangle {


   public String gettriangletype(int x, int y, int z) {
   
	   
	   if ( ( x+y<z || y+z<x || z+x<y ) 
			||
			(x<0 || y<0 || z<0)
          ) {
	      return "not a triangle";
	   }
	
	   if (x==y && y==z) {
		   return "equilateral";
	   }
	   
	   if (x==y || y==z || x==z) {
		   return "isosceles";
	   }
	   
	   return "scalene";
	   
	   

   }

}
