public class GraphColoring {

    private static Graph graph;

    private static int[] colors;

    private static final int NUMBER_OF_VERTICES = 4;
    private static final int NUMBER_OF_COLORS = 3;

    public static void main(String[] args) {

        colors = new int[NUMBER_OF_VERTICES];

        graph = new Graph(true, NUMBER_OF_VERTICES);
        graph.matrix = new int[][]{
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        graphColoring(0);

//        Printing.print2DArray(graph.matrix);
        Printing.printArray(colors);

    }

    private static boolean graphColoring(int vertex){

        if (vertex == NUMBER_OF_VERTICES){
            return true;
        }

        for (int color = 0; color <= NUMBER_OF_COLORS; color++) {

            if (isSafe(vertex, color)){

                colors[vertex] = color;

                if (graphColoring(vertex + 1)){
                    return true;
                }

                colors[vertex] = 0;

            }

        }

        return false;

    }

    private static boolean isSafe(int vertex, int color){

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if (graph.matrix[vertex][i] == 1 && colors[i] == color) {
                return false;
            }
        }
        return true;

    }



}
