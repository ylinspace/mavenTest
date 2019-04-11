package org.cute;

import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String [] args) throws Exception {

        Date dd = new Date( 1554511684000L);

        System.out.println(dd);

        Calendar c = Calendar.getInstance();
        c.setTime(dd);

        c.add(Calendar.HOUR_OF_DAY,-12);

        Date start = c.getTime();

        c.add(Calendar.HOUR_OF_DAY,24);
        Date end = c.getTime();


        System.out.println("start"+start+";end"+end);
    }

}
