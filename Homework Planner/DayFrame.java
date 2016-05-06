import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Represents a specific day and the hours in it, to allow events to be set to those times.
 * 
 * @Andrew Souhrada
 * @04/15/16
 */
public class DayFrame extends JFrame
{
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
    private JLabel numday;
    private JTextField creno;
    private FlowLayout lay = new FlowLayout();
    private JTextArea notes;
    private JButton clear;
    private JScrollPane sp;
    private File notesFile;
    private BufferedWriter buffwrit;
    private BufferedWriter clearwrit;
    private FileInputStream creek;
    private InputStreamReader canoe;
    private BufferedReader buff;
    private ActionListener notl = new NoteListener();
    private String month;
    private String day;
    
    
    /**
     * Constructor for objects of class DayFrame
     */
    public DayFrame()
    {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        this.setLayout( lay );
        
        
        this.numday = new JLabel( " " );
        this.add( this.numday );
        
        this.creno = new JTextField( 25 );
        this.add( this.creno );
        
        this.notes = new JTextArea( 15, 20 );
        this.sp = new JScrollPane( notes );
        notes.setEditable( false );
        this.add( this.notes );
        
        this.clear = new JButton( "Clear" );
        this.add( this.clear );
        
        
        ActionListener notl = new NoteListener();
        this.creno.addActionListener( notl );
        
        ActionListener clel = new ClearListener();
        this.clear.addActionListener( clel );
        
        
        try
        {
            this.notesFile = new File( "notesFile.txt" );
            this.creek = new FileInputStream( "notesFile.txt" );
            this.canoe = new InputStreamReader( this.creek );
            this.buff = new BufferedReader( this.canoe );
            try
            {
                this.buffwrit = new BufferedWriter( new FileWriter( "notesFile.txt", true ) );
                
            }
            catch ( IOException a )
            {
                System.err.println( "IOException: " + a.getMessage() );
            }
        }
        catch( FileNotFoundException e )
        {
            System.err.println( "FileNotFoundException: " + e.getMessage() );
        }
        
        
        updateNotes();
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //this.pack();
        this.setVisible( false );
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void updateDay( String month, String day )
    {
        this.numday.setText( month + " " + day );
        this.month = month;
        this.day = day;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void changeNotes( String s )
    {
        try
        {
            try
            {
                this.buffwrit.write( month + day + " " );
                this.buffwrit.write( s + " " );
            }
            catch( FileNotFoundException e )
            {
                System.err.println( "FileNotFoundException: " + e.getMessage() );
            }
            this.buffwrit.flush();
        }
        catch( IOException a )
        {
            System.err.println( "IOException: " + a.getMessage() );
        }
    }

    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void updateNotes()
    {
        try
        {
            String newup = "";
            Scanner in = new Scanner( notesFile );
            while( in.hasNext() )
            {
                newup += in.next() + " ";
            }
            this.notes.setText( newup );
            in.close();
        }
        catch( IOException a )
        {
            System.err.println( "IOException: " + a.getMessage() );
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void clearNotes()
    {
        try
        {
            try
            {
                this.clearwrit = new BufferedWriter( new FileWriter( "notesFile.txt" ) );
                this.clearwrit.write( "" );
            }
            catch( FileNotFoundException e )
            {
                System.err.println( "FileNotFoundException: " + e.getMessage() );
            }
            this.notes.setText( "" );
            this.clearwrit.flush();
        }
        catch( IOException a )
        {
            System.err.println( "IOException: " + a.getMessage() );
        }
    }

    
    class NoteListener implements ActionListener
    {
        public void actionPerformed( ActionEvent event ) 
        {
            JTextField newf = (JTextField)event.getSource();
            String usernotes = newf.getText();
            changeNotes( usernotes );
            updateNotes();
        }
    }
    
    class ClearListener implements ActionListener
    {
        public void actionPerformed( ActionEvent event ) 
        {
            clearNotes();
        }
    }
}
