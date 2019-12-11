package com.example.sukarela;

import java.io.Serializable;

public class RegistrasiOrganisasi3 implements Serializable {

    private String kota;
    private String kabupaten;
    private String alamat;
    private String website;
    private String key;

    public RegistrasiOrganisasi3(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    @Override
    public String toString() {
        return " "+kota+"\n" +
                " "+kabupaten +"\n" +
                " "+alamat +"\n" +
                " "+website;
    }

    public RegistrasiOrganisasi3(String kot, String kab, String almt, String web){
        kota = kot;
        kabupaten = kab;
        alamat = almt;
        website = web;


    }
}
