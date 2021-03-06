public class NQueen {

    private static int[] solutions;

    public static void main(String[] args) {

        int n = 4;
        solutions = new int[n];

        placeQueens(0, n);

        Printing.printArray("Queen", solutions);

    }

    private static boolean placeQueens(int queenNum, int n) {

        System.out.println();
        System.out.println("Queen Number = " + queenNum);

        for (int column = 0; column < n; column++) {

            if (isQueenNotUnderAttack(queenNum, column)) {

                System.out.print("Not Under attack at: ");
                Printing.printPair(queenNum,column);

                //Placing Queen at column
                solutions[queenNum] = column;

                //For All Solutions

                boolean allQueensPlaced = (queenNum == n - 1);
                if (allQueensPlaced) {
                    System.out.println("All Queens Placed");
                    System.out.println();
                    Printing.printArray("Queen", solutions);
                    return true;
                }
                placeQueens(queenNum + 1, n);

/*              For One Solution

                boolean allQueensPlaced = (queenNum == n - 1);
                if (allQueensPlaced) {
                    System.out.println("All Queens Placed");
                    return true;
                } else if (placeQueens(queenNum + 1, n)){
                    return true;
                }
*/

                //Removing Queen From Board
                solutions[queenNum] = -1;
            }

        }

        return false;

    }

    private static boolean isQueenNotUnderAttack(int row, int column) {

        System.out.print("Checking Attack for Queen at ");
        Printing.printPair(row,column);

        //Checking attacks from already placed queens
        for (int i = 0; i < row; i++) {

            boolean underAttackFromColumn = (solutions[i] == column);

            int rowDiff = Math.abs(row - i);
            System.out.println("Row Diff = " + rowDiff);
            int columnDiff = Math.abs(solutions[i] - column);
            System.out.println("Column Diff = " + columnDiff);

            boolean underAttackFromDiagonal = (rowDiff == columnDiff);

            if (underAttackFromColumn || underAttackFromDiagonal) {

                String from;
                if (underAttackFromColumn)
                    from = "Column";
                else
                    from = "Diagonal";

                System.out.println("Under Attack From " + from + " Returning...");
//                System.out.println("Under Attack Returning...");
                return false;

            } else {
                System.out.println("Queen " + (row - 1) + " Not Under Attack from Queen " + (i));
            }


        }
        return true;
    }


}
