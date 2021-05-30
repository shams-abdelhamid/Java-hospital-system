/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author User
 */
public class ReceptionistLogin extends JFrame implements Serializable
{
    JTextField ReceptionistID=new JTextField("REC/");
    JPasswordField ReceptionistPass=new JPasswordField();
    JLabel msglabel1=new JLabel();
    JLabel msglabel2=new JLabel();
    ReceptionistLogin()
    {
     setTitle("Start");
        setSize(500, 300);
        Container container =getContentPane();
        container.setLayout(null);
        
        ReceptionistID.setBounds(200, 60, 120, 20);
        container.add(ReceptionistID);
        
        ReceptionistPass.setBounds(200, 90, 120, 20);
        container.add(ReceptionistPass);
        
        JLabel idlabel=new JLabel("Receptionist ID :");
        idlabel.setBounds(30, 60, 150, 20);
        container.add(idlabel);
        
        JLabel Passlabel=new JLabel("Receptionist Password :");
        Passlabel.setBounds(30, 90, 150, 20);
        container.add(Passlabel);
        
        JButton startbutton=new JButton("Start");
        startbutton.addActionListener(new ReceptionistLogin.login());
        startbutton.setBounds(80, 130, 120, 25);
        container.add(startbutton);
    }
    
     private class login implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            FileInputStream r= null;
            try {
                String id= ReceptionistID.getText();
                String pass= ReceptionistPass.getText();
                File file= new File("D:/Receptionistz.bin");
                 r = new FileInputStream(file);
                ObjectInputStream rb=new ObjectInputStream(r);
                ArrayList<Receptionist> y=new ArrayList<Receptionist>();
                
                y=(ArrayList)rb.readObject();
                System.out.println(y.get(0).name);
                System.out.println("ehh");
                boolean found=false;
                for(int i=0;i<y.size();i++)
                {
                    System.out.println(y.get(i).ID);
                    if(y.get(i).ID.equals(id))
                    {
                        found=true;
                        if(y.get(i).password.equals(pass))
                        {
                             MainForm a=new MainForm();
                             a.setVisible(true);
                            break;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(msglabel2, "       Wrong Password", "Error", JOptionPane.WARNING_MESSAGE);
                            break;

                        }
                    }
                    else
                        found=false;
//                    
                }
               
                if(found==false)
                {
                                     JOptionPane.showMessageDialog(msglabel1,"             ID not found", "Error", JOptionPane.WARNING_MESSAGE);

                }
              

                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReceptionistLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReceptionistLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReceptionistLogin.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    r.close();
                } catch (IOException ex) {
                    Logger.getLogger(ReceptionistLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
    }
    
    }