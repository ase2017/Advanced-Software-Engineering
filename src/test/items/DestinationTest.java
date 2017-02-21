package test.items;

import main.io.DataFileReader;
import main.items.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DestinationTest {

    private int trueDestinationID = 1;
    private String trueDestinationName = "George Street";
    private double trueDistance = 22.1;
    private boolean trueUrban = true;

    @Test
    public void testWrongDestinationID(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        int wrongDestinationID = 0;

        System.setOut(new PrintStream(serialContent));
        new Destination(wrongDestinationID, trueDestinationName, trueDistance, trueUrban);

        assertEquals("Error! Invalid record`s ID (in file destinations_2017.txt in line: "
                + DataFileReader.line_counter + " ).\r\n", serialContent.toString());

    }

    @Test
    public void testWrongLengthDestinationName2017(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        String wrongDestinationName = "Ab"; //Just checks if destination`s name is between 3 and 30 characters, other check will be implemented in DataFileReaderTest

        System.setOut(new PrintStream(serialContent));
        new Destination(trueDestinationID, wrongDestinationName, trueDistance, trueUrban);

        assertEquals("Error! The name of the destination is invalid (in file destinations_2017.txt in line: "
                + DataFileReader.line_counter + " ).\r\n", serialContent.toString());
    }


    @Test
    public void testNullDestinationName2017(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        String wrongDestinationName = null; //Just checks if driver`s name is between 3 and 30 characters, other check will be implemented in DataFileReaderTest

        System.setOut(new PrintStream(serialContent));
        new Destination(trueDestinationID, wrongDestinationName, trueDistance, trueUrban);

        assertEquals("Error! The name of the destination is invalid (in file destinations_2017.txt in line: "
                        + DataFileReader.line_counter + " ).\r\n", serialContent.toString());
    }

    @Test
    public void testWrongRangeDistance(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        int wrongDistance = -1; //Just checks if driver`s name is between 3 and 30 characters, other check will be implemented in DataFileReaderTest

        System.setOut(new PrintStream(serialContent));
        new Destination(trueDestinationID, trueDestinationName, wrongDistance, trueUrban);

        assertEquals("Error! The distance is not in the correct range (in file destinations_2017.txt in line: "
                + DataFileReader.line_counter + " ).\r\n", serialContent.toString());

    }

    @Test
    public void testWrongLengthDestinationName2016(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        String wrongDestinationName = "Ab"; //Just checks if destination`s name is between 3 and 30 characters, other check will be implemented in DataFileReaderTest

        System.setOut(new PrintStream(serialContent));
        new Destination(wrongDestinationName);

        assertEquals("Error! The name of the destination is invalid (in file destinations_2016.txt in line: 0 ).\r\n",
                serialContent.toString());
    }


    @Test
    public void testNullDestinationName2016(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        String wrongDestinationName = null; //Just checks if driver`s name is between 3 and 30 characters, other check will be implemented in DataFileReaderTest

        System.setOut(new PrintStream(serialContent));
        new Destination(wrongDestinationName);

        assertEquals("Error! The name of the destination is invalid (in file destinations_2016.txt in line: 0 ).\r\n",
                serialContent.toString());
    }

}
