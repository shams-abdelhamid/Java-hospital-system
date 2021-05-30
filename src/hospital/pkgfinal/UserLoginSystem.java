/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class UserLoginSystem extends JFrame implements Serializable
{
    JComboBox userChoice = new JComboBox();
    
    UserLoginSystem()
    {
        setTitle("User Login System");
        setSize(500,500);
        Container container=getContentPane();
        container.setLayout(null);
        JLabel user = new JLabel("Login as:");
        user.setBounds(150,150,60,70);
        container.add(user);
        
        userChoice.setBounds(220,170,100,30);
        userChoice.addItem("Admin");
        userChoice.addItem("Doctor");
        userChoice.addItem("Receptionist");
        container.add(userChoice);
        JButton logbutton = new JButton("Login");
        logbutton.setBounds(140,220,100,30);
        container.add(logbutton);
        logbutton.addActionListener(new login());
        JButton signUp = new JButton("Sign Up");
        signUp.setBounds(250,220,100,30);
        container.add(signUp);
        signUp.addActionListener(new signup());
        
    }
    private class signup implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            if (userChoice.getSelectedItem().equals("Admin"))
            {
                AdminRegisterFrame arf = new AdminRegisterFrame();
                arf.setVisible(true);
            }
            else if (userChoice.getSelectedItem().equals("Doctor"))
            {
               JOptionPane.showMessageDialog(null, "Doctors are signed up by admins", "Error",JOptionPane.ERROR_MESSAGE);            }
            else if (userChoice.getSelectedItem().equals("Receptionist"))
            {
                ReceptionistReg r = new ReceptionistReg();
                r.setVisible(true);
            }
           
        }
        
    }
    
     private class login implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (userChoice.getSelectedItem().equals("Admin"))
            {
             AdminLogin a=new AdminLogin();
             a.setVisible(true);
            }
            else if (userChoice.getSelectedItem().equals("Doctor"))
                    {
                        
                     StaffLogin d = new StaffLogin();
                     d.setVisible(true);
                    }
             else if (userChoice.getSelectedItem().equals("Receptionist"))
            {
               ReceptionistLogin m = new ReceptionistLogin();
               m.setVisible(true);
            }
        }
     }
    
}