import java.util.Scanner;

public class MainProgram{
  public static void main(String[] args){
    int row = 0, col = 0, sumber;
    MainSystem system = new MainSystem();
    TextReader baca = new TextReader();
    MainCalc calculation = new MainCalc();
    Matrix M = new Matrix();
    Scanner in = new Scanner(System.in);
    system.welcome();
    int pilihan = system.menu();

    if(pilihan == 1){ //Jika pilihan menu ke-1, jalanin augmented
      int metode = system.choice();
      sumber = system.source();

      if(sumber == 1){ //jika sumber dari keyboard
        System.out.print("Masukkan jumlah baris (termasuk baris b): ");
        row = in.nextInt();
        System.out.print("Masukkan jumlah kolom (termasuk kolom b): ");
        col = in.nextInt();
        M.isimatrix(row, col);
        System.out.println();
        System.out.println("Matrix yang dimasukkan: ");
        M.tulismatrix(row, col);

      } else{ //jika sumber dari file
        row = baca.getbaris("augmented.txt");
        col = baca.getkolom("augmented.txt");
        M = baca.readFile("augmented.txt");
        System.out.println();
        System.out.println("Isi dari Matrix: ");
        M.tulismatrix(row, col);
      }

      if(metode == 1){ //Jika metode ke-1, jalanin gauss
        //gauss
        calculation.gauss();
      } else{ //Jika metode ke-2, jalanin gauss-jordan
        //gauss-jordan
        calculation.gaussjordan();
      }

    } else if(pilihan == 2){ //Jika pilihan menu ke-2, jalanin interpolasi
      sumber = system.source();
      if(sumber == 1){ //jika sumber dari keyboard
        System.out.print("Masukkan jumlah pasangan point: ");
        row = in.nextInt();
        M.isimatrix(row, 2);
        System.out.println("Matrix yang dimasukkan: ");
        M.tulismatrix(row, 2);

      } else{ //jika sumber dari file
        row = baca.getbaris("interpolasi.txt");
        M = baca.readFile("interpolasi.txt");
        System.out.println();
        System.out.println("Isi dari Matrix: ");
        M.tulismatrix(row, 2);
      }

      //interpolasi
      calculation.interpolasi();
    } else{ //Jika pilihan menu ke-3, maka program berhenti
      System.exit(0);
    }
  }
}
