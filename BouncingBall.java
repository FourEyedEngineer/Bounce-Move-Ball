package drawing_basics;

import edu.princeton.cs.introcs.StdDraw;

public class BouncingBall { 
    public static void main(String[] args) {

        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // initial values
        double rx = 0., ry = 0.;     // position
        double vx = 0.015, vy = 0.023;     // velocity
        double radius = 0.05;              // radius

      /*//mouse location 
        double x = StdDraw.mouseX();
        double y = StdDraw.mouseY(); */

        // main animation loop
        while (true)  {
        	
            // bounce off wall according to law of elastic collision
            if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx;
            if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;
           
            if (StdDraw.mousePressed()) {
            	rx = StdDraw.mouseX();
            	ry = StdDraw.mouseY();
            	
            	rx = rx + vx; 
                ry = ry + vy; 
            }
            
            // update position
            rx = rx + vx; 
            ry = ry + vy; 

            // clear the background
            StdDraw.clear(StdDraw.GRAY);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.BLACK); 
            StdDraw.filledCircle(rx, ry, radius); 

            // copy offscreen buffer to onscreen
            StdDraw.show();

            // pause for 20 ms
            StdDraw.pause(20);

        } 
    } 
} 