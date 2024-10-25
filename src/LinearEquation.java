public class LinearEquation {




    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double slope;




    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        slope = 0;
    }




    public double distance() {
        double x = Math.pow((x2 - x1),2);
        double y = Math.pow((y2 - y1),2);
        return roundedToHundredth(Math.sqrt(x + y));
    }




    public double slope() {
        double top = (y2 - y1);
        double bottom = (x2 - x1);
        slope = (top / bottom);
        if (top % bottom == 0) {
            return top/bottom;
        }
        return slope;
    }




    public double yIntercept() {
        double mx = slope() * x1;
        return y1 - mx;
    }




    public String equation() {
        if (y1 == y2) {
            return "y = " + yIntercept();
        }
        return "y = " + slope() + "x + " + yIntercept();
    }




    public String coordinateForX(double x) {
        double yValue = (slope() * x) + yIntercept();
        return "The point on the line is (" + x + ", " + yValue + ")";
    }




    public void lineInfo() {
        if (x1 == x2) {
            System.out.println();
            System.out.println("These points are on a vertical line: x = " + x1);
            System.out.println();
        } else {
            System.out.println();
            System.out.println("The two points are " + "(" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")");
            System.out.println("The equation of the line between these points is: " + equation());
            System.out.println("The y-intercept of this line is: " + yIntercept());
            System.out.println("The slope of this line is: " + slope());
            System.out.println("The distance between these points is " + distance());
            System.out.println();
        }
    }




    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}
