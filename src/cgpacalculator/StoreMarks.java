package cgpacalculator;

import java.util.HashMap;

/**
 *
 * @author Jagdish
 */
public class StoreMarks 
{
    HashMap<String, HashMap<String, String[][]>> grades;
    
    public StoreMarks()
    {
        grades = new HashMap<String, HashMap<String, String[][]>>();
    }
    
    public void addValue(String sem, HashMap<String, String[][]> credits_grades)
    {
        try
        {
            if(!(grades.containsKey(sem)))
            {
                grades.put(sem, credits_grades);
            }
            else
            {
                String message = "You have already entered the grades for semester" + sem + " to add new value choose File->New and start entering new values.";
                MsgBox msg = new MsgBox(message);
            }
        }
        catch(Exception e)
        {
            Error error = new Error(e.getMessage());
            error.setVisible(true);
        }
    }
}
