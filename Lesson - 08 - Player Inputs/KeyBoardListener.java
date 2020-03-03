import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class KeyBoardListener implements KeyListener, FocusListener
{

    public boolean[] keys = new boolean[120];

    public void keyPressed( KeyEvent event ) {
        // System.out.println( event.getKeyCode() );  // Get hints in the terminal
        int keyCode = event.getKeyCode();
        if( keyCode < keys.length )
            keys[keyCode] = true;
    }

    public void keyReleased( KeyEvent event ) { }

    public void focusLost( FocusEvent event ) { }

    public void keyTyped( KeyEvent event ) {

    }

    public void focusGained( FocusEvent event ) { }
}