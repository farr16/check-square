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
		for (int i=0; i<points.length; i++) 
		{
			System.out.println("Point #" + (i+1) + ": (" + points[i][0] + " , " + points[i][1] + ")");
		}
		
		Double[] distances = computePointDistances(points);
		for (int i=0; i<distances.length; i++) 
		{
			System.out.println("Distance from Point #1 to Point #" + (i+2) + " = " + distances[i]);
		}
		
		int sideIdx, hypoTestIdx;
		sideIdx = hypoTestIdx = -1;
		if (distances[0].compareTo(distances[1]) == 0) 
		{
			sideIdx = 0;
			hypoTestIdx = 2;
			System.out.println("Edge from point#1 to point#2 and edge from point#1 to point#3 are equal in length");
		} else if (distances[0].compareTo(distances[2]) == 0) 
		{
			sideIdx = 0;
			hypoTestIdx = 1;
			System.out.println("Edge from point#1 to point#2 and edge from point#1 to point#4 are equal in length");
		}
		else if (distances[1].compareTo(distances[2]) == 0) 
		{
			sideIdx = 1;
			hypoTestIdx = 0;
			System.out.println("Edge from point#1 to point#3 and edge from point#1 to point#4 are equal in length");
		} else 
		{
			System.out.println("Points fail test #1, points do not form the corners of a square.");
			System.exit(0);
		}
		
		// Test if the hypotenuse distance is the expected length given the length of the sides
		// NOTE: This calculation only seems to be precise enough for non-rotated squares
		if (distances[hypoTestIdx].compareTo(distances[sideIdx] * Math.sqrt(2)) == 0) 
		{
			System.out.println("Hypotenuse distance is correct!");
		} else 
		{
			System.out.println("Hypotenuse distance is incorrect!");
			System.exit(0);
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
	private static Double[] computePointDistances(double[][] points)
	{
		double firstX = points[0][0];
		double firstY = points[0][1];
		System.out.print("\n");
		
		double distance = 0d;
		Double[] distances = new Double[3];
		for (int i=1; i<points.length; i++) {
			distance = getDistance(firstX, firstY, points[i][0], points[i][1]);
			distances[i-1] = distance;
		}
		
		return distances;
	}
}