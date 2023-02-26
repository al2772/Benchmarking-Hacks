//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Checks and compares bruteForce and hack method times
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
 * Uses PasswordHacker objects to check runtime
 * of the bruteForce method and hack method
 *
 */
public class Benchmarker {

  public static long timeBruteForce(PasswordHacker ph) {
    long before = System.currentTimeMillis();
    
    ph.bruteForce();
    
    long after = System.currentTimeMillis();
    
    return after - before;
  }
  
  public static long timeHack(PasswordHacker ph) {
    long before = System.currentTimeMillis();
    
    ph.hack();
    
    long after = System.currentTimeMillis();
    
    return after - before;
  }

  public static String race(int passwordLength, int numRuns) {
    PasswordHacker newHack = new PasswordHacker(passwordLength);
    
    long meanBruteTime = timeBruteForce(newHack) / numRuns;
    long meanHackTime = timeHack(newHack) / numRuns;
    
    
    return "Brute force " + passwordLength + ": " + meanBruteTime + "\nHack " + passwordLength 
        + ": " + meanHackTime;
    
  }
  public static void main(String[] args) {
      System.out.println();
  }

}
