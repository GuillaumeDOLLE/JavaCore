package javacore.chapter03.loop.exercise;

public class ChessboardDrawing {

    public static void main(String[] args) {

        int chessboardSize = 5;

        // rows
        for (int count = 0 ; count < chessboardSize ; count++) {
            System.out.println();
            // columns
            if (count % 2 == 0) {
                for (int c = 0 ; c < 5 ; c++ ) {
                    if ( c % 2 == 0) {
                        System.out.printf("# ");
                    }
                    else {
                        System.out.printf(". ");
                    }
                }
            }
            else {
                for (int c = 0 ; c < 5 ; c++ ) {
                    if ( c % 2 == 0) {
                        System.out.printf(". ");
                    }
                    else {
                        System.out.printf("# ");
                    }
                }
            }

        }

    }

}
