import java.util.*;
public class FaceComponentDetection{
	private Photo photo;
	private Box box;
	public FaceComponentDetection(Photo photo){
		this.photo = photo;
		box = null;
	}
	private int moment(int i, int j, int value){
	 	int sum = 0;
	 	for(Point p: photo.getPhoto2D()){
	 		if(p.getElement() == value){
	 			sum = sum + (int)Math.pow(p.getX(),i)*(int)Math.pow(p.getY(),j);
	 		}
	 	}
	 	return sum;
	}

	public Box getBox(){
		return box;
	}

	public void setBox(Box newBox){
		box = newBox;
	}

	public Point centroid(int value){
		int x_0 = moment(1,0,value)/moment(0,0,value);
		int y_0 = moment(0,1,value)/moment(0,0,value);
		Point centralPoint = new Point(x_0, y_0);
		return centralPoint;
	}

	public void centralBox(int value){
		int count = 0;
		int sumX = 0;
		int sumY = 0;
		Point centroidPoint = centroid(value);
		int centroidX = centroidPoint.getX();
		int centroidY = centroidPoint.getY();

		for(Point p: photo.getPhoto2D()){
	 		if(p.getElement() == value){
	 			sumX = sumX + (int)Math.pow(p.getX() - centroidX,2);
	 			sumY = sumY + (int)Math.pow(p.getY() - centroidY,2);
	 			count++;
	 		}
	 	}
	 	int sigmaX = sumX/count;
	 	int sigmaY = sumY/count;
	 	Box newBox = new Box(centroidPoint.getX() - sigmaX, centroidPoint.getY() - sigmaY, centroidPoint.getX() + sigmaX, centroidPoint.getY() + sigmaY, photo);
	 	setBox(newBox);

	}

	public void draw(){
		int oldValue = photo.getPhoto2D().get(0).getElement();
		List<Point> boxLines = new ArrayList<>();
		if(box != null){
			boxLines = box.drawLines();
		}
		for(Point pixel: photo.getPhoto2D()){
			int elemValue = pixel.getY();
			if(oldValue!=elemValue){
				System.out.println("");
				oldValue = elemValue;
			}
			boolean notPrinted = true;
			if(box != null){
				for(Point boxPoint: boxLines){
					if(boxPoint.getX() == pixel.getX() && boxPoint.getY() == pixel.getY()){
						System.out.print(boxPoint.getElement());
						notPrinted = false;
						break;
					}
				}
			}
			if(notPrinted){
				System.out.print(pixel.getElement());
			}
		}
	}

}