
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author lenovo
 */
public class PatientFrame extends JFrame {
    
        private JLabel namelb,phonelb,header,showname,showage,showphone,showgender,showentry;
    private JTextField nametf,phonetf;
    private JButton search;
    
    
    Container cp=new Container();
    PatientFrame()
    {
        
        setSize(500,500);
        
         cp=getContentPane();
        cp.setLayout(null);
        
         
             showname=new JLabel();
             showage=new JLabel();
               showgender=new JLabel();
             showentry=new JLabel ();
             showphone=new JLabel();
             
        
       namelb = new JLabel("Enter name :");
         namelb.setBounds(35, 75, 120, 30);
        
         
         nametf=new JTextField();
         nametf.setBounds(160, 75, 150, 30);
         
            phonelb=new JLabel("Enter phone number :");
         phonelb.setBounds(35, 120, 160, 30);
         
         
         phonetf=new JTextField();
         phonetf.setBounds(160, 120, 150, 30);
         
          search=new JButton(" search");
           search.setBounds(85, 175, 150, 30);
          
           header=new JLabel("Search for a patient");
           header.setBounds(200,20,160,30);
          cp.add(namelb);
          cp.add(nametf);
          cp.add(phonelb);
         cp.add(phonetf);
         cp.add(search);
         cp.add(header);
         search.addActionListener(new Searchwatcher());
         
    }
                  
   


         
         private class Searchwatcher implements ActionListener

    {

             
             
             
        @Override
        public void actionPerformed(ActionEvent ae) {
            
          boolean foundpatient=false;
        int index;
        
         
        
           ObjectInputStream  in = null;
           try {
               in = new ObjectInputStream(new FileInputStream ("D:/patients.bin" ));
           } catch (IOException ex) {
               Logger.getLogger(PatientFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
         
       ArrayList<Patient> readpatients=new ArrayList<Patient>();
       
           
            try {
                readpatients=( ArrayList<Patient> )in.readObject();
            } catch (IOException ex) {
                Logger.getLogger(PatientFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PatientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(PatientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
   
            
      for(Patient i : readpatients)
      {
          
          
          if(i.name.equals(nametf.getText())&& i.phone.equals(phonetf.getText()))
          {                
             
             foundpatient=true;
            
             
             showname.setText(i.name);
             showage.setText(i.age);
             showgender.setText("gender :" +i.gender);
             
            
             showentry.setText("entry date  : " +i.entrydate);
             showphone.setText("phone number : "+i.phone);
             
              showname.setBounds(35, 220, 160, 30);
              showage.setBounds(35,270,160,30);
              showgender.setBounds(35,320,160,30);
              showentry.setBounds(35,370,160,30);
              showphone.setBounds(35,420,200,30);
           
              
              cp.add(showname);
              cp.add(showage);
               cp.add(showgender);
              cp.add(showentry);
              cp.add(showphone);
           
              repaint();
              
             
              
              

             
             
             
          }
             
              
              
      }     
         
      
      
       if(foundpatient==false)
       {
        JOptionPane.showMessageDialog(null, "Patient not found ", "Error",JOptionPane.ERROR_MESSAGE);
              
            
           
           
       }
              
          
          
          

// 
//      for(int i=0;i<readpatients.size();i++)
//      {
//          if(x.name.)
//          {
//              
//          }
//          
//      }
// 
           
           
            
            
            
            
            
        }
         }
}

        
        

        
        
                
            
         
 

       
    
    
        
        
    
    
    
    

