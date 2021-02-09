import java.awt.Dialog;
import javax.swing.JDialog;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.KeyStroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//i might of been doing this wrong but look for  "Key listener" on oracle's website

public class AutoClickerNEWV2{

public static int fast = 0;
public static int times = 0;

/*class MKeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent event) {
 
  char ch = event.getKeyChar();
 
  if (ch == 'a' ||ch == 'b'||ch == 'c' ) {
 
System.out.println("it works");
 
  }
    }
}*/

public static void main (String[] args) 
   throws InterruptedException {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLabel emptyLabel = new JLabel();
      frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);


String HowFast = "Real fast";
String Times = "None";
while(fast == 0){


          HowFast = (String)JOptionPane.showInputDialog(
                    frame,
                    "How fast does this need to be?\n(In miliseconds- 1 second == 1000 miliseconds)",
                    "How Fast?",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "5");


   try{
   fast = Integer.parseInt(HowFast);
   }
   catch(NumberFormatException ex){
   System.exit(0);
   continue;
   }
   
   
            Times = (String)JOptionPane.showInputDialog(
                    frame,
                    "How many times?",
                    "Click how many times?",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "1000");


   try{
   times = Integer.parseInt(Times);
   }
   catch(NumberFormatException ex){
   System.exit(0);
   }
   
   int Howlongsec = ((fast * times) / 1000);
   int Howlongmin = Howlongsec / 60;
   
   JOptionPane.showMessageDialog(frame,"This will take... " + Howlongsec + " seconds to complete\n (In Minutes..." + Howlongmin + ")" , "",JOptionPane.PLAIN_MESSAGE);
   
   JOptionPane.showMessageDialog(frame,"Starting in 3 seconds...", "",JOptionPane.PLAIN_MESSAGE);
   System.out.println("3");
   Thread.sleep(1000);
   System.out.println("2");
   Thread.sleep(1000);
   System.out.println("1");
   Thread.sleep(1000);
   System.out.println("GO!");
   
   try {
      Robot robot = new Robot();
      while (times != 0) {
         try{
             Thread.sleep(fast);
             robot.mousePress(InputEvent.BUTTON1_MASK);
             robot.mouseRelease(InputEvent.BUTTON1_MASK);
             } 
             catch(InterruptedException ex){
             //Nothing
             }
             times = times -1;
             //System.out.println(times);
         } 
      }
    catch(AWTException e){
    //Nothing?
    }
}
   
   System.out.println("Done.");
   System.exit(0);

}



}