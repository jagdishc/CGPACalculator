package cgpacalculator;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Jagdish
 */
public class Calculator 
{
    HashMap<String, Integer> grade_values;
    HashMap<String, String[][]> value;
    HashMap<String, HashMap<String, String[][]>> value_cgpa;
    
    private void init()
    {
        grade_values = new HashMap<String, Integer>();
        
        grade_values.put("S", 10);
        grade_values.put("A", 9);
        grade_values.put("B", 8);
        grade_values.put("C", 7);
        grade_values.put("D", 6);
        grade_values.put("E", 5);
        grade_values.put("U", 0);
    }
    public Calculator(String sem, StoreMarks sm)
    {
        init();
        value = sm.grades.get(sem);              
    }
    
    public Calculator(StoreMarks sm)
    {
        init();        
        value_cgpa = sm.grades;
    }
    
    public void calculateGPA()
    {
        Double total_credits = 0.0, marks = 0.0, gpa;        
        
        for(Iterator<String> it = value.keySet().iterator(); it.hasNext();)
        {
            String sub = it.next();
            String temp[][] = value.get(sub);            
            int crd = Integer.parseInt(temp[0][0]);
            String grd = temp[0][1];
            if(grd.equals("U")==false)
            {
                marks += crd*grade_values.get(grd);
                total_credits += crd;
            }
        }
        
        gpa = marks/total_credits;
        System.out.println("Your GPA is: " + gpa);
        
    }
    
    public void calculateCGPA()
    {
        Double total_credits = 0.0, marks = 0.0, cgpa;
        HashMap<String, String[][]> temp;
        for(Iterator<String> iter = value_cgpa.keySet().iterator();iter.hasNext();)
        {
            String tmp = iter.next();
            temp = value_cgpa.get(tmp);
            for(Iterator<String> it = temp.keySet().iterator();it.hasNext();)
            {
                String sub = it.next();
                String temp_array[][] = temp.get(sub);
                int crd = Integer.parseInt(temp_array[0][0]);
                String grd = temp_array[0][1];
                if(grd.equals("U") == false)
                {
                    marks += crd*grade_values.get(grd);
                    total_credits += crd;
                }
            }          
        }
         cgpa = marks/total_credits;
         System.out.println("Your CGPA is: " + cgpa);
    }
    
}
