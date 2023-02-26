//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Class that hacks a new LockBox object
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
/**
 * 
 * @author Adam Lewandowski
 * 
 * Creates a new LockBox object with a random password
 * and uses LockBox.java to "hack" the password
 *
 */
public class PasswordHacker {
  
  private LockBox toPick;
  private int passwordLength;
  
  public PasswordHacker(int passwordLength) {
   this.toPick = new LockBox(passwordLength);

   this.passwordLength = passwordLength;
    
  }
  
  /**
   * Complexity: O(1)
   * 
   * Although multiple methods are called, with the size N
   * being the number of characters in the password, all the
   * methods called have a constant complexity, so hack() will
   * also have complexity O(1)
   */
  public void hack() {
    this.toPick.reset();
    
    this.toPick.hackMe();
    
    this.toPick.authenticate(this.toPick.hackMe());
  }
  
  /**
   * Complexity: O(10^N)
   *
   * Every time the length of the password increases
   * by N, there are 10 more options for passwords
   * that can be correct
   */
  public void bruteForce() {
    this.toPick.reset();
    
    int attemptNum = 0;
    
    while(this.toPick.isOpen() == false && passwordLength < 9) {
      this.toPick.authenticate(generateGuess(attemptNum));
      attemptNum++;
    }
   
   
    
  }
  
  public String generateGuess(int count) {
    String guess = "";
    
    for (int i = 0; i < this.passwordLength; i++) {
      guess = (count % 10) + guess;
      count = count / 10;
    }    
   return guess;
  }
  
  

}
