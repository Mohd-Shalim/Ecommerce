class Animal
{  
	void eat(){System.out.println("eating...");
	}  
}  
class Dog extends Animal
{  
	void bark()
	{
		System.out.println("barking...");
	}  
}  
class BabyDog extends Dog
{  
	void weep()
	{
		System.out.println("weeping...");
	}  
}  
public class Inheritance1 extends BabyDog

{  
	
	void m()
	{
		
	}
	public static void main(String args[])
	{  
		Inheritance1 d= new Inheritance1();  
		d.m();
		d.weep();  
		d.bark();  
		d.eat();  
	}}  