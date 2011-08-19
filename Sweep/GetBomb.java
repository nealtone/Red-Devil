
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class GetBomb extends JFrame implements ActionListener,MouseListener{
    static int bomb;
        JPanel Start1 = new JPanel();
        JTextField getbomb = new JTextField("Please input 2-80 Bomb!!");
        
        //For test
         //JTextField getbomb = new JTextField("9");
        JButton ok = new JButton("OK");
        
    public GetBomb() {
        super("Set Bomb");
		setBounds(500,500,220,70);
                setBackground(Color.red);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
        Start1.add(getbomb);
        Start1.add(ok);
        getbomb.addMouseListener(this);
        ok.addActionListener(this);
        add(Start1);
        
      
    }
        
   
public void reset(){
   
    new GetBomb();
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
      if(e.getSource()==ok)
      {
 try{
          setVisible(false);
          choose();
           PlateGame game = new PlateGame(bomb);
          game.setVisible(true);
                }
    catch(Exception a){
        JOptionPane.showMessageDialog(Start1,"  Please input only number");
        setVisible(true);
    }
         
      }
    }
public int choose(){
    bomb =Integer.parseInt(getbomb.getText());
    return bomb;
}
    @Override
    public void mouseClicked(MouseEvent e) {
        getbomb.selectAll();
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
