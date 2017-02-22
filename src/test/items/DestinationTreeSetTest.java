package test.items;

import main.items.*;
import org.junit.Test;


import java.util.TreeSet;

/**
 * Class Name: DestinationTreeSetTest.java
 *
 * Description: This class includes JUnit tests for the class DestinationTreeSet.
 *
 * @author George Goniotakis
 * @since Feb 9, 2017
 */

public class DestinationTreeSetTest {

    private int trueDestinationID = 1; //Example of correct destination id
    private String trueDestinationName = "George Street"; //Example of correct destination name
    private double trueDistance = 22.1; //Example of correct distance
    private boolean trueUrban = true; //Example of correct urban identifier

    /**
     * This method tries to create a new DestinationTreeSet and push a null Destination in it.
     *
     * @exception NullPointerException
     */
    @Test
    public void checkNullDestinationName(){

        TreeSet<Destination> wrongTreeSet = new TreeSet<Destination>();
        DestinationTreeSet dtst = new DestinationTreeSet(wrongTreeSet);
        dtst.add(new Destination(null));

    }

    @Test
    public void testTrueCase(){

        TreeSet<Destination> wrongTreeSet = new TreeSet<Destination>();
        Destination dest = new Destination( trueDestinationID, trueDestinationName, trueDistance, trueUrban);
        wrongTreeSet.add(dest);
        //assertEquals(1, );
    }

}
