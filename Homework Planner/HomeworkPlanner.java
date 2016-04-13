import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;


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
    
    /**
     * Constructor for objects of class HomeworkPlanner
     */
    public HomeworkPlanner()
    {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        
        CalendarFrame mainpage = new CalendarFrame();
        this.add( mainpage, BorderLayout.SOUTH );
        
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
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
}
