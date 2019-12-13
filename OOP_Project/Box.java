import java.util.*;
public class Box{
	private Point leftTop;
	private Point rightBottom;
	Photo photo;

	public Box(Point top, Point bottom,Photo photo){
		leftTop = top;
		rightBottom = bottom;
		this.photo = photo;
	}
	public Box(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY, Photo photo2){
		this(new Point(topLeftX,topLeftY), new Point(bottomRightX,bottomRightY), photo2);
	}

	public Point getLeftTop(){
		return leftTop;
	}
	public Point getRightBottom(){
		return rightBottom;
	}
	public void setLeftTop(Point top){
		leftTop = top;
	}
	public void setRightBottom(Point bottom){
		rightBottom = bottom;
	}
	public int getLength(){
		return getRightBottom().getX() - getLeftTop().getX() ;
	}
	public int getHeight(){
		return getRightBottom().getY() - getLeftTop().getY();
	}

	public void shiftBox(int x, int y){
		leftTop.setX(x - getLength()/2); 
		leftTop.setY(y - getHeight()/2);
		rightBottom.setX(x + getLength()/2);
		rightBottom.setY(y + getHeight()/2);
	}

	public void resize(int value){
		leftTop.setX(leftTop.getX() - value);
		leftTop.setY(leftTop.getY() - value);
		rightBottom.setX(rightBottom.getX() + value);
		rightBottom.setY(rightBottom.getY() + value);
	}

	public List<Point> drawLines(){
		List<Point> result = new ArrayList<>();
		int startLeftX = leftTop.getX();
		int startLeftY = leftTop.getY();
		int startRightX = rightBottom.getX();
		int startRightY = rightBottom.getY();
		for(int i = 0;i<getLength()+1;i++){
			result.add(new Point(startLeftX+i,startLeftY));
			result.add(new Point(startLeftX+i,startRightY));
		}
		for(int j = 0;j<getHeight();j++){
			result.add(new Point(startLeftX,startLeftY+j));
			result.add(new Point(startRightX,startLeftY+j));
		}
		return result;
	}
}