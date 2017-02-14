package test.items;
import main.exceptions.DuplicateIDException;
import main.items.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TaxiDataTest{

    TaxiData taxiData;



    @Before
    public void setUp() {

        taxiData = new TaxiData();

        /* TAXIS */
        TreeMap<String,Taxi> taxis = new TreeMap<>();
        TaxiTreeMap taxiTreeMap = new TaxiTreeMap(taxis);

        taxiTreeMap.addTaxi(new Taxi("BR204SV","Eric Smith","Mercedes"));
        taxiTreeMap.addTaxi(new Taxi("CO367DG","Giovanni Campbell","Mercedes"));
        taxiTreeMap.addTaxi(new Taxi("AA743HE","Antonio Ivanov","Toyota"));
        taxiTreeMap.addTaxi(new Taxi("AC123UV","Alice Smith","Nissan"));
        taxiTreeMap.addTaxi(new Taxi("AC321RE","Nicholas Ivanov","Toyouta"));
        taxiTreeMap.addTaxi(new Taxi("zz999zz","Jack Hunter","Mercedes")); // taxi without journey

        taxiData.setTaxis(taxiTreeMap);

        /* ************************************************* */

        /* DESTINATIONS 2017 */
        TreeMap<Integer,Destination> destinations = new TreeMap<>();
        DestinationtTreeMap currentYearDestinations = new DestinationtTreeMap(destinations);
        try {
            currentYearDestinations.addDestination2017(new Destination(1, "Palace of Holyroodhouse", 2.9, false));
            currentYearDestinations.addDestination2017(new Destination(2, "Heriot Watt University", 10.3, true));
            currentYearDestinations.addDestination2017(new Destination(3, "National Museum of Scotland", 6.3, false));
            currentYearDestinations.addDestination2017(new Destination(4, "Edinburgh Airport", 3.6, true));
            currentYearDestinations.addDestination2017(new Destination(5, "NO JOURNEY", 3.6, true));
        } catch(DuplicateIDException e) {

        }

        taxiData.setCurrentYearDestinations(currentYearDestinations);

        /* ************************************************* */

        /* DESTINATIONS 2016 */
        TreeSet<Destination> lastYearDestinations = new TreeSet<>();
        DestinationTreeSet previousYearDestinations = new DestinationTreeSet(lastYearDestinations);

        previousYearDestinations.add(new Destination("Main Station"));
        previousYearDestinations.add(new Destination("Napier University"));
        previousYearDestinations.add(new Destination("Main Station"));
        previousYearDestinations.add(new Destination("BT Murrayfield Stadium"));

        taxiData.setPreviousYearDestinations(previousYearDestinations);


        /* ************************************************* */

        /* JOURNEYS */
        TreeMap<String,ArrayList<Journey>> journeys = new TreeMap<>();
        JourneyTreeMap journeyTreeMap = new JourneyTreeMap(journeys);

        journeyTreeMap.addJourney(new Journey(1,"BR204SV",2,15,43.4));
        journeyTreeMap.addJourney(new Journey(2,"BR204SV",3,33,52.3));
        journeyTreeMap.addJourney(new Journey(3,"CO367DG",2,21,39.1));
        journeyTreeMap.addJourney(new Journey(4,"BR204SV",1,8,60.7));
        journeyTreeMap.addJourney(new Journey(55555,"ZZ367ZZ",5,8,78.3)); // journey without destination. Index 4

        taxiData.setJourneys(journeyTreeMap);
    }


    @Test
    public void formatInfoLine() {

    }

    @Test
    public void formatJourneyFile() {

    }

    @Test
    public void formatTopJourneys() {

    }




    @Test
    public void calculateFeeTest() {

        // Testing : Journey is null
        Journey nullJourney = null;
        assertEquals(-1,taxiData.calculateFee(nullJourney),0.0);

        // Testing : Journey has a related Destination
        Journey journeyWithDestination = taxiData.getJourneys().getJourneys().get("BR204SV").get(0);
        assertEquals(82,taxiData.calculateFee(journeyWithDestination),0.0);

        // Testing : Journey does not have a related Destination
        Journey journeyWithoutDestination = taxiData.getJourneys().getJourneys().get("ZZ367ZZ").get(0);
        assertEquals(-1,taxiData.calculateFee(journeyWithoutDestination),0.0);
    }


    @Test
    public void calculateFee() {

    }

    @Test
    public void getJourneysByPrice() {

    }

    @Test
    public void findTaxi() {

    }

    @Test
    public void findDestination() {

    }

    @Test
    public void formatPlacesVisitedPerDriver() {

    }

    @Test
    public void sortTaxisByName() {

    }

    @Test
    public void findJourneys() {

    }

    @Test
    public void formatPlacesVisited() {

    }

    @Test
    public void formatCurrentYearVisitedPlaces() {

    }

    @Test
    public void formatPreviousYearVisitedPlaces() {

    }

    @Test
    public void formatPlacesVisitedInBothYears() {

    }



}
