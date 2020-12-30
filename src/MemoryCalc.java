import javax.swing.JOptionPane;

public class MemoryCalc {
    private double currentValue = 0.0;
    private String currentValueString = "0";
    private double secondValue = 0.0;
    private String secondValueString = "0";
	private String operandType = "";
	private boolean operatorPressed = false;

    public MemoryCalc() {
    }
    
    //Converts the current text string to a double for calculations
    public void ConvertToCurrentValue() throws NumberFormatException
    {
    	double tempCurrentValue = currentValue;
    	
    	try 
    	{
    		currentValue = Double.parseDouble(currentValueString);	
    	}
    	catch(Exception e)
    	{
    		currentValue = tempCurrentValue;
    		JOptionPane.showMessageDialog(null, "ERROR - IMPROPER FORMAT - VALUE SET TO 0");
    	}
    }
    
    //Converts the second text string to a double for calculations
    public void ConvertToSecondValue() throws NumberFormatException
    {
    	double tempSecondValue = secondValue;
    	
    	try 
    	{
    		secondValue = Double.parseDouble(secondValueString);	
    	}
    	catch(Exception e)
    	{
    		secondValue = tempSecondValue;
    		JOptionPane.showMessageDialog(null, "ERROR - IMPROPER FORMAT - VALUE SET TO 0");
    	}
    }
    
    public double getCurrentValue() 
    {
        return this.currentValue;
    }
    
    public void setCurrentValue(double currentValue)
    {
    	this.currentValue = currentValue;
    }
    
    public String getCurrentValueString() 
    {
        return this.currentValueString;
    }
    
    public void setCurrentValueString(String currentValue) 
   	{
   		this.currentValueString = currentValue;
   	}
    
    public double getSecondValue() 
    {
        return this.secondValue;
    }
    
    public void setSecondValue(double secondValue)
    {
    	this.secondValue = secondValue;
    }
    
    public String getSecondValueString() 
    {
        return this.secondValueString;
    }
    
    public void setSecondValueString(String secondValue) 
	{
		this.secondValueString = secondValue;
	}
    
	public String getOperandType() 
	{
		return operandType;
	}

	public void setOperandType(String operandType) 
	{
		this.operandType = operandType;
	}

    public void add() 
    {
        this.currentValue += secondValue;
        this.currentValueString = String.valueOf(currentValue);
        this.secondValueString = "";
    }

    public void subtract() 
    {
        this.currentValue -= secondValue;
        this.currentValueString = String.valueOf(currentValue);
        this.secondValueString = "";
    }

    public void multiply() 
    {
        this.currentValue *= secondValue;
        this.currentValueString = String.valueOf(currentValue);
        this.secondValueString = "";
    }

    public void divide() 
    {
        if (secondValue == 0.0) 
        {
            this.currentValue = Double.NaN;
        } 
        else 
        {
            this.currentValue /= secondValue;
        }
        this.currentValueString = String.valueOf(currentValue);
        this.secondValueString = "";

    }

    public void clear() 
    {
        this.currentValue = 0.0;
        this.currentValueString = "";
        this.secondValue = 0.0;
        this.secondValueString = "";
    }

	public boolean isOperatorPressed() 
	{
		return operatorPressed;
	}

	public void setOperatorPressed(boolean operatorPressed) 
	{
		this.operatorPressed = operatorPressed;
	}
}