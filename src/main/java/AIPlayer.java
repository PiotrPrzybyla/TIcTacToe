public class AIPlayer implements Player {

    public AIPlayer() {

    }

    @Override
    public void makeMove(Board board, Sign sign) {
        Sign[][] currentArray = new Sign[board.getSize()][board.getSize()];
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                currentArray[i][j] = board.getBoardArray()[i][j];
            }
        }
        int[] choice = MiniMax.getBestMove(board, currentArray);
//        board.setBoardArray(currentArray);
        board.setChoice(choice[0], choice[1], sign);
    }
}
