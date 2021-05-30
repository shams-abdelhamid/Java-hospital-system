/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JFrame;

public class feedback extends JFrame {

    private JButton back = new JButton("back");
    private JButton submit = new JButton("Submit");
    private JTextArea txt = new JTextArea();
    private JLabel p = new JLabel("Write your feedback!");

    public feedback() {
        setSize(500, 500);
        setTitle("Feedback");
        Container cp = getContentPane();
        cp.setLayout(null);
        cp.add(submit);
        cp.add(back);
        cp.add(txt);
        cp.add(p);
        back.setBounds(10, 10, 100, 25);
        p.setBounds(90, 10, 300, 120);
        submit.setBounds(180, 400, 100, 25);
        txt.setBounds(70, 90, 320, 290);
        
        action object=new action();
        submit.addActionListener(object);
        back.addActionListener(object);
        
        
    }

    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String words = txt.getText();
           //FILE
            ObjectOutputStream Bin = null;
            try {
                Bin = new ObjectOutputStream(new FileOutputStream("d:\\feedbacks.bin"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(feedback.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(feedback.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Bin.writeObject(words);
            } catch (IOException ex) {
                Logger.getLogger(feedback.class.getName()).log(Level.SEVERE, null, ex);
            }

            //MESSAGE
            MainForm mf=new MainForm();
            Object ButtonPressed=ae.getSource();
            if (ButtonPressed==submit){
            JOptionPane.showMessageDialog(null, "Your feedback is submitted succesfully!");
            }
            else if (ButtonPressed==back){
            mf.setVisible(true);
            }
        }

    }
}