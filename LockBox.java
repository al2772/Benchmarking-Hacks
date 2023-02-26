//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    LockBox object that is to be hacked by the other classes
// Course:   CS 300 Fall 2021
//
// Author:   Adam Lewandowski
// Email:    aclewandowsk@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;
/**
 * 
 * @author Adam Lewandowski
 * 
 * Sets up the parameters for PasswordHacker to "hack"
 * the random password that is created
 *
 */
public class LockBox {
  
  protected static Random randGen;
  private String password;
  private boolean isOpen;

  public LockBox(int passwordLength) {
    if (randGen == null) {
      randGen = new Random();
    }
    
    if (passwordLength <= 0) {
      throw new IllegalArgumentException ("Invalid password length");
    }
   int num = (int)Math.pow(10, passwordLength - 1);
   Integer result = num + randGen.nextInt(9 * passwordLength);
   this.password = result.toString();
       
   }
 
  
  public void authenticate(String guess) {
    if (guess.equals(this.password)) {
      this.isOpen = true;
    }
  }
  
  public String hackMe() {
    return this.password;
  }
  
  public boolean isOpen() {
    return this.isOpen;
  }
  
  public void reset() {
    this.isOpen = false;
  }
}
