public class Printing {

    public static void printPair(int num1, int num2){
        System.out.println( "( " + num1 + " , " + num2 + " ) " );
    }

    public static void print2DArray(int[][] array){
        if (array != null) {
            for (int i = 0; i < array.length; i++) {

                if (array[i] != null)
                for (int j = 0; j < array[i].length; j++) {
                    System.out.println("( " + "Row = " + i + " " +
                            "Column " + j + " ) " +
                            " = " + array[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void printArray(int[] array){
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("Item " + i + " = " + array[i]);
            }
        }
    }
    public static void printArray(boolean[] array){
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("Item " + i + " = " + array[i]);
            }
        }
    }

    public static void printArray(String itemName, int[] array){
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.println( itemName + " " + i + " = " + array[i]);
            }
        }
    }

}
