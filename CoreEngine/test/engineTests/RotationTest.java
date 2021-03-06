package engineTests;

import static org.junit.Assert.*;

import org.junit.Test;

import engine.Rotation;
import lightning.vecmath.Vec2;

public class RotationTest {
	private Vec2 known = new Vec2(-1,-1);
	private Vec2 supposedResult = new Vec2(0.9999999999999999,-1.0);
	@Test
	public void testRotateVec2() {
		assertTrue(Rotation.rotateVec2(known, Math.toRadians(90)).equals(supposedResult));
	}
}
