package javacore.chapter03.loop.exercise;

public class ChessboardDrawing {

    public static void main(String[] args) {

        int chessboardSize = 5;

        // rows
        for (int row = 0 ; row < chessboardSize ; row++) {
            System.out.println();
            // columns
            for (int column = 0 ; column < chessboardSize ; column++) {
                System.out.print((row + column) % 2 == 0 ? "# " : ". ");
            }

        }

    }

}
