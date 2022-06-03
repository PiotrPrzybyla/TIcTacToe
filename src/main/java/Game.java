import java.util.Scanner;

public class Game {
    private Player player1, player2, winner;
    private Board board;

    public Game() {
        startGame();
    }

    private void startGame() {
        Scanner sc = new Scanner(System.in);
        int boardSize;
        System.out.println("Set board size");
        boardSize = sc.nextInt();
        while(boardSize<3){
            System.out.println("Size can't be less than 3");
            System.out.println("Set board size");
            boardSize = sc.nextInt();
        }
        board = new Board(boardSize);
        player1 = new NormalPlayer();
        int choice = 0;
        while(choice!=1&&choice!=2){
            System.out.println("Choose Game Mode");
            System.out.println("1. 1 Player");
            System.out.println("2. 2 Players");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    player2 = new AIPlayer();
                    break;
                case 2:
                    player2 = new NormalPlayer();
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }

        }
        play();
    }

    private void play() {
        while (true){
            board.showBoard();
            if(isFinished()) break;
            player1.makeMove(board, Sign.CROSS);
            board.showBoard();
            if(isFinished()) break;
            player2.makeMove(board, Sign.CIRCLE);
        }
        endGame();


    }
    private boolean isFinished(){
        Sign boardArray[][] = board.getBoardArray();
        if(checkDiagonal() || checkVertical() || checkHorizontal()){
            return true;
        }
        if(checkDraw()){
            return true;
        }
        return false;
    }
    private boolean checkVertical(){
        for (int i = 0; i < board.getSize(); i++) {
            int counter =1;
            for (int j = 0; j < board.getSize()-1; j++) {
                if((board.getBoardArray()[i][j] == board.getBoardArray()[i][j+1])&&
                        (board.getBoardArray()[i][i] != Sign.EMPTY)){
                    counter++;
                }
                if(counter==board.getSize()){
                    if(board.getBoardArray()[i][j]== Sign.CIRCLE){
                        winner=player2;
                    }else{
                        winner=player1;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkHorizontal(){
        for (int i = 0; i < board.getSize(); i++) {
            int counter =1;
            for (int j = 0; j < board.getSize()-1; j++) {
                if((board.getBoardArray()[j][i] == board.getBoardArray()[j+1][i])&&
                        (board.getBoardArray()[i][i] != Sign.EMPTY)){
                    counter++;
                }
                if(counter==board.getSize()){
                    if(board.getBoardArray()[j][i]== Sign.CIRCLE){
                        winner=player2;
                    }else{
                        winner=player1;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkDiagonal(){
        int firstDiagonal=1, secondDiagonal=1;
        for (int i = 0; i < board.getSize() -1; i++) {
            if((board.getBoardArray()[i][i] == board.getBoardArray()[i+1][i+1]) &&
                (board.getBoardArray()[i][i] != Sign.EMPTY)){
                    firstDiagonal++;
            }
            if(firstDiagonal==board.getSize()){
                if(board.getBoardArray()[i][i] == Sign.CROSS){
                    winner = player1;
                }else{
                    winner=player2;
                }
                return true;
            }
            if((board.getBoardArray()[i][board.getSize()-i-1] == board.getBoardArray()[i+1][board.getSize() -i -2]) &&
                    (board.getBoardArray()[i][i] != Sign.EMPTY)){
                secondDiagonal++;

            }
            if(secondDiagonal==board.getSize()){
                if(board.getBoardArray()[i][board.getSize()-i-1] == Sign.CROSS){
                    winner = player1;
                }else{
                    winner=player2;
                }
                return true;
            }
        }
       return false;

    }
    private boolean checkDraw(){
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if(board.getBoardArray()[i][j] == Sign.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
    private void endGame(){
        if(winner==player1){
            System.out.println("Player 1 wins");
        }else if(winner==player2){
            System.out.println("Player 2 wins");
        }else{
            System.out.println("Draw");
        }
    }


}
