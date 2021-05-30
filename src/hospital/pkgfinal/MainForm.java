/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.pkgfinal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author User
 */
public class MainForm extends JFrame 
{
    JPanel panel=new JPanel();
    JPanel panel2=new JPanel();
    JPanel panel3=new JPanel();
    JPanel panel4=new JPanel();
    private JLabel header,showname,showage,showphone,showgender,showentry,showamount,namelb,agelb,Genderlb,phonelb,datlb,namelb2,phonelb2,roomlb,namelb3,patentry;
    private JButton search,assign,showbut;
    private JTextField nametf2,phonetf2,roomnums;
    private JTextField nametf3,phonetf3;
    private JTextField nametf,agetf,phonetf,dattf;
    private JComboBox day,month,year;
    private JRadioButton male;
    private JRadioButton female;
    private int[] Age = new int[6];
       ArrayList<Patient> y=new ArrayList<>();
    ArrayList<Room> z=new ArrayList<>();
         ArrayList<Room> Roomslist=new ArrayList<>();
       ArrayList<Room> Roomslist2=new ArrayList<>();

    ArrayList<Patient> patientslist=new ArrayList<>();
    ArrayList<Patient> patientslist2=new ArrayList<>();
    Container container= getContentPane();

    MainForm()
    {
        setTitle("Welcome to MIU Hospital");
        setSize(800, 500);
        showname=new JLabel();
        showage=new JLabel();
        showgender=new JLabel();
        showentry=new JLabel ();
        showphone=new JLabel();
        JButton patreg=new JButton("Register Patient");
        patreg.setBounds(60, 50, 200, 50);
        patreg.setBackground(new Color(0, 190, 210));
        patreg.addActionListener(new clickpatientreg());
        
        JButton patinfo=new JButton("Patient Information");
        patinfo.setBounds(60, 120, 200, 50);
        patinfo.setBackground(new Color(0, 170, 190));
        patinfo.addActionListener(new clickpatientinfo());
        
        JButton checkoutbut=new JButton("Assign Room");
        checkoutbut.setBounds(60, 190, 200, 50);
        checkoutbut.setBackground(new Color(0, 150, 170));
        checkoutbut.addActionListener(new clickassroom());
        
        JButton roominfobut=new JButton("Room Information");
        roominfobut.setBounds(60, 260, 200, 50);
        roominfobut.setBackground(new Color(0, 110, 130));
        roominfobut.addActionListener(new clickroominfo());
        
       
        JButton statistics = new JButton("View Patients Statistics");
        statistics.setBounds(60, 330, 200, 50);
        statistics.setBackground(new Color(0, 90, 110));
        statistics.addActionListener(new statisticsbutton());
        
        female = new JRadioButton("Female");
        male = new JRadioButton("Male",true);
          
        male.setBounds(160, 220, 100, 30);
        female.setBounds(270,220,100,30);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        container.setLayout(null);
        
        container.add(roominfobut);
        container.add(patreg);
        container.add(patinfo);
        container.add(checkoutbut);
        container.add(statistics);
        
         nametf2=new JTextField();
         nametf2.setBounds(160, 130, 150, 30);
         
         phonetf2=new JTextField();
         phonetf2.setBounds(160, 265, 150, 30);
     
        panel.setBounds(300, 30, 450, 400);
        panel.setBackground(new Color(0, 255, 200));
        panel.setLayout(null);
        
        namelb=new JLabel("Enter name :");
        namelb.setBounds(35, 130, 120, 30);
         
        
        
         panel.add(namelb);
         
         
         
         
         nametf=new JTextField();
         nametf.setBounds(160, 130, 150, 30);
         panel.add(nametf2);
         
         agelb=new JLabel("Enter age : ");
         agelb.setBounds(35, 175, 120, 30);
         panel.add(agelb);
         
         agetf=new JTextField();
         agetf.setBounds(160, 175, 150, 30);
         panel.add(agetf);
                  
         Genderlb=new JLabel("Enter Gender :");
         Genderlb.setBounds(35, 220, 120, 30);
         panel.add(Genderlb);


         phonelb=new JLabel("Enter phone number :");
         phonelb.setBounds(35, 265, 160, 30);
         panel.add(phonelb);
         
        phonetf=new JTextField();
        phonetf.setBounds(160, 265, 150, 30);
        panel.add(phonetf2);

         datlb=new JLabel("Enter Date  :");
         datlb.setBounds(35, 300, 180, 30);
         panel.add(datlb);
        
         day=new JComboBox ();
         day.setBounds(150, 300, 60, 30);
         month=new JComboBox();
         month.setBounds(220, 300, 60, 30);
         year=new JComboBox();
         year.setBounds(285, 300, 60, 30);
         for(int i=1;i<=31;i++)
         {
             day.addItem(i);
         }
         panel.add(day);
         for(int i=1 ;i<=12;i++)
         {
             month.addItem(i);
         }
         panel.add(month);
         for(int i=2019;i>=2010;i--)
         {
             year.addItem(i);
         }
         panel.add(year);
         JButton Submitbut =new JButton("Submit");
         Submitbut.setBounds(180, 348, 100, 35);
         panel.add(Submitbut); panel.add(male);
         panel.add(female);
         Submitbut.addActionListener(new SubmitWatcher());
         panel2.setBounds(300, 30, 450, 400);
         panel2.setBackground(new Color(0, 255, 200));
         panel2.setLayout(null);
         
         showname=new JLabel();
         showage=new JLabel();
         showgender=new JLabel();
         showentry=new JLabel ();
         showphone=new JLabel();
         showamount =new JLabel();
         
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
         panel2.add(namelb);
         panel2.add(nametf);
         panel2.add(phonelb);
         panel2.add(phonetf);
         panel2.add(search);
         panel2.add(header);
         search.addActionListener(new Searchwatcher());
         
         panel3.setBounds(300, 30, 450, 400);
         panel3.setBackground(new Color(0, 255, 200));
         panel3.setLayout(null);
         
         nametf3=new JTextField();
         nametf3.setBounds(160, 60, 150, 30);
         
         phonetf3=new JTextField();
         phonetf3.setBounds(160, 110, 150, 30);
         
         namelb2=new JLabel("Enter name :");
         namelb2.setBounds(35, 60, 120, 30);
         
         phonelb2=new JLabel("Enter phone number :");
         phonelb2.setBounds(35, 110, 160, 30);
         
         assign=new JButton("Assign");
         assign.setBounds(150, 160, 160, 30);
         assign.addActionListener(new assignwatcher());
         
        
                
         panel3.add(nametf3);
         panel3.add(phonetf3); panel3.add(namelb2);
         panel3.add(phonelb2);
         panel3.add(assign);
         
         
         
         panel4.setBounds(300, 30, 450, 400);
         panel4.setBackground(new Color(0, 255, 200));
         panel4.setLayout(null);
         showbut=new JButton(" Show room info");
         
         namelb3=new JLabel();
         patentry=new JLabel();
         
         roomnums=new JTextField();
         roomnums.setBounds(160, 60, 150, 30);
         roomlb=new JLabel("Enter Room Number :");
         roomlb.setBounds(35, 60, 120, 30);
         showbut.setBounds(85, 175, 150, 30);
         panel4.add(roomnums);
         panel4.add(roomlb);
         panel4.add(showbut);
         showbut.addActionListener(new showinfo());
         
    }
   
    private class clickpatientreg implements ActionListener
         {
          @Override
          public void actionPerformed(ActionEvent ae) 
          {
              panel.setVisible(true);
              panel2.setVisible(false);
              panel3.setVisible(false);
              panel4.setVisible(false);
              container.add(panel);
              container.repaint();
          }
         }
    
    private class clickpatientinfo implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            panel2.setVisible(true);
            panel.setVisible(false);
            panel3.setVisible(false);
            panel4.setVisible(false);
            container.add(panel2);
            container.repaint();
        }
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
                    return x;
            }
               
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(nametf2.getText().equals("") || agetf.getText().equals("") ||  phonetf2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill all empty textfields.", "Error",JOptionPane.ERROR_MESSAGE);
            } else if (isDig(nametf2))
            {
                     JOptionPane.showMessageDialog(null, "Rewrite name.", "Error",JOptionPane.ERROR_MESSAGE);
           }else if(!isDig(agetf))
            {
                    JOptionPane.showMessageDialog(null, "Invalid age!", "Error",JOptionPane.ERROR_MESSAGE);
           }else if (phonetf2.getText().length() != 11 || !isDig(phonetf))
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
          
          
          if(y.get(i).phone.equals(phonetf2.getText()))
          { 
              found=true;
           JOptionPane.showMessageDialog(null, "Patient already registered ", "Error",JOptionPane.ERROR_MESSAGE);
          }
      }
         if(found==false)         
         {               
             System.out.println("eh");
             Patient p=new Patient();
             Patient x=  ref(p,y);
         
             x.name=nametf2.getText();
             x.age=(agetf.getText());
             x.gender=selectedgender();
             x.entrydate=day.getSelectedItem()+" /" +month.getSelectedItem()+"/"+ year.getSelectedItem();
             x.phone=phonetf2.getText();
          
             JOptionPane.showMessageDialog(null, "Patient registered " );       
             y.add(x);
             
//             try {
//                    writepatient(y);
//                } catch (IOException ex) {
//                    Logger.getLogger(PatientRegister.class.getName()).log(Level.SEVERE, null, ex);
//                }
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
            
            System.out.println(readpatients.size());
      for(int j=0;j<readpatients.size();j++)
      {
          System.out.println(readpatients.get(j).name);
//          System.out.println(nametf.getText());
          if(readpatients.get(j).name.equals(nametf.getText())&& readpatients.get(j).phone.equals(phonetf.getText()))
          {                
              System.out.println("hasal");
             foundpatient=true;
             
             showname.setText(readpatients.get(j).name);
             showage.setText("age" +readpatients.get(j).age);
             showgender.setText("gender :" +readpatients.get(j).gender);showentry.setText("entry date  : " +readpatients.get(j).entrydate);
             showphone.setText("phone number : "+readpatients.get(j).phone);
             showname.setBounds(35, 200, 160, 30);
              showage.setBounds(35,250,160,30);
              showgender.setBounds(35,300,160,30);
              showentry.setBounds(35,350,160,30);
              showphone.setBounds(35,400,200,30);
           
              panel2.add(showname);
              panel2.add(showage);
              panel2.add(showgender);
              panel2.add(showentry);
              panel2.add(showphone);
           
              repaint();
             
          }
      }     
         
      
      
       if(foundpatient==false)
       {
        JOptionPane.showMessageDialog(null, "Patient not found ", "Error",JOptionPane.ERROR_MESSAGE);

       }   
            
            
        }
         }
                    
                    
                    private class clickassroom implements ActionListener
         {

          @Override
          public void actionPerformed(ActionEvent ae) 
          {
              panel.setVisible(false);
              panel2.setVisible(false);
              panel3.setVisible(true);
              panel4.setVisible(false);
              container.add(panel3);
              container.repaint();
          }
             
         }
                    
    private class assignwatcher implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            try {
                z=readroom(Roomslist);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
           
              ObjectInputStream  in = null;
          
            try {
                in = new ObjectInputStream(new FileInputStream ("D:/patients.bin" ));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
           
              
            
            try {
                patientslist2=( ArrayList<Patient> )in.readObject();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
         
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            
            boolean foundpatient=false;
            
            
       
          
                       
             
             
            if(z.size()<100)
            {
            for(Patient i : patientslist2)
      {
          
          if(i.name.equals(nametf3.getText())&& i.phone.equals(phonetf3.getText()))
          {  
              foundpatient=true;
              Room r=new Room();
           Room x=ref(r,z);
           x.patient.name=i.name;
           x.patient.phone=i.phone;
           x.RoomNumber=z.size()+100;
           x.patient.age=i.age;
           x.patient.entrydate=i.entrydate;
           x.patient.gender=i.gender;
           
           
           z.add(x);  
              try {
                  writeroom(z);
              } catch (IOException ex) {
                  Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
              }
         JOptionPane.showMessageDialog(null, "Patient " + x.patient.name+ " has been assigned to room : " +x.RoomNumber) ;

            }
            
        }
             if(foundpatient==false)
          {
              
        JOptionPane.showMessageDialog(null, "Patient not found ", "Error",JOptionPane.ERROR_MESSAGE); 

          }
            }
            
             else
          {
          JOptionPane.showMessageDialog(null, "No empty rooms ", "Error",JOptionPane.ERROR_MESSAGE); 

              
          }
            
         
          
         
          
    
    
    
}
              

}
    
     
    
     
        public ArrayList readroom(ArrayList<Room>  x) throws FileNotFoundException, IOException, ClassNotFoundException
               {
                   
                   ObjectInputStream  in = null;
                 in = new ObjectInputStream(new FileInputStream ("D:/Rooms.bin" ));
                    x=( ArrayList<Room> )in.readObject();
                in.close();
                return x;
                }
                 public void writeroom(ArrayList<Room>  x) throws FileNotFoundException, IOException
    {
         ObjectOutputStream write;
    write = new ObjectOutputStream ( new FileOutputStream("D:/Rooms.bin"));
     write.writeObject(x);
             write.close();
        }
                 Room ref(Room x,ArrayList<Room> y)
            {
                if(y.contains(x))
                {
                    x=new Room();
                    return ref(x,y);
                }
                else
                {
                    return x;
                }
            }
                 private class clickroominfo implements ActionListener
                 {
                  @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        panel.setVisible(false);
                        panel2.setVisible(false);
                        panel3.setVisible(false);
                        panel4.setVisible(true);
                        container.add(panel4);
                        repaint();
                    }
                  }
                 
                 
                 
                               
        private class showinfo implements ActionListener
    {
            boolean roomoccupied=false;
        @Override 
        public void actionPerformed(ActionEvent ae)
        {
   
            
                 ObjectInputStream  in = null;
           try {
               in = new ObjectInputStream(new FileInputStream ("D:/Rooms.bin" ));
           } catch (IOException ex) {
               Logger.getLogger(PatientFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
 
            try {
                Roomslist2=( ArrayList<Room> )in.readObject();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
  
          if(parseInt(roomnums.getText())>=100 && parseInt(roomnums.getText())<=600 )
          {
              for(int i=0 ; i <Roomslist2.size();i++)
              {
          if(Integer.parseInt(roomnums.getText())==(Roomslist2.get(i).RoomNumber))
          {                
              System.out.println(" hasal");
             roomoccupied=true;
            
             
             namelb3.setText(" Room assigned to patient " + Roomslist2.get(i).patient.name);
             
             patentry.setText("Patient entry date :  "+Roomslist2.get(i).patient.entrydate);
                     
              namelb3.setBounds(35, 220, 250, 30);
              patentry.setBounds(35,270,250,30);
             
           
              
              panel4.add(namelb3);
              panel4.add(patentry);
             
           
              repaint();

             
          }
             
              
              
      }     
           if(roomoccupied==false)
       {
        JOptionPane.showMessageDialog(null, "Room is empty ", "Error",JOptionPane.ERROR_MESSAGE);
              
            
           
           
       }
      }
          else
              JOptionPane.showMessageDialog(null, "Incorrect room number ", "Error",JOptionPane.ERROR_MESSAGE);
      
     
            
            
            
        }
        
        
        
        
        
        
        
        
        }
                 
  
                 
                 private class statisticsbutton implements ActionListener
    {
        @Override 
        public void actionPerformed(ActionEvent ae)
        {
            panel.setVisible(false);
            panel2.setVisible(false);
            panel3.setVisible(false);
            panel4.setVisible(false);
              ObjectInputStream read = null;
            try {
                read = new ObjectInputStream(new FileInputStream("D:/patients.bin"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        ArrayList<Patient> ar = new ArrayList<Patient>();
            try {
                ar =(ArrayList)read.readObject();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                read.close();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        int v;
        for (v = 0; v < 6; v++)
            {
                Age[v] = 0;
            }
        int getAge;
        int i;
        for (i = 0; i < ar.size(); i++)
        {
          getAge = parseInt(ar.get(i).age);
          Age[5]++;
                if (getAge <= 18)
                    Age[0]++;
                else if (getAge > 18 && getAge <= 25)
                    Age[1]++;
                else if (getAge > 25 && getAge <= 40)
                    Age[2]++;
                else if (getAge > 40 && getAge <= 60)
                    Age[3]++;
                else if (getAge > 60)
                    Age[4]++;
          
        }
            graph g = new graph();
            g.setVisible(true);
          //  graphPanel.setVisible(true);
        }
    }
    
     private class graph extends JFrame implements Serializable
    {
        graph()
        {
            setTitle("Ages Statistics");
            setBounds(380,110,310,320);
          
        }
        
         @Override
    public void paint(Graphics grphcs)
    {
        super.paint(grphcs);
        //(int x, int y, int width, int height, int startAngle, int arcAngle)
        grphcs.setColor(new Color(0, 190, 210));
        grphcs.fillOval(25,280,10,10);
        grphcs.drawString("1->18",15,300);
        grphcs.fillArc(80,100,150,150,0,360*Age[0]/(Age[5]));
        
        grphcs.setColor(new Color(0,170,190));
        grphcs.fillOval(72,280,10,10);
        grphcs.drawString("19->25",62,300);
        grphcs.fillArc(80,100,150,150,360*Age[0]/(Age[5]),360*Age[1]/Age[5]);
       
        grphcs.setColor(new Color(0,150,170));
        grphcs.fillOval(134,280,10,10);
        grphcs.drawString("26->40",124,300);
        grphcs.fillArc(80, 100, 150,150,(360*Age[1]/Age[5])+(360*Age[0]/Age[5]),360*Age[2]/Age[5]);
       
        grphcs.setColor(new Color(0,130,150));
        grphcs.fillOval(196,280,10,10);
        grphcs.drawString("41->60",186,300);
        grphcs.fillArc(80,100,150,150,(360*Age[2]/Age[5])+(360*Age[1]/Age[5])+(360*Age[0]/Age[5]),360*Age[3]/Age[5]);
       
        grphcs.setColor(new Color(0,110,130));
        grphcs.fillArc(80,100,150,150,(360*Age[3]/Age[5])+(360*Age[2]/Age[5])+(360*Age[1]/Age[5])+(360*Age[0]/Age[5]),360*Age[4]/Age[5]);
        grphcs.fillOval(251,280,10,10);
        grphcs.drawString("60+",248,300);
    }
      }
                 
}