import java.util.*;

public class Main {

    static int start;
    static int end;

    public void fillPrime(){
        boolean[] tmp = new boolean[end];
        Arrays.fill(tmp, true);
        tmp[1] = false;
        for (int i=2; i*i < end; i++) {
            if (tmp[i]) {
                for (int j=i*i; j < end; j+=i) {
                    tmp[j] = false;
                }
            }
        }
        for (int i = start; i < end; i++) {
            if(tmp[i]) {
                System.out.println(" " + i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean inputValid = true;
        boolean inputValid2 = true;
        do {
            System.out.println("start must be < then end");
            do {
                try {
                    System.out.println("enter start point");
                    if((start = in.nextInt()) <= 0) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    inputValid = false;
                } catch (InputMismatchException ex) {
                    System.out.println("wrong input, try again");
                    in.next();
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("negative num, try again");
                }
            } while(inputValid);
            do {
                try {
                    System.out.println("enter end point");
                    if((end = in.nextInt()) <= 0) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    inputValid2 = false;
                } catch (InputMismatchException ex) {
                    System.out.println("wrong input");
                    in.next();
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("negative num");
                }
            } while(inputValid2);
        } while (start >= end);
        System.out.println("");
        Main test = new Main();
        test.fillPrime();
        in.close();
    }
}