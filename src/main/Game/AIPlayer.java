public class AIPlayer implements Player {

    public AIPlayer() {

    }

    @Override
    public void makeMove(Board board, Sign sign) {

//        int[] choice = MiniMax.getBestMove(board, currentArray);
        int[] choice = AlphaBeta.getBestMove(board);
//        board.setBoardArray(currentArray);
        board.setChoice(choice[0], choice[1], sign);
    }

    @Override
    public void makeMove(Board board, Sign sign, int x, int y) {

    }
}
