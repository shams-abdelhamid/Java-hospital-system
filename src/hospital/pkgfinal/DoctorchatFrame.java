/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class DoctorchatFrame extends JFrame {
     private JLabel chatfulltext;
    private JTextField message=new JTextField("Write your note");
    InputStream input;
    OutputStream output;
    Socket portal = null;
    String DoctorName;
    public DoctorchatFrame (String name) throws IOException
    {
        this.DoctorName=name;
        setSize(300,600);
        setTitle("Doctor " + name+" server communication");
        chatfulltext=new JLabel("chat log");
        setLayout(null);
        chatfulltext.setBounds(20,20, 200,250);
        add(chatfulltext);
        JButton sendbutton=new JButton("Send");
        sendbutton.setBounds(20,350,100,50);
        message.setBounds(sendbutton.getBounds().x,sendbutton.getBounds().y+50,100,50);
        add(message);
        sendbutton.addActionListener(new PressSend());
        add(sendbutton);
        
                try {
                    portal = new Socket("192.168.1.105", 6000);
                    input=portal.getInputStream();
                    output=portal.getOutputStream();
                    updategui t=new updategui();
                    t.start();

                } catch (IOException ex) {
                    
                }
                
    }
     private class PressSend implements  ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {System.out.println(message.getText());
            PrintWriter pw=new PrintWriter(output,true);
            pw.println(": "+message.getText());
        }
        
    }
    private class updategui extends Thread
    {
        
        @Override
        public void run()
        {
            while (true)
            {
                
                BufferedReader bf=new BufferedReader(new InputStreamReader(input));
                String Message = null;
                try {
                    Message = bf.readLine();
                    if (Message!=null)
                    {
                    chatfulltext.setText(chatfulltext.getText()+"<br>"+Message);
                    System.out.println("Server says " +Message);
                    
                    }
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    
                }
    
         
            }
        }
        }
}
