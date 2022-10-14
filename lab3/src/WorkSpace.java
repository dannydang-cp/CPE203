import java.awt.*;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class WorkSpace {

    private List<Shape> shape;

    public WorkSpace()
    {
        shape = new ArrayList<Shape>();
    }

    public void add(Shape newShape)
    {
        this.shape.add(newShape);
    }

    public Shape get(int index)
    {
        return this.shape.get(index);
    }

    public int size()
    {
        return this.shape.size();
    }

    public List<Circle> getCircles ()
    {
        List<Circle> circleList = new ArrayList<>();
        for (Shape a_shape : this.shape)
        {
            if (a_shape instanceof Circle)
            {
                circleList.add((Circle)a_shape);
            }
        }
        return circleList;
    }

    public List<Rectangle> getRectangles()
    {
        List<Rectangle> rectangle_list = new ArrayList<>();
        for (Shape a_shape : this.shape)
        {
            if (a_shape instanceof Rectangle)
            {
                rectangle_list.add((Rectangle)a_shape);
            }
        }
        return rectangle_list;
    }

    public List<Triangle> getTriangles ()
    {
        List<Triangle> triangle_list = new ArrayList<>();
        for (Shape a_shape : this.shape)
        {
            if (a_shape instanceof Triangle){
                triangle_list.add((Triangle)a_shape);
            }
        }
        return triangle_list;
    }


    public List<Shape> getShapesByColor(Color color){
        List<Shape> color_list = new ArrayList<>();
        for (Shape a_shape : this.shape)
        {
            if (a_shape.getColor() == color)
            {
                color_list.add((Shape)a_shape);
            }
        }
        return color_list;
    }

    public double getAreaOfAllShapes()
    {
        double area = 0.0;
        for (Shape a_shape : this.shape)
        {
            area += a_shape.getArea();
        }
        return area;
    }

    public double getPerimeterOfAllShapes()
    {
        double peri = 0.0;
        for (Shape a_shape : this.shape)
        {
            peri += a_shape.getPerimeter();;
        }
        return peri;
    }



}
