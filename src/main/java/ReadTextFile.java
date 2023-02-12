import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis= new FileInputStream("D:\\Documents\\CSC.txt");
		Scanner sc= new Scanner(fis);
		while(sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		}

	}

}
