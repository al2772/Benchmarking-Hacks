
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
