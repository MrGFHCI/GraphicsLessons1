/*from ht/*tp://stackoverflow.com/questions/21206484/2d-sidescroller-moving-background-in-java

within character class:

if (speedX < 0) {
            centerX += speedX;
        }
        if (speedX == 0 || speedX < 0) {
            bg1.setSpeedX(0);
            bg2.setSpeedX(0);

        }
        if (centerX <= 350 && speedX > 0) {
            centerX = centerX + speedX ;
        }
        if (speedX > 0 && centerX > 350) {
            bg1.setSpeedX(-MOVESPEED / 4);
            bg2.setSpeedX(-MOVESPEED / 4);
        }

within tile class:
        
speedX = bg.getSpeedX() * 3;
            tileX = tileX + speedX - 4;
            
            key listener:
            case 
               KeyEvent.VK_LEFT:
               character.moveLeft();
               character.setMovingLeft(true);
               break; 
               
               
               another site:
               To maintain the perception of scrolling in a 2D game:

Define a pair of coordinates (scrollX, scrollY) that store the current scroll position of the top left of the screen.
You can update scrollX and ScrollY whenever you want to scroll (e.g. following the player)
Give each sprite a co-ordinate (spriteX, spriteY) that is relative to the game world (i.e. the game background) and not relative to the screen position. Then you don't need to change these numbers when you scroll....
Then you need to draw the background at screen position (-scrollX, -scrollY) and each sprite at (spriteX-scrollX, spriteY-scrollY).
Java should take care of the screen clipping for you. But if your game world and background is large, then you may need some additional techniques to avoid the overhead of trying to draw offscreen objects (this would be called "view frustrum culling" in game development lingo)
               


From http://fivedots.coe.psu.ac.th/~ad/jg/ch062/ch6-2.pdf

if ((xImHead > 0) && (xImHead < pWidth)) {
 // draw im tail at (0,0) and im head at (xImHead,0)
 draw(g, im, 0, xImHead, width-xImHead, width); // im tail
 draw(g, im, xImHead, pWidth, 0, pWidth-xImHead); // im head
 }

This technique redraws the same image, but draws it twice - one the head and the other the tail.

An OK video: http://www.yourepeat.com/watch/?v=zCRgJAHWEYA

               */