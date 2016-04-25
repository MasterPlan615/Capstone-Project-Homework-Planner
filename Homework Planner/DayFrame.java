import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private JScrollPane sp;
    private File notesFile;
    private Scanner in;
    private ActionListener notl = new NoteListener();
    
    
    /**
     * Constructor for objects of class DayFrame
     */
    public DayFrame()
    {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        this.setLayout( lay );
        
        try
        {
            notesFile = new File( "notesFile.txt" );
            try
            {
                notesFile.createNewFile();
            }
            catch ( IOException a )
            {
                System.err.println( "IOException: " + a.getMessage() );
            }
            in = new Scanner( notesFile );
        }
        catch( FileNotFoundException e )
        {
            System.err.println( "FileNotFoundException: " + e.getMessage() );
        }
        
        this.numday = new JLabel( " " );
        this.add( this.numday );
        
        this.creno = new JTextField( 25 );
        this.add( this.creno );
        
        this.notes = new JTextArea( 15, 20 );
        this.sp = new JScrollPane( notes );
        notes.setEditable( false );
        this.add( this.notes );
        
        ActionListener notl = new NoteListener();
        this.creno.addActionListener( notl );
        
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
    }
    
    
    class NoteListener implements ActionListener
    {
        public void actionPerformed( ActionEvent event )
        {
            JTextField newf = (JTextField)event.getSource();
            String usernotes = newf.getText();
            notes.setText( usernotes );
        }
    }
}
