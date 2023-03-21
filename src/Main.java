import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String inp = scan.nextLine();
        String[] inpS = inp.split(" ");

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
            System.out.println(roman_ans);
        }
        else if(!rome.containsKey(inpS[0]) && !rome.containsKey(inpS[2])){                  // both digits arab
            System.out.println(ans);
        }
        else throw new IOException("Wrong expression");

    }

}