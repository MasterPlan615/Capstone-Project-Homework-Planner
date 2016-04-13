import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.GridLayout;


/**
 * Main page of HomeworkPlanner, shows calendar interface for the specific year and month.
 * 
 * @Andrew Souhrada 
 * @04/13/16
 */
public class CalendarFrame extends JPanel
{
    private JFrame
    /**
     * Constructor for objects of class CalendarFrame
     */
    public CalendarFrame()
    {
        createCalendar( 31 );
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void createCalendar( int numdays )
    {
        Container pane = getContentPane();
        pane.setLayout( new GridLayout( 7, 5 ) );
        for( int i = 0; i < numdays; i++ )
        {
            JButton day = new JButton( Integer.toString( i + 1 ) );
            pane.add( day );
        }
    }
}
