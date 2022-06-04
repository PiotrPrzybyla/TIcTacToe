public class Board implements Cloneable {
    private int size;

    public int getSize() {
        return size;
    }

    private Sign[][] boardArray;

    public void setBoardArray(Sign[][] boardArray) {
        this.boardArray = boardArray;
    }

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

    public Sign getSignAt(int x, int y){
        return(boardArray[x][y]);
    }
    public boolean isAvilable(int x, int y){
        if(boardArray[x][y] == Sign.EMPTY){
            return true;
        }else{
            return false;
        }
    }
    public boolean isAvilable(int position){
        int x = position/size;
        int y = position%size;
        if(boardArray[x][y] == Sign.EMPTY){
            return true;
        }else{
            return false;
        }
    }
    public void setChoice(int position, Sign sign){
        int x = position/size;
        int y = position%size;

            boardArray[x][y] = sign;


    }
    public void setChoice(int x, int y, Sign sign){

            boardArray[x][y] = sign;

    }
    public boolean isMoveAvilable(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(boardArray[i][j] == Sign.EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
