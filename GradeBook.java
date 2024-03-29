import java.util.ArrayList;
/*Class: CMSC203 CRN 31414
Program: Lab 3
Instructor: Prof. Ahmed Tarek
Summary of Description: The code defines a JUnit Jupiter test class `GradeBookTest` to verify the functionality of a `GradeBook` class, including methods to add scores, calculate the sum and minimum score, and compute the final score, using setup and teardown methods for test initialization and cleanup.
Due Date: 03/19/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
*/
public class GradeBook {
	  private double[] scores;
	  private int scoresSize;

	  /**
	   * Constructs a gradebook with no scores and a given capacity.
	   * 
	   * @capacity the maximum number of scores in this gradebook
	   */
	  public GradeBook(int capacity) {
	    scores = new double[capacity];
	    scoresSize = 0;
	  }

	  /**
	   * Adds a score to this gradebook.
	   * 
	   * @param score the score to add
	   * @return true if the score was added, false if the gradebook is full
	   */
	  public boolean addScore(double score) {
	    if (scoresSize < scores.length) {
	      scores[scoresSize] = score;
	      scoresSize++;
	      return true;
	    } else
	      return false;
	  }

	  /**
	   * Computes the sum of the scores in this gradebook.
	   * 
	   * @return the sum of the scores
	   */
	  public double sum() {
	    double total = 0;
	    for (int i = 0; i < scoresSize; i++) {
	      total = total + scores[i];
	    }
	    return total;
	  }

	  /**
	   * Gets the minimum score in this gradebook.
	   * 
	   * @return the minimum score, or 0 if there are no scores.
	   */
	  public double minimum() {
	    if (scoresSize == 0)
	      return 0;
	    double smallest = scores[0];
	    for (int i = 1; i < scoresSize; i++) {
	      if (scores[i] < smallest) {
	        smallest = scores[i];
	      }
	    }
	    return smallest;
	  }

	  /**
	   * Gets the final score for this gradebook.
	   * 
	   * @return the sum of the scores, with the lowest score dropped if there are at least two scores,
	   *         or 0 if there are no scores.
	   */
	  public double finalScore() {
	    if (scoresSize == 0)
	      return 0;
	    else if (scoresSize == 1)
	      return scores[0];
	    else
	      return sum() - minimum();
	  }

	  /**
	   * Gets the size of the scores field
	   * 
	   * @return the scoresSize
	   */
	  public int getScoresSize() {
	    return scoresSize;
	  }

	  /**
	   * Output as String the added scores of the scores array field
	   * according to scoreSize
	   *
	   * @ the elements of scores separated by " "
	   */
	  @Override
	  public String toString() {
	    StringBuilder scoreString = new StringBuilder();
	    for (int i = 0; i < scoresSize;i++){
	      scoreString.append(scores[i] + " ");
	    }
	    return scoreString.toString();
	  }



	}
