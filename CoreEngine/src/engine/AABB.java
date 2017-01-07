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
	
	public double getIntersectionX(AABB other) {
		double maximum = 0;
		if(!isIntersecting(other)) return 0;
		double tmp = other.points[1].x - points[0].x;
		if(tmp > maximum) maximum = tmp;
		tmp = points[1].x - other.points[0].x;
		if(tmp > maximum) maximum = tmp;
		return maximum;
	}
	
	public boolean isIntersecting(AABB other) {
		verifyOrder();
		other.verifyOrder();
		return (points[0].x < other.points[1].x) && (points[1].x > other.points[0].x) && (points[0].y < other.points[1].y) && (points[1].y > other.points[0].y);
	}
	
	public AABB translate(double x, double y) {
		return new AABB(new Vec2[]{
				new Vec2(points[0].x + x, points[0].y + y),
				new Vec2(points[1].x + x, points[1].y + y)
				});
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
