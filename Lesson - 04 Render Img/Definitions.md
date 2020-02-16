# BufferedImage

 - An Image with a Buffer
 - Allows us to edit all of the pixels in the buffer.
 - Compromised of a ColorModel and a Raster of image data.
   - ColorModel - handles our RGB Components in order to render a coplete image to the screen 
   - Raster - A rectangular array of pixels
     - DataBuffer - Stores all pixel values in an array
     - SampleModel - Describes how to locate the pixel values.


## Importing Game Assets

 - ImageIO - Image Input/Output.
   - A library that allows us to simply input images and output images from our storage system.
 - Every class has the ability to 'getResource("path")' which just retrieves the resource at "path" as an InputStream.
 - An InputStream Is simplt an object representing a file we are reading.
 - ImageIO.read(inputStream) 0 Reads an image at specific inputStream.