import java.util.Scanner;

public class NormalPlayer implements Player {
    public NormalPlayer() {

    }

    @Override
    public void makeMove(Board board, Sign sign) {
        Scanner sc = new Scanner(System.in);
        boolean isLegalMove = false;
        int position;
        while (!isLegalMove){
            position = sc.nextInt();
            if(board.isAvilable(position-1)){
                board.setChoice(position-1, sign);
                isLegalMove = true;
            }else{
                System.out.println("Wrong position");
            }


        }

    }
}
