
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.util.*;

class PlateGame extends JFrame {
	private int  numOfBomb;
	private int  numOfTable;
	private int[][] table; 
	private int[][] visible ;
	int checkIsAllCorrect=0,startTimer=0,checkIsOpened=0;
	int i,j,k;
	
	
	JPanel tablePanel = new JPanel();
	JPanel blank = new JPanel();
	
	JButton[][] block = new JButton[9][9];	
	
	PlateGame(){
		super("GameMineSweeper");
		setBounds(200,200,400,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		final int numOfBomb=9;
		final int numOfTable=10;
		
		tablePanel.setLayout(new GridLayout(9,9,0,0));
		//add all Button 
		for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
			table = new int[ numOfTable][ numOfTable];
			visible = new int[ numOfTable][ numOfTable];
			block[i][j] = new JButton("");
			tablePanel.add(block[i][j]);
			
		}
		}
		
		
		RandomizeTable ran = new RandomizeTable( numOfBomb, numOfTable);
		ran.takeNumber();
		table = ran.getTableArray();

		add(tablePanel,"Center");
	} 
      
}
	
	