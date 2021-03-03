// java Program to create a simple JPanel add components to it 

import javax.swing.*; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class DrivePanel extends JFrame { 
  
    // JFrame 
    static JFrame f;  
    static JLabel l; 
    static JPanel p;
    int[] xArray;
    int[] yArray;

    DrivePanel(int[] x, int[] y){
        this.xArray = new int[x.length];
        this.yArray = new int[y.length];
        this.xArray= x.clone();
        this.yArray = y.clone();

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        this.setTitle("Assignment 3");
        this.setSize(600, 600);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }

    public void paint(Graphics gp) { super.paint(gp); Graphics2D graphics = (Graphics2D) gp;
        for(int i=1; i < this.xArray.length; ++i){
           Line2D line = new Line2D.Float(this.xArray[i-1],(this.getHeight()-this.yArray[i-1]), this.xArray[i], (this.getHeight()-this.yArray[i]));
           
           graphics.draw(line);
           graphics.drawString("("+xArray[i]+" , "+yArray[i]+")",  this.xArray[i]+10, (this.getHeight()-this.yArray[i]));

        }
     }


    
} 