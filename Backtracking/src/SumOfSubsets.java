import java.util.Arrays;

public class SumOfSubsets {

    private static boolean[] states;
    private static int[] weights;

    public static final int n = 6;
    public static final int TOTAL_SUM = 30;

    public static final boolean INCLUDED = true;
    public static final boolean NOT_INCLUDED = false;

    public static void main(String[] args) {

        states = new boolean[n];
        weights = new int[]{5, 10, 12, 13, 15, 18};

        sumOfSubset(0, 0, 73);

    }

    private static void sumOfSubset(int currentSum, int number, int remainingSum) {


        states[number] = INCLUDED;
        int numberWeight = weights[number];
//        int nextNumberWeight = weights[number + 1];

        System.out.println("Sum = " + (currentSum + numberWeight));
        System.out.println("Number = " + number);
        if ( currentSum + numberWeight == TOTAL_SUM ){
            System.out.println("GOT IT");
            Printing.printArray(states);
        } else if ( currentSum + numberWeight + weights[number + 1] <= TOTAL_SUM ){
            System.out.println("Can Include any of remaining numbers also ");
            sumOfSubset(currentSum + numberWeight , number + 1, remainingSum - numberWeight);
        }

        if ( currentSum + remainingSum - numberWeight >= TOTAL_SUM && currentSum + weights[number + 1] <= TOTAL_SUM  ){
            states[number] = NOT_INCLUDED;
            sumOfSubset(currentSum, number + 1, remainingSum - numberWeight);
        }

    }

}
