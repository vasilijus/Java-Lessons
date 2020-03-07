public interface GameObject
{

    // Call every time physically possible
    public void render( RenderHandler renderer , int zoomX, int zoomY );

    // Call at 60 fps rate
    public void update( Game game );
}