import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardPanel extends JFrame {
    JPanel gamePanel = new JPanel();
    JButton buttons[][];
    Board board;
    Player player1, player2;

    public BoardPanel(String title, int boardSize) throws HeadlessException {
        super(title);
        board = new Board(boardSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridBagLayout());
        initializePanel();
        add(gamePanel);
        player1 = new NormalPlayer();
        player2 = new AIPlayer();

    }
    public void showBoard(){
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if(board.getBoardArray()[i][j] == Sign.EMPTY){
                    buttons[i][j].setText(" ");
                } else  if(board.getBoardArray()[i][j] == Sign.CIRCLE){
                    buttons[i][j].setText(" O ");
                } else  if(board.getBoardArray()[i][j] == Sign.CROSS){
                    buttons[i][j].setText(" X ");
                }
            }
        }
    }
    public void initializePanel(){
        gamePanel.setLayout(new GridLayout(board.getSize(),board.getSize(),15,15));
        buttons = new JButton[board.getSize()][board.getSize()];
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if(board.getBoardArray()[i][j] == Sign.EMPTY){
                    buttons[i][j] = new JButton(" ");
                    int finalI = i;
                    int finalJ = j;
                    buttons[i][j].addActionListener(e-> {
                        if(board.isFinished()){
                            endGame();
                        }else{
                            player1.makeMove(board,Sign.CIRCLE, finalI, finalJ);

                            if(board.isFinished()){
                                endGame();
                            }else{ player2.makeMove(board,Sign.CROSS);
                                showBoard();
                                add(gamePanel);}

                        }

                    });
                } else  if(board.getBoardArray()[i][j] == Sign.CIRCLE){
                    buttons[i][j] = new JButton(" O ");
                } else  if(board.getBoardArray()[i][j] == Sign.CROSS){
                    buttons[i][j] = new JButton(" X ");
                }
                buttons[i][j].setPreferredSize(new Dimension(50,50));
                gamePanel.add(buttons[i][j]);
            }
        }
    }
    public void endGame(){
        if(board.getWinner() == Sign.CIRCLE){
            JOptionPane.showMessageDialog(null, "O wins");
        }else  if(board.getWinner() == Sign.CROSS){
            JOptionPane.showMessageDialog(null, "X wins");
        }  if(board.getWinner() == Sign.EMPTY){
            JOptionPane.showMessageDialog(null, "Draw");
        }
    }
}
