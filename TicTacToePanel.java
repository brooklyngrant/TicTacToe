
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The purpose of this code is the board of TicTacToe.java. It is too make the game Tic Tac Toe, and to make sure all the 
 * rules are enforced
 * @author brooklyn grant
 *
 */

public class TicTacToePanel extends JPanel {

	private JButton spots[] = new JButton[9]; //array of buttons
	private int turn = 0; // if odd, x goes, if even, o goes
	private String winner = "no one"; //string for who wins
	private int buttonCount = 0;
	
	
	public TicTacToePanel() {
		
		
	    startButtons(); //creates buttons
	    setLayout(new GridLayout(3,3)); //tictactoe grid
		
	}
	
	public void startButtons() {
		
        for (int i = 0; i < 9; i++) {// for all of the buttons
        	
            spots[i] = new JButton(); //makes the buttons
            spots[i].setText("");// sets them to be blank
            spots[i].setBackground(Color.white);//changes color
            spots[i].addActionListener(new clickListener()); //listens to buttons
            add(spots[i]); //adds buttons      
            
        }
    }
	
	public void resetButtons() {
		
        for (int i = 0; i < 9; i++) {// for all of the squares
        	
            spots[i].setText("");// sets them to be blank
            spots[i].setEnabled(true);// sets them to be enabled
            
        }
    }
	
	
	 private class clickListener implements ActionListener {
	       
	        public void actionPerformed(ActionEvent e) {
	            
	            JButton buttonClicked = (JButton) e.getSource(); // gets the button clicked
	            if (turn % 2 == 0 && buttonClicked.getText().equals("")) { // if even and not already used
	                buttonClicked.setText("O");// sets to o
	                buttonCount++;
	                buttonClicked.setEnabled(false);
	            } else if (turn % 2 == 1 && buttonClicked.getText().equals("")) { // if odd and not already used
	                buttonClicked.setText("X");// sets to x
	                buttonCount++;
	                buttonClicked.setEnabled(false);
	            } else {
	            	turn--;
	            }
	            
	            // horizontal 
	            if (check(0, 1, 2) == true) { 
	                win();
	            } else if (check(3, 4, 5) == true) { 
	            	win();
	            } else if (check(6, 7, 8) == true) { 
	            	win();
	            // vertical 
	            } else if (check(0, 3, 6) == true) { 
	            	win();
	            } else if (check(1, 4, 7) == true) { 
	            	win();
	            } else if (check(2, 5, 8) == true) { 
	            	win();
	            // diagonal
	            } else if (check(0, 4, 8) == true) { 
	            	win();
	            } else if (check(2, 4, 6) == true) { 
	            	win();
	            } else if (buttonCount >= 9) {
	            	win();
	            	
	            }
	                
	            turn++;
	            
	        }
	    
	    }
	
	 private boolean check(int button1, int button2, int button3) {
		 
		 boolean check = true;
		 
		 String b1 = spots[button1].getText();
		 String b2 = spots[button2].getText();
		 String b3 = spots[button3].getText();
		 
		 if ( (b1.equals(b2)) && (b2.equals(b3)) && !(b1.equals("")) ) {
			 check = true;
			 winner = b1;
		 } else {
			 check = false;
			 winner = "no one";
		 }
		 
		 return check;
	 }
	 
	 
	private void win() {
		JOptionPane.showConfirmDialog(null, "The game is over, " + winner + " wins. Do you want to play again?"); // dialog box asking to play again
        resetButtons();
        buttonCount = 0;
	}
	 
}

