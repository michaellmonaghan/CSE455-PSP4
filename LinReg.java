

/**
 * Author: Michael Monaghan
**/

import java.util.Scanner;

class LinReg {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Number of entries");
		int count = s.nextInt();
		double[] x = new double[count];
		double[] y = new double[count];
		System.out.println("Input entries:\nX1 Y1\nX2 Y2\n...\nXn Yn\n");
		for (int i = 0; i < count; i++) {
			System.out.print((i + 1) + ": ");
			x[i] = s.nextDouble();
			y[i] = s.nextDouble();
		}
		
		
		double xavg = avg(x);
		double yavg = avg(y);
		double b1 = b1(x, y, xavg, yavg);
		double b0 = b0(b1, xavg, yavg);
		
		System.out.println("xavg: " + xavg);
		System.out.println("yavg: " + yavg);
		System.out.println("B1: " + b1);
		System.out.println("B0: " + b0);
	}
	
	private static double avg(double[] n) {
		double sum = 0;
		for (double d : n) {
			sum += d;
		}
		return sum / n.length;
	}
	
	public static double b1(double[] x, double[] y, double xavg, double yavg){
		int n = x.length;
		double num = 0d, den = 0d;
		
		for (int i = 0; i < n; i++) {
			num += (x[i] * y[i]) - (n * xavg * yavg);
		}
		
		for (int i = 0; i < n; i++) {
			den += (x[i] * x[i]) - (n * xavg * xavg);
		}
		
		return num / den;
		
		
	}
	
	public static double b0 (double b1,double xavg, double yavg) {
		return yavg - b1 * xavg;
	}
	
	public static double y(double x, double b0, double b1) {
		return b0 + b1 * x;
	}
}
