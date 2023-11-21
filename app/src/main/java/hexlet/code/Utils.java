package hexlet.code;

public class Utils {
    public static int generateRandomNumber(int minLength, int maxLength) {
        return (int) (Math.random() * (maxLength - minLength + 1)) + minLength;
    }
}
