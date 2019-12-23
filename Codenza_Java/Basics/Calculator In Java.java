Calculator In Java

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class CalculatorApplet extends Applet implements ActionListener
{
private Button keysArray[];
private Panel keyPad;
private TextField lcdField;
private double result;
private boolean first;
private boolean foundKey;
static boolean clearText;
private int prevOperator;

public void init()
{
  lcdField = new TextField(20);
  keyPad = new Panel ();
  keysArray = new Button[17];
  result = 0.0;
  prevOperator = 0;
  first = true;
  clearText = true;

  //Set frame layout manager setLayout(new BorderLayout());

  lcdField.setEditable(false);

  //Create buttons
  for (int i = 0; i <=9; i++)
   keysArray[i] = new Button(String.valueOf(i));
   keysArray[10] = new Button("/");
   keysArray[11] = new Button("*");
   keysArray[12] = new Button("-");
   keysArray[13] = new Button("+");
   keysArray[14] = new Button("=");
   keysArray[15] = new Button(".");
   keysArray[16] = new Button("CLR");

   //Set panel layout manager
   keyPad.setLayout(new GridLayout (4,4));

   //Add button to keyPad panel
   for (int i = 7; i <=10; i++) //adds Button 7,8,9, and divide to 
Panel
    keyPad.add(keysArray[i]);

   for (int i = 4; i <6; i++) //adds buttons 4,5,6 to Panel
    keyPad.add(keysArray[i]);

   keyPad.add(keysArray[11]); //adds multiply button to Panel

   for (int i = 1; i <= 3;i++) //adds buttons 1,2 and 3 to Panel
    keyPad.add(keysArray[i]);

   keyPad.add(keysArray[12]);//adds minus button to Panel

   keyPad.add(keysArray[0]); //adds 0 key to Panel

   for (int i = 15; i >=13; i--)
    keyPad.add(keysArray[i]); //adds decimal point, equal, and addition 
ke
ys Panel

    add(lcdField, BorderLayout.NORTH); //adds text field to top of 
Frame
    add(keyPad, BorderLayout.CENTER); //adds Panel to center of Frame
    add(keysArray[16], BorderLayout.EAST); //adds Clear key to right 
side
of applet

    for(int i = 0; i < keysArray.length; i++)
     keysArray[i].addActionListener(this);
 }

 public void actionPerformed(ActionEvent e)
 {
	  foundKey = false;

	  //Search for the key pressed
	  for (int i = 0; i < keysArray.length && !foundKey; i++)
	  if(e.getSource() == keysArray[i]) //key match found
	  {
		   foundKey = true;
		   switch(i)
		   {
		   case 0: case 1: case 2: case 3: case 4: //number buttons
		   case 5: case 6: case 7: case 8: case 9: //0-9
		   case 15:
		   if (clearText)
		   {
		   lcdField.setText("");
		   clearText = false;
		}
		lcdField.setText(lcdField.getText() +
		keysArray[i].getLabel());
		break;

		case 10:// divide button
		case 11:// multiply button
		case 12:// minus button
		case 13:// plus button
		case 14:// equal button
		  clearText = true;
		  if (first) // First operand
		  {
		  if(lcdField.getText().length()==0)
		   result = 0.0;
		  else
		   result = Double.valueOf(lcdField.getText()).doubleValue();

		first = false;
	               prevOperator = i; //save previous operator
		   }
		     else //second operand already enter, so calculator total
		     {
		 switch(prevOperator)
		 {
		 case 10: //divide Button
		  result /= Double.valueOf(lcdField.getText()).
		  doubleValue();
		break;
		case 11: //multiply Button
		result *= Double.valueOf(lcdField.getText()).
		doubleValue();
		break;
		case 12: //minus button
		result -= Double.valueOf(lcdField.getText()).
		doubleValue();
		break;
		case 13: //plus button
		result += Double.valueOf(lcdField.getText()).
		doubleValue();
		break;
		  }
		  lcdField.setText(Double.toString(result));
		  if (i==14)//equal button
		   first = true;
		  else
		   prevOperator = i; //save previous opetator
		   }
		   break;

		   case 16://Clear button
		   clearText = true;
		   first = true;
		   lcdField.setText("");
		   result = 0.0;
		   prevOperator = 0;
		   break;
		   }
		   }
	   }
   }
