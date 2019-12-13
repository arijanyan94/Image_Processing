import java.util.Scanner;
import java.lang.*;

public class Test{
	public static void main(String[] args) {
		FaceComponentDetection fcd = new FaceComponentDetection(new Photo());
		Scanner sc = new Scanner(System.in);
		while(true){
			userInterface(sc,fcd);
		}
	}

	public static void userInterface(Scanner sc, FaceComponentDetection component){
		System.out.println(" Welcome !!!");
		System.out.println(" Here are the commands:");
		System.out.println(" resize");
		System.out.println(" shift");
		System.out.println(" centralbox");
		System.out.println(" exit");

		component.draw();
		System.out.println();
		System.out.println("Write a command");
		String input1 = sc.next();
		if(input1.equals("resize")){
			if(component.getBox() == null){
				System.out.println("Please first create a box!");
			}else{
				System.out.println("Resize by how much?");
				int size = sc.nextInt();
				component.getBox().resize(size);
				component.draw();
			}
		}else if(input1.equals("shift")){
			if(component.getBox() == null){
				System.out.println("Please first create a box!");
			}else{
				System.out.println("Write x and y coordinates.");
				int x = sc.nextInt();
				int y = sc.nextInt();
				component.getBox().shiftBox(x,y);
				component.draw();
			}
		}else if(input1.equals("centralbox")){
			System.out.println("Of which value?");
			int value = sc.nextInt();
			component.centralBox(value);
			component.draw();
		}else if(input1.equals("exit")){
			System.exit(0);
		}	
	}
}