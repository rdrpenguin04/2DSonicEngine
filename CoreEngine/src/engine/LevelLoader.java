package engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LevelLoader {
	private Scanner scanner;
	public LevelLoader(int levelID) {
		this(".." + File.separator + "assets" + File.separator + "levels" + File.separator + levelID + ".lvl");
	}
	
	LevelLoader(String fileName) {
		try {
			scanner = new Scanner(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {e.printStackTrace();System.exit(1);}
	}
	
	public LevelLoader() {
		this(0);
	}
	
	public Level load() {
		Level l = new Level();
		l.sizeX = scanner.nextByte()*256+scanner.nextByte();
		l.sizeY = scanner.nextByte()*256+scanner.nextByte();
		l.spawnX = scanner.nextByte()*256+scanner.nextByte();
		l.spawnY = scanner.nextByte()*256+scanner.nextByte();
		l.tileset = scanner.nextByte()*256+scanner.nextByte();
		l.level = new int[l.sizeX][l.sizeY];
		for(int i = 0; i < l.sizeX; i++) {
			for(int j = 0; j < l.sizeY; j++) {
				l.level[i][j] = scanner.nextByte();
			}
		}
		return l;
	}
}
