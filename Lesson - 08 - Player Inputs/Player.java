public  class Player implements GameObject // cannot be abstract ??? abstract
{
    Rectangle playerRectangle;
    int speed = 10;

    public Player() {
        playerRectangle = new Rectangle( 20, 16, 16, 20 );
        playerRectangle.generateGraphics(2 , 0x00FF0090 );

    }

    // Call every time physically possible
    public void render( RenderHandler renderer , int xZoom, int yZoom ) {
        renderer.renderRectangle( playerRectangle, xZoom, yZoom );
    }

    // Call at 60 fps rate
    public void update( Game game ) {
        KeyBoardListener keyListener = game.getKeyListener();
        if ( keyListener.up() )
            playerRectangle.y -= speed;
        if ( keyListener.down() )
            playerRectangle.y += speed;
        if ( keyListener.left() )
            playerRectangle.x -= speed;
        if ( keyListener.right() )
            playerRectangle.x += speed;
    }

}