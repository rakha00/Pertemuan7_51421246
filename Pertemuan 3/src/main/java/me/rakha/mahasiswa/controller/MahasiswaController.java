/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.rakha.mahasiswa.controller;

import me.rakha.mahasiswa.model.MahasiswaDAO;
import me.rakha.mahasiswa.model.ModelMahasiswa;
import java.util.List;
/**
 *
 * @author rkhdi
 */
public class MahasiswaController {
    private MahasiswaDAO mahasiswaDAO;
    
    public MahasiswaController(MahasiswaDAO mahasiswaDAO) {
        this.mahasiswaDAO = mahasiswaDAO;
    }
    
    public void displayMahasiswaList(List<ModelMahasiswa> mahasiswaList) {
        if(mahasiswaList.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa");
        } else {
            System.out.println("");
            System.out.println("======================");
            for(ModelMahasiswa m: mahasiswaList) {
                System.out.println("ID          : " + m.getId());
                System.out.println("NAMA        : " + m.getNama());
                System.out.println("NPM         : " + m.getNpm());
                System.out.println("SEMESTER    : " + m.getSemester());
                System.out.println("IPK         : " + m.getIpk());
                System.out.println("======================");
            }
        }
    }
    
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    public void checkDatabaseConnection() {
        boolean isConnected = mahasiswaDAO.checkConnection();
        if(isConnected) {
            displayMessage("Koneksi ke db berhasil");
        } else {
            displayMessage("Koneksi DB Gagal");
        }
    }
    
    public void displayAllMahasiswa() {
        List<ModelMahasiswa> mahasiswaList = mahasiswaDAO.getAllMahasiswa();
        displayMahasiswaList(mahasiswaList);
    }
    
    public void addMahasiswa(String nama, String npm, int semester, float ipk){
        ModelMahasiswa mahasiswaBaru = new ModelMahasiswa(0, nama, npm, semester, ipk);
        System.out.println("Controller Data : " + nama + npm + semester + ipk);
        System.out.println(mahasiswaBaru);
        mahasiswaDAO.addMahasiswa(mahasiswaBaru);
        displayMessage("Mahasiswa berhasil ditambahkan");
    }
    
    public void updateMahasiswa(int id, String nama, String npm, int semester, float ipk){
        ModelMahasiswa mahasiswaBaru = new ModelMahasiswa(id, nama, npm, semester, ipk);
        mahasiswaDAO.updateMahasiswa(mahasiswaBaru);
        displayMessage("Mahasiswa berhasil diperbarui");
    }
    
    public void deleteMahasiswa(int id){
        mahasiswaDAO.deleteMahasiswa(id);
        displayMessage("Mahasiswa berhasil dihapus!");
    }
    
    public void closeConnection() {
        mahasiswaDAO.closeConnection();
    }
}
