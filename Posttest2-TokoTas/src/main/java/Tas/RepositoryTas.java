package Tas;

import java.util.ArrayList;

public interface RepositoryTas {
    void tambahTas(Tas tas);
    Tas dapatkanTasById(int id);
    ArrayList<Tas> dapatkanSemuaTas();
    boolean perbaruiTas(int ID, double hargaBaru);
    void hapusTas(int id);
}
