// Oasis Java Internship
// Jaydeep Ulhas Dongale

// Task 4 - Online Exam System


import java.awt.event.*;
import javax.swing.*;

class Exam extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton[] jb =new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0;
    int current=0;

    Exam(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Result");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b2.setEnabled(false);
        add(b1);
        add(b2);
        set();
        l.setBounds(130,40,450,20);
        jb[0].setBounds(180,80,200,20);
        jb[1].setBounds(180,110,200,20);
        jb[2].setBounds(180,140,200,20);
        jb[3].setBounds(180,170,200,20);
        b1.setBounds(120,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setSize(600,450);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==4)
            {
                b1.setEnabled(false);
                b2.setEnabled(true);
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
            {
                count=count+1;
            }
            current++;

            JOptionPane.showMessageDialog(this,"Correct Answers = "+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Q.1) : Java is which type of language ?");
            jb[0].setText("Procedural");jb[1].setText("Object-oriented");jb[2].setText("Scripting");jb[3].setText("All of the above mentioned");
        }
        if(current==1)
        {
            l.setText("Q.2) : Which class is a parent class of all the classes present in java ?");
            jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
        }
        if(current==2)
        {
            l.setText("Q.3) : Which package is directly available to our class without importing it in java ?");
            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("lang");jb[3].setText("net");
        }
        if(current==3)
        {
            l.setText("Q.4) :Is Java supports multiple inheritance ?");
            jb[0].setText("yes");jb[1].setText("no");jb[2].setText("can't say");jb[3].setText("other");
        }
        if(current==4)
        {
            l.setText("Q.5) : Which one among these is not a keyword ?");
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("if");jb[3].setText("get");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[1].isSelected());
        if(current==1)
            return(jb[2].isSelected());
        if(current==2)
            return(jb[2].isSelected());
        if(current==3)
            return(jb[1].isSelected());
        if(current==4)
            return(jb[3].isSelected());
        return false;
    }

    public static void main(String[] args)
    {
        new Exam("Java Online Exam");
    }


}