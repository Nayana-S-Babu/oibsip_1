import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Numguess extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField t1;
    JButton b1;
    Random rand=new Random();
    int rnd_no,i=5;
    Numguess()
    {
        super("Number guessing game");
        setSize(800,400);
        setLayout(new GridLayout(10,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1=new JLabel("I have a number between 1 and 100. Can you guess it?");
        l3=new JLabel("You have 5 chances");
        l2=new JLabel();
        l1.setFont(new Font("Cambria",Font.PLAIN,20));
        l2.setFont(new Font("Cambria",Font.HANGING_BASELINE,18));
        l3.setFont(new Font("Cambria",Font.PLAIN,19));
        t1=new JTextField();
        b1=new JButton("Check");
        add(l1);
        add(l3);
        add(t1);
        add(b1);
        add(l2);
        setLocationRelativeTo(null);
        setVisible(true);
        rnd_no=rand.nextInt(100)+1;
        b1.addActionListener(this);
    }
    public void actionPerformed (ActionEvent e)
    {
      String user_ip=t1.getText();
      try{
       int user_int=Integer.parseInt(user_ip);
      if(rnd_no==user_int)
      {
        l2.setText("Congratulations! You got it!!");
        b1.setEnabled(false);
      }
      else if(rnd_no>user_int)
      {
        l2.setText("Your number is less than my number. "+(i-1)+" more chances left.");
      }
      else
      {
        l2.setText("Your number is greater than my number. "+(i-1)+" more chances left.");
      }
      i--;
    
    if(i==0 && rnd_no!=user_int)
    {
    l2.setText("Your attempts finished! The number was "+rnd_no);
    b1.setEnabled(false);
    }
    }
    catch(NumberFormatException ex)
    {
      l2.setText("Please enter a valid integer!");
      i--;
      if(i==0){
        l2.setText("Your attempts finished! The number was "+rnd_no);
        b1.setEnabled(false);
      }
    }
  }

}

class Demo
{
    public static void main(String args[])
    {
        
        Numguess ng=new Numguess();
    }
}
