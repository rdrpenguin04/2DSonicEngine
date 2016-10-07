package engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class LevelLoader {
	private String name;
	public LevelLoader(int levelID) {
		this(".." + File.separator + "assets" + File.separator + "levels" + File.separator + levelID + ".lvl");
	}
	
	LevelLoader(String fileName) {
		try {
			new Scanner(new FileInputStream(fileName)).close();
		} catch (FileNotFoundException e) {e.printStackTrace();System.exit(1);}
		name = fileName;
	}
	
	public LevelLoader() {
		this(0);
	}
	
	public Level load() {
		Level l = new Level();
		Path path = Paths.get(name);
		byte[] data = null;
		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		l.sizeX = data[0]*256+data[1];
		l.sizeY = data[2]*256+data[3];
		l.spawnX = data[4]*256+data[5];
		l.spawnY = data[6]*256+data[7];
		l.tileset = data[8]*256+data[9];
		l.level = new int[l.sizeX][l.sizeY];
		int n = 0;
		for(int i = 0; i < l.sizeX; i++) {
			for(int j = 0; j < l.sizeY; j++) {
				l.level[i][j] = data[10+n];
				n++;
			}
		}
		return l;
	}
}
