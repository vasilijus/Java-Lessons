
            # Threads
     
     - Simply put , a thread is an 'executor' of code 
     - Having multiple threads means you have two 'executors' that are 'concurrently' reading lines of code in order
     - Every program we have made so far has only one Thread.
     - To instantiate a Thread in java you must pass in a type of Runnable. This mans we have to implement Runnable into our game.



            # implement

     - The 'Implement' Call is almost the same as extend except it implements somethins called an interface
     - An interface is almost exactly the  same as an abstract class, except methods are also abstract.

     ```
        Public interface Animal {
            public void eat();
            public void travel();
        }
     ```
     ```
        Public class Dog implements Animal {
            public void eat() {
                // Eat stuff specifically as a dog
            }
            public void travel() {
                // Travel specifically as a dog
            }
        }
     ```

            # Render and Update

     - Computers don't all run at the same speed.
        * Some computers will run the update and render diffrently on diffrent CPU's ....
     - We don't want the speed of our game to change based on what computer you are playing it on.


     - Render() - This method will run as fast as the computer can run it
       - Will render everything to the screen

     - Update() - This method will run at a specific rate.
       - Will update player/NPC movement. Change any variables, etc.

