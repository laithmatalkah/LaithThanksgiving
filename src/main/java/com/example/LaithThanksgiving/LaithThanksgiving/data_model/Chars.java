package com.example.LaithThanksgiving.LaithThanksgiving.data_model;




import javax.persistence.*;

import java.util.Arrays;
import java.util.Random;



@Entity(name= "CHARACTERS")
public class Chars {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "CHARACTER_ID")
    private Long id;

    @Column (name="CHAR_NAME")
    private String name;


    @Column (name="CHARACTER_CLASS")
    private String charClass;

    @Column (name="INT")
    private int Int ;

    @Column (name="WIS")
    private int wis;

    @Column (name="CHA")
    private int cha;

    @Column(name="STR")
    private int str;

    @Column(name="DEX")
    private  int dex;

    @Column(name="CON")
    private int con;

    @Column(name="LOCATION")
    private int location;

    @Column(name="INVENTORY")
    private Object[] inventory;

    @Column(name="HITPOINTS")
    private int hitpoints;

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInt(int anInt) {

        this.Int = anInt;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setCon(int con) {
        this.con = (int)(Math.random()* (18-8)) +8;
    }

    public void setLocation(int location) {
        this.location = location;//(int)(Math.random()* (18-8)) +8;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = getCon()*2;
    }


    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getInt() {
        return Int;
    }

    public int getWis() {
        return wis;
    }

    public int getCha() {
        return cha;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getCon() {
        return con;
    }

    public int getLocation() {
        return location;
    }

    public int getHitpoints() {
        return hitpoints;
    }






}
