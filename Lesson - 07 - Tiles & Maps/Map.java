public class Map
{
    private Tiles tileSet;
    private int fillTileID = -1;

    public Map(File mapFile, Tiles tileSet)
    {
        this.tileSet = tileSet;
        try
        {
            Scanner line = new Scanner(tileSet);
            if (!line.startsWith("//") )
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
                if ()
                {
                    
                }

            }
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }
}