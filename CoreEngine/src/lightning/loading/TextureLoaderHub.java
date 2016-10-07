package lightning.loading;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureLoaderHub {
	private static ArrayList<String> locations = new ArrayList<String>();
	private static ArrayList<Texture> textures = new ArrayList<Texture>();
	
	public static Texture getTexture(String type, String location) throws IOException {
		int index = locations.indexOf(location);
		if(index < 0) {
			locations.add(location);
			index = textures.size();
			textures.add(TextureLoader.getTexture(type, new FileInputStream(location)));
		}
		return textures.get(index);
	}
}
