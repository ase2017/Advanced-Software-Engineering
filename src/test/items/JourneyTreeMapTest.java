package test.items;

import org.junit.Test;
import main.items.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;

public class JourneyTreeMapTest {

    private int trueDestinationID = 1;
    private String trueTaxiRegistrationNumber = "AA111AA";
    private int trueNumberOfPassengers = 2;
    private double trueTime = 10.2;
    private double trueMaximumVelocity = 20.2;

    @Test(expected = NullPointerException.class)
    public void testNullJourneyAddJourney(){

        TreeMap<String, ArrayList<Journey>> journeys = new TreeMap<String, ArrayList<Journey>>();
        JourneyTreeMap jtmp = new JourneyTreeMap(journeys);
        Journey jn = null;

        jtmp.addJourney(jn);
    }

    @Test(expected = NullPointerException.class)
    public void testNullArrayListAddJourney(){

        TreeMap<String, ArrayList<Journey>> journeys = new TreeMap<String, ArrayList<Journey>>();
        ArrayList<Journey> aj = new ArrayList<Journey>();
        aj = null;
        JourneyTreeMap jtmp = new JourneyTreeMap(journeys);

        jtmp.addJourney(aj);
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyArrayListAddJourney(){

        TreeMap<String, ArrayList<Journey>> journeys = new TreeMap<String, ArrayList<Journey>>();
        ArrayList<Journey> aj = new ArrayList<Journey>();
        JourneyTreeMap jtmp = new JourneyTreeMap(journeys);

        jtmp.addJourney(aj);
    }


}
