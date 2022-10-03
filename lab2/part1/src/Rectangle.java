public class Rectangle {

    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point topRight){
        this.topLeft = topLeft;
        this.bottomRight = topRight;
    }

    public Point getTopLeft(){
        return this.topLeft;
    }

    public Point getBottomRight(){
        return this.bottomRight;
    }
}


