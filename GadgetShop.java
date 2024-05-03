 import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.Color;

public class GadgetShop implements ActionListener
{

    private JFrame frame;

    private Label modellabel;
    private Label pricelabel;
    private Label weightlabel;
    private Label sizelabel;
    private JLabel displayNumberlabel;
    private JLabel phoneNumberlabel;
    private JLabel durationlabel;
    private JLabel downloadMusiclabel;

    private JTextField modelTextbox;
    private JTextField priceTextbox;
    private JTextField weightTextbox;
    private JTextField sizeTextbox;
    private JTextField displayNumberTextbox;
    private JTextField phoneNumberTextbox;
    private JTextField durationTextbox;
    private JTextField MemoryTextbox;
    private JTextField creditTextbox;
    private JTextField downloadMusicTextbox;

    private JLabel creditlabel;
    private Label Memorylabel;
    private Button addMobileButton;
    private Button addDownloadButton;
    private Button addMP3Button;
    private Button makeACall;
    private Button viewAll;
    private Button clear;

    ArrayList<Gadget> item= new ArrayList<Gadget>();

    public static void main(String arg[])
    {
        GadgetShop aGadgetShop=new GadgetShop() ;
    }

    public GadgetShop()
    {
        makeFrame();
    }

    private void makeFrame()
    {
        frame = new JFrame (" GadgetShop ") ;
        Container contentPane = frame.getContentPane();
        frame.getContentPane().setBackground(new Color(173,216,230,139));
         
        JLabel modellabel = new JLabel( "Model:");
        JLabel pricelabel = new JLabel("Price:");
        JLabel weightlabel = new JLabel ( "Weight:");
        JLabel sizelabel = new JLabel ("Size:");
        JLabel downloadMusiclabel = new JLabel("Download Music:");
    
        modelTextbox = new JTextField(10);
        priceTextbox = new JTextField(10);
        weightTextbox = new JTextField(10);
        creditTextbox = new JTextField(10);
        sizeTextbox = new JTextField(10);
        downloadMusicTextbox = new JTextField(10);

        JLabel creditlabel = new JLabel("Credit:");
        JLabel Memorylabel = new JLabel ("Memory:");

        addMobileButton = new Button( "Add Mobile");
        addMobileButton.addActionListener(this);
        addMP3Button = new Button( "Add MP3");
        addMP3Button.addActionListener(this);
        makeACall = new Button ("Make a Call");
        makeACall.addActionListener(this);
        viewAll = new Button ("View All");
        viewAll.addActionListener(this);
        clear = new Button ("Clear");
        clear.addActionListener(this);
        addDownloadButton= new Button ("Download");
        addDownloadButton.addActionListener(this);
        
        makeACall.setForeground(Color.white);
        makeACall.setBackground(Color.black);
        addMobileButton.setForeground(Color.white);
        addMobileButton.setBackground(Color.black);
        addDownloadButton.setForeground(Color.white);
        addDownloadButton.setBackground(Color.black);
        addMP3Button.setForeground(Color.white);
        addMP3Button.setBackground(Color.black);
        viewAll.setForeground(Color.white);
        viewAll.setBackground(Color.gray);
        clear.setForeground(Color.white);
        clear.setBackground(Color.gray);
      
        creditTextbox = new JTextField(10);
        MemoryTextbox = new JTextField(10);
        
        JLabel displayNumberlabel = new JLabel("Display...");
        displayNumberTextbox = new JTextField(10);

        JLabel phoneNumberlabel = new JLabel("Phone Number...");
        phoneNumberTextbox = new JTextField(10);
        JLabel durationlabel = new JLabel ("Duration:");
        durationTextbox = new JTextField(10);

        contentPane. setLayout (new GridLayout(14,2));

        contentPane.add(modellabel);
        contentPane.add(modelTextbox);
        contentPane.add(pricelabel);
        contentPane.add(priceTextbox);
        contentPane.add (weightlabel);
        contentPane.add (weightTextbox);
        contentPane.add(sizelabel);
        contentPane.add(sizeTextbox);
        contentPane.add(addMP3Button);
        contentPane.add(addDownloadButton);
        
        contentPane.add(creditlabel);
        contentPane.add(creditTextbox);
        contentPane.add(Memorylabel);
        contentPane.add(MemoryTextbox);
        contentPane.add(downloadMusiclabel);
        contentPane.add(downloadMusicTextbox);

        contentPane.add(addMobileButton);
        contentPane.add (makeACall);
    
        contentPane.add(displayNumberlabel);
        contentPane.add(displayNumberTextbox);
        contentPane.add(phoneNumberlabel);
        contentPane.add(phoneNumberTextbox);
        contentPane.add(durationlabel);
        contentPane.add(durationTextbox);
        contentPane.add (viewAll);
        contentPane.add (clear);
        contentPane.add (Box.createVerticalGlue());
         
        frame .pack () ;
        frame.setVisible(true);
    }

    public void actionPerformed( ActionEvent event)
    {
        String command = event.getActionCommand();
        if (command.equals ("Add Mobile")) {
            addMobile();
        }
        if (command. equals( "Add MP3")) {
            addMP3 ();
        }
        if (command. equals ("Make a Call")) {
            makeACall();
        }
         if (command. equals ("View All")) {
            viewAll();
        }
          if (command. equals ("Clear")) {
            clear();
        }
        if (command.equals ("Download")) {
            download();
        }
    }

    public void addMobile()
    {
           if(getCredit() == -1 || getaModel() == null || getPrice() == -1 || getWeight() == -1 || getSize() == null)
        {
            JOptionPane.showMessageDialog(frame, "unabled to design a mobile");
        }
        else{
            Mobile newMobile= new Mobile (getCredit(), getaModel(),getPrice(), getWeight(), getSize());
            item.add(newMobile);
            JOptionPane.showMessageDialog(frame,"Reserving a brand new smartphone or tablet");

        }
    }    

    public void addMP3()
    {
        MP3 newMP3 = new MP3 (getMemory(), getaModel(),
                getPrice(), getWeight(), getSize());

        item.add(newMP3);
        JOptionPane.showMessageDialog(frame,"The installation of a new MP3 is accomplished.");
    }

    public void makeACall()
    {
     // Retrieve the gadget from the list of items based on the display number
        Gadget gadget = item.get(getDisplayNumber());
        // Check if the display number is valid and the gadget is an instance of Mobile
        if (getDisplayNumber() != -1 && gadget instanceof Mobile)
        {
            // If so, cast the gadget to Mobile and make a call
            Mobile mobile= (Mobile) item.get(getDisplayNumber());
            mobile.makeCall(getPhoneNumber(), getDuration());
        }
        else
        {
            // If the display number is invalid or the gadget is not a Mobile, display an error message
            JOptionPane.showMessageDialog(frame,"Unable to Make A Call.");

        }

    }
    
    public void download() {
    int displayNumber = getDisplayNumber();
    
    // Check if the display number is valid (-1 indicates an invalid display number)
    if (displayNumber != -1) {
        // Get the gadget from the ArrayList using the display number
        Gadget gadget = item.get(displayNumber);
        
        // Check if the gadget is an instance of MP3
        if (gadget instanceof MP3) {
            
            // Cast the gadget to MP3
            MP3 mp3 = (MP3) gadget;
            double downloadSize = Double.parseDouble(downloadMusicTextbox.getText());
            
            // Call the method to download music in the MP3 class with the download size
            mp3.downloadingMusic(downloadSize);
            JOptionPane.showMessageDialog(frame, "Music downloaded successfully.");
        } else {
            // Show a message indicating that the selected gadget is not an MP3 player
            JOptionPane.showMessageDialog(frame, "Please select an MP3 player to download music.");
        }
    } else {
        // Show a message indicating that no gadget is selected
        JOptionPane.showMessageDialog(frame, "Please select a gadget to download music.");
    }
}

    
     public void viewAll()
    {     
        for(Gadget list :item){  
            
            System.out.print("Item number: " + item.indexOf(list) +"\n");
            
            list.display();
        
        }
    }
        
    // before was callCredit()
    public int getCredit()
    {
        int callCredit = -1;
        try{
            callCredit = Integer.parseInt(creditTextbox.getText());
        } catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(frame, "Please include a number as well.");
        }
        return callCredit;
    }

    
    // before was only price()
    private double getPrice()
    {
        double aPrice = Double.parseDouble(priceTextbox.getText());
        return aPrice;
    }

    // before was only weight()
    private int getWeight()
    {
        int aWeight = Integer.parseInt(weightTextbox.getText());
        return aWeight;
    }

    //before was of int data type and it was just size()
    private String getSize()
    {
          String aSize = sizeTextbox.getText();
        if(aSize.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in the Size field");
            aSize = null;
            return aSize;
        }
        else{
            return aSize;
        }
     }
    

    public String getaModel()
    {
        String aModel = modelTextbox.getText();
        if(aModel.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Fill out the model information field.");
            aModel = null;
            return aModel;
        }
        else{
            return aModel;
        }
    }

    public double getMemory()
    { 
        double aMemory = Double.parseDouble(MemoryTextbox.getText());
        return aMemory;
    }

    public double getDownload()
    {
       double aDownloadMusic = Double.parseDouble(downloadMusicTextbox.getText());
        return aDownloadMusic;
    
    }
    
    public int getDisplayNumber()
    {
         int getDisplayNumber = -1;
        try{
            int userInput = Integer.parseInt(displayNumberTextbox.getText());
            if(userInput >= 0 && userInput <= item.size()-1)
            {
               getDisplayNumber = userInput; 
            }
            else{JOptionPane.showMessageDialog(frame, "This gadget doesn't belong within the list.");
            }
        } catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(frame, "Please include a number as well");
        }
        return getDisplayNumber;
    }


    public int getDuration()
    {
        int Duration = Integer.parseInt(durationTextbox.getText());
        return Duration;
    }

    public String getPhoneNumber()
    {
        String PhoneNumber = phoneNumberTextbox.getText(); 
        return PhoneNumber;
    }
    
    public void clear()
      {
    modelTextbox.setText(null);
    priceTextbox.setText(null);
    weightTextbox.setText(null);
    sizeTextbox.setText(null);
    displayNumberTextbox.setText(null);
    phoneNumberTextbox.setText(null);
    durationTextbox.setText(null);
    MemoryTextbox.setText(null);
    creditTextbox.setText(null);
    downloadMusicTextbox.setText(null);
    }
    
} 