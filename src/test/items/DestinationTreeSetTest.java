package test.items;

import main.items.*;
import org.junit.Test;


import java.util.TreeSet;

public class DestinationTreeSetTest {


    @Test(expected=NullPointerException.class)
    public void checkNullDestinationName(){

        TreeSet<Destination> wrongTreeSet = new TreeSet<Destination>();
        Destination dest = new Destination(null);
        wrongTreeSet.add(dest);

    }



}
