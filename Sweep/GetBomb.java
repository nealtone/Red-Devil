
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sun.nio.cs.Surrogate.Parser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class GetBomb extends JFrame implements ActionListener{
    static int bomb;
        JPanel Start1 = new JPanel();
        JTextField getbomb = new JTextField("input 2-80");
        JButton ok = new JButton("OK");

    public GetBomb() {
        super("Set Bomb");
		setBounds(200,200,220,70);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
        Start1.add(getbomb);
        Start1.add(ok);
        ok.addActionListener(this);
        add(Start1);
      
    }
        
   


    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==ok)
      {
           bomb =Integer.parseInt(getbomb.getText());
          PlateGame game = new PlateGame(bomb);
        	game.setVisible(true);
                
      }
    }
    
}
