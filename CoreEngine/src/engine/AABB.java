package engine;

import javax.naming.directory.InvalidAttributesException;

import lightning.vecmath.Vec2;

public class AABB {
	public Vec2[] points = new Vec2[2];
	public AABB() {}
	public AABB(Vec2[] points) {
		if(points.length != 2) {
			RuntimeException e = new RuntimeException();
			e.initCause(new InvalidAttributesException());
			throw e;
		}
		this.points = points;
	}
	
	public boolean isIntersecting(AABB other) {
		verifyOrder();
		other.verifyOrder();
		return (points[0].x < other.points[1].x) && (points[1].x > other.points[0].x) && (points[0].y < other.points[1].y) && (points[1].y > other.points[0].y);
	}
	
	public void verifyOrder() {
		double tmp;
		if (points[0].x > points[1].x) {
			tmp = points[0].x;
			points[0].x = points[1].x;
			points[1].x = tmp;
		}
		if (points[0].y > points[1].y) {
			tmp = points[0].y;
			points[0].y = points[1].y;
			points[1].y = tmp;
		}
	}
}
