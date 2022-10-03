public class Bigger {
    public static double whichIsBigger(Circle circle, Rectangle rectangle, Polygon polygon){
       double perimeterCircle = Util.perimeter(circle);
       double perimeterRectangle = Util.perimeter(rectangle);
       double perimeterPolygon = Util.perimeter(polygon);

       if (perimeterCircle > perimeterRectangle && perimeterCircle > perimeterPolygon) {
           return perimeterCircle;
       }

       else if (perimeterRectangle > perimeterCircle && perimeterRectangle > perimeterPolygon) {
           return perimeterRectangle;
       }

       else if (perimeterPolygon > perimeterCircle && perimeterPolygon > perimeterRectangle) {
           return perimeterPolygon;
       }
    return 0.0;
    }
}
