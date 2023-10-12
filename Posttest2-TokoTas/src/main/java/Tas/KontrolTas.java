package Tas;

import java.util.ArrayList;
import java.util.Scanner;

public class KontrolTas implements RepositoryTas {
    private ArrayList<Tas> dapatkanSemuaTas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void tambahTas(Tas tas) {
        dapatkanSemuaTas.add(tas);
    }

    @Override
    public Tas dapatkanTasById(int id) {
        for (Tas tas : dapatkanSemuaTas) {
            if (tas.getId() == id) {
                return tas;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Tas> dapatkanSemuaTas() {
        return new ArrayList<>(dapatkanSemuaTas);
    }

    @Override
    public boolean perbaruiTas(int ID, double hargaBaru) {
    for (int i = 0; i < dapatkanSemuaTas.size(); i++) {
        Tas tas = dapatkanSemuaTas.get(i);
        if (tas.getId() == ID) {
            tas.setHarga(hargaBaru);
            return true;
        }
    }
    return false;
}
    @Override
    public void hapusTas(int id) {
        // Implementasi penghapusan tas berdasarkan ID
        Tas tas = dapatkanTasById(id);
        dapatkanSemuaTas.remove(tas);
    }
    // Metode lainnya sesuai kebutuhan proyek
}
