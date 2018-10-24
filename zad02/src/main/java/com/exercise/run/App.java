package com.exercise.run;
import java.sql.SQLException;

import com.exercise.domain.Table;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        Table table = new Table();
        //table.createTablePerson();
        //table.addPerson("Krystyna", "Pikoń");
    	table.deleteAllPersons();
    	
    }
}
