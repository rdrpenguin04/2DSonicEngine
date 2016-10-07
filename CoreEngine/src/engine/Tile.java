package engine;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import lightning.loading.TextureLoaderHub;

public class Tile {
	public int id;
	public int tileset;
	
	public Tile(int id, int tileset) {
		this.id = id;
		this.tileset = tileset;
	}
	
	public void render(double x, double y) {
		Texture texture = null;
		try {
			texture = TextureLoaderHub.getTexture("jpg", ".."+File.separator+"assets"+File.separator+"tilesets"+File.separator+tileset+File.separator+id+".jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		texture.bind();
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
