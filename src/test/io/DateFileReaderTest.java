package test.io;
import static org.junit.Assert.*;
import java.io.IOException;
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

    @Test(expected=NullPointerException.class)
    public void ioFailure() throws IOException, NullPointerException {

        fileReaderObject.taxiChecker(testNameLegal, filenameIllegal);
        fileReaderObject.taxiChecker(testNameLegal, filenameLegal);
        fileReaderObject.taxiChecker(testNameLegal, filenameIllegal);

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
    public void invalidBrandNameTaxi() throws InvalidBrandNameException {

        exceptionRule.expect(InvalidBrandNameException.class);
        exceptionRule.expectMessage("Error! Wrong car`s brand");

        fileReaderObject.taxiChecker(testNameLegal, filenameTaxiUnitTesting);

        throw new InvalidBrandNameException(filenameTaxiUnitTesting, 0);
    }


    @Test
    public void invalidDriverNameTaxi() throws InvalidTaxiNameException {

        exceptionRule.expect(InvalidTaxiNameException.class);
        exceptionRule.expectMessage("Error! Wrong driver`s name");

        fileReaderObject.taxiChecker(testNameLegal, filenameTaxiUnitTesting);

        throw new InvalidTaxiNameException(filenameTaxiUnitTesting, 0);

    }

    @Test
    public void invalidRegistrationNumberTaxi() throws InvalidRegistrationNumberException {

        exceptionRule.expect(InvalidRegistrationNumberException.class);
        exceptionRule.expectMessage("Error! Wrong registration number");

        fileReaderObject.taxiChecker(testNameLegal, filenameTaxiUnitTesting);

        throw new InvalidRegistrationNumberException(filenameTaxiUnitTesting, 0);
    }

    @Test
    public void invalidNumberOfArgsTaxi() throws InvalidInputArgumentsException {

        exceptionRule.expect(InvalidInputArgumentsException.class);
        exceptionRule.expectMessage("Error! The input arguements are invalid");

        fileReaderObject.taxiChecker(testNameLegal, filenameTaxiUnitTesting);

        throw new InvalidInputArgumentsException(filenameTaxiUnitTesting, 0);
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
    public void invalidDestNameDestin2016() throws InvalidDestinationNameException {

        exceptionRule.expect(InvalidDestinationNameException.class);
        exceptionRule.expectMessage("Error! The name of the destination is invalid");

        fileReaderObject.destination2016Checker(testNameLegal, filenameLastYearDestTesting);

        throw new InvalidDestinationNameException(filenameLastYearDestTesting, 0);

    }

    @Test
    public void invalidNumOfArgsDestin2016() throws InvalidInputArgumentsException {

        exceptionRule.expect(InvalidInputArgumentsException.class);
        exceptionRule.expectMessage("Error! The input arguements are invalid");

        fileReaderObject.destination2016Checker(testNameLegal, filenameLastYearDestTesting);

        throw new InvalidInputArgumentsException(filenameLastYearDestTesting, 0);
    }

    @Test
    public void outOfBoundsDestin2016() throws ArrayIndexOutOfBoundsException {

        exceptionRule.expect(ArrayIndexOutOfBoundsException.class);
        exceptionRule.expectMessage("Array index out of range");

        fileReaderObject.destination2016Checker(testNameLegal, filenameLastYearDestTesting);

        throw new ArrayIndexOutOfBoundsException(0);

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
    public void invalidIDDest2017() throws InvalidIDException {

        exceptionRule.expect(InvalidIDException.class);
        exceptionRule.expectMessage("Error! Invalid record`s ID");

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        throw new InvalidIDException(filenameCurrentYearDestTesting, 0);
    }

    @Test
    public void integerConvertionDest2017() throws NumberFormatException {

        exceptionRule.expect(NumberFormatException.class);
        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        throw new NumberFormatException();
    }

    @Test
    public void invalidNumOfArgsDest2017() throws InvalidInputArgumentsException {

        exceptionRule.expect(InvalidInputArgumentsException.class);
        exceptionRule.expectMessage("Error! The input arguements are invalid");

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        throw new InvalidInputArgumentsException(filenameCurrentYearDestTesting, 0);
    }

    @Test
    public void invalidDestNameDest2017() throws InvalidDestinationNameException {

        exceptionRule.expect(InvalidDestinationNameException.class);
        exceptionRule.expectMessage("Error! The name of the destination is invalid");

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        throw new InvalidDestinationNameException(filenameCurrentYearDestTesting, 0);
    }

    @Test
    public void invalidDistanceDest2017() throws InvalidDistanceException {

        exceptionRule.expect(InvalidDistanceException.class);
        exceptionRule.expectMessage("Error! The distance is not in the correct range");

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        throw new InvalidDistanceException(filenameCurrentYearDestTesting, 0);
    }

    @Test
    public void invalidUrbanDest2017() throws InvalidUrbanException {

        exceptionRule.expect(InvalidUrbanException.class);
        exceptionRule.expectMessage("Error! Wrong urban area");

        fileReaderObject.destination2017Checker(testNameLegal, filenameCurrentYearDestTesting);

        throw new InvalidUrbanException(filenameCurrentYearDestTesting, 0);
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
    public void invalidNumOfArgsJourney() throws InvalidInputArgumentsException {

        exceptionRule.expect(InvalidInputArgumentsException.class);
        exceptionRule.expectMessage("Error! The input arguements are invalid");

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        throw new InvalidInputArgumentsException(filenameJourneyTesting, 0);
    }

    @Test
    public void invalidIDJourney() throws InvalidIDException {

        exceptionRule.expect(InvalidIDException.class);
        exceptionRule.expectMessage("Error! Invalid record`s ID");

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        throw new InvalidIDException(filenameJourneyTesting, 0);
    }

    @Test
    public void numberExceptionJourney() throws NumberFormatException {

        exceptionRule.expect(NumberFormatException.class);

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        throw new NumberFormatException();
    }

    @Test
    public void invalidRegNumberJourney() throws InvalidRegistrationNumberException {

        exceptionRule.expect(InvalidRegistrationNumberException.class);
        exceptionRule.expectMessage("Error! Wrong registration number");

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        throw new InvalidRegistrationNumberException(filenameJourneyTesting, 0);

    }

    @Test
    public void invalidNumOfPassengersJourney() throws InvalidNumberOfPassengersException {

        exceptionRule.expect(InvalidNumberOfPassengersException.class);
        exceptionRule.expectMessage("Error! The number of passengers is not correct");

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        throw new InvalidNumberOfPassengersException(filenameJourneyTesting, 0);

    }

    @Test
    public void invalidTimeJourney() throws InvalidTimeException {

        exceptionRule.expect(InvalidTimeException.class);
        exceptionRule.expectMessage("Error! The time of the journey is not in the correct format");

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        throw new InvalidTimeException(filenameJourneyTesting, 0);

    }


    @Test
    public void invalidMaxVelocityJourney() throws InvalidMaximumVelocityException {

        exceptionRule.expect(InvalidMaximumVelocityException.class);
        exceptionRule.expectMessage("Error! The maximum velocity is not in the correct range");

        fileReaderObject.journeyChecker(testNameLegal, filenameJourneyTesting);

        throw new InvalidMaximumVelocityException(filenameJourneyTesting, 0);

    }



}