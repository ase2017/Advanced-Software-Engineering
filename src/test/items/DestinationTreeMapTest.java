package test.items;

import main.io.DataFileReader;
import main.items.*;
import main.exceptions.DuplicateIDException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.TreeMap;

public class DestinationTreeMapTest {

    private int trueDestinationID = 1;
    private String trueDestinationName = "Some Street";
    private double trueDistance = 24.2;
    private boolean trueUrban = true;

    @Test
    public void testAddDestination2017() throws DuplicateIDException{

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        TreeMap<Integer, Destination> destinations = new TreeMap<Integer, Destination>();
        Destination d1 = new Destination(trueDestinationID, trueDestinationName, trueDistance, trueUrban);
        Destination d2 = new Destination(trueDestinationID, trueDestinationName, trueDistance, trueUrban);
        DestinationTreeMap dtmp = new DestinationTreeMap(destinations);

        dtmp.addDestination2017(d1);
        dtmp.addDestination2017(d2);

        assertEquals("Error! Duplicate item ID (in file destinations_2017.txt in line: "
                + DataFileReader.line_counter + " ).\r\n", serialContent.toString());
    }
}
