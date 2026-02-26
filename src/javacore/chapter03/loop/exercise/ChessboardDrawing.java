package javacore.chapter03.loop.exercise;

public class ChessboardDrawing {

    public static void main(String[] args) {

        int chessboardSize = 5;

        // rows
        for (int row = 0 ; row < chessboardSize ; row++) {
            System.out.println();
            // columns
            if (row % 2 == 0) {
                for (int column = 0 ; column < 5 ; column++ ) {
                    if ( column % 2 == 0) {
                        System.out.print("# ");
                    }
                    else {
                        System.out.print(". ");
                    }
                }
            }
            else {
                for (int column = 0 ; column < 5 ; column++ ) {
                    if ( column % 2 == 0) {
                        System.out.print(". ");
                    }
                    else {
                        System.out.print("# ");
                    }
                }
            }

        }

    }

}
