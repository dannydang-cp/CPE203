import java.lang.Math;
public class Util {

    public static double perimeter(Circle circle){
        double perimeterCircle = (2 * Math.PI * circle.getRadius());
        return perimeterCircle;
    }

    public static double perimeter (Rectangle rectangle){
        double length = Math.abs(rectangle.getTopLeft().getX() - rectangle.getBottomRight().getX()) * 2;
        double height = Math.abs(rectangle.getTopLeft().getY() - rectangle.getBottomRight().getY()) * 2;
        double perimeterRectangle = length + height;
        return perimeterRectangle;
    }

    public static double perimeter (Polygon polygon){
        double perimeterPolygon = 0.0;
        double xDistance = 0.0;
        double yDistance = 0.0;

        for (int i = 0; i <= polygon.getPoints().size() - 1; i ++) {
            if (i == polygon.getPoints().size() - 1){
                xDistance = Math.abs(polygon.getPoints().get(polygon.getPoints().size()-1).getX()-polygon.getPoints().get(0).getX());
                yDistance = Math.abs(polygon.getPoints().get(polygon.getPoints().size()-1).getY()-polygon.getPoints().get(0).getY());
                perimeterPolygon = perimeterPolygon + Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
            }

            else{
                xDistance = Math.abs(polygon.getPoints().get(i+1).getX()-polygon.getPoints().get(i).getX());
                yDistance = Math.abs(polygon.getPoints().get(i+1).getY()-polygon.getPoints().get(i).getY());
                perimeterPolygon = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)) + perimeterPolygon;
            }
        }

        return perimeterPolygon;

        }
    }
