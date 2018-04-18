package sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] mas = {22, 12, 3, 213, 2, 13, 229, 0, 1, 29, 16, 5, 2, 89, 21, 19};
        int temp;

        for (int i = 0; i < mas.length-1; i++) {

            for (int j = 0; j < mas.length-i-1; j++) { //-i bcs when we made one prohod last el. is true and fixed, we don't have check it

                if(mas[j] > mas[j+1]){
                    temp = mas[j];
                    mas[j] = mas [j+1];
                    mas[j+1] = temp;
                }

            }

        }
        System.out.println(Arrays.toString(mas));


    }
}
