import javax.swing.*;
import javax.swing.text.GapContent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameMode extends JFrame {
    JPanel choicePanel = new JPanel();
    ArrayList<JButton> buttons = new ArrayList<>();
    public GameMode(){
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setSize(1300, 800);
//        setLocation(50,50);
        setLayout(new GridBagLayout());
        initializePanel();
        add(choicePanel);

    }
    void initializePanel(){
        choicePanel.setLayout(new GridLayout(10,1,0,15));
//        choosePanel.setLayout(new BorderLayout(10,20));
        choicePanel.setBounds(0, 0, 800, 100);

        buttons.add(new JButton("3 x 3"));
        buttons.add(new JButton("4 x 4"));
        buttons.add(new JButton("5 x 5"));
        buttons.add(new JButton("6 x 6"));
        buttons.add(new JButton("7 x 7"));
        buttons.add(new JButton("8 x 8"));
        buttons.add(new JButton("9 x 9"));
        buttons.add(new JButton("10 x 10"));
        int index = 3;
        for (JButton button:buttons) {
            button.setBackground(Color.LIGHT_GRAY);
            int finalIndex = index;
            button.addActionListener(e -> {new BoardPanel(button.getLabel(),finalIndex); dispose();});
            index++;
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setPreferredSize(new Dimension(200,50));
            choicePanel.add(button);
        }
    }
}
