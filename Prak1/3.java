import java.util.Scanner;
public class Main {
    public static void main (String[] args){
        //System.out.println("Hello World");
        Scanner scanner = new Scanner (System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int multiplier = scanner.nextInt();
        int booster = scanner.nextInt();

        if (booster == 1){
            multiplier*=2;
        }
        else if (booster == 2){
            multiplier*=3;
        }

        int hasil = (a+b+c+d+e)*(multiplier);
        System.out.println(hasil);

    }
}
