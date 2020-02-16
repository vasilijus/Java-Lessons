import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.lang.Runnable;
import java.lang.Thread;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable
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
 
    }

    public void update()
    {
        // System.out.println("Update method"); // works...
        x += 1;
    }

    private int x = 0;

    public void render()
    {
        // System.out.println("Render method");
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        super.paint(graphics);

        // Paint rectangle
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, getWidth(), getHeight());

        // paint circle
        graphics.setColor(Color.red);
        graphics.fillOval(x, 50, 40, 40);
    
        // Release the graphics restore
        graphics.dispose();
        bufferStrategy.show();
    }


    public void run()
    {
        System.out.println("Error");
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        int i = 0;
        int x = 0;

        // Getting time in Java
        long lastTime = System.nanoTime(); // long (2^63) > int 
        double nanoSecondConversion = 1000000000.0 / 60; //  1e+9 / ^60 frames per second 
        double changeInSeconds = 0;

        while(true) {
            long now = System.nanoTime();
            
            changeInSeconds += (now -lastTime) / nanoSecondConversion; 
            System.out.println(changeInSeconds);
            while( changeInSeconds >= 1 ) {
                update();
                changeInSeconds = 0;
            }

            render();
            lastTime = now;
        }

        // // Bad loop
        // while(true) {

        // }
    }


    public static void main(String[] args)
    {
        Game game = new Game();
        Thread gameThread = new Thread(game);
        gameThread.start();
    }
}