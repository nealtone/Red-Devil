
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class GetBomb extends JFrame implements ActionListener,MouseListener{
    static int bomb;
        JPanel Start1 = new JPanel();
        JTextField getbomb = new JTextField("Please input 2-80 Bomb!!");
        JButton ok = new JButton("OK");
        
    public GetBomb() {
        super("Set Bomb");
		setBounds(200,200,220,70);
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
          setVisible(false);
          bomb =Integer.parseInt(getbomb.getText());
          PlateGame game = new PlateGame(bomb);
          game.setVisible(true);
                
      }
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
