package test.io;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import main.io.DataFileWriter;
import main.items.TaxiData;

public class DataFileWriterTest {


    //private String directoryNameLegal = "outputFiles/";
    //private String outputFile1 = "top-5.txt";
    //private String outputFile2 = "driver-Journeys.txt";
    //private String outputFile3 = "visited-Places.txt";

    TaxiData taxiDataTest = null;
    DataFileWriter fileWriterObject = null;


    @Before
    public void loadFunc() {

        taxiDataTest = new TaxiData();
        fileWriterObject = new DataFileWriter();

    }



    /***********************************************************************************************************************
     *
     * DataFileWriter: Open the default files under the default directory and fill them with data.
     *
     ***********************************************************************************************************************/

    @Test
    public void ioSuccess() {

        assertTrue( "Error: Return null object!", fileWriterObject.writeFile1(taxiDataTest) );
        assertTrue( "Error: Return null object!", fileWriterObject.writeFile2(taxiDataTest) );
        assertTrue( "Error: Return null object!", fileWriterObject.writeFile3(taxiDataTest) );
    }


    @Test(expected=NullPointerException.class)
    public void ioFailure() throws NullPointerException, IOException {

        assertFalse("Error: Return null object!", fileWriterObject.writeFile1(null));
        assertFalse("Error: Return null object!", fileWriterObject.writeFile2(null));
        assertFalse("Error: Return null object!", fileWriterObject.writeFile3(null));
    }


}