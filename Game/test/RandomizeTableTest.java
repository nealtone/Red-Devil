/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class RandomizeTableTest {
    
    public RandomizeTableTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of takeNumber method, of class RandomizeTable.
     */
    @Test
    public void testTakeNumber() {
        
    }

    /**
     * Test of check method, of class RandomizeTable.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
       
	int[] randx =new int[4] ;
	int[] randy =new int[4];
       randx[0]=0;
       randx[1]=0;
       randx[2]=1;
       randx[3]=1;
       randy[0]=0;
       randy[1]=2;
       randy[2]=1;
       randy[3]=2;
       
       
        
        int[][] table=new int[9][9];
        for(int i=0;i< 9;i=i+1)		{	
  			
  			for(int j=0;j< 9;j++)	{
  				if(table[i][j]!= 999){
  				   for(int k=0;k< 4;k++){
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
        table[0][0]=999;
        table[0][2]=999;
        table[1][1]=999;
        table[1][2]=999;
        RandomizeTable instance = null;
        
        assertEquals(4, table[0][1]);
    }

    /**
     * Test of getTableArray method, of class RandomizeTable.
     */
    @Test
    public void testGetTableArray() {
        System.out.println("getTableArray");
        RandomizeTable instance = null;
    }
}
