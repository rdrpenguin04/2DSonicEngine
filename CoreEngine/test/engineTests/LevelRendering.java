package engineTests;

import engine.Level;
import engine.LevelLoader;
import engine.LevelRenderer;
import startup.Util;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class LevelRendering {
	public static void main(String[] args) {
		Util.setupGL(500, 500);
		LevelLoader ll = new LevelLoader(0);
		Level l = ll.load();
		LevelRenderer lr = new LevelRenderer();
		lr.level = l.level.clone();
		lr.upToDate = false;
		double x = 0;
		double y = 0;
		while (!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT);
			lr.render(l.spawnX + x, l.spawnY + y);
			x -= 0.005;
			y -= 0.001;
			Util.renderAndUpdate(60);
		}
		Display.destroy();
	}
}
