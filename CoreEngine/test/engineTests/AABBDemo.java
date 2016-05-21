package engineTests;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;

import engine.AABB;
import lightning.vecmath.Vec2;

public class AABBDemo {
	private static AABB a = new AABB(new Vec2[]{new Vec2(0,0),new Vec2(10,10)});
	private static AABB b = new AABB(new Vec2[]{new Vec2(11,0),new Vec2(21,10)});
	public static void main(String[] args) throws InterruptedException {
		long fpsTerms = 0;
		long fpsSum = 0;
		try {
			Display.setDisplayMode(new DisplayMode(500, 500));
			Display.setTitle("Collision Demo: AABBs");
			Display.create();
		} catch (LWJGLException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		glOrtho(-20, 20, -20, 20, -1, 1);
		glClearColor(0, 0, 0, 1);
		glDisable(GL_DEPTH_TEST);
		long initTime = System.nanoTime();
		long lastTime = initTime;
		while (!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT);
			long curTime = System.nanoTime() - initTime;
			glBegin(GL_QUADS); {
				glColor4f(1,1,0,1);
				glVertex2d(a.points[0].x,a.points[0].y);
				glColor4f(0,1,1,1);
				glVertex2d(a.points[1].x,a.points[0].y);
				glColor4f(1,0,1,1);
				glVertex2d(a.points[1].x,a.points[1].y);
				glColor4f(0.5f,0.75f,0.25f,1);
				glVertex2d(a.points[0].x,a.points[1].y);
			}glEnd();
			
			glBegin(GL_QUADS); {
				glColor4f(1,1,0,1);
				glVertex2d(b.points[0].x,b.points[0].y);
				glColor4f(0,1,1,1);
				glVertex2d(b.points[1].x,b.points[0].y);
				glColor4f(1,0,1,1);
				glVertex2d(b.points[1].x,b.points[1].y);
				glColor4f(0.5f,0.75f,0.25f,1);
				glVertex2d(b.points[0].x,b.points[1].y);
			}glEnd();
			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
				b.points[0].x -= (curTime-lastTime) / 100000000.0;
				b.points[1].x -= (curTime-lastTime) / 100000000.0;
				if(a.isIntersecting(b)) {
					b.points[0].x += (curTime-lastTime) / 100000000.0;
					b.points[1].x += (curTime-lastTime) / 100000000.0;
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
				b.points[0].x += (curTime-lastTime) / 100000000.0;
				b.points[1].x += (curTime-lastTime) / 100000000.0;
				if(a.isIntersecting(b)) {
					b.points[0].x -= (curTime-lastTime) / 100000000.0;
					b.points[1].x -= (curTime-lastTime) / 100000000.0;
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
				b.points[0].y += (curTime-lastTime) / 100000000.0;
				b.points[1].y += (curTime-lastTime) / 100000000.0;
				if(a.isIntersecting(b)) {
					b.points[0].y -= (curTime-lastTime) / 100000000.0;
					b.points[1].y -= (curTime-lastTime) / 100000000.0;
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
				b.points[0].y -= (curTime-lastTime) / 100000000.0;
				b.points[1].y -= (curTime-lastTime) / 100000000.0;
				if(a.isIntersecting(b)) {
					b.points[0].y += (curTime-lastTime) / 100000000.0;
					b.points[1].y += (curTime-lastTime) / 100000000.0;
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
				a.points[0].x -= (curTime-lastTime) / 100000000.0;
				a.points[1].x -= (curTime-lastTime) / 100000000.0;
				if(a.isIntersecting(b)) {
					a.points[0].x += (curTime-lastTime) / 100000000.0;
					a.points[1].x += (curTime-lastTime) / 100000000.0;
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
				a.points[0].x += (curTime-lastTime) / 100000000.0;
				a.points[1].x += (curTime-lastTime) / 100000000.0;
				if(a.isIntersecting(b)) {
					a.points[0].x -= (curTime-lastTime) / 100000000.0;
					a.points[1].x -= (curTime-lastTime) / 100000000.0;
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
				a.points[0].y += (curTime-lastTime) / 100000000.0;
				a.points[1].y += (curTime-lastTime) / 100000000.0;
				if(a.isIntersecting(b)) {
					a.points[0].y -= (curTime-lastTime) / 100000000.0;
					a.points[1].y -= (curTime-lastTime) / 100000000.0;
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
				a.points[0].y -= (curTime-lastTime) / 100000000.0;
				a.points[1].y -= (curTime-lastTime) / 100000000.0;
				if(a.isIntersecting(b)) {
					a.points[0].y += (curTime-lastTime) / 100000000.0;
					a.points[1].y += (curTime-lastTime) / 100000000.0;
				}
			}
			Display.update();
			fpsTerms++;
			fpsSum += 1000000000 / (curTime-lastTime);
			System.out.printf("fps: %2d\n", 1000000000 / (curTime-lastTime));
			System.out.println("average fps: "+fpsSum/fpsTerms);
			lastTime = curTime;
		}
		Display.destroy();
	}
}