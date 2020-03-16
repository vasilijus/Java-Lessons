
public class Rectangle
{
    public int x, y, w, h;

    public int[] pixels;

    Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    Rectangle() {
        this(0,0,0,0);
    }

    public void generateGraphics(int color) {
        pixels = new int[w*h];

        for (int y = 0; y < h; y++) {
            for (int x = 0 ; x < w; x++) {
                pixels[x + y * w] = color;
            }
        }
    }


    public boolean intersects(Rectangle otheRectangle)
    {
        if(x > otheRectangle.x + otheRectangle.w || otheRectangle.x > x + w)
            return false;
        
        if(y > otheRectangle.y + otheRectangle.h || otheRectangle.y > y + h)
            return false;
        
        return true;
    }

    public void generateGraphics(int borderWidth, int color) {
        pixels = new int[w*h];

        for(int i = 0; i < pixels.length; i++)
            pixels[i] = Game.alpha;
            
        // Top horizontal
        for(int y = 0; y < borderWidth; y++)
            for(int x = 0; x < w; x++)
                pixels[x + y * w] = color; 
        // Left vertical
        for(int y = 0; y < h; y++)
            for(int x = 0; x < borderWidth; x++)
                pixels[x + y * w] = color;
        // Bot horizontal
        for(int y = h - borderWidth; y < h; y++)
            for(int x = 0; x < w; x++)
                pixels[x + y * w] = color;
        // Right Vertical
        for(int y = 0; y < h; y++)
            for(int x = w - borderWidth; x < w; x++)
                pixels[x + y * w] = color;
    }

    public int[] getPixels()
    {
        if (pixels != null)
            return pixels;
        else
            System.out.println("Attemted to retrieve pixels from a Rect without a generated graphics!");
        return null;
    }

    public String toString()
    {
        return "[" + x + ", " + y + ", " + w + ", " + h + "]";
    }
    
}