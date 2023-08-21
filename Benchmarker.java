
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
