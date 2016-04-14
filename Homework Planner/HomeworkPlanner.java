import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.text.DateFormatSymbols;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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
    private Container pane = getContentPane();
    private JButton day;
    private DateFormatSymbols symbols = new DateFormatSymbols();
    private String months[] = symbols.getMonths();
    private JComboBox<String> monthList;
    private ArrayList<JButton> grid = new ArrayList<JButton>();
    
    /**
     * Constructor for objects of class HomeworkPlanner
     */
    public HomeworkPlanner()
    {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        
        monthList = new JComboBox<String>( months );
        this.add( monthList );
        
        ActionListener monl = new ComboBoxListener();
        this.monthList.addActionListener( monl );
        
        createCalendar();
        
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
    public void createCalendar()
    {
        pane.setLayout( new GridLayout( 7, 4 ) );
        for( int i = 0; i < 49; i++ )
        {
            day = new JButton();
            grid.add( day );
            pane.add( day );
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void updateCalendar( int days )
    {
        for( int i = 0; i < grid.size(); i++ )
        {
            grid.get( i ).setText( "" );
        }
        for( int i = 0; i < days; i++ )
        {
            grid.get( i ).setText( Integer.toString( i + 1 ) );
        }
    }

    
    
    class ComboBoxListener implements ActionListener
    {
        public void actionPerformed( ActionEvent event )
        {
            JComboBox cb = (JComboBox)event.getSource();
            if( cb.getSelectedItem() == "January"  )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem() == "February" )
            {
                updateCalendar( 29 );
            }
            else if( cb.getSelectedItem() == "March" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem() == "April" )
            {
                updateCalendar( 30 );
            }
            else if( cb.getSelectedItem() == "May" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem() == "June" )
            {
                updateCalendar( 30 );
            }
            else if( cb.getSelectedItem() == "July" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem() == "August" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem() == "September" )
            {
                updateCalendar( 30 );
            }
            else if( cb.getSelectedItem() == "October" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem() == "November" )
            {
                updateCalendar( 30 );
            }
            else if( cb.getSelectedItem() == "December" )
            {
                updateCalendar( 31 );
            }
        }
    }
}
