package com.exercise.domain;
import java.sql.Date;

public class Desk {
	private int id;
	private String name;
	private Date production_date;
	private int height;
	private int width;
	private int thickness;
	private boolean are_legs_removable;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getThickness() {
        return thickness;
    }

    public boolean isAre_legs_removable() {
        return are_legs_removable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setAre_legs_removable(boolean are_legs_removable) {
        this.are_legs_removable = are_legs_removable;
    }
}
