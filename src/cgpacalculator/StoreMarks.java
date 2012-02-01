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
        }
        catch(Exception e)
        {
            Error error = new Error(e.getMessage());
            error.setVisible(true);
        }
    }
}
