package com.exercise.service;
import com.exercise.domain.Desk;
import java.sql.Date;
import java.util.List;

public interface DeskManager {
        public int addDesk(Desk desk);
        public List<Desk> getAllDesks();
        public void clearDesks();
        public void deleteDesk(int id);
        public void updateDesk(int id, String name, Date production_date, int height,  int width,  int thickness,  boolean are_legs_removable);


        public List<Desk> findByHeight(int more_than);
        public List<Desk> getOrderByName(); // ascending order
        // all or none
        public void addAllDesks(List<Desk> desks);


}
