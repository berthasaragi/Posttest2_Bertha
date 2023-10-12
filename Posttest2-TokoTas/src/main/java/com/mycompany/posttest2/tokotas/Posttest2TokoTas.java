package com.mycompany.posttest2.tokotas;

import Tas.KontrolTas;
import Tas.RepositoryTas;
import java.util.Scanner;
import Tas.Tas;
import java.util.ArrayList;

public class Posttest2TokoTas{
    public static void main(String[] args) {
        RepositoryTas tasRepository = new KontrolTas();
        Scanner scanner = new Scanner(System.in);

        // Menu utama
        int pilihan;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Tambah Tas");
            System.out.println("2. Lihat Semua Tas");
            System.out.println("3. Perbarui Tas");
            System.out.println("4. Hapus Tas");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahTas(scanner, tasRepository);
                    break;
                case 2:
                    lihatSemuaTas(tasRepository);
                    break;
                case 3:
                    perbaruiTas(scanner, tasRepository);
                    break;
                case 4:
                    hapusTas(scanner, tasRepository);
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }

    private static void tambahTas(Scanner scanner, RepositoryTas tasRepository) {
        System.out.print("Masukkan ID Tas: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consuming newline
        System.out.print("Masukkan Nama Tas: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Stok Tas: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan Harga Tas: ");
        double harga = scanner.nextDouble();

        Tas tasBaru = new Tas(id, nama, stok, harga);
        tasRepository.tambahTas(tasBaru);
    }

    private static void lihatSemuaTas(RepositoryTas tasRepository) {
         ArrayList<Tas> semuaTas = tasRepository.dapatkanSemuaTas();
        System.out.println("=== Semua Tas ===");
        if (semuaTas.isEmpty()) {
            System.out.println("Data Kosong !!!");
        } else {
            for (Tas tas : semuaTas) {
                System.out.println("ID: " + tas.getId() + "\nNama: " + tas.getNama() 
                    + " \nStok: " + tas.getStok() + "\nHarga: " + tas.getHarga());
            }
        }  
    }

    private static void perbaruiTas(Scanner scanner, RepositoryTas tasRepository) {
        System.out.print("Masukkan ID Tas yang ingin diperbarui: ");
        int idPerbarui = scanner.nextInt();

        // Assuming you have a method to retrieve a Tas object by Id
        Tas tas = tasRepository.dapatkanTasById(idPerbarui);

        if (tas != null) {
            System.out.print("Masukkan Harga baru: ");
            double hargaBaru = scanner.nextDouble();

            // Update the Tas object in the repository
            tasRepository.perbaruiTas(idPerbarui, hargaBaru);

            System.out.println("Tas berhasil diperbarui.");
        } else {
            System.out.println("Tas dengan ID tersebut tidak ditemukan.");
        }
    }

    private static void hapusTas(Scanner scanner, RepositoryTas tasRepository) {
        System.out.print("Masukkan ID Tas yang ingin dihapus: ");
        int idHapus = scanner.nextInt();
        tasRepository.hapusTas(idHapus);
    }
}
