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
			Display.setDisplayMode(new DisplayMode(1000, 1000));
			Display.create();
		} catch (LWJGLException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		glOrtho(-2, 2, -2, 2, -1, 1);
		glClearColor(0, 0, 0, 1);
		glDisable(GL_DEPTH_TEST);
		long initTime = System.nanoTime();
		Vec2[] vectors = new Vec2[] {
			new Vec2(-1,-1), new Vec2( 1,-1), 
			new Vec2( 1, 1), new Vec2(-1, 1)
		};
		Vec2[] rotated = new Vec2[4];
		int j = 0;
		while (!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT);
			j++;
			long curTime = System.nanoTime() - initTime;
			for(int i = 0; i < 4; i++) {
				rotated[i] = rotateVec2(vectors[i], Math.toRadians(curTime / 50000000.0));
			}
			glBegin(GL_QUADS); {
				glColor4f(1,1,1,1);
				glVertex2d(rotated[0].x,rotated[0].y);
				glVertex2d(rotated[1].x,rotated[1].y);
				glColor4f(0.5f,0.5f,0.5f,1);
				glVertex2d(rotated[2].x,rotated[2].y);
				glVertex2d(rotated[3].x,rotated[3].y);
			}glEnd();
			Display.update();
			Thread.sleep(100);
			System.out.println(j);
		}
		Display.destroy();
	}
}
