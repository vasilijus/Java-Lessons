# Render and Update

     - Computers don't all run at the same speed.
        * Some computers will run the update and render diffrently on diffrent CPU's ....
     - We don't want the speed of our game to change based on what computer you are playing it on.


     - Render() - This method will run as fast as the computer can run it
       - Will render everything to the screen

     - Update() - This method will run at a specific rate.
       - Will update player/NPC movement. Change any variables, etc.

# Let's get those pixels

## BufferedImage

 - An image with a buffer.
 - Allows us to edit all tof the pixels in the bugger.
 - A compromised of a ColorModel and a Raster of image data.
   - ColorModel - Handles our RGB Components in order to render a complete image to the screen ( with all colors mixed)
   - Raster - A rectangular array of pixels
     - DataBuffer - Stores all the pixel values in an array
     - SampleModel - Describe how to locate the pixel values

# Importing Game Models.