package MineSweeperFull;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PlateGame extends JFrame implements ActionListener{
    public static final  int NUMOFTABLE = 9;
    public static final  int NUMOFBOMB = 10;
	private int  numOfBomb=9;
	private int  numOfTable=10;
	private int[][] table; 
	private int[][] visible ;
	int checkIsAllCorrect=0,checkIsOpened=0;
	int i,j,k;
	
	Icon pic =new ImageIcon("Image/bomb.jpg");
	JPanel tablePanel = new JPanel();
	JPanel blank = new JPanel();
	JButton[][] block = new JButton[9][9];	
	
	PlateGame(){
		super("GameMineSweeper");
		setBounds(200,200,400,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		numOfBomb = NUMOFBOMB;
		 numOfTable = NUMOFTABLE;
		
		tablePanel.setLayout(new GridLayout(9,9,0,0));
		//add all Button 
		for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
			table = new int[ numOfTable][ numOfTable];
			visible = new int[ numOfTable][ numOfTable];
			block[i][j] = new JButton("");
			tablePanel.add(block[i][j]);
			block[i][j].addActionListener(this);
		}
		}
		RandomizeTable ran = new RandomizeTable( numOfBomb, numOfTable);
		ran.takeNumber();
		table = ran.getTableArray();
		add(tablePanel,"Center");
	}
	
	public void actionPerformed(ActionEvent e){
		for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
			if(e.getSource()== block[i][j])
			{
			block[i][j].setEnabled(false);
			visible[i][j]=1;
			if(table[i][j]>0&&table[i][j]<=8)
				block[i][j].setText(Integer.toString(table[i][j]));
					if(table[i][j]==999){
						block[i][j].setIcon(pic);
						block[i][j].setDisabledIcon(pic);
						block[i][j].setEnabled(true);
						block[i][j].setBackground(Color.orange);
						restart(2);
					}	
					if(table[i][j]==0&&visible[i][j]==1)
					zeroAction();
					checkEnd();
			}
		}
	}
   }
	public void zeroAction()
	{
		int u=0;
		int i=0,j=0;
		while(u<( numOfTable)){		
		 	for(i=0;i< numOfTable;i++){
			for(j=0;j< numOfTable;j++){
			  	 if(visible[i][j]==1&&table[i][j]==0){
					if(((i-1)>=0)&&((j-1)>=0)){
						visible[i-1][j-1]=1;
						block[i-1][j-1].setEnabled(false);
						if(table[i-1][j-1]!=0)
							block[i-1][j-1].setText(Integer.toString(table[i-1][j-1]));					
					}
					if((i-1)>=0){
						visible[i-1][j]=1;
						block[i-1][j].setEnabled(false);
						if(table[i-1][j]!=0)
							block[i-1][j].setText(Integer.toString(table[i-1][j]));
					}
					if((i-1)>=0&&(j+1)< numOfTable){
						visible[i-1][j+1]=1;
						block[i-1][j+1].setEnabled(false);
						if(table[i-1][j+1]!=0)
							block[i-1][j+1].setText(Integer.toString(table[i-1][j+1]));
					}
					if((j-1)>=0){
						visible[i][j-1]=1;
						block[i][j-1].setEnabled(false);
						if(table[i][j-1]!=0)
							block[i][j-1].setText(Integer.toString(table[i][j-1]));
					}
					
					if((j+1)< numOfTable){
						visible[i][j+1]=1;
						block[i][j+1].setEnabled(false);
						if(table[i][j+1]!=0)
							block[i][j+1].setText(Integer.toString(table[i][j+1]));
					}
					if((i+1)< numOfTable&&(j-1)>=0){
						visible[i+1][j-1]=1;
						block[i+1][j-1].setEnabled(false);
						if(table[i+1][j-1]!=0)
							block[i+1][j-1].setText(Integer.toString(table[i+1][j-1]));
					}
						
					if((i+1)< numOfTable){
						visible[i+1][j]=1;
						block[i+1][j].setEnabled(false);
						if(table[i+1][j]!=0)
							block[i+1][j].setText(Integer.toString(table[i+1][j]));
					}
						
					if((i+1)< numOfTable&&(j+1)< numOfTable){
						visible[i+1][j+1]=1;
						block[i+1][j+1].setEnabled(false);
						if(table[i+1][j+1]!=0)
							block[i+1][j+1].setText(Integer.toString(table[i+1][j+1]));	
					}					
				}
			}
			}
		   u++;	
		}
	}
	
	public void checkEnd(){
		
		checkIsAllCorrect=0;
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(visible[i][j]==1&&table[i][j]!=8)
					checkIsAllCorrect++;	
			}
		}
		checkIsOpened=checkIsAllCorrect;
		
		if(checkIsAllCorrect==(( numOfTable* numOfTable)- numOfBomb)){
			restart(1);
		}
	}
	
	public void restart(int end){
		
		
		for(int m=0;m<9;m++){
			for(int n=0;n<9;n++){
					visible[m][n]=1;
			}
		}
		if(end==0)
			newGame();
		else if(end==1){
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					if(table[i][j]==999){
						block[i][j].setBackground(Color.green);
						block[i][j].setEnabled(false);
						block[i][j].setIcon(pic);
						block[i][j].setDisabledIcon(pic);
					}
				}
			}
		}
		else if(end==2){
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					block[i][j].setEnabled(false);
					if(table[i][j]>0&&table[i][j]<8)
						block[i][j].setText(Integer.toString(table[i][j]));
					else if(table[i][j]==0)block[i][j].setText("");
					else{
						block[i][j].setIcon(pic);
						block[i][j].setDisabledIcon(pic);
					}
				}	
			}
		}
	}
	
	public void newGame(){
		//add all Button 
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				visible[i][j]=0;
				block[i][j].setEnabled(true);
				block[i][j].setText("");
				tablePanel.remove(block[i][j]);
				block[i][j]  = new JButton("");
				tablePanel.add(block[i][j]);
				block[i][j].addActionListener(this);	
			}
		}
			repaint();
			
		j=0;
		k=0;	
		checkIsOpened=0;	
                
		RandomizeTable ran = new RandomizeTable( numOfBomb, numOfTable);
		ran.takeNumber();
                
		table = ran.getTableArray();
                
		System.out.println("");
		System.out.println("");
		for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
			if(table[i][j]==999)
				System.out.print("X  ");
			else
				System.out.print(table[i][j]+"  ");
		}
		System.out.println("");
		System.out.println("");
		}
		
	}
}
