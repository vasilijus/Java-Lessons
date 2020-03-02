import java.lang.reflect.*;

class Invoke
{
    public static void main( String[] args ) {
        try {
            Class c = Class.forName( args[0] );
            Method m = c.getMethod( args[1] , new Class [] { } );
            Object ret = m.invoke( null, null );
            System.out.println(
                "Invokedstatic method: " + args[1]
                + " of class: " + args[0]
                + " with no args\nResults: " + ret );
            
        } catch ( ClassNotFoundException e ) {

        } catch ( NoSuchMethodException e2 ) {

        } catch ( IllegalAccessException e3 ) {

        } catch ( InvocationTargetException e4 ) {
            System.out.println( "Method threw an: " + e4.getTargetException() );
        } 
    }
}
// We can use it in : 
//  java Invoke java.lang.System currentTimeMillis