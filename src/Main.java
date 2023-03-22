import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)throws IOException{
        System.out.println("Enter expression: ");
        Scanner s = new Scanner(System.in);
        String inp = s.nextLine();
        System.out.println(calc(inp));
    }
    public static String calc (String input) throws IOException {
        String[] inpS = input.split(" ");
        if (inpS.length != 3) throw new IOException("Wrong expression");

        HashMap<String, Integer> rome = new HashMap<String, Integer>();
        rome.put("I", 1);
        rome.put("II", 2);
        rome.put("III", 3);
        rome.put("IV", 4);
        rome.put("V", 5);
        rome.put("VI", 6);
        rome.put("VII", 7);
        rome.put("VIII", 8);
        rome.put("IX", 9);
        rome.put("X", 10);

        int arab1;          // первое число в выражении

        if (rome.containsKey(inpS[0])) {
            arab1 = rome.get(inpS[0]);
        } else arab1 = Integer.parseInt(inpS[0]);
        if (arab1 > 10 | arab1 < 0) throw new IOException("Numbers must be in range 1 to 10");

        int arab2;         // второе число в выражении

        if (rome.containsKey(inpS[2])) {
            arab2 = rome.get(inpS[2]);
        } else arab2 = Integer.parseInt(inpS[2]);
        if (arab2 > 10 | arab2 < 0) throw new IOException("Numbers must be in range 1 to 10");

        int ans = 101;                  // заготовка под ответ

        switch (inpS[1]) {
            case "+":
                ans = arab1 + arab2;
                break;
            case "-":
                ans = arab1 - arab2;
                break;
            case "*":
                ans = arab1 * arab2;
                break;
            case "/":
                ans = arab1 / arab2;
                break;
            default:
                throw new IOException("Only '+ - * /' operations avalible");
        }

        if (rome.containsKey(inpS[0]) && rome.containsKey(inpS[2]) && ans > 0) {            // both digits roman
            String roman_ans = ArabToRome.calculate(ans);
            return roman_ans;
        } else if (!rome.containsKey(inpS[0]) && !rome.containsKey(inpS[2])) {                  // both digits arab
            return Integer.toString(ans);
        } else throw new IOException("Wrong expression");

        }
    }
