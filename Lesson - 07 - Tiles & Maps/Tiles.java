import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; // IO
import java.util.ArrayList;

public class Tiles 
{
    private SpriteSheet spriteSheet;
    private ArrayList<Tile> tilesList = new ArrayList<Tile>();

    // get a list of all the tiles from a .txt file
    // This will only work asuming the sprite in the sproteSheet have been loaded.
    public Tiles(File tilesFile, SpriteSheet spriteSheet)
    {
        this.spriteSheet = spriteSheet;

        try {
            Scanner scanner = new Scanner(tilesFile);
            while( scanner.hasNextLine() ) 
            {
                // read each line and create a Tile;
                String line = scanner.nextLine();
                if (!line.startsWith("//") )
                {
                    String[] splitString = line.split("-");
                    String tileName = splitString[0];
                    int spriteX = Integer.parseInt(splitString[1]);
                    int spriteY = Integer.parseInt(splitString[2]);
                    Tile tile = new Tile(tileName, spriteSheet.getSprite(spriteX, spriteY) );
                    tilesList.add(tile);
                }
            }
        } 
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
    }

    public renderTile(int tileID, RenderHandler renderer, int xPosition, int yPosition, int xZoom, int yZoom)
    {
        if( tileID >= 0 && tilesList.size() > tileID )
        {
            // render sprite
            renderSprite(tilesList.get(tileID).sprite, xPosition, yPosition, xZoom, yZoom);
        }
        else
        {
            System.out.println("TileID "+tileID+" is not within range "+tilesList.size()+ ".");
        }
    }

    public Tile()
    {
        public String tileName;
        public Sprite sprite;

        public Tile(String tileName, Sprite sprite)
        {
            this.tileName = tileName;
            this.sprite = sprite;
        }
    }

}