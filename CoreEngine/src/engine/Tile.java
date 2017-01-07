package engine;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.newdawn.slick.opengl.Texture;

import lightning.loading.TextureLoaderHub;
import lightning.vecmath.Vec2;

public class Tile {
	public int id;
	public int tileset;
	public AABB aabb;
	
	public Tile(int id, int tileset) {
		this.id = id;
		this.tileset = tileset;
		if(id != 0)
			this.aabb = new AABB();
		else {
			this.aabb = new AABB(new Vec2[]{
					new Vec2(-1,-1),
					new Vec2(-1,-1)
			});
		}
	}
	
	public void render(double x, double y) {
		Texture texture = null;
		try {
			texture = TextureLoaderHub.getTexture("png", Paths.get("").toAbsolutePath().toString()+File.separator+"assets"+File.separator+"tilesets"+File.separator+tileset+File.separator+id+".png");
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
		if(id != 0) {
			aabb.points[0] = new Vec2(x-0.5,y-0.5);
			aabb.points[1] = new Vec2(x+0.5,y+0.5);
		}
	}
}
