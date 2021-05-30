/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.*;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author lenovo
 */
public class PatientRegister extends JFrame {
       private JLabel namelb,agelb,phonelb,genderlb,datelb;
    private JTextField nametf,agetf,phonetf;
    private JRadioButton male;
    private JRadioButton female;
    private JButton Submitbut;
    private JComboBox day,month,year;
      ArrayList<Patient> patientslist=new ArrayList<Patient>();
            ArrayList<Patient> y=new ArrayList<Patient>();

    
     
   PatientRegister()
   {
       setSize(500,500);
      
    Container con=getContentPane();
    con.setLayout(null);
        namelb = new JLabel("Enter name :");
         namelb.setBounds(35, 130, 120, 30);
        
         
         nametf=new JTextField();
         nametf.setBounds(160, 130, 150, 30);
         
          agelb=new JLabel("Enter age : ");
         agelb.setBounds(35, 175, 120, 30);
        
         
         agetf=new JTextField();
        agetf.setBounds(160, 175, 150, 30);         
         
         genderlb = new JLabel("Enter gender: ");
         genderlb.setBounds(35, 220, 160, 30);
         
       
     
          female = new JRadioButton("female");
          male = new JRadioButton("male",true);
          
          male.setBounds(160, 220, 100, 30);
          female.setBounds(270,220,100,30);
          
          ButtonGroup gendergroup = new ButtonGroup();
          
         gendergroup.add(male);
         gendergroup.add(female);
                  
         phonelb=new JLabel("Enter phone number :");
         phonelb.setBounds(35, 265, 160, 30);
         
         
         phonetf=new JTextField();
         phonetf.setBounds(160, 265, 150, 30);
         
           datelb=new JLabel("Enter entry Date : ");
         
         datelb.setBounds(35, 310, 200, 30);
        
         day=new JComboBox ();
         month=new JComboBox();
         year=new JComboBox();
         for(int i=1;i<=31;i++)
         {
             
             
             day.addItem(i);
             
          
             
         }
         
         for(int i=1 ;i<=12;i++)
         {
             
             month.addItem(i);
             
         }
         
         
         for(int i=2019;i>=2010;i--)
         {
             
             year.addItem(i);
             
             
         }
        
 
         
        
         Submitbut =new JButton("Submit");
         
         Submitbut.setBounds(180, 400, 100, 35);
         
         day.setBounds(30,350,70,30);
         month.setBounds(120,350,70,30);
         year.setBounds(210,350,70,30);
         
         con.add(namelb);
         con.add(nametf);
         con.add(agelb);
         con.add(agetf);
         con.add(phonelb);
         con.add(phonetf);
         con.add(genderlb);
         con.add(male);
         con.add(female);
         con.add(Submitbut);
         con.add(datelb);
         con.add(day);
         con.add(month);
         con.add(year);
         Submitbut.addActionListener(new SubmitWatcher());
         
         
       
       
   }
    
    
    private class SubmitWatcher implements ActionListener

    {
        
        
    
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
        
       
            String selectedgender()
            {
                
            
                if(male.isSelected())
                return male.getText();
                else 
               return female.getText();

                
            }
            
            Patient ref(Patient x,ArrayList<Patient> y)
            {
                if(y.contains(x))
                {
                    x=new Patient();
                    return ref(x,y);
                }
                else
                {
                    return x;
                }
                
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
            
           else if(!isDig(agetf))
            {
                    JOptionPane.showMessageDialog(null, "Invalid age!", "Error",JOptionPane.ERROR_MESSAGE);
                   
            }
              
         
            
           else if (phonetf.getText().length() != 11 || !isDig(phonetf))
            {
                 JOptionPane.showMessageDialog(null, "Invalid Phone Number", "Error",JOptionPane.ERROR_MESSAGE); 
                    
            }
  
   else
            {
              
               
                try {
                   y= readpatient(patientslist);
                } catch (IOException ex) {
                    Logger.getLogger(PatientRegister.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PatientRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            
   
            boolean found =false;
      for(int i=0;i<y.size();i++)
      {
          
          
          if(y.get(i).phone.equals(phonetf.getText()))
          { 
              found=true;
           JOptionPane.showMessageDialog(null, "Patient already registered ", "Error",JOptionPane.ERROR_MESSAGE); 
         
              
              
          }
      }
      
         if(found==false)         
         {                System.out.println("eh");

             Patient p=new Patient();
              Patient x=  ref(p,y);
         
             x.name=nametf.getText();
             x.age=(agetf.getText());
             x.gender=selectedgender();
            x.entrydate=day.getSelectedItem()+" /" +month.getSelectedItem()+"/"+ year.getSelectedItem();
            
            x.phone=phonetf.getText();
          
             JOptionPane.showMessageDialog(null, "Patient registered " );
             
                       
             y.add(x);
              

                try {
                    writepatient(y);
                } catch (IOException ex) {
                    Logger.getLogger(PatientRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
       
        
    }
            }
        }
                public void writepatient(ArrayList<Patient>  x) throws FileNotFoundException, IOException
                {
        
        
                 ObjectOutputStream write;
                 write = new ObjectOutputStream ( new FileOutputStream("D:/patients.bin"));
 
                 write.writeObject(x);

                 write.close();
         
                }
              
                  public ArrayList readpatient(ArrayList<Patient>  x) throws FileNotFoundException, IOException, ClassNotFoundException
               {
                   
        

                   ObjectInputStream  in = null;
          
                 in = new ObjectInputStream(new FileInputStream ("D:/patients.bin" ));
         
                    x=( ArrayList<Patient> )in.readObject();
           
                in.close();
            
                return x;
            
         
                }
       }




               

