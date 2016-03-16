package matrix;

public class Mat2 {
	public double[][] data;
	private double[][] prevData;
	private Vec2[] vecData;
	
	public Mat2(){
		data = new double[2][2];
	}
	
	public void updateData() {
		if(data!=prevData) {
			prevData = data.clone();
			for(int i = 0; i < 2; i++) {
				vecData[i].x = data[i][0];
				vecData[i].y = data[i][1];
			}
		}
	}
	public Mat2 mul(Mat2 other) {
		updateData();
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				data[i][j]*=other.data[i][j];
			}
		}
		return this;
	}
	
	public Vec2 mul(Vec2 vector) {
		return new Vec2(vector).mul(vecData);
	}
}
