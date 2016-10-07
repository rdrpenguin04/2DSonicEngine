package engine;

import org.newdawn.slick.Color;

public class LevelRenderer {
	public Tile[][] levelTiles = new Tile[0][0];
	public int[][] level = new int[0][0];
	public int tileset = 0;
	public boolean upToDate = false;
	
	public void render(double x, double y) {
		if(!upToDate) update();
		Color.white.bind();
		for(int i = 0; i < levelTiles.length; i++) {
			for(int j = 0; j < levelTiles[0].length; j++) {
				levelTiles[levelTiles[0].length-j-1][i].render(i + x, j + y);
			}
		}
	}
	
	public void update() {
		if((level.length != 0) && (levelTiles.length != 0) && (level[0].length != levelTiles[0].length)) {
			if(level.length == levelTiles.length){
				for(int i = 0; i < level.length; i++) {
					levelTiles[i] = new Tile[level[i].length];
				}
			}
		}
		
		if(level.length != levelTiles.length){
			levelTiles = new Tile[level.length][level[0].length];
			for(int i = 0; i < level.length; i++) {
				levelTiles[i] = new Tile[level[i].length];
			}
		}
		
		for(int i = 0; i < level.length; i++) {
			for(int j = 0; j < level[0].length; j++) {
				levelTiles[i][j] = new Tile(level[i][j],tileset);
			}
		}
		upToDate = true;
	}
}
