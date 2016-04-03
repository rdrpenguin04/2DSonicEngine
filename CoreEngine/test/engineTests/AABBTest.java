package engineTests;

import static org.junit.Assert.*;

import org.junit.Test;

import engine.AABB;
import lightning.vecmath.Vec2;

public class AABBTest {
	
	private AABB a = new AABB(new Vec2[]{
			new Vec2(0,0),
			new Vec2(10,10)
	});
	private AABB b = new AABB(new Vec2[]{
			new Vec2(5,0),
			new Vec2(15,10)
	});
	private AABB c = new AABB(new Vec2[]{
			new Vec2(11,0),
			new Vec2(21,10)
	});
	private AABB d = new AABB(new Vec2[]{
			new Vec2(0,5),
			new Vec2(10,15)
	});
	private AABB e = new AABB(new Vec2[]{
			new Vec2(0,11),
			new Vec2(10,21)
	});
	
	@Test
	public void test() {
		assertTrue(a.isIntersecting(b));
		assertTrue(a.isIntersecting(d));
		assertFalse(a.isIntersecting(c));
		assertFalse(a.isIntersecting(e));
	}
}
