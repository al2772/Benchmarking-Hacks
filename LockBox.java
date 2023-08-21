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
