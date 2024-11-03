public class LinearEquation {


    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public double distance() {
        double x = Math.pow((x2 - x1),2);
        double y = Math.pow((y2 - y1),2);
        return roundedToHundredth(Math.sqrt(x + y));
    }


    public double slope() {
        double top = (y2 - y1);
        double bottom = (x2 - x1);
        double slope = (top / bottom);
        if (top % bottom == 0) {
            return top/bottom;
        }
        return roundedToHundredth(slope);
    }


    public double yIntercept() {
        double mx = slope() * x1;
        return y1 - mx;
    }


    public String equation() {
        int top = (y2 - y1);
        int bottom = (x2 - x1);


        if (y1 == y2) {
            return "y = " + yIntercept();
        }
        if (slope() == -1 ) {
            if (yIntercept() == 0) {
                return "y = " + "-x";
            } else if (yIntercept() < 0) {
                return  "y = " + "-x - " + Math.abs(roundedToHundredth(yIntercept()));
            } else {
                return  "y = " + "-x + " + roundedToHundredth(yIntercept());
            }
        } else if (slope() == 1){
            if (yIntercept() == 0) {
                return  "y = " + "x";
            } else if (yIntercept() < 0) {
                return  "y = " + "x - " + Math.abs(roundedToHundredth(yIntercept()));
            } else {
                return  "y = " + "x + " + roundedToHundredth(yIntercept());
            }
        } else if (top % bottom == 0) {
            if (yIntercept() == 0) {
                return "y = " + (int) slope() + "x";
            } else if (yIntercept() < 0) {
                return "y = " + (int) slope() + "x - " + Math.abs(roundedToHundredth(yIntercept()));
            } else {
                return "y = " + (int) slope() + "x + " + roundedToHundredth(yIntercept());
            }
        } else {
            if ((top <= -1) && (bottom <= -1)) {
                if (yIntercept() == 0) {
                    return "y = " + Math.abs(top) + "/" + Math.abs(bottom) + "x";
                } else if (yIntercept() < 0) {
                    return "y = " + Math.abs(top) + "/" + Math.abs(bottom) + "x - " + Math.abs(roundedToHundredth(yIntercept()));
                } else {
                    return "y = " + Math.abs(top) + "/" + Math.abs(bottom) + "x + " + roundedToHundredth(yIntercept());
                }
            } else if ((top <= -1) || (bottom <= -1)) {
                if (yIntercept() == 0) {
                    return "y = " + "-" + Math.abs(top) + "/" + Math.abs(bottom) + "x";
                } else if (yIntercept() < 0) {
                    return "y = " + "-" + Math.abs(top) + "/" + Math.abs(bottom) + "x - " + Math.abs(roundedToHundredth(yIntercept()));
                } else {
                    return "y = " + "-" + Math.abs(top) + "/" + Math.abs(bottom) + "x + " + roundedToHundredth(yIntercept());
                }
            }
            if (yIntercept() == 0) {
                return "y = " + top + "/" + bottom + "x";
            } else if (yIntercept() < 0) {
                return "y = " + top + "/" + bottom + "x - " + Math.abs(roundedToHundredth(yIntercept()));
            }else {
                return "y = " + top + "/" + bottom + "x + " + roundedToHundredth(yIntercept());
            }
        }
    }


    public String coordinateForX(double x) {
        double yValue = (slope() * x) + yIntercept();
        return "The point on the line is (" + roundedToHundredth(x) + ", " + roundedToHundredth(yValue) + ")";
    }


    public String lineInfo() {
        if (x1 == x2) {
            return "\nThese points are on a vertical line: x = " + x1 + "\n";
        } else {
            return "\nThe two points are " + "(" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" + "\nThe equation of the line between these points is: " + equation() + "\nThe y-intercept of this line is: " + roundedToHundredth(yIntercept()) + "\nThe slope of this line is: " + roundedToHundredth(slope()) + "\nThe distance between these points is " + distance() + "\n";
        }
    }


    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}

