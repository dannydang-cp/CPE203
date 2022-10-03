import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PartOneTestCases
{
   public static final double DELTA = 0.00001;

   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getCenter", "getRadius");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testCircle1(){
      Circle circle = new Circle(new Point(1.0, 1.0), 4.0);
      double testCircle = Util.perimeter(circle);
      assertEquals(8.0 * Math.PI, testCircle, DELTA);
   }

   @Test
   public void testCircle2(){
      Circle circle = new Circle(new Point(5.0, 2.0), 3.0);
      double testCircle = Util.perimeter(circle);
      assertEquals(6.0 * Math.PI, testCircle, DELTA);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getTopLeft", "getBottomRight");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, Point.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangle1(){
      Rectangle rectangle = new Rectangle(new Point(1.0, 3.0), new Point(4.0, 1.0));
      double testRectangle = Util.perimeter(rectangle);
      assertEquals(10.0, testRectangle, DELTA);
   }

   @Test
   public void testRectangle2(){
      Rectangle rectangle = new Rectangle(new Point(2.0, 2.0), new Point(6.0, 5.0));
      double testRectangle = Util.perimeter(rectangle);
      assertEquals(14.0, testRectangle, DELTA);
   }

   @Test
   public void testPolygonImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getPoints");

      final List<Class> expectedMethodReturns = Arrays.asList(
         List.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[][] {new Class[0]});

      verifyImplSpecifics(Polygon.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testPolygon1(){
      List<Point> points = new ArrayList<Point>();
      points.add(new Point(0, 0));
      points.add(new Point(3, 0));
      points.add(new Point(0, 4));
      double testPolygon = Util.perimeter(new Polygon(points));
      assertEquals(12.0, testPolygon, DELTA);



   }

   @Test
   public void testUtilImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "perimeter", "perimeter", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         double.class, double.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[] {Circle.class},
         new Class[] {Polygon.class},
         new Class[] {Rectangle.class});

      verifyImplSpecifics(Util.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testWhichIsBigger() {
      Circle circle = new Circle(new Point(1.0, 1.0), 2.0);
      Rectangle rectangle = new Rectangle(new Point(-1.0, 2.0), new Point(1.0, -1.6));
      List<Point>points = new ArrayList<Point>();
      points.add(new Point(0, 0));
      points.add(new Point(3, 1));
      points.add(new Point(1, 4));
      points.add(new Point(-1, 4));
      Polygon polygon = new Polygon(points);
      double testBigger = Util.perimeter(polygon);
      assertEquals(testBigger, Bigger.whichIsBigger(circle, rectangle, polygon), DELTA);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals(0, clazz.getFields().length,
              "Unexpected number of public fields");

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals(expectedMethodNames.size(), publicMethods.size(),
              "Unexpected number of public methods");

      assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
              "Invalid test configuration");
      assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
              "Invalid test configuration");

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}
