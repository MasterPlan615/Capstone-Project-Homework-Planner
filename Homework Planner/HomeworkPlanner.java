import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.text.DateFormatSymbols;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;


/**
 * Keeps track of notes and sets them to a specific month and day.
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
    private DayFrame df = new DayFrame();
    private ActionListener butl = new DayListener();
    private FlowLayout lay = new FlowLayout();
    
    /**
     * Constructor for objects of class HomeworkPlanner.
     */
    public HomeworkPlanner()
    {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        this.setLayout( this.lay );
        
        monthList = new JComboBox<String>( this.months );
        this.add( this.monthList );
        
        ActionListener monl = new MonthListener();
        this.monthList.addActionListener( monl );
        
        createCalendar();
        
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.pack();
        this.setVisible( true );
    }
    
    /**
     * Main method that begins the program.
     */
    public static void main( String[] args )
    {
        HomeworkPlanner start = new HomeworkPlanner();
    }
    
    /**
     * Creates the calendar grid layout of buttons for each day in a month.
     */
    public void createCalendar()
    {
        pane.setLayout( new GridLayout( 7, 4 ) );
        for( int i = 0; i < 49; i++ )
        {
            this.day = new JButton();
            this.day.addActionListener( butl );
            this.grid.add( day );
            pane.add( day );
        }
    }
    
    /**
     * Changes the days that the buttons in the calendar grid display.
     *
     * @param  days   number of days in the selected month
     */
    public void updateCalendar( int days )
    {
        for( int i = 0; i < this.grid.size(); i++ )
        {
            this.grid.get( i ).setText( "" );
        }
        for( int i = 0; i < days; i++ )
        {
            this.grid.get( i ).setText( Integer.toString( i + 1 ) );
        }
    }

    
    class DayListener implements ActionListener
    {
        public void actionPerformed( ActionEvent event )
        {
            JButton bday = (JButton)event.getSource();
            df.setVisible( true );
            df.updateDay( monthList.getSelectedItem().toString() ,bday.getText() );
        }
    }
    
    
    class MonthListener implements ActionListener
    {
        public void actionPerformed( ActionEvent event )
        {
            JComboBox cb = (JComboBox)event.getSource();
            if( cb.getSelectedItem().toString() == "January"  )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem().toString() == "February" )
            {
                updateCalendar( 29 );
            }
            else if( cb.getSelectedItem().toString() == "March" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem().toString() == "April" )
            {
                updateCalendar( 30 );
            }
            else if( cb.getSelectedItem().toString() == "May" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem().toString() == "June" )
            {
                updateCalendar( 30 );
            }
            else if( cb.getSelectedItem().toString() == "July" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem().toString() == "August" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem().toString() == "September" )
            {
                updateCalendar( 30 );
            }
            else if( cb.getSelectedItem().toString() == "October" )
            {
                updateCalendar( 31 );
            }
            else if( cb.getSelectedItem().toString() == "November" )
            {
                updateCalendar( 30 );
            }
            else if( cb.getSelectedItem().toString() == "December" )
            {
                updateCalendar( 31 );
            }
        }
    }
}
