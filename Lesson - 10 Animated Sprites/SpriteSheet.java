import java.awt.image.BufferedImage;

public class SpriteSheet
{

    private int[] pixels;
    private BufferedImage image;

    // Set them final, not allowed to change.(requires to setup a constructor)
    public final int SIZEX;
    public final int SIZEY;
    private Sprite[] loadedSprites = null;
    private boolean spriteLoaded = false;

    private int spriteSizeX;


    public SpriteSheet(BufferedImage sheetImage)
    {
        image = sheetImage;
        SIZEX = sheetImage.getWidth();
        SIZEY = sheetImage.getHeight();

        pixels = new int[SIZEX*SIZEY];
        pixels = sheetImage.getRGB(0, 0, SIZEX, SIZEY, pixels, 0, SIZEX);
    }

    // method that loads sprites
    public void loadSprites(int spriteSizeX, int spriteSizeY)
    {
        this.spriteSizeX = spriteSizeX;
        loadedSprites = new Sprite[ (SIZEX / spriteSizeX) * (SIZEY / spriteSizeY) ];

        int spriteID = 0;
        for( int y = 0; y < SIZEY; y += spriteSizeY ) {
            for( int x = 0; x < SIZEX; x += spriteSizeX ) {
                loadedSprites[spriteID] = new Sprite(this, x, y, spriteSizeX, spriteSizeY);
                spriteID++;
            }
        }

        spriteLoaded = true;
    }

    public Sprite getSprite( int x, int y)
    {
        if(spriteLoaded)
        {
            int spriteID = x + y * ( SIZEX / spriteSizeX );

            if(spriteID < loadedSprites.length)
                return loadedSprites[spriteID];
            else
                System.out.println("SpriteID of " + spriteID + " is out of the range with a length of " + loadedSprites.length+ " .");
        }
        else
        {
            System.out.println("SpriteSheet couldn't get a sprite with no loaded sprite.");
        }
        return null;
    }

    public int[] getPixels()
    {
        return pixels;
    }

    public BufferedImage getImage()
    {
        return image;
    }

}