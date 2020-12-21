package ru.program;

import java.util.*;
import java.io.*;



class Conf {

    private String city;
    private Integer service;
    private Integer param;
    Properties p = new Properties();

    Conf() throws IOException {
        this.p.load(new FileInputStream("src/ru/program/config.ini"));
        this.city = this.p.getProperty("CITY");
        this.service = Integer.parseInt(this.p.getProperty("SERVICE"));
        this.param = Integer.parseInt(this.p.getProperty("PARAMETERS"));
    }


    public Integer getProp(int index) {
        ArrayList<Integer> ret = new ArrayList();
        ret.add(this.service);
        ret.add(this.param);

        return ret.get(index);
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String city) throws IOException {
        p.setProperty("CITY", city);
        p.setProperty("SERVICE", this.service.toString());
        p.setProperty("PARAMETERS", this.param.toString());
        this.setProp();
    }

    public void setService(Integer service) throws IOException {
        p.setProperty("CITY", this.city);
        p.setProperty("SERVICE", service.toString());
        p.setProperty("PARAMETERS", this.param.toString());
        this.setProp();
    }

    public void setParam(Integer param) throws IOException {
        p.setProperty("CITY", this.city);
        p.setProperty("SERVICE", this.service.toString());
        p.setProperty("PARAMETERS", param.toString());
        this.setProp();
    }

    public void setAll(String city, Integer service, Integer param) throws IOException {
        p.setProperty("CITY", city);
        p.setProperty("SERVICE", service.toString());
        p.setProperty("PARAMETERS", param.toString());
        this.setProp();
    }

    private void setProp() throws IOException {
        FileOutputStream s = new FileOutputStream(new File("src/ru/program/config.ini"));
        this.p.store(s, "Changing default parameters");
        s.close();
    }
}