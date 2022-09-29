import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCases
{
   @Test
   public void testGetName()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades, false);
      assertEquals("Aakash", testApplicant.getName());
   }

   @Test
   public void testGetName1()
   {
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 100),
              new CourseGrade("Algorithms", 100),
              new CourseGrade("Computer Organization", 100),
              new CourseGrade("Operating Systems", 100),
              new CourseGrade("Non-CS", 100)
      );
      Applicant testApplicant = new Applicant("smartbob", grades, true);
      assertEquals("smartbob", testApplicant.getName());
   }
}
