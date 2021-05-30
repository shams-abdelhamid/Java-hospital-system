/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class AdminRegisterFrame extends JFrame
{
     private JLabel namelb,agelb,phonelb,yearslb, passlb;
    private JTextField nametf,agetf,phonetf;
    private JComboBox yearsexp;
    private JButton regbutton;
    private JPasswordField pass;
         ArrayList<Admin> Adminlist= new ArrayList<Admin> ();

    
    public AdminRegisterFrame()
    {
         setSize(400,400);
         
         Container con = getContentPane();
         con.setLayout(null);
         
         namelb=new JLabel("Enter name :");
         namelb.setBounds(35, 50, 120, 30);
         con.add(namelb);
         
         nametf=new JTextField();
         nametf.setBounds(160, 50, 150, 30);
         con.add(nametf);
         
         agelb=new JLabel("Enter age : ");
         agelb.setBounds(35, 85, 120, 30);
         con.add(agelb);
         
         agetf=new JTextField();
         agetf.setBounds(160, 85, 150, 30);
         con.add(agetf);

         phonelb=new JLabel("Enter phone number :");
         phonelb.setBounds(35, 120, 160, 30);
         con.add(phonelb);
         
         phonetf=new JTextField();
         phonetf.setBounds(160, 120, 150, 30);
         con.add(phonetf);

         yearslb=new JLabel(" Years of experience :");
         yearslb.setBounds(35, 155, 180, 30);
         con.add(yearslb);

         yearsexp=new JComboBox();
         yearsexp.setBounds(165, 155, 95, 30);
         yearsexp.addItem("Unspecified");
         yearsexp.addItem("1+ ");
         yearsexp.addItem("3+ ");
         yearsexp.addItem("5+");
         yearsexp.addItem("7+");
         yearsexp.setSelectedItem("Unspecified");
         con.add(yearsexp);
         
          passlb = new JLabel("Password :");
          pass = new JPasswordField();
         passlb.setBounds(35,200,150,30);
         pass.setBounds(160,200,150,30);
         con.add(pass);
         con.add(passlb);
         
         regbutton=new JButton("Register");
         regbutton.setBounds(150, 250, 100, 40);
         con.add(regbutton);
         regbutton.addActionListener(new AdminRegisterFrame.ButtonWatcher());

    }
      private class ButtonWatcher implements ActionListener

    {
         Admin ref(Admin x,ArrayList<Admin> y)
            {
                if(y.contains(x))
                {
                    x=new Admin();
                    return ref(x,y);
                }
                else
                {
                    return x;
                }
                
            }
        boolean isDig(JTextField o)
        {
            String check = o.getText();
            for(int i = 0; i < check.length(); i++)
            {
                if(!Character.isDigit(check.charAt(i)))
                    return false;
            }
            return true;
        }
        
       
        
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
            
            if(nametf.getText().equals("") || agetf.getText().equals("") ||  phonetf.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill all empty textfields.", "Error",JOptionPane.ERROR_MESSAGE);
               
            }
            
            else if (isDig(nametf))
            {
                     JOptionPane.showMessageDialog(null, "Rewrite name.", "Error",JOptionPane.ERROR_MESSAGE);
                     
            }
            
           else if(!isDig(agetf) || parseInt(agetf.getText()) < 21 || parseInt(agetf.getText()) > 65)
            {
                    JOptionPane.showMessageDialog(null, "Invalid age!", "Error",JOptionPane.ERROR_MESSAGE);
                   
            }
          
           else if (phonetf.getText().length() != 11 || !isDig(phonetf))
            {
                 JOptionPane.showMessageDialog(null, "Invalid Phone Number", "Error",JOptionPane.ERROR_MESSAGE); 
                    
            }
           else if(pass.getText().length()<8)
           {
                JOptionPane.showMessageDialog(null, "Password must be more than 8 characters", "Error",JOptionPane.ERROR_MESSAGE); 
           }
  
                
            else
            {
                
                    Admin d=new Admin();
              Admin x=  ref(d,Adminlist);
         
             x.name=nametf.getText();
             x.age=parseInt(agetf.getText());
            
    
                try {
                    x.ID=generateid();
                } catch (IOException ex) {
                    Logger.getLogger(AdminRegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminRegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
             x.password = pass.getText();
             JOptionPane.showMessageDialog(null, "Admin registered with ID : "+ x.ID);
             
             Adminlist.add(x);
             
            try {
                writebin(Adminlist);
            } catch (IOException ex) {
                Logger.getLogger(AdminRegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
         public void writebin(ArrayList<Admin> x) throws FileNotFoundException, IOException
    {
        
        
         ObjectOutputStream write;
 write = new ObjectOutputStream ( new FileOutputStream("D:/Adminz.bin"));
 
     write.writeObject(x);

             write.close();
        
    }
         public String generateid() throws FileNotFoundException, IOException, ClassNotFoundException
       {
           String id="AD/";
          Random rand=new Random();
          int generated;
          
          for(int i=0;i<4;i++)
          {
              generated=rand.nextInt(10);
              id+=generated;
          }
        return id;
       }
        
    }
    
      
}
