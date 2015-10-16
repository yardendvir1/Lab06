import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UniverseSimulator 
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How big of a world? > ");
		UniverseGenerator universe = new UniverseGenerator(sc.nextInt());
		universe.printUniverse();
		
		String choice = "";
		
		System.out.println("Pick one:");
		System.out.println("\t(Q)uit");
		System.out.println("\t(A)dvance");
		System.out.println("\t(S)ave");
		
		do
		{
			choice = sc.next();
			
			if (choice.equals("A"))
			{
				universe.advanceUniverse();
				universe.printUniverse();
			}
			else if (choice.equals("S"))
			{
				universe.saveUniverse();
			}
		}
		while (!choice.equals("Q"));
		
		
		System.exit(0);
	}
}
