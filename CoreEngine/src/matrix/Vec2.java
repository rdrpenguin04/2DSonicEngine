package matrix;

import static java.lang.Math.*;

public class Vec2 {
	public double x, y;
	private double prevX, prevY;
	private double magSquared;
	private double magnitude;
	
	public Vec2() {
		this(0,0);
	}
	
	public Vec2(double xy){
		this(xy, xy);
	}
	
	public Vec2(double x, double y) {
		this.x = prevX = x;
		this.y = prevY = y;
		magSquared = pow(x, 2) + pow(y, 2);
		magnitude = sqrt(magSquared);
	}
	
	public Vec2(Vec2 clone) {
		this(clone.x, clone.y);
	}
	
	public Vec2 add(Vec2 other) {
		x+=other.x;
		y+=other.y;
		return this;
	}
	
	public Vec2 sub(Vec2 other) {
		x-=other.x;
		y-=other.y;
		return this;
	}
	
	public Vec2 mul(Vec2 other) {
		x*=other.x;
		y*=other.y;
		return this;
	}
	
	Vec2 mul(Vec2[] vecData) {
		x=vecData[0].x*x+vecData[0].y*y;
		y=vecData[1].x*x+vecData[1].y*y;
		return this;
	}
	
	public Vec2 div(Vec2 other) {
		x/=other.x;
		y/=other.y;
		return this;
	}
	
	public void updateVars(){
		if(!(prevX==x && prevY==y)) {
			magSquared = pow(x, 2) + pow(y, 2);
			magnitude = sqrt(magSquared);
			prevX=x;
			prevY=y;
		}
	}
	
	public double magSquared() {
		updateVars();
		return magSquared;
	}
	
	public double magnitude() {
		updateVars();
		return magnitude;
	}
}
