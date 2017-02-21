package test.items;

import main.exceptions.DuplicateIDException;
import main.items.Taxi;
import main.items.TaxiTreeMap;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class TaxiTreeMapTest {

    private String trueRegistrationNumber = "AA111AA";
    private String trueDriverName = "Jack Ko";
    private String trueBrandName = "Toyota";

    @Test(expected = NullPointerException.class)
    public void testAddNullTaxi(){

        TreeMap<String, Taxi> taxis = new TreeMap<String, Taxi>();
        Taxi tx = null;
        TaxiTreeMap txtmp = new TaxiTreeMap(taxis);
        txtmp.addTaxi(tx);

    }

    @Test
    public void testDuplicateKey(){

        final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(serialContent));

        TreeMap<String, Taxi> taxis = new TreeMap<String, Taxi>();
        TaxiTreeMap txtmp = new TaxiTreeMap(taxis);
        Taxi tx1 = new Taxi(trueRegistrationNumber, trueDriverName, trueBrandName);
        Taxi tx2 = new Taxi(trueRegistrationNumber, trueDriverName, trueBrandName);

        txtmp.addTaxi(tx1);
        txtmp.addTaxi(tx2);

        assertEquals("Error! Duplicate item ID (in file taxis.txt in line: 0 ).\r\n",
                serialContent.toString());
    }
}
