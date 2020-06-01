import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int start;
    static int end;

    int sqrtOfEnd = (int) Math.ceil(Math.sqrt(end));
    List<Integer> primeNums = new ArrayList<>();
    boolean[] isPrime = new boolean[end - start + 1];

    private void fillPrime(){
        boolean[] tmp = new boolean[sqrtOfEnd];
        Arrays.fill(tmp, true);
        tmp[1] = false;
        for (int i=2; i*i < sqrtOfEnd; i++) {
            if (tmp[i]) {
                for (int j=i*i; j < sqrtOfEnd; j+=i) tmp[j] = false;
            }
        }
        for (int i = 1; i < sqrtOfEnd; i++) {
            if (tmp[i]) primeNums.add(i);
        }
    }

    public boolean[] sieve(){
        fillPrime();
        Arrays.fill(isPrime, true);
        for (int i = 0; i < primeNums.size(); i++) {
            int h = start % primeNums.get(i);
            int j = h == 0 ? 0 : primeNums.get(i) - h;
            for (; j<=end - start; j+= primeNums.get(i)) isPrime[j] = false;
        }
        return isPrime;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("start must be < then end");
            System.out.println("enter start point");
            start = in.nextInt();
            System.out.println("enter end point");
            end = in.nextInt();
        } while (start >= end);
        System.out.println("");
        Main test = new Main();
        long startTime = System.currentTimeMillis();
        boolean[] arrayPrimes = test.sieve();
        long timeSpent = System.currentTimeMillis() - startTime;
        for (int i = 0; i < arrayPrimes.length; i++) {
            if (arrayPrimes[i]) {
                System.out.printf("%d ", i + start);
            }
        }
        System.out.println("time spend " + timeSpent + " milisec");
        in.close();
    }
}