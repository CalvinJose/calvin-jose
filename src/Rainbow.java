// Chapter 6 Question 19
//Calvin Jose
// ________________________________________________

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
  // Declare skyColor:
  Color skyColor = Color.CYAN; //set the skyColor as Cyan

  public Rainbow()
  {
    setBackground(skyColor); //background will be Cyan because set skyColor as Cyan
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();   //width
    int height = getHeight(); //height
    
    // Declare and initialize local int variables xCenter, yCenter
    // that represent the center of the rainbow rings:
    int xCenter=(int)((double)width/2); //creates xCenter Variable
    int yCenter=(int)((double)height*3/4); //creates yCenter Variable
 
    // Declare and initialize the radius of the large semicircle:
    int largeRadius=(int)((double)width/4);
    int smallRadius=(int)((double)height/4);//declared and initialized radius of the small semicircle
    int mediumRadius=(int)(Math.sqrt(largeRadius*smallRadius));//declared and initialized radius of the medium semicircle
    int skyRadius=(int)((double)width/11); //declared and initialized radius of the sky Semicircle
    g.setColor(Color.RED);
    // Draw the large semicircle:
    g.fillArc(xCenter-largeRadius, yCenter-largeRadius, largeRadius*2, largeRadius*2, 0, 180 ); //makes the largest arc 

    // Declare and initialize the radii of the small and medium
    // semicircles and draw them:
    g.setColor(Color.GREEN); //set the color as green
    g.fillArc(xCenter-mediumRadius, yCenter-mediumRadius, mediumRadius*2, mediumRadius*2, 0, 180); //makes the medium arc

    g.setColor(Color.MAGENTA); //set the color as magenta
    g.fillArc(xCenter-smallRadius, yCenter-smallRadius, smallRadius*2, smallRadius*2, 0, 180); //makes the small arc
    
    // Calculate the radius of the innermost (sky-color) semicircle
    // so that the width of the middle (green) ring is the
    // arithmetic mean of the widths of the red and magenta rings:
    g.setColor(skyColor); //set the color as skyColor
    g.fillArc(xCenter-skyRadius, yCenter-skyRadius, skyRadius*2, skyRadius*2, 0, 180); //makes the skyColored arc
    
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
