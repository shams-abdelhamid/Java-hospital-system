/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class AdminFrame extends JFrame
{

    AdminFrame()  
    {
        setSize(400, 400);
        setTitle("Admin Page");
        
        Container container=getContentPane();
        container.setLayout(null);
        
        JButton registerbutton =new JButton("Register Staff");
        registerbutton.addActionListener(new openregframe());
        registerbutton.setBounds(240, 320, 130, 20);
        container.add(registerbutton);
        
        JButton serverbut =new JButton("Activate Server");
        serverbut.setBounds(100, 320, 130, 20);
        container.add(serverbut);
    }
    
    private class openregframe implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
             docregisterframe dg=new docregisterframe();
             dg.setVisible(true);
        }
        
    }
}
