public class Board {
    private int size;

    public int getSize() {
        return size;
    }

    private Sign[][] boardArray;

    public Board(int size) {
        this.size = size;
        boardArray = new Sign[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardArray[i][j] = Sign.EMPTY;
            }
        }
    }

    public Sign[][] getBoardArray() {
        return boardArray;
    }

    public void showBoard(){
        int currentPosition = 0;
        int spaceCounter = String.valueOf(size*size).length();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                currentPosition++;
                for (int k = 0; k < (spaceCounter - String.valueOf(currentPosition).length() + 1 ); k++) {
                    System.out.print(" ");
                }

                switch(boardArray[i][j]){
                    case CROSS:
                        System.out.print("x");
                        break;
                    case CIRCLE:
                        System.out.print("o");
                        break;
                    case EMPTY:
                        System.out.print(currentPosition );
                        break;
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public boolean setChoice(int position, Sign sign){
        int x = position/size;
        int y = position%size;
        if(boardArray[x][y] == Sign.EMPTY){
            boardArray[x][y] = sign;
            return true;
        }else{
            System.out.println("This position is taken");
            return false;
        }

    }
}
