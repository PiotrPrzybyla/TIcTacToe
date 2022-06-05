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
            clearConsole();
            board.showBoard();
            if(board.isFinished()) break;
            player1.makeMove(board, Sign.CIRCLE);
            clearConsole();
            board.showBoard();
            if(board.isFinished()) break;

            player2.makeMove(board, Sign.CROSS);

        }
        endGame();


    }
    private void clearConsole(){
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
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
