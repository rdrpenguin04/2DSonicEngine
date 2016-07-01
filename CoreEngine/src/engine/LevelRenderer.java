package engine;

public class LevelRenderer {
	public Tile[][] levelTiles = new Tile[0][0];
	public int[][] level = new int[0][0];
	public int tileset = 0;
	public boolean upToDate = false;
	
	public void render(double x, double y) {
		if(!upToDate) update();
		for(int i = 0; i < levelTiles.length; i++) {
			for(int j = 0; j < levelTiles[0].length; j++) {
				levelTiles[i][j].render(i + x, j + y);
			}
		}
	}
	
	public void update() {
		if(level[0].length != levelTiles[0].length) {
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
