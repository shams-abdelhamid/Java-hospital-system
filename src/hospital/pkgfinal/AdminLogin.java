
package hospital.pkgfinal;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class AdminLogin extends JFrame
{ 
    
    JTextField AdminID=new JTextField("AD/");
    JPasswordField AdminPass=new JPasswordField();
    JLabel msglabel1=new JLabel();
    JLabel msglabel2=new JLabel();


    
    AdminLogin()
    {
        setTitle("Start");
        setSize(300, 250);
        Container container =getContentPane();
        container.setLayout(null);
        
        AdminID.setBounds(140, 60, 120, 20);
        container.add(AdminID);
        
        AdminPass.setBounds(140, 90, 120, 20);
        container.add(AdminPass);
        
        JLabel idlabel=new JLabel("Admin ID :");
        idlabel.setBounds(30, 60, 120, 20);
        container.add(idlabel);
        
        JLabel Passlabel=new JLabel("Admin Password :");
        Passlabel.setBounds(30, 90, 120, 20);
        container.add(Passlabel);
        
        JButton startbutton=new JButton("Start");
        startbutton.addActionListener(new startengine());
        startbutton.setBounds(80, 130, 120, 25);
        container.add(startbutton);
    }
    
    
    private class startengine implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            FileInputStream r= null;
            try {
                String id= AdminID.getText();
                String pass= AdminPass.getText();
                File file= new File("D:/Adminz.bin");
                 r = new FileInputStream(file);
                ObjectInputStream rb=new ObjectInputStream(r);
                ArrayList<Admin> y=new ArrayList<Admin>();
                
                y=(ArrayList)rb.readObject();
                boolean found=false;
                for(int i=0;i<y.size();i++)
                {
                    
                    if(y.get(i).ID.equals(id))
                    {
                        found=true;
                        if(y.get(i).password.equals(pass))
                        {
                             AdminFrame a=new AdminFrame();
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
                Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    r.close();
                } catch (IOException ex) {
                    Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
    }
}