package com.example.sukarela;

import java.io.Serializable;

public class RegistrasiOrganisasi2 implements Serializable {
    private String namaorganisasi;
    private String jenisorganisasi;
    private String deskripsi;
    private String key;

    public RegistrasiOrganisasi2(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNamaorganisasi() {
        return namaorganisasi;
    }

    public void setNamaorganisasi(String namaorganisasi) {
        this.namaorganisasi = namaorganisasi;
    }

    public String getJenisorganisasi() {
        return jenisorganisasi;
    }

    public void setJenisorganisasi(String jenisorganisasi) {
        this.jenisorganisasi = jenisorganisasi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


    @Override
    public String toString() {
        return " "+namaorganisasi+"\n" +
                " "+jenisorganisasi +"\n" +
                " "+deskripsi;
    }

    public RegistrasiOrganisasi2(String nmorg, String jnsorg, String dsk){
        namaorganisasi = nmorg;
        jenisorganisasi = jnsorg;
        deskripsi = dsk;

    }
}
