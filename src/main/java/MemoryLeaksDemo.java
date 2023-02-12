// Java Program to illustrate memory leaks
import java.util.Vector;
public class MemoryLeaksDemo
{
	public static void main(String[] args)
	{

		/*In C, programmers totally control
		 *  allocation and deallocation of dynamically created objects.
		 *   And if a programmer does not destroy objects,


Java does automatic Garbage collection
. However there can be situations where
garbage collector does not collect objects because there
are references to them. There might be situations where an
application creates lots of objects and does not use them.
Just because every objects has valid references, garbage collector
in Java can’t destroys the objects. Such types of useless objects
are called as Memory leaks. If allocated memory goes beyond limit,
program will be terminated by rising OutOfMemoryError. Hence if an object
is no longer required, it is highly recommended 
to make that object eligible for garbage collector.  
		 *    memory leak happens in C,
		 */
		
		Vector v = new Vector(214644444);
		Vector v1 = new Vector(214744444);
		Vector v2 = new Vector(214444);
		System.out.println("Memory Leaks");
	}
}
