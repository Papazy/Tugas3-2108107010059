package com.example.userform;

public class MahasiswaModal {
    private String nama;
    private String NIM;
    private String Jurusan;

    public MahasiswaModal(String nama, String NIM, String jurusan) {
        this.nama = nama;
        this.NIM = NIM;
        Jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getJurusan() {
        return Jurusan;
    }

    public void setJurusan(String jurusan) {
        Jurusan = jurusan;
    }
}
