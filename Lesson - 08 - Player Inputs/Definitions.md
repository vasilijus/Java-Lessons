# Tiles and maps

 - While the Sprite class deals with the 'graphics' of the image, the Tiles class deals with the 'placement' of those sprites.
 - For this nex class we will be using something new called a 'Structure', better know as 'Struct'.

```
Public class ParticleJandler {
    public void createParticle() {
        new Particle().create();
    }
    // Our Particle Struct
    class Particle {
        public void create() {
            // Create a particle 
        }
    }
}
```


# Scanner
// To scan files / console inputs

 - We will also use a Scanner to read lines of a text file.
```
File textFile = new File("textFile.txt");
Scanner textScanner = new Scanner(textFile);

while(textScanner.hasNextLine() ) {
    System.our.println"( scanner.nextLine() );
}
```

