import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, ArrayList<MyValues> myValues) {
        double value = 0;

        //Sorting values and weights according to value per weight
        Collections.sort(myValues, new valuesPerWeightComparator());

        for(int i = 0; i < myValues.size(); i++) {
            if(capacity == 0){
                return value;
            }
            else {
                if(capacity > myValues.get(i).weight){
                    value = value + myValues.get(i).values;
                    capacity = capacity - myValues.get(i).weight;
                }
                else {
                    double multiplier = (double) capacity/myValues.get(i).weight;
                    value = value + (myValues.get(i).values * multiplier);
                    capacity = 0;
                }
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        ArrayList<MyValues> myValues = new ArrayList<MyValues>();

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            myValues.add(new MyValues(a, b, (double)a/b));
        }
        System.out.println(getOptimalValue(capacity, myValues));
    }
} 


class valuesPerWeightComparator implements Comparator<MyValues>{

    @Override
    public int compare(MyValues o1, MyValues o2) {
        if(o1.vPW > o2.vPW){
            return -1;
        }
        else if (o1.vPW < o2.vPW){
                return 1;
        }
        else {
            return 0;
        }
    }
}
