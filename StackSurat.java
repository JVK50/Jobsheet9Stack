package smt2.jobsheet9.Tugas;

public class StackSurat {
    Surat[] stack;
    int size;
    int top;

    public StackSurat(int size) {
        this.size = size;
        stack = new Surat[size];
        top = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Surat s) {
        if (!isFull()) {
            top++;
            stack[top] = s;
        } else {
            System.out.println("Stack penuh! Tidak bisa menerima surat lagi.");
        }
    }

    public Surat pop() {
        if (!isEmpty()) {
            Surat s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat.");
            return null;
        }
    }

    // Cari surat berdasarkan nama mahasiswa
    public void cariSurat(String nama) {
        boolean ditemukan = false;
        for (int i = 0; i <= top; i++) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                System.out.println("Surat ditemukan!");
                System.out.println("ID Surat   : " + stack[i].idSurat);
                System.out.println("Nama       : " + stack[i].namaMahasiswa);
                System.out.println("Kelas      : " + stack[i].kelas);
                System.out.println("Jenis Izin : " + (stack[i].jenisIzin == 'S' ? "Sakit" : "Izin"));
                System.out.println("Durasi     : " + stack[i].durasi + " hari");
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Surat atas nama \"" + nama + "\" tidak ditemukan.");
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Tidak ada surat dalam stack.");
        } else {
            System.out.printf("%-10s %-20s %-8s %-12s %-6s%n",
                    "ID Surat", "Nama Mahasiswa", "Kelas", "Jenis Izin", "Durasi");
            for (int i = top; i >= 0; i--) {
                String jenis = stack[i].jenisIzin == 'S' ? "Sakit" : "Izin";
                System.out.printf("%-10s %-20s %-8s %-12s %-6d hari%n",
                        stack[i].idSurat, stack[i].namaMahasiswa,
                        stack[i].kelas, jenis, stack[i].durasi);
            }
        }
        System.out.println();
    }
}