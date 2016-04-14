import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import java.text.DateFormatSymbols;


/**
 * Keeps track of events and sets them to a date and time as well as notifies user of events.
 * 
 * @Andrew Souhrada
 * @04/13/16
 */
public class HomeworkPlanner extends JFrame
{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;
    private Container pane;
    private JButton day;
    private JSpinner month;
    private DateFormatSymbols symbols;
    
    /**
     * Constructor for objects of class HomeworkPlanner
     */
    public HomeworkPlanner()
    {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        
        pane = getContentPane();
        createCalendar( 31 );
        
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.pack();
        this.setVisible( true );
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public static void main( String[] args )
    {
        HomeworkPlanner start = new HomeworkPlanner();
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void createCalendar( int numdays )
    {
        symbols = new DateFormatSymbols();
        String months[] = symbols.getShortMonths();
        SpinnerModel model1 = new SpinnerListModel( months );
        JSpinner spinner1 = new JSpinner( model1 );
        this.add( spinner1 );
        
        pane.setLayout( new GridLayout( 5, 7 ) );
        for( int i = 0; i < numdays; i++ )
        {
            day = new JButton( Integer.toString( i + 1 ) );
            pane.add( day );
        }
    }
}
