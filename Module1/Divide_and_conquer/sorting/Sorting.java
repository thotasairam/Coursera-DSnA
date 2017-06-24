import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
        int x = a[l];

        for(int i = l+1; i<=r; i++){
            if(a[i] < x){
                int t = a[i];
                a[i] = a[l];
                a[l] = t;
                l++;
            }else {
                int t = a[i];
                a[i] = a[r];
                a[r] = t;
                r--;
                i--;
            }
        }

        int m1 = l;
        int m2 = r;
        int[] m = {m1, m2};
        return m;
    }

    public static void printArray(int[] a){
        System.out.print("Array print:- ");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;

                //swap i and j
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;

        int[] m = partition3(a,l,r);

        if(m[0]!=m[1]) {
            randomizedQuickSort(a, l, m[0]);
            randomizedQuickSort(a, m[1], r);
        }
        else {
            randomizedQuickSort(a, l, m[0]);
            randomizedQuickSort(a, m[0]+1, r);
        }

        //int m = partition2(a, l, r);
        //randomizedQuickSort(a, l, m - 1);
        //randomizedQuickSort(a, m + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        stressTest();

    }

    static void stressTest(){
        boolean answer = true;

        while(answer) {
            int[] a = new int[20];
            for (int i = 0; i < a.length; i++) {
                a[i] = random.nextInt(100);
            }
            randomizedQuickSort(a, 0, a.length - 1);
            for (int i = 0; i < a.length;i++){
                if((i+1) != a.length) {
                    if (a[i + 1] < a[i]) {
                        printArray(a);
                        answer = false;
                    }
                }
            }
            System.out.println(answer + " : ");
            printArray(a);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

