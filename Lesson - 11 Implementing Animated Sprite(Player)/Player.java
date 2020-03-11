public  class Player implements GameObject // cannot be abstract ??? abstract
{
    private Rectangle playerRectangle;
    private int speed = 10;
    private Sprite sprite;
    private AnimatedSprite animatedSprite = null;
    // 0 = right, 1 = left , 2 = up , 3 = down
    private int direction = 0;

    public Player() {
        this.sprite = sprite;
        if( sprite instanceof AnimatedSprite )
            animatedSprite = ( AnimatedSprite) sprite;

        playerRectangle = new Rectangle( 20, 16, 16, 20 );
        playerRectangle.generateGraphics(2 , 0x00FF0090 );

    }

    private void updateDirection()
    {
        if( animatedSprite != null)
        {
            animatedSprite.setAnimationRange( direction * 8 , (direction * 8) + 7);
        }
    }

    // Call every time physically possible
    public void render( RenderHandler renderer , int xZoom, int yZoom ) {
        renderer.renderRectangle( playerRectangle, xZoom, yZoom );
    }

    // Call at 60 fps rate
    public void update( Game game ) {

        KeyBoardListener keyListener = game.getKeyListener();

        boolean didMove = false;

        if ( keyListener.left() ) {
            direction = 1;
            didMove = true;
            playerRectangle.x -= speed;
            
        }
          
        if ( keyListener.right() ) {
            direction = 0;
            didMove = true;
            playerRectangle.x += speed;
            
        }

        if ( keyListener.up() ){
            direction = 2;
            didMove = true;
            playerRectangle.y -= speed;
            
        }
            
        if ( keyListener.down() ) {
            direction = 3;
            didMove = true;
            playerRectangle.y += speed;
            
        }
      
        updateDirection();

        updateCamera( game.getRenderer().getCamera() );
    }

    public void updateCamera( Rectangle camera ) {
        camera.x = playerRectangle.x - ( camera.w / 2 );
        camera.y = playerRectangle.y - ( camera.h / 2 );
    }

}