/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Da_che
 */
public class testMineSweeper extends JFrame implements ActionListener {
    private int[][] visible ;
    private int[][] table; 
    JButton[][] block = new JButton[9][9];
    JPanel tablePanel = new JPanel();
    int checkIsAllCorrect=0,startTimer=0,checkIsOpened=0;
    int i,j,k;
    public static void main(String[] args) {
        
		
    }
    public void NewGame(){
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
		//time.setText("    time :  00:00");
		//stat.setText("...");
		
		//RandomizeTable ran = new RandomizeTable( numOfBomb, numOfTable);
		//ran.takeNumber();
		//table = ran.getTableArray();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
