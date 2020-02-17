import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class RenderHandler 
{

    private BufferedImage view;
    private Rectangle camera;
    private int[] pixels;

    // Constructor
    public RenderHandler(int width, int height)
    {
        // Create a BufferedImage that will represent the view
        view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //
        camera = new Rectangle(0, 0, width, height);

        camera.x = -100;
        camera.y = -30;

        // Create an array for pixels
        pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();

    }

    // Renders our pixel array to the screen...
    public void render(Graphics graphics)
    {
        graphics.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
    }

    // Render an image to our array of pixels.
    public void renderImage(BufferedImage image, int xPosition, int yPosition, int xZoom, int yZoom)
    {
        int[] imagePixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        renderArray(imagePixels, image.getWidth(), image.getHeight(), xPosition, yPosition, xZoom, yZoom);
    } 

    public void renderRectangle( Rectangle rectangle, int xZoom, int yZoom)
    {

    }

    public void renderArray(int[] renderPixels, int renderWidth, int renderHeight, int xPosition, int yPosition, int xZoom, int yZoom)
    {
        for(int y = 0; y < renderHeight; y++ ) 
            for(int x = 0; x < renderWidth; x++ ) 
                for(int xZoomPosition = 0; xZoomPosition < xZoom; xZoomPosition++)
                    for(int yZoomPosition = 0; yZoomPosition < yZoom; yZoomPosition++)
                    setPixel(renderPixels[x + y * renderWidth], (x * xZoom)+xPosition+xZoomPosition, (y*yZoom)+yPosition+yZoomPosition );      
    }

    private void setPixel( int pixel, int x, int y)
    {
        if (x >=camera.x && y >= camera.y && x <= camera.x + camera.w && y <= camera.y + camera.h) {
            int pixelIndex = (x - camera.x) + (y - camera.y) * view.getWidth();
            if(pixels.length > pixelIndex) {
                pixels[pixelIndex] = pixel;
            }
        }
    }


}
