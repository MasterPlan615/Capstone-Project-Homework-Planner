import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Represents a specific day and keeps track of notes set to that day.
 * 
 * @Andrew Souhrada
 * @04/15/16
 */
public class DayFrame extends JFrame
{
    private static final int FRAME_WIDTH = 550;
    private static final int FRAME_HEIGHT = 400;
    private JLabel numday;
    private JTextArea notes;
    private File notesFile;
    private BufferedWriter buffwrit;
    private String month;
    private String day;
    
    
    /**
     * Constructor for objects of class DayFrame.
     */
    public DayFrame()
    {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        FlowLayout lay = new FlowLayout();
        this.setLayout( lay );
        
        this.numday = new JLabel( " " );
        this.add( this.numday );
        
        JTextField creno = new JTextField( 25 );
        this.add( creno );
        
        this.notes = new JTextArea( 15, 20 );
        notes.setEditable( false );
        this.add( this.notes );
        
        JButton clear = new JButton( "Clear" );
        this.add( clear );
        
        ActionListener notl = new NoteListener();
        creno.addActionListener( notl );
        
        ActionListener clel = new ClearListener();
        clear.addActionListener( clel );
        
        this.notesFile = new File( "notesFile.txt" );
            
        try
        {
            this.buffwrit = new BufferedWriter( new FileWriter( "notesFile.txt", true ) );
        }
        catch ( IOException a )
        {
            System.err.println( "IOException: " + a.getMessage() );
        }

        updateNotes();
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( false );
    }
    
    /**
     * Changes the displayed date on the day page as well as sets the day and month to variables.
     *
     * @param  month   the selected month
     * @param  day   the selected day
     */
    public void updateDay( String month, String day )
    {
        this.numday.setText( month + " " + day );
        this.month = month;
        this.day = day;
    }
    
    /**
     * Writes the note to the file notesFile.txt.
     *
     * @param  s   the note to be written to the file
     */
    public void changeNotes( String s )
    {
        try
        {
            try
            {
                this.buffwrit.write( month + " " + day + ": ");
                this.buffwrit.write( s + ". " );
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
     * Reads the file notesFile.txt and prints the note to the text field.
     *
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
     * Clears both the file notesFile.txt and the text field of all notes.
     *
     */
    public void clearNotes()
    {
        try
        {
            BufferedWriter clearwrit = new BufferedWriter( new FileWriter( "notesFile.txt" ) );
            try
            {
                clearwrit.write( "" );
            }
            catch( FileNotFoundException e )
            {
                System.err.println( "FileNotFoundException: " + e.getMessage() );
            }
            this.notes.setText( "" );
            clearwrit.flush();
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
