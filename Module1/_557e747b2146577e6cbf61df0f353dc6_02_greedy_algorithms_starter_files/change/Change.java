import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        String in = m + "";
        String tens = in.substring(0,in.length()-1);
        String units = in.substring(in.length()-1);
        m = 0 + Integer.parseInt(tens);

        if(Integer.parseInt(units) >= 5){
            m = m + 1 + (Integer.parseInt(units)%5);
        }
        else{
            m = m + Integer.parseInt(units);
        }

        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

