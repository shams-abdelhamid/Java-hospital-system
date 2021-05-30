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
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author lenovo
 */
public class docregisterframe extends JFrame implements Serializable 
{
    
    
   
    private JLabel namelb,agelb,specialitylb,phonelb,yearslb, passlb;
    private JPasswordField pass ;
    private JTextField nametf,agetf,specialitytf,phonetf;
    private JComboBox yearsexp;
    private JButton regbutton;
      ArrayList<Doctor> doctorslist= new ArrayList<Doctor> ();
           

    
   public docregisterframe()
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
                  
         specialitylb=new JLabel("Enter speciality :");
         specialitylb.setBounds(35, 120, 120, 30);
         con.add(specialitylb);

         specialitytf=new JTextField();
         specialitytf.setBounds(160, 120, 150, 30);
         con.add(specialitytf);

         phonelb=new JLabel("Enter phone number :");
         phonelb.setBounds(35, 155, 160, 30);
         con.add(phonelb);
         
         phonetf=new JTextField();
         phonetf.setBounds(160, 155, 150, 30);
         con.add(phonetf);

         yearslb=new JLabel(" Years of experience :");
         yearslb.setBounds(35, 200, 180, 30);
         con.add(yearslb);

         yearsexp=new JComboBox();
         yearsexp.setBounds(165, 200, 95, 30);
         yearsexp.addItem("Unspecified");
         yearsexp.addItem("1+ ");
         yearsexp.addItem("3+ ");
         yearsexp.addItem("5+");
         yearsexp.addItem("7+");
         yearsexp.setSelectedItem("Unspecified");
         con.add(yearsexp);
         
          passlb = new JLabel("Password :");
          pass = new JPasswordField();
         passlb.setBounds(35,230,150,30);
         pass.setBounds(160,230,150,30);
         con.add(pass);
         con.add(passlb);
         
         regbutton=new JButton("Register");
         regbutton.setBounds(150, 270, 100, 40);
         con.add(regbutton);
         regbutton.addActionListener(new ButtonWatcher());

    }
   
    
    private class ButtonWatcher implements ActionListener

    {
        Doctor ref(Doctor x,ArrayList<Doctor> y)
            {
                if(y.contains(x))
                {
                    x=new Doctor();
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
        
        boolean validation()
        {
            boolean flag=true;
            if(nametf.getText().equals("") || agetf.getText().equals("") || specialitytf.getText().equals("") ||  phonetf.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill all empty textfields.", "Error",JOptionPane.ERROR_MESSAGE);
                flag=false;
            }
                 if(!isDig(agetf) || parseInt(agetf.getText()) < 21 || parseInt(agetf.getText()) > 65)
                {
                    JOptionPane.showMessageDialog(null, "Invalid age!", "Error",JOptionPane.ERROR_MESSAGE);
                    flag=false;
                }
              
                 if (phonetf.getText().length() < 11)
                {
                    JOptionPane.showMessageDialog(null, "Incomplete phone number.", "Error",JOptionPane.ERROR_MESSAGE); 
                    flag=false;
                }
                 if (!isDig(phonetf))
                {
                    JOptionPane.showMessageDialog(null, "Rewrite phone number.", "Error",JOptionPane.ERROR_MESSAGE);
                    flag=false;
                }
                 if (isDig(specialitytf))
                {
                    JOptionPane.showMessageDialog(null, "Rewrite speciality.", "Error",JOptionPane.ERROR_MESSAGE); 
                    flag=false;
                }
                 if (isDig(nametf))
                {
                     JOptionPane.showMessageDialog(null, "Rewrite name.", "Error",JOptionPane.ERROR_MESSAGE);
                     flag=false;
                }
                 return flag;
        }
    
        
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
 
                 
                
         if(validation())
         {
             
             
                   ArrayList<Doctor> y= new ArrayList<Doctor> ();

             
             
        
         
  
                Doctor d=new Doctor();
             try {
                 y=readdoctor(doctorslist);
                 
             } catch (IOException ex) {
                 Logger.getLogger(docregisterframe.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(docregisterframe.class.getName()).log(Level.SEVERE, null, ex);
             }
             
              boolean found =false;
      for(int i=0;i<y.size();i++)
      {
          
          if(y.equals(null)){
             
          }
              System.out.println(y.get(i).PhoneNum);
              System.out.println(phonetf.getText());
          if(y.get(i).PhoneNum.equals(phonetf.getText()))
          { 
              found=true;
           JOptionPane.showMessageDialog(null, "Doctor already registered ", "Error",JOptionPane.ERROR_MESSAGE); 
         
              
              
          }
      }
      
         if(found==false)         
         {                System.out.println("eh");
              Doctor x=  ref(d,doctorslist);
         
             x.name=nametf.getText();
             x.age=(agetf.getText());
             x.spec=specialitytf.getText();
                       try {
                           x.ID=generateid();
                       } catch (IOException ex) {
                           Logger.getLogger(docregisterframe.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (ClassNotFoundException ex) {
                           Logger.getLogger(docregisterframe.class.getName()).log(Level.SEVERE, null, ex);
                       }
             x.PhoneNum=phonetf.getText();
             x.experience=(String) yearsexp.getSelectedItem();
              x.password = pass.getText();
             JOptionPane.showMessageDialog(null, "Doctor registered with ID : "+ x.ID);
           
              
             
             y.add(x);
             
            try {
                writebin(y);
            } catch (IOException ex) {
                Logger.getLogger(docregisterframe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
        
         
            
             
    }
     public void writebin(ArrayList<Doctor>  x) throws FileNotFoundException, IOException
       {
        
        
         ObjectOutputStream write;
         write = new ObjectOutputStream ( new FileOutputStream("D:/applicants.bin"));
 
         write.writeObject(x);
   
             write.close();
        
       }
     
      public ArrayList readdoctor(ArrayList<Doctor>  x) throws FileNotFoundException, IOException, ClassNotFoundException
               {
                   
        

                   ObjectInputStream  in = null;
          
                 in = new ObjectInputStream(new FileInputStream ("D:/applicants.bin" ));
         
                    x=( ArrayList<Doctor> )in.readObject();
           
                in.close();
            
                return x;
     
               }
       public String generateid() throws FileNotFoundException, IOException, ClassNotFoundException
       {
           String id="DOC/";
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