package cc.emotion.util.other;

public class Random {
    public String SYMBOL = "!<*.,/?>;:#%()[]_-+=|`~^";
    public String FULL = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    public String LOWER = "qwertyuiopasdfghjklzxcvbnm";
    public String UPPER = "QWERTYUIOPASDFGHJKLZXCVBNM";
    public String NUMBER = "1234567890";
    public int getInt(int maxNumber, int minNumber) {
        java.util.Random R = new java.util.Random();
        return R.nextInt(maxNumber, minNumber);
    }

    public double getDouble(double maxNumber, double minNumber) {
        java.util.Random R = new java.util.Random();
        return R.nextDouble(maxNumber, minNumber);
    }

    public float getFloat(float maxNumber, float minNumber) {
        java.util.Random R = new java.util.Random();
        return R.nextFloat(maxNumber, minNumber);
    }

    public char getChar(String string) {
        java.util.Random R = new java.util.Random();
        return string.charAt(getInt(0, string.length()-1));
    }

    public String getString(String string, int newLength) {
        java.util.Random R = new java.util.Random();
        StringBuilder result = new StringBuilder();
        while (newLength != 0) {
            newLength --;
            result.append(string.charAt(getInt(0, string.length() - 1)));
        }
        return result.toString();
    }
}
