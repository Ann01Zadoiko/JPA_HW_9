package org.example;

import org.apache.log4j.Logger;
import org.example.data.service.OsbbList;
import org.example.data.service.Query;

import java.util.List;

public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        logger.info("The program has started!");

        Query query = new Query();
        List<OsbbList> osbbLists = query.getListOfOsbb();

        logger.info("List of osbb");
        for (OsbbList osbb : osbbLists){

            System.out.printf("%-10s %-12s : %-35s : %-27s : %d : %d%n",
                    osbb.getFirstName(), osbb.getLastName(), osbb.getEmail(), osbb.getAddress(),
                    osbb.getNumber(), osbb.getSqr());
        }

        query.close();

        logger.info("The program has finished");
    }
}
