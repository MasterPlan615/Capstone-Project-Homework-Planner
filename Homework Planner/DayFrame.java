import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;


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
    private JTextField notes;
    private FlowLayout lay = new FlowLayout();
    
    
    /**
     * Constructor for objects of class DayFrame
     */
    public DayFrame()
    {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        this.setLayout( lay );
        
        this.numday = new JLabel( " " );
        this.add( this.numday );
        
        this.notes = new JTextField( 25 );
        this.add( this.notes );
        
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
}
