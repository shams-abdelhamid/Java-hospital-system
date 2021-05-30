

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author User
 */
public class StaffLogin extends JFrame implements Serializable
{
    JTextField ID = new JTextField("DOC/");
    JPasswordField Password = new JPasswordField();
    JLabel checkfound = new JLabel();
    JLabel checkpass = new JLabel();
    protected String getpass;
    StaffLogin()
    {
        setTitle("Please Log-in");
        setSize(400, 550);
        
        
        ID.setBounds(100, 100, 250, 30);
        
         JLabel IDlabel =new JLabel("ID");
//        IDlabel.setLabelFor(ID);
        IDlabel.setBounds(30, 100,50,30);
        
       
        Password.setBounds(100, 150, 250, 30);
        checkfound.setBounds(100, 255, 220, 30);
        checkpass.setBounds(100, 305, 220, 30);
        
        JLabel Passwordlabel =new JLabel("Password");
//        IDlabel.setLabelFor(ID);
        Passwordlabel.setBounds(30, 150,90,30);
        
        JButton loginbutton=new JButton("Log-in");
        loginbutton.setBounds(160, 200, 80, 50);
        loginbutton.addActionListener(new actions());
       
        
        Container container =getContentPane();
        container.setLayout(null);
        container.add(ID);
        container.add(IDlabel);
        container.add(Password);
        container.add(Passwordlabel);
        container.add(loginbutton);
        container.add(checkfound);
        container.add(checkpass);

        
       
            
        }
         private class actions implements ActionListener
        {

        @Override
        public void actionPerformed(ActionEvent ae)  
        {
            checkfound.setText(null);
            checkpass.setText(null);
            
            

            File myfile = new File( "D:/applicants.bin");
            

              
               
                  ObjectInputStream  in = null;
           try {
               in = new ObjectInputStream(new FileInputStream ("D:/applicants.bin" ));
           } catch (IOException ex) {
               Logger.getLogger(PatientFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
         
       ArrayList<Doctor> readdoctors=new ArrayList<Doctor>();
       
           
            try {
                readdoctors=( ArrayList<Doctor> )in.readObject();
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
            
//                Scanner scan =new Scanner(myfile);
              String logread=ID.getText();
              boolean found =false;
         for(Doctor y : readdoctors)
      {
                if(logread.equals(y.ID))
                {
                    found=true;
                    logread =Password.getText();
                    if(logread.equals(y.password))
                    {
                        DoctorForm doctorform=new DoctorForm(y.name);
                        doctorform.setVisible(true);
                        dispose();
                        break;
                    }
                    else
                    {
//                        checkpass.setText("Wrong Password"); 
                         JOptionPane.showMessageDialog(checkpass, "       Wrong Password", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
               
              
            

        }
                    if(found==false)
                    {
                        JOptionPane.showMessageDialog(checkpass, "             ID not found", "Error", JOptionPane.WARNING_MESSAGE);
                    }

        
    }
   
        }
         }
