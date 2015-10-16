import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class UniverseGenerator 
{
	char[] universe;
	
	public UniverseGenerator(int universeSize)
	{
		universe = new char[universeSize];
		
		for (int i = 0; i < universe.length; i++)
		{
			universe[i] = '.';
		}
		
		for (int i = 4; i < universe.length; i += 5)
		{
			universe[i] = '^';
		}
		
		for (int i = 0; i < universe.length; i += 7)
		{
			universe[i] = '0';
		}
	}
	
	public static void quitUniverse()
	{
		System.exit(0);
	}
	
	public void advanceUniverse()
	{
		int i = 0;
		
		while (i < universe.length)
		{
			if (universe[i] == '0')
			{
				universe[i] = '1';
				i++;
			}
			else if (universe[i] == '1')
			{
				universe[i] = '2';
				i++;
			}
			else if (universe[i] == '2' && (i + 1) < universe.length)
			{
				if (universe[i + 1] == '.')
				{
					universe[i] = '.';
					universe[i + 1] = '2';
				}
				else if (universe[i + 1] == '^')
				{
					universe[i] = '.';
					universe[i + 1] = '0';
				}
				i += 2;
			}
			else
			{
				i++;
			}
		}
	}
	
	public void saveUniverse() throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter("universe.txt");
		
		String universeString = new String(universe);
		out.println(universeString);
		
		int amount0 = 0;
		int amount1 = 0;
		int amount2 = 0;
		
		for (int i = 0; i < universe.length; i++)
		{
			if (universe[i] == '0')
			{
				amount0++;
			}
		}
		
		for (int i = 0; i < universe.length; i++)
		{
			if (universe[i] == '1')
			{
				amount1++;
			}
		}
		
		for (int i = 0; i < universe.length; i++)
		{
			if (universe[i] == '2')
			{
				amount2++;
			}
		}
		
		out.println("Babies: " + amount0);
		out.println("Children: " + amount1);
		out.println("Adults: " + amount2);
		out.close();
		System.out.println("Universe saved!");
	}
	
	public void printUniverse()
	{
		String universeString = new String(universe);
		
		System.out.println(universeString);
	}
	
	
	
	
}
