# breakout-tc
 Remake of the [breakout game (1978) Atari 2600](https://www.youtube.com/watch?v=Cr6z3AyhRr8) built with java using the [@TotalCross](https://github.com/TotalCross/) framework as the final project of the MAMI (mathematics applied to multimedia).
 
 And thanks to [@fabio](https://github.com/flsobral) for helping me to understand how the framework works and especially for guiding me on the best object-oriented practices
 
 ## Info:
* Name and registration: Vaneska Sousa, 476389;
* Course and Institution: [System and digital midia](https://smd.ufc.br/pt/sobre-o-curso/) na Federal University of Ceará;
* Subject: MAMI - Mathematics Applied to Multimedia, 2020.1;

![](https://i.imgur.com/RvkxEo5.gif)

## How to run
- `git clone https://github.com/TotalCross/totalcross-embedded-samples/` or download the .zip by clicking the green "Code" button next to repo name and choosing "Download ZIP".
- If you downloaded .zip file, uncompress it in a folder and open it.
- If you are using Linux, run `code <totalcross-embedded-samples>` or open VS Code and Click in "File > Open..." and select totalcross-embedded-samples in the file dialog that will be shown.
- Look for its `RunBreakoutApplication.java` and right-click.
- Choose the "Run" option in the popup.
- And play :smiley:

## Mechanical
Below are the mechanics implemented in this remake: 

1. The game starts on a splash screen, and when clicked on the start button it changes to the game screen
1. To start the game for the first time or restart after the ball falls, just double-click on the screen;
1. The platform moves to the right and left according to user commands (with two console buttons);
1. When the ends of the platform touch the ends of the screen there is a collision, preventing the platform from leaving the screen;
1. The ball moves from the center of the screen downwards with vertical and horizontal oscillatory movements;
1. The ball collides with the ends of the screen, changing its direction;
1. The ball changes direction according to the location of the collision with the platform;
1. The game ends if the ball falls, that is, it reaches the place where the platform should be;
1. When the ball collides with the block it disappears from the screen;
1. When breaking all the blocks on the screen, the ball changes speed and returns the same number of blocks;
1. When you break all the blocks for the first time the speed of the ball increases and the blocks are placed back on the screen;
1. When breaking all blocks for the second time the game continues even without blocks on the screen, being finished;       

## Project Struture:

<pre> GameTC
 |- RunBreakoutApplication.java //starts the totalcross application with the desired screen size
 |- Breakout.java // Add all sprites in the screen and controls what the player see. 
 |- ui // User interface 
    |- InitialScreen.java
 |- sprites // All sprites are built here as well as the behavior of each one
    |- Brick.java
    |- Paddle.java
    |- Ball.java
    |- Stage.java 
// Brick sprites that are children of bricks, here is basically change the sprite image. 
    |- BlueBrick.java 
    |- GreenBrick.java
    |- OrageBrick.java
    |- YellowBrick.java
    |- DarkOrageBrick.java
    |- GreenBrick.java
 |- util // All constants, colors and images used in the construction of the game are placed here in order to facilitate the maintenance of the code.
    |- Constants.java 
    |- Colors.java
    |- Images.java
</pre>

## Social media:
* [Instagram](https://www.instagram.com/vaneska.sousa20/);
* [Linkedin](https://www.linkedin.com/in/vaneska-sousa);
* [Medium](https://medium.com/@vaneskakaren15).
