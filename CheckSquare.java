import java.util.Scanner;

public class CheckSquare
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		float[] point = null;
		
		while (point == null) 
		{
			System.out.print("Input point #1 in the format x,y\n");
			
			String input = scanner.nextLine();
			
			String[] pair = input.split(",");
			
			if (pair.length != 2) 
			{
				System.out.println("Please input two numbers separated by a single comma.");
				continue;
			}
			
			try 
			{
				point = new float[2];
				point[0] = Float.parseFloat(pair[0]);
				point[1] = Float.parseFloat(pair[1]);
			}
			catch (NumberFormatException e) 
			{
				System.out.println("Please make sure comma separated values are proper float numbers");
				point = null;
			}
		}
		
		System.out.println("Point x: " + point[0] + "\nPoint y: " + point[1]);
		
	}
}