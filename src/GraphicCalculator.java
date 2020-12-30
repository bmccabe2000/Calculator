import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GraphicCalculator extends Application
{
	MemoryCalc Calculator = new MemoryCalc();
	TextField output = new TextField();
    //Overriding the start function of application
    @Override
    public void start (Stage primaryStage)
    {
        //Setting up a grid pane of calculator buttons and the output field
    	//These are organized by an overlaying border pane
        GridPane pane = new GridPane();
        BorderPane orgPane = new BorderPane();
        
        //Creating output at top of calculator
        output.setPrefWidth(100);
        orgPane.setTop(output);
        output.setAlignment(Pos.CENTER_LEFT);
        Font outputFont = Font.font("mono-spaced", FontWeight.BOLD, 20);
        output.setFont(outputFont);
        output.setEditable(false);
        
        //Creating buttons
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btnDivide = new Button("/");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btnMultiply = new Button("*");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btnSubtract = new Button("-");
        Button btnClear = new Button("C");
        Button btn0 = new Button("0");
        Button btnDot = new Button(".");
        Button btnAdd = new Button("+");
        
        //Creating grid
        pane.add(btn7, 0, 1);
        pane.add(btn8, 1, 1);
        pane.add(btn9, 2, 1);
        pane.add(btnDivide, 3, 1);
        pane.add(btn4, 0, 2);
        pane.add(btn5, 1, 2);
        pane.add(btn6, 2, 2);
        pane.add(btnMultiply, 3, 2);
        pane.add(btn1, 0, 3);
        pane.add(btn2, 1, 3);
        pane.add(btn3, 2, 3);
        pane.add(btnSubtract, 3, 3);
        pane.add(btnClear, 0, 4);
        pane.add(btn0, 1, 4);
        pane.add(btnDot, 2, 4);
        pane.add(btnAdd, 3, 4);
        orgPane.setCenter(pane);
        pane.setAlignment(Pos.CENTER);
        pane.setMaxWidth(Double.MAX_VALUE);
        
        //Creating the stretched equals button
        Button equalsBtn = new Button("=");
        equalsBtn.setMaxWidth(Double.MAX_VALUE);
        equalsBtn.setAlignment(Pos.CENTER);
        orgPane.setBottom(equalsBtn);
        
        //Creating handlers
        DigitHandler handler1 = new DigitHandler();
        OperatorHandler handler2 = new OperatorHandler();
        ClearHandler handler3 = new ClearHandler();
        EqualsHandler handler4 = new EqualsHandler();
        
        
        //Setting handlers
        btnDot.setOnAction(handler1);
        btn9.setOnAction(handler1);
        btn8.setOnAction(handler1);
        btn7.setOnAction(handler1);
        btn6.setOnAction(handler1);
        btn5.setOnAction(handler1);
        btn4.setOnAction(handler1);
        btn3.setOnAction(handler1);
        btn2.setOnAction(handler1);
        btn1.setOnAction(handler1);
        btn0.setOnAction(handler1);
        btnAdd.setOnAction(handler2);
        btnSubtract.setOnAction(handler2);
        btnMultiply.setOnAction(handler2);
        btnDivide.setOnAction(handler2);
        btnClear.setOnAction(handler3);
        equalsBtn.setOnAction(handler4);

        //Creating a scene and assigning it to the main stage
        Scene scene = new Scene(orgPane);
        primaryStage.setTitle("Graphic Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        


    }
    //Handler for digit and dot input, will edit either the current or second value based on if an operator has been selected
    class DigitHandler implements EventHandler<ActionEvent>
    {
    	public void handle(ActionEvent e)
    	{
    		if(Calculator.isOperatorPressed() == false)
    		{
    			String digit = ((Button)e.getSource()).getText();
        		Calculator.setCurrentValueString(Calculator.getCurrentValueString() + digit);
        		output.setText(Calculator.getCurrentValueString());
    		}
    		else
    		{
    			String digit = ((Button)e.getSource()).getText();
        		Calculator.setSecondValueString(Calculator.getSecondValueString() + digit);
        		output.setText(Calculator.getSecondValueString());
    		}
    		
    	}
    }
    
    class OperatorHandler implements EventHandler<ActionEvent>
    {
    	public void handle(ActionEvent e)
    	{
    		Calculator.setOperandType(((Button)e.getSource()).getText());
    		Calculator.ConvertToCurrentValue();
    		Calculator.setOperatorPressed(true);
    	}
    }
    
    class ClearHandler implements EventHandler<ActionEvent>
    {
    	public void handle(ActionEvent e)
    	{
    		Calculator.clear();
    		output.setText(Calculator.getCurrentValueString());
    	}
    }
    
    class EqualsHandler implements EventHandler<ActionEvent>
    {
    	public void handle(ActionEvent e)
    	{
    		Calculator.ConvertToSecondValue();
    		String operator = Calculator.getOperandType();
    		
    		switch(operator)
    		{
    		case("+"):
    			Calculator.add();
    			break;
    		case("-"):
    			Calculator.subtract();
    			break;
    		case("*"):
    			Calculator.multiply();
    			break;
    		case("/"):
    			Calculator.divide();
    			break;
    		}
    		
    		output.setText(Calculator.getCurrentValueString());
    		Calculator.setOperatorPressed(false);
    	}
    }

    public static void main(String[] args)
    {
    	
        launch(args);
    }

}
