/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_2.pkg3;

/**
 *
 * @author PC
 */
public class Rectangle {
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

/**
 * Create a new rectangle at default position with default color.
 */
    public Rectangle()
    {
        height = 20;
        width = 10;
        xPosition = 310;
        yPosition = 120;
        color = "red";
        isVisible = false;
    }

/**
 * Make this rectangle visible. If it was already visible, do nothing.
 */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

/**
 * Make this rectangle invisible. If it was already invisible, do nothing.
 */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

/**
 * Move the rectangle a few pixels to the right.
 */
    public void moveRight()
    {
        moveHorizontal(20);
    }

/**
 * Move the rectangle a few pixels to the left.
 */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

/**
 * Move the rectangle a few pixels up.
 */
    public void moveUp()
    {
        moveVertical(-20);
    }

/**
 * Move the rectangle a few pixels down.
 */
    public void moveDown()
    {
        moveVertical(20);
    }

/**
 * Move the rectangle horizontally by 'distance' pixels.
 */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

/**
 * Move the rectangle vertically by 'distance' pixels.
 */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

/**
 * Slowly move the rectangle horizontally by 'distance' pixels.
 */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
    {
            delta = -1;
            distance = -distance;
    }
        else 
    {
            delta = 1;
    }

        for(int i = 0; i < distance; i++)
    {
            xPosition += delta;
            draw();
    }
}

/**
 * Slowly move the rectangle vertically by 'distance' pixels.
 */
    public void slowMoveVertical(int distance)
{
        int delta;

        if(distance < 0) 
    {
            delta = -1;
            distance = -distance;
    }
        else 
    {
            delta = 1;
    }

        for(int i = 0; i < distance; i++)
    {
            yPosition += delta;
            draw();
    }
}

/**
 * Change the size to the new size (in pixels). Size must be >= 0.
 */
    public void changeSize(int newWidth, int newHeight)
{
        erase();
        height = newHeight;
        width = newWidth;
        draw();
}

/**
 * Change the color. Valid colors are "red", "yellow", "blue", "green",
 * "magenta" and "black".
 */
    public void changeColor(String newColor)
{
        color = newColor;
        draw();
}

/**
 * Draw the rectangle with current specifications on screen.
 */
   private void draw()
{
    if(isVisible) 
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.drawRect(color, this.xPosition, this.yPosition, this.width, this.height); 
        canvas.wait(10);
    }
}

/**
 * Erase the rectangle on screen.
 */
    private void erase()
{
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
    }
}

}
