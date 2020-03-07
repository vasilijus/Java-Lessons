# Hierarchy

```
Public interface GameObject {
    // Called every frame ( every time physically possible).
    public void render ( RenderHandler renderer , int zoomX , int zoomY );

    // Called 60 fps ( constant rate )
    public void update ( Game game );

}
```

In interface you dont need to add a body, 
every method is defined in any place where the interface is implemented.

```
// Field in Game.java
GameObject [] objects;

// In constructor...
objects = new GameObject [numObjects]

// In render() ...
for ( int index = 0 ; index < objects.length; index++ ) {
    objects[index].render(...);
}
```

# Key Listener !!!