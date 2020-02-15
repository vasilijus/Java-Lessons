import java.awt.Graphics;
import javax.swing.JFrame;

public class Game extends JFrame
{

    public Game() {
        // System.out.println("Hello ");
        setBounds(0,0,800,600);
        setVisible(true);
    }

    public void paint(Graphics graphics)
    {

    }

    public static void main(String[] args)
    {
        new Game();
    }
}