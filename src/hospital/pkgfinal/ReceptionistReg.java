/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
public class ReceptionistReg extends JFrame implements Serializable
{
    
     private JLabel namelb,agelb,phonelb, passlb;
    private JTextField nametf,agetf,phonetf;
    private JButton regbutton;
    private JPasswordField pass;
    ArrayList<Receptionist> Receptionistlist= new ArrayList<Receptionist> ();
    
    ReceptionistReg()
    {   setSize(400,400);
         
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
         
         passlb = new JLabel("Password :");
         pass = new JPasswordField();
         passlb.setBounds(35,155,150,30);
         pass.setBounds(160,155,150,30);
         con.add(pass);
         con.add(passlb);
         
         
         regbutton=new JButton("Register");
         regbutton.setBounds(150, 200, 100, 40);
         con.add(regbutton);regbutton.addActionListener(new ReceptionistReg.RegButton());

    }
     private class RegButton implements ActionListener
     {
            Receptionist ref(Receptionist x,ArrayList<Receptionist> y)
            {
                if(y.contains(x))
                {
                    x=new Receptionist();
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
                
                    Receptionist d=new Receptionist();
              Receptionist x=  ref(d,Receptionistlist);
         
             x.name=nametf.getText();
             x.age=parseInt(agetf.getText());
            
    
                try {
                    x.ID=generateid();
                } catch (IOException ex) {
                    Logger.getLogger(ReceptionistReg.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ReceptionistReg.class.getName()).log(Level.SEVERE, null, ex);
                }
             x.password = pass.getText();
             JOptionPane.showMessageDialog(null, "Receptionist registered with ID : "+ x.ID);
             
             Receptionistlist.add(x);
             
            try {
                writebin(Receptionistlist);
            } catch (IOException ex) {
                Logger.getLogger(ReceptionistReg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
         public void writebin(ArrayList<Receptionist> x) throws FileNotFoundException, IOException
    {
        
        
         ObjectOutputStream write;
 write = new ObjectOutputStream ( new FileOutputStream("D:/Receptionistz.bin"));
 
     write.writeObject(x);

             write.close();
        
    }
         public String generateid() throws FileNotFoundException, IOException, ClassNotFoundException
       {
           String id="REC/";
          Random rand=new Random();
          int generated;
//          
          for(int i=0;i<4;i++)
          {
              generated=rand.nextInt(10);
              id+=generated;
          }
          return id;
       }
     }
}