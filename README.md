# breakout-tc
 Remake of the [breakout game (1978) Atari 2600](https://www.youtube.com/watch?v=Cr6z3AyhRr8) built with java using the [@TotalCross](https://github.com/TotalCross/) framework as the final project of the MAMI (mathematics applied to multimedia).
 
 And thanks to [@fabio](https://github.com/flsobral) for helping me to understand how the framework works and especially for guiding me on the best object-oriented practices
 
 ## Info:
* Name and registration: Vaneska Sousa, 476389;
* Course and Institution: [System and digital midia](https://smd.ufc.br/pt/sobre-o-curso/) na Federal University of Ceará;
* Subject: MAMI - Mathematics Applied to Multimedia, 2020.1;

## Mechanical
All mechanics listed below must be represented in the natural, computational and, if needed, a mathematical model.

> The description of the mechanics already corresponds to its natural model, since I had to watch the gameplay several times in addition to using an Atari emulator to be able to describe them.

| Mechanics | Natural Model | Computational Model | Mathematical Model | OBS
|:-:|---|---|---|---|
| The game starts on a screen with the information and when the start button is clicked the interface is changed and the game starts, according to the mechanics bellows| :heavy_check_mark: | :x: | :x: | The inicial screen are finished but the change between the gameinit and the container aren't done yet|
| Platform moves left or right, according to the user's command | :heavy_check_mark: | :heavy_check_mark: | :x: | - |
| When the platform reaches the edge of the screen it collides, never exceeding the screen | :heavy_check_mark: | :heavy_check_mark: | :x: | - |
| The ball moves from the center of the screen in an oscillatory motion starting down | :heavy_check_mark: | :heavy_check_mark: | :x: | - |
| Each time the ball collides with the platform, it returns in the opposite direction | :heavy_check_mark: | :x: | :x: | I'm having difficulty in this part because the direction and direction of the ball changes depending on where the platform collided. |
| Each time the ball hits a “brick” (blue, green, yellow, orange, red) the brick disappears | :heavy_check_mark: | :heavy_check_mark: | :x: | - | - |
| Each time a brick is destroyed, a score is added. This value varies depending on the color of the brick | :heavy_check_mark: | :x: | :x: | - |
| When all the bricks of level 01 are destroyed, new ones appear (in the same position as the previous one) and the speed of the ball increases | :heavy_check_mark: | :x: | :x: | - |
| When all the bricks of level 02 are destroyed, the game continues without any obstacle on the screen. | :x: | :heavy_check_mark: | :x: | - |
| When the ball falls (that is, it reaches the height of the platform without collision), the game restarts. Regardless of the level the user is in, it returns to the initial state (level 01, with zero points). | :heavy_check_mark: | :x: | :x: | - |

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
