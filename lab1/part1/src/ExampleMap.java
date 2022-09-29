
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExampleMap {

  /**
   * Return a list of "high scoring" students --- High scoring students are
   * students who have all grades strictly greater than the given threshold.
   * 
   * @param scoresByApplicantName A map of applicant names to applicant scores
   * @param scoreThreshold        The score threshold
   * @return The list of high-scoring applicant names
   */
  public static List<String> highScoringStudents(Map<String,
          List<CourseGrade>> scoresByApplicantName, int scoreThreshold)
  {
    // Build a linked list named highScoringStudents
    List<String> highScoringStudents = new LinkedList<>();

    // For each loop
    for (Map.Entry<String, List<CourseGrade>> current : scoresByApplicantName.entrySet()) {
      List<CourseGrade> scores = current.getValue();

      String name = null;
      boolean x = true;

      for (CourseGrade c : scores)
      {
        if(!(c.getScore() > scoreThreshold))
        {
          x = false;
          break;
        }
      }
      if (x)
      {
        highScoringStudents.add(current.getKey());
      }
    }

    return highScoringStudents;
  }
}
