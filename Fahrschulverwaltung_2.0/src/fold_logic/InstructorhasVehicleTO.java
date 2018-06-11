/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fold_logic;

/**
 *
 * @author Fabian
 */
public class InstructorhasVehicleTO 
{
    private String CarID;
    private int InstructorID;
    
    public InstructorhasVehicleTO(String ID, int id)
    {
        CarID=ID;
        InstructorID=id;
        
    }
    public String getCarID()
    {
        return CarID;
    }
    
    public int getInstructorID ()
    {
        return InstructorID;
    }
    
    
}
