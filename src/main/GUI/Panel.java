import javax.swing.*;
import java.awt.*;

public class Panel extends JFrame {
    public Panel(){
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(300, 100);
        setLocation(50,50);
        setLayout(new FlowLayout());
        add(new Button("Start"));
        add(new Button("End"));
    }
}
