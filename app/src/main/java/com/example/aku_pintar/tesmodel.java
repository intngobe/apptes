package com.example.aku_pintar;

public class tesmodel {
    private int Id;
    private String nm_univ;
    private String akreditas;
    private String status;


    public tesmodel(int kd_univ, String nm_univ, String akreditas, String status) {
        this.Id = kd_univ;
        this.nm_univ = nm_univ;
        this.akreditas = akreditas;
        this.status = status;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }

    public String getNamaUniversitas() {
        return nm_univ;
    }
    public void setNamaUniversitas(String nm_univ) {
        this.nm_univ = nm_univ;
    }

    public String getAkreditas() {
        return akreditas;
    }
    public void setAkreditas(String akreditas) {
        this.akreditas = akreditas;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }




}
