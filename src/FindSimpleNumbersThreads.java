import java.util.ArrayList;

public class FindSimpleNumbersThreads {
    public static long x = 0;
//    public static long firstA = (long) Math.pow(2, 33) / 2;
//    public static long secondA = (long) Math.pow(2, 33);
    public static long firstA = 1000 / 2;
    public static long secondA = 1000;

    public static void main(String args[]) throws InterruptedException {

        Thread firstThread = new Thread(new FirstThread());
      //  Thread secondThread = new Thread(new SecondThread());

        firstThread.start();
      //  secondThread.start();


        firstThread.join();
       // secondThread.join();

        System.out.println("Кількість простих чисел на проміжку 0-2^33: " + x);

    }

    public static class FirstThread implements Runnable {

        @Override
        public void run() {
            long i, j;
            boolean check = false;
            for (i = 2; i <= firstA; i++) {
                check = false;
                for (j = 2; j < i - 1; j++) {
                    if (i % j == 0) {
                        check = true; //число не просте
                    }
                }

                if (!check) {
                    x++;
                    //System.out.println(i); // Виводим всі прості числа
                }
            }
        }
    }

    public static class SecondThread implements Runnable {

        @Override
        public void run() {
            long i, j;
            boolean check = false;
            for (i = firstA + 1; i <= secondA; i++) {
                check = false;
                for (j = firstA + 1; j < i - 1; j++) {
                    if (i % j == 0) {
                        check = true; //число не просте
                    }
                }

                if (!check) {
                    x++;
                    //System.out.println(i); // Виводим всі прості числа
                }
            }
        }
    }
}