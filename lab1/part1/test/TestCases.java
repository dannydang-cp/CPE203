import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class TestCases
{
   private final static double DELTA = 0.0001;

   ////////////////////////////////////////////////////////////
   //                      SimpleIf Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testAnalyzeApplicant()
   {
      assertTrue(SimpleIf.analyzeApplicant(89, 85));
   }

   @Test
   public void testAnalyzeApplicant2()
   {
      assertFalse(SimpleIf.analyzeApplicant(15, 90));
   }

   @Test
   public void testAnalyzeApplicant3()
   {
      assertFalse(SimpleIf.analyzeApplicant(10, 50));
   }

   @Test
   public void testMaxAverage() {
      assertEquals(SimpleIf.maxAverage(89.5, 91.2), 91.2, DELTA);
   }

   @Test
   public void testMaxAverage2() {
      assertEquals(SimpleIf.maxAverage(60, 89), 89, DELTA);
   }

   @Test
   public void testMaxAverage3() {
      assertEquals(SimpleIf.maxAverage(6, 3), 6, DELTA);
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleLoop1()
   {
      assertEquals(7, SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()
   {
      assertEquals(7, SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3()
   {
      assertEquals(102, SimpleLoop.sum(3, 14));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleArray Tests                   //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleArray1()
   {
      /* What is that parameter?  They are newly allocated arrays
         with initial values. */
      assertArrayEquals(
              new boolean[] {false, false, true, true, false, false},
              SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 85)
      );
   }

   @Test
   public void testSimpleArray2()
   {
      assertArrayEquals(
              new boolean[] {false, false},
              SimpleArray.applicantAcceptable(new int[] {80, 83}, 92));
   }

   @Test
   public void testSimpleArray3()
   {
      assertArrayEquals(
              new boolean[] {true, false},
              SimpleArray.applicantAcceptable(new int[] {95, 85}, 90));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleList Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleList1()
   {
      List<Integer> input =
              new LinkedList<>(Arrays.asList(80, 85, 89, 92, 76, 81));
      List<Boolean> expected =
              new ArrayList<>(Arrays.asList(false, false, true, true, false, false));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 85));
   }

   @Test
   public void testSimpleList2()
   {
      List<Integer> input =
              new LinkedList<>(Arrays.asList(5, 10, 15, 20, 25, 30));
      List<Boolean> expected =
              new ArrayList<>(Arrays.asList(false, false, false, true, true, true));
      assertEquals(expected, SimpleList.applicantAcceptable(input, 15));
   }

   ////////////////////////////////////////////////////////////
   //                    BetterLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testFourOver85()
   {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {89, 93, 100, 39, 84, 63}));
   }

   @Test
   public void testFourOver85_2()
   {
      assertTrue(BetterLoop.atLeastFourOver85(new int[] {89, 86, 90, 92, 84, 88}));
   }

   @Test
   public void testFourOver85_3()
   {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {89, 86, 90, 84, 82}));
   }


   ////////////////////////////////////////////////////////////
   //                    ExampleMap Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testExampleMap1()
   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
              Arrays.asList(
                      new CourseGrade("CPE 123", 89),
                      new CourseGrade("CPE 101", 90),
                      new CourseGrade("CPE 202", 99),
                      new CourseGrade("CPE 203", 100),
                      new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Paul",
              Arrays.asList(
                      new CourseGrade("CPE 101", 86),
                      new CourseGrade("CPE 202", 80),
                      new CourseGrade("CPE 203", 76),
                      new CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("Zoe",
              Arrays.asList(
                      new CourseGrade("CPE 123", 99),
                      new CourseGrade("CPE 203", 91),
                      new CourseGrade("CPE 471", 86),
                      new CourseGrade("CPE 473", 90),
                      new CourseGrade("CPE 476", 99),
                      new CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Julie", "Zoe");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
              new HashSet<>(ExampleMap.highScoringStudents(
                      courseListsByStudent, 85)));
   }

   @Test
   public void testExampleMap2()
   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Bob",
              Arrays.asList(
                      new CourseGrade("CPE 123", 100),
                      new CourseGrade("CPE 101", 100),
                      new CourseGrade("CPE 202", 100),
                      new CourseGrade("CPE 203", 100),
                      new CourseGrade("CPE 225", 100)));
      courseListsByStudent.put("Rob",
              Arrays.asList(
                      new CourseGrade("CPE 101", 95),
                      new CourseGrade("CPE 202", 95),
                      new CourseGrade("CPE 203", 95),
                      new CourseGrade("CPE 225", 95)));
      courseListsByStudent.put("Pob",
              Arrays.asList(
                      new CourseGrade("CPE 123", 50),
                      new CourseGrade("CPE 203", 50),
                      new CourseGrade("CPE 471", 50),
                      new CourseGrade("CPE 473", 50),
                      new CourseGrade("CPE 476", 50),
                      new CourseGrade("CPE 572", 50)));

      List<String> expected = Arrays.asList("Bob");

      assertEquals(new HashSet<>(expected),
              new HashSet<>(ExampleMap.highScoringStudents(
                      courseListsByStudent, 99)));

   }
}
