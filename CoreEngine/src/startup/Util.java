package startup;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Util {
	private static long fpsTerms = 0;
	private static long fpsSum = 0;
	private static long lastTime;
	public static long initTime;
	public static void setupGL(int width, int height) {
		initTime = System.nanoTime();
		lastTime = initTime;
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("Level Rendering Demo");
			Display.create();
		} catch (LWJGLException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		glOrtho(0, 20, 0, 20, -1, 1);
		glClearColor(0, 0.70703125f, 1, 1);
		glEnable(GL_TEXTURE_2D);
		glDisable(GL_DEPTH_TEST);
	}
	
	public static void renderAndUpdate(int fps) {
		long curTime = System.nanoTime() - initTime;
		Display.update();
		fpsTerms++;
		fpsSum += 1000000000 / (curTime-lastTime);
		System.out.printf("fps: %2d\n", 1000000000 / (curTime-lastTime));
		System.out.println("average fps: "+fpsSum/fpsTerms);
		lastTime = curTime;
		Display.sync(fps);
	}
}
