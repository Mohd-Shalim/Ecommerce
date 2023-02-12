import java.util.Scanner;

public class PalindromeNumber {
public static void main(String[] args){
int r,sum=0,temp;
Scanner sc = new Scanner(System.in);
System.out.println("Enter a number");
int n = sc.nextInt();
temp=n;
while (n > 0) {
r = n%10;
sum = (sum*10) + r;
n=n/10;
}
if(temp==sum)
System.out.println("Number is palindrome");
else
System.out.println("Number is not palindrome");
}
}