public  class Player implements GameObject // cannot be abstract ??? abstract
{
    private Rectangle playerRectangle;
    private int speed = 10;
    private Sprite sprite;
    private AnimatedSprite animatedSprite = null;
    // 0 = right, 1 = left , 2 = up , 3 = down
    private int direction = 0;

    public Player( Sprite sprite ) {
        this.sprite = sprite;
        if( sprite instanceof AnimatedSprite )
            animatedSprite = ( AnimatedSprite) sprite;

        updateDirection();
        playerRectangle = new Rectangle( 20, 16, 16, 20 );
        playerRectangle.generateGraphics(2 , 0x00FF0090 );

    }

    private void updateDirection()
    {
        if( animatedSprite != null)
        {
            animatedSprite.setAnimationRange( direction * 8, ( direction * 8) + 7 );
        }
    }

    // Call every time physically possible
    public void render( RenderHandler renderer , int xZoom, int yZoom ) {
        //renderer.renderRectangle( playerRectangle, xZoom, yZoom );
        if(animatedSprite != null) {
            // System.out.println("Render: animatedSprite != null");
            renderer.renderSprite(animatedSprite, playerRectangle.x, playerRectangle.y, xZoom, yZoom, false);
        } else if (sprite != null ) {
            System.out.println("Render: sprite != null");
            renderer.renderSprite(sprite, playerRectangle.x, playerRectangle.y, xZoom, yZoom, false );
        } else {
            System.out.println("Render: Else");
            renderer.renderRectangle(playerRectangle, xZoom, yZoom, false);
        }

    }

    // Call at 60 fps rate
    public void update( Game game ) {

        KeyBoardListener keyListener = game.getKeyListener();

        boolean didMove = false;
        int newDirection = direction;

        if ( keyListener.left() ) {
            newDirection = 1;
            didMove = true;
            playerRectangle.x -= speed;
            
        }
          
        if ( keyListener.right() ) {
            newDirection = 0;
            didMove = true;
            playerRectangle.x += speed;
            
        }

        if ( keyListener.up() ){
            newDirection = 2;
            didMove = true;
            playerRectangle.y -= speed;
            
        }
            
        if ( keyListener.down() ) {
            newDirection = 3;
            didMove = true;
            playerRectangle.y += speed;
            
        }
      
        if ( newDirection != direction ){
            direction = newDirection;
            updateDirection();
        }
        
        if ( !didMove ) {
            animatedSprite.reset();
        }

        updateCamera( game.getRenderer().getCamera() );

        if (didMove)
            animatedSprite.update(game);

    }

    public void updateCamera( Rectangle camera ) {
        camera.x = playerRectangle.x - ( camera.w / 2 );
        camera.y = playerRectangle.y - ( camera.h / 2 );
    }

      // Call whenever mouse is clicked within the canvas
    public void handleMouseClick( Rectangle mouseRectangle, Rectangle camera, int xZoom, int yZoom) {}


}