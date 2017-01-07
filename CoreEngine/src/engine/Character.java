package engine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import org.newdawn.slick.opengl.Texture;

import lightning.loading.TextureLoaderHub;

public class Character {
	private int[] numAnimationFrames;
	
	public Texture[][] leftAnimations;
	public Texture[][] rightAnimations;
	
	public double rotation;
	
	public Character(String name, int tileset, int numAnimationFrames[], int numModes) throws IOException {
		leftAnimations = new Texture[numModes][];
		rightAnimations = new Texture[numModes][];
		for(int j = 0; j < numAnimationFrames.length; j++) {
			leftAnimations[j] = rightAnimations[j] = new Texture[numAnimationFrames[j]];
			this.numAnimationFrames = Arrays.copyOf(numAnimationFrames, numAnimationFrames.length);
			for(int i = 0; i < numAnimationFrames[j]; i++) {
				leftAnimations[j][i] = TextureLoaderHub.getTexture("PNG", Paths.get("").toAbsolutePath().toString()+File.separator+"assets"+File.separator+"tilesets"+File.separator+tileset+File.separator+name+"Left"+j+"_"+i);
				rightAnimations[j][i] = TextureLoaderHub.getTexture("PNG", Paths.get("").toAbsolutePath().toString()+File.separator+"assets"+File.separator+"tilesets"+File.separator+tileset+File.separator+name+"Right"+j+"_"+i);
			}
		}
	}
	
	public void rotate(double radians) {
		rotation += radians;
	}
	
	public void resetRotation() {
		rotation = 0;
	}
	
	public double getRotation() {
		return rotation;
	}
	
	public Texture getLeftTexture(int index, int mode) {
		index %= numAnimationFrames[mode];
		return leftAnimations[mode][index];
	}
	
	public Texture getRightTexture(int index, int mode) {
		index %= numAnimationFrames[mode];
		return rightAnimations[mode][index];
	}
}
