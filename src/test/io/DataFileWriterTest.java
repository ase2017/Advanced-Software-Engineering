package test.io;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import main.io.DataFileWriter;
import main.items.TaxiData;

public class DataFileWriterTest {

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

        assertTrue(fileWriterObject.writeFile1(taxiDataTest) );
        assertTrue(fileWriterObject.writeFile2(taxiDataTest) );
        assertTrue(fileWriterObject.writeFile3(taxiDataTest) );
    }


    @Test(expected = NullPointerException.class)
    public void ioFailure() throws NullPointerException, IOException {

        assertFalse(fileWriterObject.writeFile1(null));
        assertFalse(fileWriterObject.writeFile2(null));
        assertFalse(fileWriterObject.writeFile3(null));
    }


}