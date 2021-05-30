/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author User
 */
public class DoctorForm extends JFrame
{
    protected String name;
    protected String spec;
    protected int salary;
    protected String ID;
    protected int age;
    protected String PhoneNum;
    protected boolean paid;
    protected String password;
    DoctorForm(String name)
    {
        this.name=name;
     setTitle("Doctor "+name);
     setSize(600, 500);
     
     JLabel namelabel = new JLabel("Name : ");
     namelabel.setBounds(100, 100, 250, 30);
     
     JLabel idlabel = new JLabel("ID :");
     idlabel.setBounds(100, 100, 250, 30);
     
     JLabel speclabel = new JLabel("Specialty : ");
     speclabel.setBounds(100, 100, 250, 30);
     
     JLabel phonenumlabel = new JLabel("Phone Number : ");
     phonenumlabel.setBounds(100, 100, 250, 30);
     
     JButton chat=new JButton("Communicate with server");
     chat.setBounds(100, 100, 250, 30);
     chat.addActionListener(new openchat());
     
     Container container =getContentPane();
     container.setLayout(null);
//     container.add(namelabel);
//     container.add(idlabel); 
//     container.add(speclabel);
//     container.add(phonenumlabel);
     container.add(chat);

    }
    
    private class openchat implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            try {
                DoctorchatFrame dcf =new DoctorchatFrame(name);
                dcf.setVisible(true);
                dcf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } catch (IOException ex) {
                Logger.getLogger(DoctorForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
