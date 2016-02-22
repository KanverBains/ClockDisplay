
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay2();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay2();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
    private void updateDisplay2()
    {
        int new_hours;
        new_hours =  hours.getValue();
        if(new_hours==0) {
            new_hours = 1;    
        }else if(new_hours==13){
            new_hours = 1;
        }else if(new_hours==14){
            new_hours = 2;
        }else if(new_hours==15){
            new_hours = 3;
        }else if(new_hours==16){
            new_hours = 4;
        }else if(new_hours==17){
            new_hours = 5;
        }else if(new_hours==18){
            new_hours = 6;
        }else if(new_hours==19){
            new_hours = 7;
        }else if(new_hours==20){
            new_hours = 8;
        }else if(new_hours==21){
            new_hours = 9;
        }else if(new_hours==22){
            new_hours = 10;
        }else if(new_hours==23){
            new_hours = 11;
        }else if(new_hours==24){
            new_hours = 12;
        }
        displayString = new_hours + ":" +  minutes.getDisplayValue();
    }
}
