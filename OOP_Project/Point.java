public class Point{
	int x_cord;
	int y_cord;
	int element;

	public Point(int x, int y){
		x_cord = x;
		y_cord = y;
		element = 5;
	}
	public Point(int x, int y, int elem){
		x_cord = x;
		y_cord = y;
		element = elem;
	}

	public int getX(){
		return x_cord;
	}
	public int getY(){
		return y_cord;
	}
	public int getElement(){
		return element;
	}
	public void setElement(int e){
		element = e;
	}
	public void setX(int x){
		x_cord = x;
	}
	public void setY(int y){
		y_cord = y;
	}
}