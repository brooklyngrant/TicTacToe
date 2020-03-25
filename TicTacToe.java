
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToe extends JPanel {
    
    public static void main(String[] args) {
    	
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.getContentPane().add(new TicTacToePanel());//sets up board
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
