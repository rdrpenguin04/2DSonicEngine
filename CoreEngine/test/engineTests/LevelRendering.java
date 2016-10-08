package engineTests;

import engine.Level;
import engine.LevelLoader;
import engine.LevelRenderer;
import util.Util;

import static org.lwjgl.opengl.GL11.*;

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
		while (!Util.isClosing()) {
			glClear(GL_COLOR_BUFFER_BIT);
			lr.render(l.spawnX + x, l.spawnY + y);
			x -= 0.005;
			y -= 0.001;
			Util.renderAndUpdate(60);
		}
		Util.destroy();
	}
}
