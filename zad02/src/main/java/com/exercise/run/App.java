package com.exercise.run;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.exercise.domain.Desk;

import com.exercise.service.DeskManagerJDBC;

class App {
     public static void main(String[] args) {

//         try {
//
//             Desk d1 = new Desk();
////           d1.setId(1);
//             d1.setName("Bjoerk");
//
//             String startDate = "2008-08-22";
//             SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//             java.util.Date date = sdf1.parse(startDate);
//             java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//
//             d1.setProduction_date(sqlStartDate);
//
//
//             d1.setHeight(150000);
//             d1.setWidth(8000);
//             d1.setThickness(500);
//             d1.setAre_legs_removable(true);
//
//             DeskManagerJDBC dm = new DeskManagerJDBC();
//             dm.addDesk(d1);
//
//         }catch(ParseException pe){
//             pe.printStackTrace();
//         }



//         DeskManagerJDBC dm = new DeskManagerJDBC();
//             dm.deleteDesk(3);

        try{
             String startDate = "2018-01-01";
             SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
             java.util.Date date = sdf1.parse(startDate);
             java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

             DeskManagerJDBC dm = new DeskManagerJDBC();
             dm.updateDesk(4,"Brzoza",sqlStartDate, 20000, 8000, 600, false);
        }catch(ParseException pe){
            pe.printStackTrace();
        }


     }
 }