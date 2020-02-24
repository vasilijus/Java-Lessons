import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.ArrayList;

public class Map
{
    private Tiles tileSet;
    private int fillTileID = -1;

    private ArrayList<MappedTile> mappedTiles = new ArrayList<MappedTile>();
    public Map(File mapFile, Tiles tileSet)
    {
        this.tileSet = tileSet;
        try
        {
            Scanner scanner = new Scanner(mapFile);
            while( scanner.hasNextLine() )
            {
                String line = scanner.nextLine();
                if ( !line.startsWith("//") )
                {
                    if( line.contains(":") )
                    {
                        String[] splitString = line.split(":");
                        if( splitString[0].equalsIgnoreCase("Fill") )
                        {
                            fillTileID = Integer.parseInt(splitString[1]);
                            continue;
                        }
                    }
                    String[]  splitString = line.split(",");
                    //
                    if (splitString.length >= 3)
                    {
                        MappedTile mappedTile = new MappedTile( Integer.parseInt(splitString[0]),
                                                                Integer.parseInt(splitString[1]),
                                                                Integer.parseInt(splitString[2]) );
    
                        mappedTiles.add(mappedTile);
                    }
    
                }
            }
            
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }

    public void render( RenderHandler renderer, int xZoom, int yZoom)
    {
        int xIncrement = 16 * xZoom;
        int yIncrement = 16 * yZoom;

        for(int tileIndex = 0; tileIndex < mappedTiles.size(); tileIndex++ )
        {
            MappedTile mappedTile = mappedTiles.get(tileIndex);
            tileSet.renderTile( mappedTile.id, renderer, mappedTile.x * xIncrement, mappedTile.y * yIncrement, xZoom, yZoom );
        }
    }

    // Tile ID in the tileSet and the position of the tile in the map ( Struct )
    class MappedTile
    {
        public int id, x, y;

        public MappedTile( int id , int x, int y)
        {
            this.id = id;
            this.x  = x;
            this.y  = y;
        }
    }
}