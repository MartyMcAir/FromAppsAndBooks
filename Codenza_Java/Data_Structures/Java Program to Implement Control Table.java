/*This Java program is to implement control table. Control tables are tables that control the control flow or play a major part in program control. There are no rigid rules about the structure or content of a control table—its qualifying attribute is its ability to direct control flow in some way through “execution” by a processor or interpreter. The design of such tables is sometimes referred to as table-driven design.
In perhaps its simplest implementation, a control table may sometimes be a one-dimensional table for directly translating a raw data value to a corresponding subroutine offset, index or pointer using the raw data value either directly as the index to the array, or by performing some basic arithmetic on the data beforehand.*/

import java.util.HashMap;
import java.util.Map;

public class ControlTable
{
    private Map<String,Integer> controlTable;

    public ControlTable()
    {
        controlTable = new HashMap<String,Integer>();
        populateTable();
    }

    public int[] controlTable(int[] asciiCodes)
    {
        int[] index = new int[asciiCodes.length];
        for (int val = 0; val < asciiCodes.length; val++)
            {
                index[val] = controlTable.get(Integer.toHexString(asciiCodes[val]));
            }
        return index;
    }

    private void populateTable()
    {
        controlTable.put(Integer.toHexString(65), 01);
        controlTable.put(Integer.toHexString(68), 04);
        controlTable.put(Integer.toHexString(77), 03);
        controlTable.put(Integer.toHexString(83), 02);
    }

    public static void main (String...arg)
    {
        int[] asciiCodes = new int[4];
        int[] tableOutput;
        asciiCodes [0] = (int) 'A';
        asciiCodes [1] = (int) 'D';
        asciiCodes [2] = (int) 'M';
        asciiCodes [3] = (int) 'S';
        ControlTable controlTable = new ControlTable();
        tableOutput = controlTable.controlTable(asciiCodes);
        System.out.println("Input values ");
        System.out.print("( ");
        for (int i = 0; i < asciiCodes.length; i++)
            {
                System.out.print((char)asciiCodes[i] + " ");
            }
        System.out.print(")\n");
        System.out.println("New Index from Control table");
        System.out.print("( ");
        for (int i = 0; i < tableOutput.length; i++)
            {
                System.out.print(tableOutput[i] + " ");
            }
        System.out.print(")");
    }
}

/*
Input values
( A D M S )
New Index from control table
( 1 4 3 2 )
