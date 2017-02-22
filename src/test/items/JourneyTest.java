package test.items;

import main.io.DataFileReader;
import main.items.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JourneyTest {

    /*
    public Journey(int destinationID, String taxiRegistrationNumber,
                   int numberOfPassengers, double time, double maximumVelocity)
    */

    private int trueDestinationID = 1;
    private String trueTaxiRegistrationNumber = "AA111AA";
    private int trueNumberOfPassengers = 2;
    private double trueTime = 11;
    private double trueMaximumVelocity = 10;

    @Test
    public void testWrongDestinationID(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        int wrongDestinationID = 0;

        System.setOut(new PrintStream(serialContent));
        new Journey(wrongDestinationID, trueTaxiRegistrationNumber, trueNumberOfPassengers,
                trueTime, trueMaximumVelocity);

        assertEquals("Error! Invalid record`s ID (in file journeys.txt in line: "
                + DataFileReader.line_counter + " ).\r\n", serialContent.toString());
    }

    @Test
    public void testWrongLengthRegistrationNumber(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        String wrongRegistrationNumber = "A1A";

        System.setOut(new PrintStream(serialContent));
        new Journey(trueDestinationID, wrongRegistrationNumber, trueNumberOfPassengers,
                trueTime, trueMaximumVelocity);

        assertEquals("Error! Wrong registration number (in file journeys.txt in line: "
                + DataFileReader.line_counter + " ).\r\n", serialContent.toString());
    }

    @Test
    public void testWrongPatternRegistrationNumber(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        String wrongRegistrationNumber = "AA1A";

        System.setOut(new PrintStream(serialContent));
        Journey jn = null;

        assertEquals(jn, new Journey(trueDestinationID, wrongRegistrationNumber, trueNumberOfPassengers,
                trueTime, trueMaximumVelocity));

    }

    @Test
    public void testWrongPassengerNumber(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        int wrongNumberOfPassengers = 0;

        System.setOut(new PrintStream(serialContent));
        new Journey(trueDestinationID, trueTaxiRegistrationNumber, wrongNumberOfPassengers,
                trueTime, trueMaximumVelocity);

        assertEquals("Error! The number of passengers is not correct (in file journeys.txt in line: "
                + DataFileReader.line_counter + " ).\r\n", serialContent.toString());
    }

    @Test
    public void testWrongTime(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        int wrongTime = 0;

        System.setOut(new PrintStream(serialContent));
        new Journey(trueDestinationID, trueTaxiRegistrationNumber, trueNumberOfPassengers,
                wrongTime, trueMaximumVelocity);

        assertEquals("Error! The time of the journey is not in the correct format " +
                        "(in file journeys.txt in line: " + DataFileReader.line_counter + " ).\r\n", serialContent.toString());
    }

    @Test
    public void testWrongMaximumVelocity(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        int wrongMaximumVelocity = -1;

        System.setOut(new PrintStream(serialContent));
        new Journey(trueDestinationID, trueTaxiRegistrationNumber, trueNumberOfPassengers,
                trueTime, wrongMaximumVelocity);

        assertEquals("Error! The maximum velocity is not in the correct range " +
                "(in file journeys.txt in line: " + DataFileReader.line_counter + " ).\r\n", serialContent.toString());
    }
}
