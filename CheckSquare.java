import java.util.Scanner;

/**
 * CheckSquare
 *
 * @author Matthew Farr
 *
 * Application which takes four points from user input and determines if those four points make up a square.
 */
public class CheckSquare
{
	public static void main(String[] args)
	{
		double[][] points = getPointsFromInput();
		
		// Print the four points to make sure input was captured correctly
		System.out.print("\n");
		for (int i=0; i<points.length; i++) {
			System.out.println("Point #" + (i+1) + ": (" + points[i][0] + " , " + points[i][1] + ")");
		}
		
	}
	
	/**
	 * getPointsFromInput
	 *
	 * Function which gathers user input from the console for the points that will be looked at
	 */
	public static double[][] getPointsFromInput()
	{
		Scanner scanner = new Scanner(System.in);
		
		double[][] points = new double[4][2];
		
		for (int i=0; i<points.length; i++) 
		{
			boolean gettingInputI = true;
			
			while (gettingInputI)
			{
				System.out.println("Input point #" + (i+1) + " in the format x,y");
				
				String input = scanner.nextLine();
				
				String[] pair = input.split(",");
				
				if (pair.length != 2)
				{
					System.out.println("Please input two numbers separated by a single comma.");
					continue;
				}
				
				try
				{
					points[i][0] = Double.parseDouble(pair[0]);
					points[i][1] = Double.parseDouble(pair[1]);
					gettingInputI = false;
				}
				catch (NumberFormatException e)
				{
					System.out.println("Please make sure comma separated values are proper double numbers");
				}
			}
		}
		
		return points;
	}
}