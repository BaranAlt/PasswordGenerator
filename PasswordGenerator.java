import java.util.Random;

public class PasswordGenerator {
    

  public static final String LOWER_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
  public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String NUMBERS = "0123456789";
  public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

  private final Random random;

  public PasswordGenerator(){random = new Random();}

  public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols){

    StringBuilder passwordBuilder = new StringBuilder();
    


    String validChracters = "";
    if(includeUppercase) validChracters += UPPERCASE_CHARACTERS;
    if(includeLowercase) validChracters += LOWER_CHARACTERS;
    if(includeNumbers) validChracters += NUMBERS;
    if(includeSpecialSymbols) validChracters = SPECIAL_SYMBOLS;

    for(int i = 0; i < length; i++){

        int randomIndex = random.nextInt(validChracters.length());
    char randomChar =  validChracters.charAt(randomIndex);

    passwordBuilder.append(randomChar);
    }
    return passwordBuilder.toString();
  }
}
