package lab0;

public class Lab00
{
   public static void main(String[] args)
   {
      // declaring and initializing some variables
      int x = 5;
      String y = "hello";
      double z = 9.8;

      // printing the variables
      System.out.println("x: " + x + " y: " + y + " z: " + z);

      // a list (make an array in java)
      int[] num = {3, 6, -1, 2};
      for (int i = 0; i < 4; i++)
      {
         System.out.println(num[i]);
      }

      // call a function
      int numFound = char_count(y, 'l');
      System.out.println("Found: " + numFound);

      // a counting for loop
      for (int j = 1; j < 11; j++)
      {
         System.out.print(j + " ");
      }

   }

   public static int char_count(String s, char c)
   {
      int count = 0;

      for (int i = 0; i < s.length(); i++)
      {
         if (c == s.charAt(i))
         {
            count += 1;
         }
      }
      return count;
   }

}
