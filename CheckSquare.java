import java.util.Scanner;
import java.lang.Math;

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
		
		computePointDistances(points);
	}
	
	/**
	 * getPointsFromInput
	 *
	 * Method which gathers user input from the console for the points that will be looked at
	 */
	private static double[][] getPointsFromInput()
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
	
	/**
	 * getDistance
	 *
	 * Method which computes the distance between two points
	 */
	private static double getDistance(double x1, double y1, double x2, double y2) 
	{	
		double xDist = x1 - x2;
		double yDist = y1 - y2;
		double dist = Math.sqrt(Math.pow(xDist, 2)+ Math.pow(yDist, 2));
		
		return dist;
	}
	
	/**
	 * computePointDistances
	 *
	 * Test method which prints out the distances between points
	 */
	private static void computePointDistances(double[][] points)
	{
		double firstX = points[0][0];
		double firstY = points[0][1];
		System.out.print("\n");
		double distance = 0d;
		for (int i=1; i<points.length; i++) {
			distance = getDistance(firstX, firstY, points[i][0], points[i][1]);
			System.out.println("Distance from point #1 to point #" + (i+1) + " = " + distance );
		}
	}
}