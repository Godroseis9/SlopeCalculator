import java.util.Scanner;

public class LinearEquationLogic {

    private Scanner myScanner;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private double newX;

    public LinearEquationLogic() {
        myScanner = new Scanner(System.in);

        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        coordinatePoints();
        linearEquation();
        anotherPair();
    }

    private void anotherPair() {
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String userInput = myScanner.nextLine();
        if (userInput.equals("y")) {
            while (userInput.equals("y")) {
                coordinatePoints();
                linearEquation();
                System.out.print("Would you like to enter another pair of coordinates? y/n: ");
                userInput = myScanner.nextLine();
            }
            System.out.println("Thank you for using the slope calculator, goodbye!");
        } else {
            System.out.println("Thank you for using the slope calculator, goodbye!");
        }
    }

    private void coordinatePoints() {
        System.out.print("Enter coordinate 1:");
        String coordinate1 = myScanner.nextLine();
        int index = coordinate1.indexOf(",");
        x1 = Integer.parseInt(coordinate1.substring(1,index));
        int length = coordinate1.length();
        y1 = Integer.parseInt(coordinate1.substring(index + 2, length - 1));

        System.out.print("Enter coordinate 2:");
        String coordinate2 = myScanner.nextLine();
        int index2 = coordinate2.indexOf(",");
        x2 = Integer.parseInt(coordinate2.substring(1,index2));
        int length2 = coordinate2.length();
        y2 = Integer.parseInt(coordinate2.substring(index2 + 2, length2 - 1));
    }

    public void linearEquation() {
        LinearEquation LinearEquation = new LinearEquation(x1,y1,x2,y2);
        if (x1 == x2) {
            LinearEquation.lineInfo();
        } else {
            LinearEquation.lineInfo();
            newPoints();
            System.out.println();
            System.out.println(LinearEquation.coordinateForX(newX));
        }
    }

    private void newPoints() {
        System.out.print("Enter a value for x: ");
        newX = myScanner.nextDouble();
        myScanner.nextLine();
    }
}

