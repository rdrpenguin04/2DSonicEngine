package engine;

import lightning.vecmath.*;
import static java.lang.Math.*;

public class Rotation {
	public static Vec2 rotateVec2(Vec2 initial, double amount) {
		Mat2 rotationMatrix = new Mat2();
		rotationMatrix.data = new double[][]{
			new double[]{cos(amount),-sin(amount)},
			new double[]{sin(amount), cos(amount)}
		};
		return rotationMatrix.mul(initial);
	}
}
