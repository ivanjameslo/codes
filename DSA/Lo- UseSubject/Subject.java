/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lo;

/**
 *
 * @author ijalo
 */
public class Subject {
    
    private final String subjectCode;
    private final int creditUnits;
        
    public Subject(String subjectCode, int creditUnits){
            this.subjectCode = subjectCode;
            this.creditUnits = creditUnits;
    }
        
    public String getSubjectCode(){
        return subjectCode;
    }
    
    public int getCreditUnits(){
        return creditUnits;
    }
   
}
