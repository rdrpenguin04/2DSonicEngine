package engineTests;

import static org.junit.Assert.*;

import org.junit.Test;

import engine.Rotation;
import lightning.vecmath.Vec2;

public class RotationTest {
	private Vec2 known = new Vec2(1,1);
	private Vec2 supposedResult = new Vec2(-1,1);
	@Test
	public void testRotateVec2() {
		assert(Rotation.rotateVec2(known, 90)==supposedResult);
	}

}
