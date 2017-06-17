import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        String in = m + "";
        int result = 0;
        String units, tens;

        if(in.length()>1) {
            tens = in.substring(0, in.length() - 1);
            units = in.substring(in.length() - 1);
            result = 0 + Integer.parseInt(tens);
        }
        else {
            units = in;
        }

        if(Integer.parseInt(units) >= 5){
            result = result + 1 + (Integer.parseInt(units)%5);
        }
        else{
            result = result + Integer.parseInt(units);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

