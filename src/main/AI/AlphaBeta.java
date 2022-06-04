public class AlphaBeta {
    private static final int MAX_DEPTH = 12;




    public static int miniMax(Board board, int depth, int alpha, int beta,
                              boolean isMax) {
        int boardVal = evaluateBoard(board);

        // Terminal node (win/lose/draw) or max depth reached.
        if (Math.abs(boardVal) == 10 || depth == 0
                || !board.isMoveAvilable()) {
            return boardVal;
        }

        // Maximising player, find the maximum attainable value.
        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            for (int row = 0; row < board.getSize(); row++) {
                for (int col = 0; col < board.getSize(); col++) {
                    if (board.isAvilable(row, col)) {
                        board.setChoice(row, col, Sign.CROSS);
                        highestVal = Math.max(highestVal, miniMax(board,
                                depth - 1, alpha, beta, false));
                        board.setChoice(row, col, Sign.EMPTY);
                        alpha = Math.max(alpha, highestVal);
                        if (alpha >= beta) {
                            return highestVal;
                        }
                    }
                }
            }
            return highestVal;
            // Minimising player, find the minimum attainable value;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int row = 0; row < board.getSize(); row++) {
                for (int col = 0; col < board.getSize(); col++) {
                    if (board.isAvilable(row, col)) {
                        board.setChoice(row, col, Sign.CIRCLE);
                        lowestVal = Math.min(lowestVal, miniMax(board,
                                depth - 1, alpha, beta, true));
                        board.setChoice(row, col, Sign.EMPTY);
                        beta = Math.min(beta, lowestVal);
                        if (beta <= alpha) {
                            return lowestVal;
                        }
                    }
                }
            }
            return lowestVal;
        }
    }

    public static int[] getBestMove(Board board) {
        int[] bestMove = new int[]{-1, -1};
        int bestValue = Integer.MIN_VALUE;

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                if (board.isAvilable(row, col)) {
                    board.setChoice(row, col, Sign.CROSS);
                    int moveValue = miniMax(board, MAX_DEPTH, Integer.MIN_VALUE,
                            Integer.MAX_VALUE, false);
                    board.setChoice(row, col, Sign.EMPTY);
                    if (moveValue > bestValue) {
                        bestMove[0] = row;
                        bestMove[1] = col;
                        bestValue = moveValue;
                    }
                }
            }
        }
        System.out.println("Best Move: " + bestMove[0] + ", " + bestMove[1]);
        return bestMove;
    }


    private static int evaluateBoard(Board board) {
        int Xsum = 0;
        int Osum = 0;
        int bWidth = board.getSize();

        // Check rows for winner.
        for (int row = 0; row < bWidth; row++) {
            for (int col = 0; col < bWidth; col++) {
                if(board.getSignAt(row, col) == Sign.CROSS){
                    Xsum++;
                }
                if(board.getSignAt(row, col) == Sign.CIRCLE){
                    Osum++;
                }
            }
            if (Xsum == board.getSize()) {
                return 10;
            } else if (Osum == board.getSize()) {
                return -10;
            }
            Xsum = 0;
            Osum = 0;
        }

        // Check columns for winner.
        Xsum = 0;
        Osum = 0;
        for (int col = 0; col < bWidth; col++) {
            for (int row = 0; row < bWidth; row++) {
                if(board.getSignAt(row, col) == Sign.CROSS){
                    Xsum++;
                }
                if(board.getSignAt(row, col) == Sign.CIRCLE){
                    Osum++;
                }
            }
            if (Xsum == board.getSize()) {
                return 10;
            } else if (Osum == board.getSize()) {
                return -10;
            }
            Xsum = 0;
            Osum = 0;
        }

        // Check diagonals for winner.
        // Top-left to bottom-right diagonal.
        Xsum = 0;
        Osum = 0;
        for (int i = 0; i < bWidth; i++) {
            if(board.getSignAt(i, i) == Sign.CROSS){
                Xsum++;
            }
            if(board.getSignAt(i, i) == Sign.CIRCLE){
                Osum++;
            }
        }
        if (Xsum == board.getSize()) {
            return 10;
        } else if (Osum == board.getSize()) {
            return -10;
        }


        // Top-right to bottom-left diagonal.
        Xsum = 0;
        Osum = 0;
        int indexMax = bWidth - 1;
        for (int i = 0; i <= indexMax; i++) {
            if(board.getSignAt(i,  indexMax-i) == Sign.CROSS){
                Xsum++;
            }
            if(board.getSignAt(i, indexMax - i) == Sign.CIRCLE){
                Osum++;
            }

        }
        if (Xsum == board.getSize()) {
            return 10;
        } else if (Osum == board.getSize()) {
            return -10;
        }

        return 0;
    }
}
