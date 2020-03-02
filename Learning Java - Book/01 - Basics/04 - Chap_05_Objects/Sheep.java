import java.util.Hashtable;

public class Sheep implements Cloneable 
{

    Hashtable flock = new Hashtable();

    public Object clone() {
        try {
            return super.clone();
        } catch ( CloneNotSupportedException e ) {
            throw new Error("This should neva happen");
        }
    }
}
