package engineTests;

import static engine.Rotation.*;
import lightning.vecmath.*;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class RotationDemo {
	public static void main(String[] args) throws InterruptedException {
		try {
			Display.setDisplayMode(new DisplayMode(500, 500));
			Display.create();
		} catch (LWJGLException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		glOrtho(-2, 2, -2, 2, -1, 1);
		glClearColor(0, 0, 0, 1);
		glDisable(GL_DEPTH_TEST);
		long initTime = System.nanoTime();
		long lastTime = initTime;
		Vec2[] vectors = new Vec2[] {
			new Vec2(-1,-1), new Vec2( 1,-1), 
			new Vec2( 1, 1), new Vec2(-1, 1)
		};
		Vec2[] rotated;
		while (!Display.isCloseRequested()) {
			rotated = vectors.clone();
			glClear(GL_COLOR_BUFFER_BIT);
			long curTime = System.nanoTime() - initTime;
			for(int i = 0; i < 4; i++) {
				rotated[i]=rotateVec2(rotated[i], Math.toRadians(curTime/25000000.0));
			}
			glBegin(GL_QUADS); {
				glColor4f(1,1,0,1);
				glVertex2d(rotated[0].x,rotated[0].y);
				glColor4f(0,1,1,1);
				glVertex2d(rotated[1].x,rotated[1].y);
				glColor4f(1,0,1,1);
				glVertex2d(rotated[2].x,rotated[2].y);
				glColor4f(0.5f,0.75f,0.25f,1);
				glVertex2d(rotated[3].x,rotated[3].y);
			}glEnd();
			Display.update();
			System.out.printf("fps: %2d\n", 1000000000 / (curTime-lastTime));
			lastTime = curTime;
		}
		Display.destroy();
	}
	
	public static Vec2 rotateVec2(Vec2 initial, double amount) {
		Vec2 result = new Vec2();
		result.x = (Math.cos(amount) * initial.x) + (-Math.sin(amount) * initial.y);
		result.y = (Math.sin(amount) * initial.x) + ( Math.cos(amount) * initial.y);
		return result;
	}
}
