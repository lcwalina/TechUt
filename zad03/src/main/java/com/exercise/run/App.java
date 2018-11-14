package com.exercise.run;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.exercise.domain.Desk;

import com.exercise.service.DeskManagerJDBC;

class App {
     public static void main(String[] args) {

//         try {
//
//             List<Desk> desks = new ArrayList<>();
//
//             Desk d1 = new Desk();
//             d1.setName("Adam");
//
//             String startDate = "2008-08-22";
//             SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//             java.util.Date date = sdf1.parse(startDate);
//             java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//             d1.setProduction_date(sqlStartDate);
//
//             d1.setHeight(110000);
//             d1.setWidth(8000);
//             d1.setThickness(500);
//             d1.setAre_legs_removable(true);
//
//             desks.add(d1);
//
//             Desk d2 = new Desk();
//             d2.setName("Adele");
//
//             startDate = "2018-08-23";
//             sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//             date = sdf1.parse(startDate);
//             sqlStartDate = new java.sql.Date(date.getTime());
//             d2.setProduction_date(sqlStartDate);
//
//             d2.setHeight(120000);
//             d2.setWidth(8000);
//             d2.setThickness(500);
//             d2.setAre_legs_removable(true);
//
//             desks.add(d2);
//
//
//             DeskManagerJDBC dm = new DeskManagerJDBC();
//             dm.addAllDesks(desks);
////             dm.addDesk(d2);
//
//         }catch(ParseException pe){
//             pe.printStackTrace();
//         }



//         DeskManagerJDBC dm = new DeskManagerJDBC();
//             dm.deleteDesk(3);

//        try{
//             String startDate = "2018-01-01";
//             SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//             java.util.Date date = sdf1.parse(startDate);
//             java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//
//             DeskManagerJDBC dm = new DeskManagerJDBC();
//             dm.updateDesk(4,"Brzoza",sqlStartDate, 20000, 8000, 600, false);
//        }catch(ParseException pe){
//            pe.printStackTrace();
//        }
//
//         List<Desk> desks = new ArrayList<>();
//         DeskManagerJDBC dm = new DeskManagerJDBC();
//         desks = dm.findByHeight(140000);
//
//         for (Desk desk : desks) {
//             System.out.println(desk.getName());
//         }

//         List<Desk> desks = new ArrayList<>();
//         DeskManagerJDBC dm = new DeskManagerJDBC();
//         desks = dm.getAllDesks();
//
//         for (Desk desk : desks) {
//             System.out.println(desk.getName());
//         }

         List<Desk> desks = new ArrayList<>();
         DeskManagerJDBC dm = new DeskManagerJDBC();
         desks = dm.getOrderByName();

         for (Desk desk : desks) {
             System.out.println(desk.getName());
         }

     }
 }