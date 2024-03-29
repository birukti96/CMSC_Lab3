import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*Class: CMSC203 CRN 31414
Program: Lab 3
Instructor: Prof. Ahmed Tarek
Summary of Description: The code defines a JUnit Jupiter test class `GradeBookTest` to verify the functionality of a `GradeBook` class, including methods to add scores, calculate the sum and minimum score, and compute the final score, using setup and teardown methods for test initialization and cleanup.
Due Date: 03/19/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
*/
public class GradeBookTest {
   GradeBook gb1, gb2, gb3, gb4;

   @BeforeEach
   public void setUp() throws Exception {
       gb1 = new GradeBook(5);
       gb2 = new GradeBook(5);
       gb3 = new GradeBook(5);
       gb4 = new GradeBook(5);

       gb1.addScore(89);
       gb1.addScore(39);
       gb1.addScore(18);
       gb2.addScore(95);
       gb2.addScore(57);

       /* TESTS BEYOND SCOPE OF LAB 6:
        * gb3 with just one element in scores:
        *  -> test that Final Sum doesn't discard the only element
        *
        * gb4 with empty scores array
        *  -> test that sum, minimum and finalSum will return 0
        */
       gb3.addScore(25);
   }

   @AfterEach
   public void tearDown() throws Exception {
       gb1 = gb2 = gb3 = gb4 = null;
   }

   @Test
   public void testAddScore() {
       assertTrue(gb1.toString().equals("89.0 39.0 18.0 "));
       assertTrue(gb2.toString().equals("95.0 57.0 "));
       assertTrue(gb3.toString().equals("25.0 "));
       assertTrue(gb4.toString().equals(""));

   }

   @Test
   public void testSum() {
       assertEquals(146, gb1.sum(), .0001);
       assertEquals(152, gb2.sum(), .0001);
       assertEquals(25, gb3.sum(), .0001);
       assertEquals(0, gb4.sum(), .0001);
   }

   @Test
   public void testMinimum() {
       assertEquals(18, gb1.minimum(), .001);
       assertEquals(57, gb2.minimum(), .001);
       assertEquals(25, gb3.minimum(), .001);
       assertEquals(0, gb4.minimum(), .001);
   }

   @Test
   public void testFinalScore() {
       assertEquals(128, gb1.finalScore(), .0001);
       assertEquals(95, gb2.finalScore(), .0001);
       assertEquals(25, gb3.finalScore(), .0001);
       assertEquals(0, gb4.finalScore(), .0001);
   }

}
