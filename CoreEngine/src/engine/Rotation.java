package engine;

import lightning.vecmath.*;
import static java.lang.Math.*;

public class Rotation {
	public static Vec2 rotateVec2(Vec2 initial, double amount) {
		Mat2 rotationMatrix = new Mat2();
		rotationMatrix.data = new double[][]{
			new double[]{ cos(amount),-sin(amount)},
			new double[]{ sin(amount), cos(amount)}
		};
		return rotationMatrix.mul(initial);
	}
	
	public static Vec2 rotateVec2B(Vec2 initial, double amount) {
		Mat2 rotationMatrix = new Mat2();
		rotationMatrix.data = new double[][]{
			new double[]{ cosB(amount),-sinB(amount)},
			new double[]{ sinB(amount), cosB(amount)}
		};
		return rotationMatrix.mul(initial);
	}
	
	private static double sinB(double in) {
		in %= 360;
		if (in < 0)
			in += 360;
		if(in > 180)
			return -((4 * (in - 180) * (360 - in))/(40500 - (in - 180) * (360 - in)));
		else
			return ((4 * in * (180 - in))/(40500 - in * (180 - in)));
	}
	
	private static double cosB(double in) {
		in -= 90;
		return sinB(in);
	}
}
