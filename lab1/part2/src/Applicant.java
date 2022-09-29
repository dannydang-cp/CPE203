import java.util.List;

public class Applicant
{
    private String name;
    private List<CourseGrade> grades;

    private boolean ifPerfect;

    public Applicant(String name, List<CourseGrade> grades, boolean ifPerfect)
    {
        this.name = name;
        this.grades = grades;
        this.ifPerfect = ifPerfect;
    }

    public boolean ifPerfect()
    {
        return this.ifPerfect;
    }

    public String getName()
    {
        return this.name;
    }

    public List<CourseGrade> getGrades()
    {
        return this.grades;
    }

    public CourseGrade getGradeFor(String course)
    {
        for (int i = 0; i < grades.size(); i++)
        {
            grades.get(i);
            if (grades.get(i).getCourseName() == course)
            {
                return grades.get(i);
            }
        }
        return null;
    }


}