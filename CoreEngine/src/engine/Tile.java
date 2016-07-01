package engine;

import static org.lwjgl.opengl.GL11.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.newdawn.slick.opengl.TextureLoader;

public class Tile {
	public int id;
	public int tileset;
	
	public Tile(int id, int tileset) {
		this.id = id;
		this.tileset = tileset;
	}
	
	public void render(double x, double y) {
		try {
			TextureLoader.getTexture("png", new FileInputStream(Tile.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath())).bind();
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		glBegin(GL_QUADS);{
			glTexCoord2f(0,0);
			glVertex2d(x-0.5,y+0.5);
			glTexCoord2f(0,1);
			glVertex2d(x-0.5,y-0.5);
			glTexCoord2f(1,1);
			glVertex2d(x+0.5,y-0.5);
			glTexCoord2f(1,0);
			glVertex2d(x+0.5,y+0.5);
		}glEnd();
	}
}
