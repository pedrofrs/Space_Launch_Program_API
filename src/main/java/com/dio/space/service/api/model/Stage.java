package com.dio.space.service.api.model;

public class Stage {
    private Thrust thrust_sea_level;
    private Thrust thrust_vacuum;
    private boolean reusable;
    private int engines;
    private int fuel_amount_tons;
    private int burn_time_sec;


    public Thrust getThrust_sea_level() {
        return thrust_sea_level;
    }

    public void setThrust_sea_level(Thrust thrust_sea_level) {
        this.thrust_sea_level = thrust_sea_level;
    }

    public Thrust getThrust_vacuum() {
        return thrust_vacuum;
    }

    public void setThrust_vacuum(Thrust thrust_vacuum) {
        this.thrust_vacuum = thrust_vacuum;
    }

    public boolean isReusable() {
        return reusable;
    }

    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

    public int getEngines() {
        return engines;
    }

    public void setEngines(int engines) {
        this.engines = engines;
    }

    public int getFuel_amount_tons() {
        return fuel_amount_tons;
    }

    public void setFuel_amount_tons(int fuel_amount_tons) {
        this.fuel_amount_tons = fuel_amount_tons;
    }

    public int getBurn_time_sec() {
        return burn_time_sec;
    }

    public void setBurn_time_sec(int burn_time_sec) {
        this.burn_time_sec = burn_time_sec;
    }

}