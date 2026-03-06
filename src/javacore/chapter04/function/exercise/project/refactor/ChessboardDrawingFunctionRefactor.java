package javacore.chapter04.function.exercise.project.refactor;

public class ChessboardDrawingFunctionRefactor {

    public static void displayRows(int chessboardSize) {
        for (int row = 0 ; row < chessboardSize ; row++) {
            System.out.println();
            displayColumns(chessboardSize, row);
        }
    }

    public static void displayColumns(int chessboardSize, int row) {
        for (int column = 0 ; column < chessboardSize ; column++) {
            System.out.print((row + column) % 2 == 0 ? "# " : ". ");
        }
    }

    public static void main(String[] args) {

        int chessboardSize = 5; // Can be a global class variable ?

        displayRows(chessboardSize);

    }

}
