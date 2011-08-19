


import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.Icon;

class PlateGame extends JFrame implements ActionListener,Runnable,MouseListener{
        //ver 3
        
        
       GetBomb test = new GetBomb();
       
        final int numOfTable = 9;
        int numOfBomb;
       
        
	private int[][] table; 
	private int[][] visible ;
	int checkIsAllCorrect=0,checkIsOpened=0,startTimer=0;
	int h,m,s,ns,setPoint;
        //Ver2//////////////////////
        JPanel startTab = new JPanel( new GridLayout(1,3));
        JLabel time  = new JLabel("    time :  00:00");
        JLabel stat = new JLabel("...");
        JButton reset = new JButton("New Game");
       
        //////////////////////////////
	//set path bomb image
	Icon pic =new ImageIcon("D:/tae/Red-Devil/Sweep/bomb.jpg");
        Icon pic2 = new ImageIcon("D:/tae/Red-Devil/Sweep/red_flag.jpeg");
	JPanel tablePanel = new JPanel();
        JPanel tableScore = new JPanel();
        JLabel Score = new JLabel();
	JPanel blank = new JPanel();
        JButton High = new JButton("High Score");
	JButton[][] block = new JButton[9][9];
        int[][] blockMark = new int[9][9];
        int[][] MarkOpen = new int[9][9];
        int[][] MarkLeftClick = new int[9][9];
        
        private int i=0;
        int min=9999,max=0;
        private double d;
        private String str,str2 = "";
	PlateGame(int numOfBomb1 ){
           
		super("GameMineSweeper");
                 numOfBomb = numOfBomb1;      
		setBounds(200,200,400,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
                  System.out.println(numOfBomb);
		tablePanel.setLayout(new GridLayout(9,9,0,0));
		//add all Button 
		for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
			table = new int[ numOfTable][ numOfTable];
			visible = new int[ numOfTable][ numOfTable];
			block[i][j] = new JButton("");
			tablePanel.add(block[i][j]);
			block[i][j].addActionListener(this);
                        block[i][j].addMouseListener(this);
		}
		}
		RandomizeTable ran = new RandomizeTable( numOfBomb, numOfTable);
		ran.takeNumber();
		table = ran.getTableArray();
                //ver3
                
                //ver2
                startTab.add(time);
                startTab.add(reset);
                startTab.add(High);
                reset.addActionListener(this);
                High.addActionListener(this);
                add(startTab,"North");
		add(tablePanel,"Center");
                
	}
	
	public void actionPerformed(ActionEvent e){
            //Even left click
		for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
                    if(MarkLeftClick[i][j] == 0){
			if(e.getSource()== block[i][j])
			{
                            MarkOpen[i][j] = 1;
                         if(startTimer==0)
                             new Thread(this).start();
					startTimer=1;
			block[i][j].setEnabled(false);
			visible[i][j]=1;
			if(table[i][j]>0&&table[i][j]<=8)
				block[i][j].setText(Integer.toString(table[i][j]));
					if(table[i][j]==999){
						block[i][j].setIcon(pic);
						block[i][j].setDisabledIcon(pic);
						block[i][j].setEnabled(true);
						block[i][j].setBackground(Color.RED);
						restart(2);
					}	
					if(table[i][j]==0&&visible[i][j]==1)
					zeroAction();
					checkEnd();
                                    }
                                }else{              } }}
            //Even Button new game
            if(e.getSource()==reset)  { restart(0); }
            //Even Button high score
    try{
            if(e.getSource()==High){
                       FileReader fin = null;
              try {
                   fin = new FileReader("GameScore.txt");
                        } catch (FileNotFoundException ex) {  }
                                int[] keep ;
                                keep = new int[100];
                                int p=0,buff=0;
                                //read File
                                Scanner src = new Scanner(fin);
                    while (src.hasNext()) {
                        if (src.hasNextInt()) {
                                 i = src.nextInt();
                                 keep[p]=i;
                                 p++;
                         } else if (src.hasNextDouble()) {
                                 d = src.nextDouble();
                        } else if (src.hasNextBoolean()) {
                                Boolean b = src.nextBoolean();
                        } else {
                                str = src.next();
                            try {
                                fin.close();
                                     } catch (IOException ex) {
                                    }
                               }
                        
                }
                   // min = keep[0];
                    //Sort rank
                    for(int i=0;i<p;i++){
                         for(int j=1;j<(p-i);j++){
                            if(keep[j-1]>keep[j]){
                            buff=keep[j-1];
                            keep[j-1]=keep[j];
                            keep[j]=buff;
                            }
                         }
                    }
                JOptionPane.showMessageDialog(tableScore,"Best Times \n"+" Rank "+(1)+"      "+ChangeValueToTime(keep[0])+"\n"
                        +"\t Rank "+(2)+"      "+ChangeValueToTime(keep[1])+"\n"
                        +"\t Rank "+(3)+"      "+ChangeValueToTime(keep[2])+"\n"
                        +"\t Rank "+(4)+"      "+ChangeValueToTime(keep[3])+"\n"
                        +"\t Rank "+(5)+"      "+ChangeValueToTime(keep[4]));
        }
        }catch(Exception a){
            JOptionPane.showMessageDialog(tableScore,"No Rank");
        }
        }
        //Maximum 7 munit
  public String ChangeValueToTime(int a){
            String time="";
            for(int i=0;i<=a;i++)
            {
                if(a<60)
                {
                    if(a<10)
                    time = "00:0"+i;
                    else
                        time = "00:"+i;
                }else if(a>=60&&a<70){
                    time = "01:0"+(i-60);
                }else if(a>=70&&a<120){
                    time = "01:"+(i-60);
                }else if(a>=120&&a<130){
                    time = "02:0"+(i-120);
                }else if(a>=130&&a<180){
                    time = "02:"+(i-120);
                }else if(a>=180&&a<190){
                    time = "03:0"+(i-180);
                }else if(a>=190&&a<240){
                    time = "03:"+(i-180);
                }else if(a>=240&&a<250){
                    time = "04:0"+(i-240);
                }else if(a>=250&&a<300){
                    time = "04:"+(i-240);
                }else if(a>=300&&a<310){
                    time = "05:0"+(i-300);
                }else if(a>=310&&a<360){
                    time = "05:"+(i-300);
                }else if(a>=360&&a<370){
                    time = "06:0"+(i-360);
                }else if(a>=370&&a<420){
                    time = "06:"+(i-360);
                }else if(a>=420&&a<430){
                    time = "07:0"+(i-420);
                }else if(a>=430&&a<480){
                    time = "07:"+(i-420);
                }
            }
            return time.toString();
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
                                                block[i-1][j-1].setIcon(null);
                                                MarkOpen[i-1][j-1] = 1;
					}
					if((i-1)>=0){
						visible[i-1][j]=1;
						block[i-1][j].setEnabled(false);
						if(table[i-1][j]!=0)
							block[i-1][j].setText(Integer.toString(table[i-1][j]));
                                                block[i-1][j].setIcon(null);
                                                MarkOpen[i-1][j] = 1;
					}
					if((i-1)>=0&&(j+1)< numOfTable){
						visible[i-1][j+1]=1;
						block[i-1][j+1].setEnabled(false);
						if(table[i-1][j+1]!=0)
							block[i-1][j+1].setText(Integer.toString(table[i-1][j+1]));
                                                block[i-1][j+1].setIcon(null);
                                                MarkOpen[i-1][j+1] = 1;
                                                
					}
					if((j-1)>=0){
						visible[i][j-1]=1;
						block[i][j-1].setEnabled(false);
						if(table[i][j-1]!=0)
							block[i][j-1].setText(Integer.toString(table[i][j-1]));
                                                block[i][j-1].setIcon(null);
                                                MarkOpen[i][j-1] = 1;
					}
					
					if((j+1)< numOfTable){
						visible[i][j+1]=1;
						block[i][j+1].setEnabled(false);
						if(table[i][j+1]!=0)
							block[i][j+1].setText(Integer.toString(table[i][j+1]));
                                                block[i][j+1].setIcon(null);
                                                MarkOpen[i][j+1] = 1;
					}
					if((i+1)< numOfTable&&(j-1)>=0){
						visible[i+1][j-1]=1;
						block[i+1][j-1].setEnabled(false);
						if(table[i+1][j-1]!=0)
							block[i+1][j-1].setText(Integer.toString(table[i+1][j-1]));
                                                block[i+1][j-1].setIcon(null);
                                                MarkOpen[i+1][j-1] = 1;
					}
						
					if((i+1)< numOfTable){
						visible[i+1][j]=1;
						block[i+1][j].setEnabled(false);
						if(table[i+1][j]!=0)
							block[i+1][j].setText(Integer.toString(table[i+1][j]));
                                                block[i+1][j].setIcon(null);
                                                MarkOpen[i+1][j] = 1;
					}
						
					if((i+1)< numOfTable&&(j+1)< numOfTable){
						visible[i+1][j+1]=1;
						block[i+1][j+1].setEnabled(false);
						if(table[i+1][j+1]!=0)
							block[i+1][j+1].setText(Integer.toString(table[i+1][j+1]));
                                                block[i+1][j+1].setIcon(null);
                                                MarkOpen[i+1][j+1] = 1;
					}					
				}
			}
			}
		   u++;	
		}
	}
	
public void checkEnd() {
		
		checkIsAllCorrect=0;
                FileWriter write = null;
            try {
                write = new FileWriter("GameScore.txt",true);
            } catch (IOException ex) {
            }
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(visible[i][j]==1&&table[i][j]!=8)
					checkIsAllCorrect++;	
			}
		}
		checkIsOpened=checkIsAllCorrect;
		
		if(checkIsAllCorrect==(( numOfTable* numOfTable)- numOfBomb)){
                     for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
			if(table[i][j]==999){
			block[i][j].setIcon(pic);
                            }
                        }
                     }
                     //winGame
                     JOptionPane.showMessageDialog(tablePanel,"   Finish!!  --   Your time: "+m+":"+s+ns);
            try {
                write.write((setPoint-1)+" "+m+":"+s+ns+"\t\n");
                write.close();
            } catch (IOException ex) {
                
            }
                     
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
                        //lose
                        for(int i=0;i<9;i++){
                        for(int j=0;j<9;j++){
                            MarkOpen[i][j] =1;
                                blockMark[i][j] = 1;
                            }
                                                 }
                         JOptionPane.showMessageDialog(tablePanel,"   You lose!!  --   55555");
		}
	}
	
	public void newGame(){
		//add all Button 
            if(checkIsOpened!=0){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				visible[i][j]=0;
				block[i][j].setEnabled(true);
				block[i][j].setText("");
                                
				tablePanel.remove(block[i][j]);
				block[i][j]  = new JButton("");
				tablePanel.add(block[i][j]);
				block[i][j].addActionListener(this);
                                block[i][j].addMouseListener(this);
                                MarkOpen[i][j] =0;
                                blockMark[i][j] = 0;
                                MarkLeftClick[i][j] = 0;
			}
		}
                
                }else{
                for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				     block[i][j].setIcon(null);
			}
		}
            }
            repaint();
		m=0;
		s=0;
                ns=0;
                setPoint=0;
		checkIsOpened=0;
                time.setText("    time :  00:00");
                
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
        public void run(){
		
		while(startTimer!=0)
		{
			if(ns==9){
   				ns=0;s++;
                                if(s==6){
                                    m++;
                                    s=0;}
   			}
	   		if(s<=6)
                            time.setText("    time :  "+m+":"+s+ns);	
                        else
                            time.setText("    time :  "+m+":"+s+ns);
    			
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){}
			setPoint++;
			GregorianCalendar timer = new GregorianCalendar();
   			ns++;
                        
		}
	}

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
			if(e.getSource()== block[i][j]&&e.getButton()==MouseEvent.BUTTON3)
                            {
                                if(blockMark[i][j] == 0)
                                    {
                                        if(MarkOpen[i][j] == 0&&blockMark[i][j]!=1){
                                         block[i][j].setIcon(pic2);
					 block[i][j].setEnabled(true);
                                         blockMark[i][j] = 1;
                                         MarkOpen[i][j] = 1;
                                         MarkLeftClick[i][j] = 1;
                                        }else
                                        { 
                                            
                                        }
                                    
                                }else
                                {
                                    if(MarkOpen[i][j] == 1){
                                    block[i][j].setIcon(null);
                                    blockMark[i][j] = 0;
                                    MarkOpen[i][j] = 0;
                                    MarkLeftClick[i][j] = 0;
                                    }
                                    else
                                    {
                                   }
                                }           
                            }
		}
	}
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
