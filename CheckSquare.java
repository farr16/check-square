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
	
	private static final double EPSILON = 0.0000000001d;
	
	public static void main(String[] args)
	{
		double[][] points = getPointsFromInput();
		
		// Sum up each of the coordinates in order to calculate their center, printing out each point while
		// doing so
		double sumX, sumY;
		sumX = sumY = 0;
		System.out.print("\n");
		for (int i=0; i<points.length; i++) 
		{
			System.out.println("Point #" + (i+1) + ": (" + points[i][0] + " , " + points[i][1] + ")");
			sumX += points[i][0];
			sumY += points[i][1];
		}
		
		double centerX = sumX/4.0d;
		double centerY = sumY/4.0d;
		
		// Create a vector v = Point1 - Center;
		double[] v = new double[2];
		v[0] = points[0][0] - centerX;
		v[1] = points[0][1] - centerY;
		
		// Create a vector that is v rotated by 90 degrees
		double[] v2 = new double[2];
		v2[0] = -1.0d * v[1];
		v2[1] = v[0];
		
		// Create points which would match the square's other points
		double[][] projectedPoints = new double[3][2];
		// projected point 1 = center - v
		projectedPoints[0][0] = centerX - v[0];
		projectedPoints[0][1] = centerY - v[1];
		// projected point 2 = center + v2
		projectedPoints[1][0] = centerX + v2[0];
		projectedPoints[1][1] = centerY + v2[1];
		// projected point 3 = center - v2;
		projectedPoints[2][0] = centerX - v2[0];
		projectedPoints[2][1] = centerY - v2[1];
		
		// Print out projected points
		System.out.println("");
		for (int i=0; i<projectedPoints.length; i++) 
		{
			System.out.println("Projected Point #" + (i+1) + ": (" + projectedPoints[i][0] + " , " + projectedPoints[i][1] + ")");
		}
		
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
	
	private static boolean checkDoubleEquals(double first, double second) 
	{
		return Math.abs(first-second) < EPSILON;
	}
	
}