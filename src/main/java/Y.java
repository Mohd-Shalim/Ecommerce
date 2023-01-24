class A{
void method1()
{
System.out.println("Hello A");
}
}
class B{
  void method2()
{
System.out.println("Hello B");
}
}
class C{
  void method3()
{
System.out.println("Hello C");
}
}

public class Y{
public static void main(String[] args)
{
A a= new A();
a.method1();
B b=new B();
b.method2();
C c= new C();
c.method3();

}
}
