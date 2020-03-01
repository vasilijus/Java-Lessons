
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava03
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Hello Java");
        frame.getContentPane().add( new HelloComponent03("Hello Java !") );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 300, 300 );
        frame.setVisible( true );
    }
}

class HelloComponent03 extends JComponent implements MouseMotionListener, ActionListener, Runnable
{
    String theMessage;
    int messageX = 125, messageY = 90; // Coordinates of the message

    JButton theButton;

    int colorIndex; // current index into someColors
    static Color[] someColors = { Color.black, Color.red, Color.green, Color.blue, Color.magenta };
    boolean blinkState;

    public HelloComponent03( String message )
    {
        theMessage = message;
        theButton = new JButton( "Change Color" );
        setLayout( new FlowLayout() );
        add( theButton );
        theButton.addActionListener( this );
        addMouseMotionListener( this );

        Thread t = new Thread( this );
        t.start();
    }

    public void paintComponent( Graphics g ) {
        g.setColor( blinkState ? getBackground() : currentColor() );
        g.drawString( theMessage, messageX, messageY );
    }

    public void mouseDragged( MouseEvent e )
    {
        messageX = e.getX();
        messageY = e.getY();
        repaint();
    }

    public void mouseMoved( MouseEvent e ) { }

    public void actionPerformed( ActionEvent e )
    {
        // someone pushing the button
        if (e.getSource() == theButton )
        {
            changeColor();
        }
    }

    synchronized private void changeColor()
    {
        // changes index to the next colorrrr
        if ( ++colorIndex == someColors.length )
            colorIndex = 0;
        setForeground( currentColor() );
        repaint();
    }

    synchronized private Color currentColor()
    {
        return someColors[colorIndex];
    }
    
    public void run( ) {
        try {
            while ( true ) {
                blinkState = !blinkState; // Toggle blinkState
                repaint(); // show the change
                Thread.sleep( 300 );
            }
        } catch ( InterruptedException ie ) { }
    }
}