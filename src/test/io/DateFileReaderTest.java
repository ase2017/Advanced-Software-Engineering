package test.io;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import main.exceptions.InvalidBrandNameException;
import main.exceptions.InvalidDestinationNameException;
import main.exceptions.InvalidDistanceException;
import main.exceptions.InvalidIDException;
import main.exceptions.InvalidInputArgumentsException;
import main.exceptions.InvalidMaximumVelocityException;
import main.exceptions.InvalidNumberOfPassengersException;
import main.exceptions.InvalidRegistrationNumberException;
import main.exceptions.InvalidTaxiNameException;
import main.exceptions.InvalidTimeException;
import main.exceptions.InvalidUrbanException;
import main.io.DataFileReader;

public class DateFileReaderTest {


    private String directoryNameLegal = "inputFiles/";
    private String testNameLegal = "testFiles/";
    private String filenameLegal = "taxis.txt";
    private String directoryNameIllegal = "NoDir/";
    private String filenameIllegal = "noFile.txt";
    private String filenameTaxiUnitTesting = "taxiTesting.txt";
    private String filenameLastYearDestTesting = "destin2016Testing.txt";
    private String filenameCurrentYearDestTesting = "destin2017Testing.txt";
    private String filenameJourneyTesting = "journeyTesting.txt";

    DataFileReader fileReaderObject = null;

    @Before
    public void loadFunc() {

        fileReaderObject = new DataFileReader();

    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();




    /***********************************************************************************************************************
     *
     * DataFileReader: Open the default file under the default directory.
     *
     ***********************************************************************************************************************/

    @Test
    public void ioSuccess() {

        assertNotNull( "Error: Return null object!", fileReaderObject.taxiChecker(directoryNameLegal, filenameLegal) );
    }


    /***********************************************************************************************************************
     *
     * DataFileReader: Fail to open file or to find the directory.
     *
     ***********************************************************************************************************************/

    @Test
    public void ioFailure() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.taxiChecker(testNameLegal, filenameIllegal);
        fileReaderObject.taxiChecker(testNameLegal, filenameLegal);
        fileReaderObject.taxiChecker(testNameLegal, filenameIllegal);

        assertEquals("\t --File: noFile.txt failed to open. [ testFiles\\noFile.txt (The system cannot find the file specified) ].\r\n"
                        + "\t --File: taxis.txt failed to open. [ testFiles\\taxis.txt (The system cannot find the file specified) ].\r\n"
                        + "\t --File: noFile.txt failed to open. [ testFiles\\noFile.txt (The system cannot find the file specified) ].\r\n"
                , serialContent.toString());

    }




    /***********************************************************************************************************************
     *
     * DataFileReader: T A X I Unit Testing
     *
     ***********************************************************************************************************************/

    @Test
    public void ioTestingTaxi() {

        assertNotNull( "File: " + filenameLastYearDestTesting + ". Error: Return null object!",
                fileReaderObject.taxiChecker(testNameLegal, filenameTaxiUnitTesting) );

    }



    @Test
    public void invalidBrandNameTaxi() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.taxiChecker(testNameLegal, filenameTaxiUnitTesting);

        assertEquals("Error! Wrong car`s brand (in file taxiTesting.txt in line: 3 ).\r\n"
                + "Error! Wrong driver`s name (in file taxiTesting.txt in line: 4 ).\r\n"
                + "Error! Wrong registration number (in file taxiTesting.txt in line: 5 ).\r\n"
                + "Error! The input arguments are invalid (in file taxiTesting.txt in line: 6 ).\r\n"
                , serialContent.toString());

    }


    @Test
    public void invalidDriverNameTaxi()  {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.taxiChecker(testNameLegal, filenameTaxiUnitTesting);

        assertEquals("Error! Wrong car`s brand (in file taxiTesting.txt in line: 3 ).\r\n"
                        + "Error! Wrong driver`s name (in file taxiTesting.txt in line: 4 ).\r\n"
                        + "Error! Wrong registration number (in file taxiTesting.txt in line: 5 ).\r\n"
                        + "Error! The input arguments are invalid (in file taxiTesting.txt in line: 6 ).\r\n"
                , serialContent.toString());
    }

    @Test
    public void invalidRegistrationNumberTaxi() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.taxiChecker(testNameLegal, filenameTaxiUnitTesting);

        assertEquals("Error! Wrong car`s brand (in file taxiTesting.txt in line: 3 ).\r\n"
                        + "Error! Wrong driver`s name (in file taxiTesting.txt in line: 4 ).\r\n"
                        + "Error! Wrong registration number (in file taxiTesting.txt in line: 5 ).\r\n"
                        + "Error! The input arguments are invalid (in file taxiTesting.txt in line: 6 ).\r\n"
                , serialContent.toString());
    }

    @Test
    public void invalidNumberOfArgsTaxi() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.taxiChecker(testNameLegal, filenameTaxiUnitTesting);

        assertEquals("Error! Wrong car`s brand (in file taxiTesting.txt in line: 3 ).\r\n"
                        + "Error! Wrong driver`s name (in file taxiTesting.txt in line: 4 ).\r\n"
                        + "Error! Wrong registration number (in file taxiTesting.txt in line: 5 ).\r\n"
                        + "Error! The input arguments are invalid (in file taxiTesting.txt in line: 6 ).\r\n"
                , serialContent.toString());
    }



    /***********************************************************************************************************************
     *
     * DataFileReader: Last's Year DESTINATION Unit Testing.
     *
     ***********************************************************************************************************************/

    @Test
    public void ioTestingLastYearDestination() {


        assertNotNull( "File: " + filenameLastYearDestTesting + ". Error: Return null object!",
                fileReaderObject.destination2016Checker(testNameLegal, filenameLastYearDestTesting) );

    }

    @Test
    public void invalidDestNameDestination2016() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.destination2016Checker(testNameLegal, filenameLastYearDestTesting);

        assertEquals("Error! The input arguments are invalid (in file destin2016Testing.txt in line: 3 ).\r\n"
                        + "Error! The input arguments are invalid (in file destin2016Testing.txt in line: 4 ).\r\n"
                , serialContent.toString());

    }

    @Test
    public void invalidNumOfArgsDestination2016(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.destination2016Checker(testNameLegal, filenameLastYearDestTesting);

        assertEquals("Error! The input arguments are invalid (in file destin2016Testing.txt in line: 3 ).\r\n"
                        + "Error! The input arguments are invalid (in file destin2016Testing.txt in line: 4 ).\r\n"
                , serialContent.toString());
    }

    @Test
    public void outOfBoundsDestination2016() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.destination2016Checker(testNameLegal, filenameLastYearDestTesting);

        assertEquals("Error! The input arguments are invalid (in file destin2016Testing.txt in line: 3 ).\r\n"
                        + "Error! The input arguments are invalid (in file destin2016Testing.txt in line: 4 ).\r\n"
                , serialContent.toString());

    }


    /***********************************************************************************************************************
     *
     * DataFileReader: Current's Year DESTINATION Unit Testing.
     *
     ***********************************************************************************************************************/

    @Test
    public void ioTestingCurrentYearDestination() {


        assertNotNull( "File: " + filenameLastYearDestTesting + ". Error: Return null object!",
                fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting) );

    }

    @Test
    public void invalidIDDestination2017() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        assertEquals("Error! Invalid record`s ID (in file destin2017Testing.txt in line: 2 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! The input arguments are invalid (in file destin2017Testing.txt in line: 4 ).\r\n"
                        + "Error! The name of the destination is invalid (in file destin2017Testing.txt in line: 5 ).\r\n"
                        + "Error! The distance is not in the correct range (in file destin2017Testing.txt in line: 6 ).\r\n"
                        + "Error! Wrong urban identifier (in file destin2017Testing.txt in line: 7 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"XYZ\" ].\r\n"
                , serialContent.toString());
    }

    @Test
    public void integerConvertionDestination2017(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        assertEquals("Error! Invalid record`s ID (in file destin2017Testing.txt in line: 2 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! The input arguments are invalid (in file destin2017Testing.txt in line: 4 ).\r\n"
                        + "Error! The name of the destination is invalid (in file destin2017Testing.txt in line: 5 ).\r\n"
                        + "Error! The distance is not in the correct range (in file destin2017Testing.txt in line: 6 ).\r\n"
                        + "Error! Wrong urban identifier (in file destin2017Testing.txt in line: 7 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"XYZ\" ].\r\n"
                , serialContent.toString());

    }

    @Test
    public void invalidNumOfArgsDestination2017() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        assertEquals("Error! Invalid record`s ID (in file destin2017Testing.txt in line: 2 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! The input arguments are invalid (in file destin2017Testing.txt in line: 4 ).\r\n"
                        + "Error! The name of the destination is invalid (in file destin2017Testing.txt in line: 5 ).\r\n"
                        + "Error! The distance is not in the correct range (in file destin2017Testing.txt in line: 6 ).\r\n"
                        + "Error! Wrong urban identifier (in file destin2017Testing.txt in line: 7 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"XYZ\" ].\r\n"
                , serialContent.toString());
    }

    @Test
    public void invalidDestNameDestination2017() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        assertEquals("Error! Invalid record`s ID (in file destin2017Testing.txt in line: 2 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! The input arguments are invalid (in file destin2017Testing.txt in line: 4 ).\r\n"
                        + "Error! The name of the destination is invalid (in file destin2017Testing.txt in line: 5 ).\r\n"
                        + "Error! The distance is not in the correct range (in file destin2017Testing.txt in line: 6 ).\r\n"
                        + "Error! Wrong urban identifier (in file destin2017Testing.txt in line: 7 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"XYZ\" ].\r\n"
                , serialContent.toString());
    }

    @Test
    public void invalidDistanceDestination2017() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        assertEquals("Error! Invalid record`s ID (in file destin2017Testing.txt in line: 2 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! The input arguments are invalid (in file destin2017Testing.txt in line: 4 ).\r\n"
                        + "Error! The name of the destination is invalid (in file destin2017Testing.txt in line: 5 ).\r\n"
                        + "Error! The distance is not in the correct range (in file destin2017Testing.txt in line: 6 ).\r\n"
                        + "Error! Wrong urban identifier (in file destin2017Testing.txt in line: 7 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"XYZ\" ].\r\n"
                , serialContent.toString());
    }

    @Test
    public void invalidUrbanDestination2017() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        assertEquals("Error! Invalid record`s ID (in file destin2017Testing.txt in line: 2 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! The input arguments are invalid (in file destin2017Testing.txt in line: 4 ).\r\n"
                        + "Error! The name of the destination is invalid (in file destin2017Testing.txt in line: 5 ).\r\n"
                        + "Error! The distance is not in the correct range (in file destin2017Testing.txt in line: 6 ).\r\n"
                        + "Error! Wrong urban identifier (in file destin2017Testing.txt in line: 7 ).\r\n"
                        + "\t --Not a number exception in file: destin2017Testing.txt [ For input string: \"XYZ\" ].\r\n"
                , serialContent.toString());
    }


    /***********************************************************************************************************************
     *
     * DataFileReader: J O U R N E Y Unit Testing.
     *
     ***********************************************************************************************************************/

    @Test
    public void ioTestingJourney() {


        assertNotNull( "File: " + filenameLastYearDestTesting + ". Error: Return null object!",
                fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting) );

    }

    @Test
    public void invalidNumOfArgsJourney() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        assertEquals("Error! The input arguments are invalid (in file journeyTesting.txt in line: 3 ).\r\n"
                        + "Error! Invalid record`s ID (in file journeyTesting.txt in line: 4 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! Wrong registration number (in file journeyTesting.txt in line: 6 ).\r\n"
                        + "Error! The time of the journey is not in the correct format (in file journeyTesting.txt in line: 7 ).\r\n"
                        + "Error! The number of passengers is not correct (in file journeyTesting.txt in line: 8 ).\r\n"
                        + "Error! The maximum velocity is not in the correct range (in file journeyTesting.txt in line: 9 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"G\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"H\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"J\" ].\r\n"
                , serialContent.toString());
    }

    @Test
    public void invalidIDJourney() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        assertEquals("Error! The input arguments are invalid (in file journeyTesting.txt in line: 3 ).\r\n"
                        + "Error! Invalid record`s ID (in file journeyTesting.txt in line: 4 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! Wrong registration number (in file journeyTesting.txt in line: 6 ).\r\n"
                        + "Error! The time of the journey is not in the correct format (in file journeyTesting.txt in line: 7 ).\r\n"
                        + "Error! The number of passengers is not correct (in file journeyTesting.txt in line: 8 ).\r\n"
                        + "Error! The maximum velocity is not in the correct range (in file journeyTesting.txt in line: 9 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"G\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"H\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"J\" ].\r\n"
                , serialContent.toString());
    }


    @Test
    public void invalidRegNumberJourney() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        assertEquals("Error! The input arguments are invalid (in file journeyTesting.txt in line: 3 ).\r\n"
                        + "Error! Invalid record`s ID (in file journeyTesting.txt in line: 4 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! Wrong registration number (in file journeyTesting.txt in line: 6 ).\r\n"
                        + "Error! The time of the journey is not in the correct format (in file journeyTesting.txt in line: 7 ).\r\n"
                        + "Error! The number of passengers is not correct (in file journeyTesting.txt in line: 8 ).\r\n"
                        + "Error! The maximum velocity is not in the correct range (in file journeyTesting.txt in line: 9 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"G\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"H\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"J\" ].\r\n"
                , serialContent.toString());

    }

    @Test
    public void invalidNumOfPassengersJourney() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        assertEquals("Error! The input arguments are invalid (in file journeyTesting.txt in line: 3 ).\r\n"
                        + "Error! Invalid record`s ID (in file journeyTesting.txt in line: 4 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! Wrong registration number (in file journeyTesting.txt in line: 6 ).\r\n"
                        + "Error! The time of the journey is not in the correct format (in file journeyTesting.txt in line: 7 ).\r\n"
                        + "Error! The number of passengers is not correct (in file journeyTesting.txt in line: 8 ).\r\n"
                        + "Error! The maximum velocity is not in the correct range (in file journeyTesting.txt in line: 9 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"G\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"H\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"J\" ].\r\n"
                , serialContent.toString());

    }

    @Test
    public void invalidTimeJourney() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        assertEquals("Error! The input arguments are invalid (in file journeyTesting.txt in line: 3 ).\r\n"
                        + "Error! Invalid record`s ID (in file journeyTesting.txt in line: 4 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! Wrong registration number (in file journeyTesting.txt in line: 6 ).\r\n"
                        + "Error! The time of the journey is not in the correct format (in file journeyTesting.txt in line: 7 ).\r\n"
                        + "Error! The number of passengers is not correct (in file journeyTesting.txt in line: 8 ).\r\n"
                        + "Error! The maximum velocity is not in the correct range (in file journeyTesting.txt in line: 9 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"G\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"H\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"J\" ].\r\n"
                , serialContent.toString());

    }


    @Test
    public void invalidMaxVelocityJourney() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        assertEquals("Error! The input arguments are invalid (in file journeyTesting.txt in line: 3 ).\r\n"
                        + "Error! Invalid record`s ID (in file journeyTesting.txt in line: 4 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! Wrong registration number (in file journeyTesting.txt in line: 6 ).\r\n"
                        + "Error! The time of the journey is not in the correct format (in file journeyTesting.txt in line: 7 ).\r\n"
                        + "Error! The number of passengers is not correct (in file journeyTesting.txt in line: 8 ).\r\n"
                        + "Error! The maximum velocity is not in the correct range (in file journeyTesting.txt in line: 9 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"G\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"H\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"J\" ].\r\n"
                , serialContent.toString());

    }

    @Test
    public void numberExceptionJourney() {

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        assertEquals("Error! The input arguments are invalid (in file journeyTesting.txt in line: 3 ).\r\n"
                        + "Error! Invalid record`s ID (in file journeyTesting.txt in line: 4 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"ABC\" ].\r\n"
                        + "Error! Wrong registration number (in file journeyTesting.txt in line: 6 ).\r\n"
                        + "Error! The time of the journey is not in the correct format (in file journeyTesting.txt in line: 7 ).\r\n"
                        + "Error! The number of passengers is not correct (in file journeyTesting.txt in line: 8 ).\r\n"
                        + "Error! The maximum velocity is not in the correct range (in file journeyTesting.txt in line: 9 ).\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"G\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"H\" ].\r\n"
                        + "\t --Number Format exception in file: journeyTesting.txt [ For input string: \"J\" ].\r\n"
                , serialContent.toString());
    }

}