/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

public class RandomizeTable {

    /**
     * @param args the command line arguments
     */
        private int  numOfBomb;
	private int  numOfTable;
	private int[][] table ;
	private int[] randx ;
	private int[] randy ;
        RandomizeTable(int bmb,int tab){
		 numOfBomb=bmb;
		 numOfTable=tab;
		table = new int[ numOfTable][ numOfTable];
		randx = new int[ numOfBomb];
		randy = new int[ numOfBomb];
	}
    public void takeNumber() {
       Random rn = new Random();
		for(int i =0;i< numOfBomb;i++)	{
			int check = 1;
			int randx1=0,randy1 =0;
			//check pair number<x,y> that same early 
			while(check==1){
				randx1 = rn.nextInt(numOfTable-1);
				randy1 = rn.nextInt(numOfTable-1);
                                
				check = 0;
			
				//check number hat over <numOfBomb>
				for(int a=0;a<numOfBomb;a++){
					if((randx1==numOfTable)||(randy1==numOfTable))
						{check = 1;break; }
					else if((randx1==randx[a])&&(randy1==randy[a]))
						{check = 1;break;}
					else check = 0;
				}
			}
			randx[i] = randx1;
                        
			randy[i] = randy1;
                         
		}
		for(int i =0;i< numOfBomb;i++){
			table[randx[i]][randy[i]]= 999 ;	
		}
               check(randx,randy);

    }
    public void check(int[] randx,int[] randy){
        for(int i=0;i< numOfTable;i=i+1){	
  			for(int j=0;j< numOfTable;j++)	{
  				if(table[i][j]!= 999){
  				   for(int k=0;k< numOfBomb;k++){
  						if((i-1)==randx[k]&&(j-1)== randy[k])	{
  							table[i][j]++;
  						}
  						if((i-1==randx[k])&& j == randy[k]){
  							table[i][j]++;
  						}
  						if((i-1)==randx[k]&&(j+1)== randy[k]){
  							table[i][j]++;
  						}
  						if(  i ==randx[k]&&(j-1)== randy[k]){
  							table[i][j]++;
  						}
  						if( i ==randx[k]&&(j+1)== randy[k]){
  							table[i][j]++;
  						}	
  						if((i+1)==randx[k]&&(j-1)== randy[k]){
  							table[i][j]++;
  						}	
  						if((i+1)==randx[k]&& j == randy[k]){
  							table[i][j]++;
  						}	
  						if((i+1)==randx[k]&&(j+1)== randy[k]){
  							table[i][j]++;
  						}	
  					}	
  				}
			}
		}
    }
    public int[][] getTableArray(){
  		return table;
  	}
}
