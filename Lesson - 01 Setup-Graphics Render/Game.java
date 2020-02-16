import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Game extends JFrame
{

    private Canvas canvas = new Canvas();

    public Game() 
    {
        // Makes our program shutdown when we exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set window boundaries
        setBounds(0,0,800,600);
        // Put Frame to center of screen
        setLocationRelativeTo(null);
        // Add our graphics component
        add(canvas);

        // Make Frame visible - ( Must Be Beffore BufferStrategy)
        setVisible(true);

        // Create our object for buffer strategy
        canvas.createBufferStrategy(3);
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        int i = 0;
        int x = 0;
        while(true) {
            i++;
            if ( i >= 1000) {
                i = 0;
                x++;
            }
            bufferStrategy = canvas.getBufferStrategy();
            Graphics graphics = bufferStrategy.getDrawGraphics();
            super.paint(graphics);
            graphics.setColor(Color.red);
            graphics.fillOval(x, 20, 50, 100);
            // Release the graphics restore
            graphics.dispose();
            bufferStrategy.show();

        }
    }

    // public void paint(Graphics graphics) {
    //     super.paint(graphics);
    //     graphics.fillRect(10,10,200,200);
    //     graphics.setColor(Color.red);
    //     graphics.fillOval(50, 50, 100, 100);
    // }

    public static void main(String[] args)
    {
        new Game();
    }
}