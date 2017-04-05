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
		float[][] points = getPointsFromInput();
		
		// Print the four points to make sure input was captured correctly
		for (int i=0; i<points.length; i++) {
			System.out.println("Point #" + (i+1) + ": (" + points[i][0] + " , " + points[i][1] + ")");
		}
		
	}
	
	/**
	 * getPointsFromInput
	 *
	 * Function which gathers user input from the console for the points that will be looked at
	 */
	public static float[][] getPointsFromInput()
	{
		Scanner scanner = new Scanner(System.in);
		
		float[][] points = new float[4][2];
		
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
					points[i][0] = Float.parseFloat(pair[0]);
					points[i][1] = Float.parseFloat(pair[1]);
					gettingInputI = false;
				}
				catch (NumberFormatException e)
				{
					System.out.println("Please make sure comma separated values are proper float numbers");
				}
			}
		}
		
		return points;
	}
}