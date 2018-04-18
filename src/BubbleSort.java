import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int mass[] = {11,12,33,4,52,611,76,38,19,0};
        int temp;

        for (int i = 0; i < mass.length-1; i++) {
            for (int j = 0; j < mass.length-i-1; j++) {
                if(mass[j] > mass[j+1]){
                    temp = mass[j];
                    mass[j] = mass[j+1];
                    mass[j+1] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(mass));
    }
}
