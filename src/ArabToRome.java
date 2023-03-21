import java.util.HashMap;

class ArabToRome {
    static String ans = "";

    public static String calculate(int n) {
        HashMap<Integer, String> rome = new HashMap<Integer, String>();
            rome.put(100, "C");
            rome.put(90, "XC");
            rome.put(50, "L");
            rome.put(40, "XL");
            rome.put(10, "X");
            rome.put(9, "IX");
            rome.put(5, "V");
            rome.put(4, "IV");
            rome.put(1, "I");

       int[] arabic = {100, 90, 50, 40, 10, 9, 5, 4, 1};

       int i = 0;
       int j = 0;

       for (i = 0; i < 9; i++){
           int count = n / arabic[i];
           for (j = 0; j < count; j++){
               ans = ans + rome.get(arabic[i]);
           n = n % arabic[i];
           }
       }
       return ans;
    }
}