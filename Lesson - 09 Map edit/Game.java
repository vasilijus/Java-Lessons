import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import java.lang.Runnable;
import java.lang.Thread;

import javax.swing.JFrame;

import javax.imageio.ImageIO;
import javax.sound.midi.Receiver;

import java.io.IOException;
import java.io.File;

public class Game extends JFrame implements Runnable {

    public static int alpha = 0xFFFF00DC; // Alpha purple / 0xFF00DC -> purple

    private Canvas canvas = new Canvas();
    private RenderHandler renderer;
    // private BufferedImage testImage;
    // private Sprite testSprite;
    private SpriteSheet sheet;

    private Rectangle testRectangle = new Rectangle(50, 50, 100, 100);
    private Tiles tiles;
    private Map map;

    private GameObject[] objects;
    private KeyBoardListener keyListener = new KeyBoardListener(this);
    private MouseEventListener mouseListener = new MouseEventListener(this);

    private Player player;

    private int xZoom = 3;
    private int yZoom = 3;

    public Game() {
        // Makes our program shutdown when we exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set window boundaries
        setBounds(0, 0, 800, 600);

        // Put Frame to center of screen
        setLocationRelativeTo(null);

        // Add our graphics component
        add(canvas);

        // Make Frame visible - ( Must Be Beffore BufferStrategy)
        setVisible(true);

        // Create our object for buffer strategy
        canvas.createBufferStrategy(3);

        renderer = new RenderHandler(getWidth(), getHeight());

        // Load Assets
        BufferedImage sheetImage = loadImage("Tiles1.png");
        sheet = new SpriteSheet(sheetImage);
        sheet.loadSprites(16, 16);

        // Load Tiles
        tiles = new Tiles(new File("defaults/Tiles.txt"), sheet);

        // testImage = loadImage("grass_tile.png");
        // // testSprite = new Sprite(testImage);
        // testSprite = sheet.getSprite(3,1);

        // Load Map
        map = new Map(new File("saves/Map.txt"), tiles);

        testRectangle.generateGraphics(1, 1230);

        // load objects
        objects = new GameObject[1];
        player = new Player();
        objects[0] = player;

        // Add Listeners
        canvas.addKeyListener(keyListener);
        canvas.addFocusListener(keyListener);
        canvas.addMouseListener(mouseListener);
        canvas.addMouseMotionListener(mouseListener);
    }

    public void update() {
        // System.out.println("Update method"); // works...
        for (int i = 0; i < objects.length; i++) {
            objects[i].update(this);
        }
    }

    private BufferedImage loadImage(String path) {
        try {

            BufferedImage loadedImage = ImageIO.read(Game.class.getResource(path));
            BufferedImage formattedImage = new BufferedImage(loadedImage.getWidth(), loadedImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            formattedImage.getGraphics().drawImage(loadedImage, 0, 0, null);
            // System.out.println("Buffe");
            return formattedImage;

        } catch (IOException exception) {

            exception.printStackTrace();
            return null;

        }
    }

    public void handleCTRL(boolean[] keys) {
        if (keys[KeyEvent.VK_S]) 
            map.saveMap();
    }

    public void leftClick(int x, int y) {
        System.out.println("Click 1: " + x + " " + y);
        x = (int) Math.floor((x + renderer.getCamera().x) / (16.0 * xZoom));
        y = (int) Math.floor((y + renderer.getCamera().y) / (16.0 * yZoom));
        map.setTile(x, y, 2);
    }

    public void rightClick(int x, int y) {
        System.out.println("Click 2: " + x + " " + y);
        x = (int) Math.floor((x + renderer.getCamera().x) / (16.0 * xZoom));
        y = (int) Math.floor((y + renderer.getCamera().y) / (16.0 * yZoom));
        map.removeTile(x, y);
    }

    public void render() {
        // System.out.println("Render method");
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        super.paint(graphics);

        map.render(renderer, xZoom, yZoom);

        // renderer.renderRectangle(testRectangle, 1, 1);

        for (int i = 0; i < objects.length; i++)
            objects[i].render(renderer, xZoom, yZoom);
        renderer.render(graphics);

        // Release the graphics restore
        graphics.dispose();
        bufferStrategy.show();

        renderer.clear();
    }

    public void run() {
        System.out.println("Error");
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        int i = 0;
        int x = 0;

        // Getting time in Java
        long lastTime = System.nanoTime(); // long (2^63) > int
        double nanoSecondConversion = 1000000000.0 / 60; // 1e+9 / ^60 frames per second
        double changeInSeconds = 0;

        while (true) {
            long now = System.nanoTime();

            changeInSeconds += (now - lastTime) / nanoSecondConversion;
            // System.out.println(changeInSeconds);
            while (changeInSeconds >= 1) {
                update();
                changeInSeconds = 0;
            }

            render();
            lastTime = now;
        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        Thread gameThread = new Thread(game);
        gameThread.start();
    }

    public KeyBoardListener getKeyListener() {
        return keyListener;
    }

    public MouseEventListener getMouseListener() {
        return mouseListener;
    }

    public RenderHandler getRenderer() {
        return renderer;
    }

    // public saveMap()
    // {

    // }
}