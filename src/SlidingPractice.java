/**
 * Date: November 29th, 2018
 * Author: Taylor Xi
 * Version: 1.5
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class SlidingPractice extends JFrame implements ActionListener {

        private JFrame myFrame;
        private JLabel label1, label2, moveCounter;
        private JPanel gameboardPanel, startMenu, winScreen; //create a panel to add to JFRAME
	private JButton[] buttons = new JButton[121]; //Make room for a potential 121 button objects
        private JButton[] menuButtons = new JButton[8]; //Make room for 8 button objects in the menu
        private JButton[] gameButtons = new JButton[3]; //Make room for 8 button objects in the game
        private JButton[] winButtons = new JButton[2]; //Make room for 8 button objects in the win menu
	private int emptyIndex, selection; //Variable will track the empty spot
        private boolean cheat;
        private int moves;
        
        public static void main(String[] args) {
		
            new SlidingPractice();      //Run constructor for class
	}
        
	public SlidingPractice()
	{
		myFrame = new JFrame("Slider Practice GUI");
                myFrame.setSize(1300,1000);   //Overall size of grid but window
                                            //is resizable by default. Layout
                                            //Manager takes care of the necessary scaling.
                myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f = new Font("Old English Text MT", Font.BOLD, 26);
                Font f2 = new Font("Comic Sans MS", Font.PLAIN, 12);
                label1 = new JLabel("Please select your grid size:");
                label1.setFont(f);
                label1.setSize(200, 100);
                label2 = new JLabel("Congratulations! You won! Play again? ");
                label2.setFont(f);
                label2.setSize(200, 100);
                startMenu = new JPanel();
                startMenu.setEnabled(true);
                startMenu.setLayout(new GridLayout(3,4,5,5));
                startMenu.setBackground(Color.gray);
                startMenu.add(label1);
                
                winScreen = new JPanel();
                winScreen.setEnabled(false);
                winScreen.setLayout(new GridLayout(4,4,5,5));
                winScreen.setBackground(Color.gray);
                winScreen.add(label2);
                winButtons[0] = new JButton("Play Again");
                winButtons[1] = new JButton("Exit");
                for(int i = 0; i < 2; i++){
                winButtons[i].setBackground(Color.cyan);
                winButtons[i].setForeground(Color.gray);
                winButtons[i].setFont(f);
                winButtons[i].addActionListener(this);
                winScreen.add(winButtons[i]);
                }
                menuButtons[0] = new JButton("4 X 4 Grid");
                menuButtons[1] = new JButton("5 X 5 Grid");
                menuButtons[2] = new JButton("6 X 6 Grid");
                menuButtons[3] = new JButton("7 X 7 Grid");
                menuButtons[4] = new JButton("8 X 8 Grid");
                menuButtons[5] = new JButton("9 X 9 Grid");
                menuButtons[6] = new JButton("10 X 10 Grid");
                menuButtons[7] = new JButton("11 X 11 Grid");
                

                
                for(int i = 0; i < 8;i++){
                menuButtons[i].setSize(200,100);
                menuButtons[i].setBackground(Color.cyan);
                menuButtons[i].setForeground(Color.gray);
                menuButtons[i].setFont(f);
                menuButtons[i].addActionListener(this);
                startMenu.add(menuButtons[i]);
                }
                
                moveCounter = new JLabel("Moves: 0");
                label2.setSize(200, 100);
                moveCounter.setFont(f2);
                
                myFrame.setContentPane(startMenu);
                myFrame.setVisible(true);
        }
                
                public void initialiseGame(int s){                   
                    moves = 0;
                    moveCounter.setText("Moves: 0");
                    boolean check[] = new boolean[121];
                    int temp = (s*s) - 1; //the amount of spaces available -1
                    Random boi = new Random();
                    Color[] colours = {Color.getHSBColor(0, 72, 92), Color.getHSBColor(214, 76, 92)};
                    gameboardPanel = new JPanel();
                    Font f = new Font("Old English Text MT", Font.BOLD, 26);
                    Font f2 = new Font("Comic Sans MS", Font.PLAIN, 12);
                    gameboardPanel.setEnabled(false);
                    gameboardPanel.setLayout(new GridLayout(s+1,s,5,5)); // (s+1)*s grid with 5 pixel padding										   // vert/horz dividers
                    gameboardPanel.setBackground(Color.gray); //Allows empty space to be black
                    startMenu.setEnabled(false);
		gameboardPanel.setEnabled(true);
                myFrame.setContentPane(gameboardPanel); //Add gameboardPanel to JFrame
                myFrame.setVisible(true); //Turn on JFrame
                    int colourIndex = 0;  //Start with Orange

		for (int i = 0; i < temp; i++)  //From i is 0 to temp, the amount of spaces minus 1
		{
                    
                        int j = boi.nextInt(temp)+1;
                        if(check[j] == false){
			
			buttons[i] = new JButton("" +j);  //Constructor sets text on new buttons
			buttons[i].setSize(100,100);  //Button size, but don't really need this line
						      //line since we are using Layout Manager

			buttons[i].setBackground(colours[colourIndex]);
			buttons[i].setForeground(Color.gray);   //Text colour
			buttons[i].setFont(f);
			buttons[i].addActionListener(this);   //Set up ActionListener on each button
			gameboardPanel.add(buttons[i]);       //Add buttons to the grid layout of 
			buttons[i].setVisible(true);				      //gameboardPanel
                        if (colourIndex%2 == 1) 
                        {
                            colourIndex = 0; //make white if necessary
                        }else
                            colourIndex = 1;
                        check[j] = true;
                    }else i--;
                }
		buttons[temp] = new JButton("" +temp); //manually add the last button, otherwise
                                                       //a number will be missing
                buttons[temp].setSize(100,100);
                buttons[temp].setBackground(colours[1]);
                buttons[temp].setForeground(Color.gray);
                buttons[temp].setFont(f);
                buttons[temp].addActionListener(this);
                gameboardPanel.add(buttons[temp]);
		buttons[temp].setVisible(false);  //Will show the black background without a
						//visible button here
                                                
		emptyIndex= temp;
		gameButtons[0] = new JButton("CHEAT");
                gameButtons[1] = new JButton("RESTART");
                gameButtons[2] = new JButton("RAGEQUIT");
                for(int i = 0; i < 3; i++){
                gameButtons[i].setBackground(Color.cyan);
                gameButtons[i].setForeground(Color.gray);
                gameButtons[i].setFont(f2);
                gameButtons[i].addActionListener(this);
                gameboardPanel.add(gameButtons[i]);
                
                }
                
                gameboardPanel.add(moveCounter);
              
	}

	
	public void actionPerformed(ActionEvent e) {
                
                for(int i = 0; i < selection*selection; i++){
                    if(e.getSource() == buttons[i]){    //If button i pushed
			swapPieces(i);		        //Swap with blank space
                    }
                }
                for(int i = 0; i < 8;i++){
                    if(e.getSource() == menuButtons[i]){
                        selectMenu(i);
                        initialiseGame(selection);
                    }
                }
                if (checkWin() == true){
                        label2.setText("Congratulations! You won in " +moves +" moves! Play Again?");
                        gameboardPanel.setEnabled(false);
                        gameboardPanel.setVisible(false);
                        winScreen.setEnabled(true);
                        winScreen.setVisible(true);
                        myFrame.setContentPane(winScreen);
                    }
                for(int i = 0; i < 2;i++){
                if (e.getSource() == winButtons[i]){
                        winScreen(i);
                }
                }
                for(int i = 0; i < 3; i++){
                if (e.getSource() == gameButtons[i]){
                    gameScreen(i);
                }
                }
        
	}
		
	private void swapPieces(int btnIndex)   //Send along button that was pushed
	{
            if (cheat == false){ //if cheat mode disabled, check with all the rules... otherwise, just swap regardless of positions
            if(((emptyIndex + 1 == btnIndex || emptyIndex - 1 == btnIndex) //if the empty space is directly above or below
                    && (emptyIndex%selection != 0 || btnIndex%selection != selection-1) //or left or right and the clicked button and empty space are not 
                    && (emptyIndex%selection != selection-1 || btnIndex%selection != 0)) //at the edge
                    || (emptyIndex + selection == btnIndex || emptyIndex - selection == btnIndex)){
		buttons[emptyIndex].setText(buttons[btnIndex].getText());  //Move over text
		buttons[emptyIndex].setVisible(true); //to blank button
		buttons[btnIndex].setVisible(false); //Turn off visibility of button that was pushed
						     //and background will show through as black
		//buttons[emptyIndex].setVisible(true);//Turn on visibility of the old blank button
		emptyIndex = btnIndex;		     //Update the emptyIndex to the button that was
		moves++;				     //pushed.
                moveCounter.setText("Moves: " +moves);
            }	
        }else{
                buttons[emptyIndex].setText(buttons[btnIndex].getText());  
		buttons[emptyIndex].setVisible(true); //to blank button
		buttons[btnIndex].setVisible(false); 
		emptyIndex = btnIndex;
                moves++;
                moveCounter.setText("Moves: " +moves);
            }
        }
        
        private void selectMenu(int s){ //The 4x4 grid will be button 0, and 0+4 = 4, so... to compensate
            selection = s+4;
        }
        
        private boolean checkWin(){
            
            
            boolean win = true;
            
            for (int i = 1; i < selection*selection; i++){ //goes through the entire 
                if(i != Integer.parseInt(buttons[i-1].getText())){
                    win = false;
                }
        }return win;
        }

        private void scramble(int s){ //basically initialise the game, but without making any additional buttons, just set the text
            moves = 0; 
            moveCounter.setText("Moves: 0");
            boolean check[] = new boolean[121];
            Random boi = new Random();
            buttons[emptyIndex].setVisible(true);
            buttons[s*s-1].setVisible(false);
            emptyIndex = s*s-1;
            int temp = (s*s) - 1;
            
            for (int i = 0; i < temp; i++)  //From i is 0 to 14
		{
                    int j = boi.nextInt(temp)+1;
                    
                    if(check[j] == false){
                        buttons[i].setText("" +j); 
                        check[j] = true;
                }else i--;
                    }
        }
        
        private void winScreen(int b){
            if(b == 0){
                winScreen.setEnabled(false);
                winScreen.setVisible(false);
                startMenu.setEnabled(true);
                startMenu.setVisible(true);
                myFrame.setContentPane(startMenu);
            }
            if(b == 1){
                System.exit(0);
            }
        }
        
        private void gameScreen(int b){
            if(b == 0){
                if (cheat == false){
                    cheat = true;
                }else cheat = false;
            }
            if(b == 1){
                scramble(selection);
            }
            if(b == 2){
                gameboardPanel.setEnabled(false);
                gameboardPanel.setVisible(false);
                startMenu.setEnabled(true);
                startMenu.setVisible(true);
                myFrame.setContentPane(startMenu);
            }
        }
}

