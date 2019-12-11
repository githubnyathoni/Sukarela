package com.example.sukarela;

import java.io.Serializable;

public class RegistrasiOrganisasi implements Serializable {
    private String namadepan;
    private String namabelakang;
    private String email;
    private String nohp;
    private String password;
    private String konfirmasipassword;
    private String key;

    public RegistrasiOrganisasi(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNamadepan() {
        return namadepan;
    }

    public void setNamadepan(String namadepan) {
        this.namadepan = namadepan;
    }

    public String getNamabelakang() {
        return namabelakang;
    }

    public void setNamabelakang(String namabelakang) {
        this.namabelakang = namabelakang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKonfirmasipassword() {
        return konfirmasipassword;
    }

    public void setKonfirmasipassword(String konfirmasipassword) {
        this.konfirmasipassword = konfirmasipassword;
    }


    @Override
    public String toString() {
        return " "+namadepan+"\n" +
                " "+namabelakang+"\n" +
                " "+namadepan+"\n" +
                " "+email+"\n" +
                " "+nohp+"\n" +
                " "+password +"\n" +
                " "+konfirmasipassword;
    }

    public RegistrasiOrganisasi(String nmdp, String nmblk, String eml, String nop, String pas, String konpas){
        namadepan = nmdp;
        namabelakang = nmblk;
        email = eml;
        nohp = nop;
        password = pas;
        konfirmasipassword = konpas;

    }
}
