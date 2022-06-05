public class Board implements Cloneable {
    private int size;

    public int getSize() {
        return size;
    }

    private Sign[][] boardArray;
    private Sign winner;

    public Sign getWinner() {
        return winner;
    }

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
    public boolean isFinished(){
        if(checkFirstDiagonal() || checkSecondDiagonal() || checkVertical() || checkHorizontal()){
            return true;
        }
        if(checkDraw()){
            return true;
        }
        return false;
    }
    private boolean checkVertical(){
        for (int i = 0; i < size; i++) {
            int counter =1;
            for (int j = 0; j < size-1; j++) {
                if((boardArray[i][j] == boardArray[i][j+1])&&
                        (boardArray[i][i] != Sign.EMPTY)){
                    counter++;
                }
                if(counter==size){
                    if(boardArray[i][j]== Sign.CIRCLE){
                        winner=Sign.CIRCLE;
                    }else{
                        winner=Sign.CROSS;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkHorizontal(){
        for (int i = 0; i < size; i++) {
            int counter =1;
            for (int j = 0; j < size-1; j++) {
                if((boardArray[j][i] == boardArray[j+1][i])&&
                        (boardArray[i][i] != Sign.EMPTY)){
                    counter++;
                }
                if(counter==size){
                    if(boardArray[j][i]== Sign.CIRCLE){
                        winner=Sign.CIRCLE;
                    }else{
                        winner=Sign.CROSS;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkFirstDiagonal(){
        int Xsum = 0;
        int Osum = 0;
        for (int i = 0; i < size; i++) {
            if(getSignAt(i, i) == Sign.CROSS){
                Xsum++;
            }
            if(getSignAt(i, i) == Sign.CIRCLE){
                Osum++;
            }
        }
        if (Xsum == size) {
            winner = Sign.CROSS;
            return true;
        } else if (Osum == size) {
            winner = Sign.CIRCLE;
            return true;
        }
        return false;
    }
    private boolean checkSecondDiagonal(){
        int Xsum = 0;
        int Osum = 0;
        for (int i = 0; i < size; i++) {
            if(getSignAt(i, size-1-i) == Sign.CROSS){
                Xsum++;
            }
            if(getSignAt(i, size-1-i) == Sign.CIRCLE){
                Osum++;
            }
        }
        if (Xsum == size) {
            winner = Sign.CROSS;
            return true;
        } else if (Osum == size) {
            winner = Sign.CIRCLE;
            return true;
        }
        return false;
    }
    private boolean checkDraw(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(boardArray[i][j] == Sign.EMPTY){
                    return false;
                }
            }
        }
        winner=Sign.EMPTY;
        return true;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
