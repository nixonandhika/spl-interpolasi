import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/*Kelas ini untuk menuliskan hasil persamaan ke layar dan ke file ekternal*/

public class TextWriter{
  public void writefile(double[] x, String[] tipe, String filename, int row, int col){
    try{
      MainCalc calculation = new MainCalc();
      Scanner in = new Scanner(System.in);
      double taksiran = 0, input = 0;
      if(filename == "augmented.txt"){ //Jika program mengoperasikan SPL
        BufferedWriter tulis = new BufferedWriter(new FileWriter("hasilaugmented.txt", true));
        System.out.println("Hasil persamaan:");
        tulis.write("Hasil persamaan");
        tulis.newLine();
        if(tipe[0] == "unique"){ //Jika tipe solusi adalah unique, menggunakan array of double
          for(int i = 0; i < col; i++){ //Menuliskan hasil persamaan ke layar dan file
            System.out.print("x");
            tulis.write("x");
            System.out.print(i+1);
            tulis.write(i+1 + "");
            System.out.print(": ");
            tulis.write(": ");
            System.out.println(x[i]);
            tulis.write(x[i] + "");
            tulis.newLine();
          }
      } else{ //Jika tipe solusi adalah infnite, menggunakan array of String
        for(int i = 0; i < col; i++){ //Menuliskan hasil persamaan ke layar dan file
          System.out.print("x");
          tulis.write("x");
          System.out.print(i+1);
          tulis.write(i+1 + "");
          System.out.print(": ");
          tulis.write(": ");
          System.out.println(tipe[i]);
          tulis.write(tipe[i] + "");
          tulis.newLine();
        }
      }
        tulis.close();
      } else{ //Jika program mengoperasikan Interpolasi
        BufferedWriter tulis = new BufferedWriter(new FileWriter("hasilinterpolasi.txt", true));
        if(tipe[0] == "unique"){ //Jika tipe solusi adalah unique, menggunakan array of double
          System.out.println("Hasil persamaan:");
          tulis.write("Hasil persamaan");
          tulis.newLine();
          for(int i = 0; i < col; i++){ //Menuliskan hasil persamaan ke layar dan file
            System.out.print("a");
            tulis.write("a");
            System.out.print(i);
            tulis.write(i+"");
            System.out.print(": ");
            tulis.write(": ");
            System.out.println(x[i]);
            tulis.write(x[i]+ "");
            tulis.newLine();
          }
          System.out.println();
          tulis.newLine();
          tulis.write("Persamaan polinom: ");
          tulis.newLine();
          System.out.print("P(x) = ");
          tulis.write("P(x) = ");
          for(int i = 0; i < col; i++){ //Menuliskan persamaan polinom ke layar dan file
            System.out.print(x[i]);
            tulis.write(x[i]+"");
            if(i == 1){
              System.out.print("x");
              tulis.write("x");
            } else if(i > 1){
              System.out.print("x^");
              tulis.write("x^");
              System.out.print(i);
              tulis.write(i);
            }
            if(i < col - 1){
              System.out.print(" + ");
              tulis.write(" + ");
            }
          }
          System.out.println();
          tulis.newLine();
          System.out.print("Masukkan nilai x yang ingin ditaksir: ");
          input = in.nextDouble(); //Meminta input x sebagai nilai yang akan ditaksir
          taksiran = calculation.interpolasi(x, input, col); //Menyimpan hasil taksiran dari x
          System.out.println();
          tulis.newLine();
          System.out.print("Hasil taksiran dari nilai x = ");
          tulis.write("Hasil taksiran dari nilai x = ");
          System.out.print(input);
          tulis.write(input + "");
          System.out.print(" adalah ");
          tulis.write(" adalah ");
          System.out.println(taksiran); //Menulis hasil taksiran ke layar dan file
          tulis.write(taksiran + "");
          tulis.close();
        }
      }
    } catch(Exception e){ //Jika terjadi error saat penulisan ke file
      System.out.println("Terjadi ERROR");
    }
  }

  public void writematrix(Matrix M, int row, int col, String filename){
    //Prosedur ini untuk menuliskan matrix hasil operasi ke file
    try{
      if(filename == "augmented.txt"){
        BufferedWriter tulis = new BufferedWriter(new FileWriter("hasilaugmented.txt"));
        tulis.write("Hasil matrix: ");
        tulis.newLine();
        for(int i = 0; i < row; i++){
          for(int j = 0; j < col; j++){
            tulis.write(M.content(i,j) + "");
            if(j != col - 1){
              tulis.write(" ");
            }
          }
          tulis.newLine();
        }
        tulis.newLine();
        tulis.close();
      } else{
        BufferedWriter tulis = new BufferedWriter(new FileWriter("hasilinterpolasi.txt"));
        tulis.write("Hasil matrix: ");
        tulis.newLine();
        for(int i = 0; i < row; i++){
          for(int j = 0; j < col; j++){
            tulis.write(M.content(i,j) + "");
            if(j != col - 1){
              tulis.write(" ");
            }
          }
          tulis.newLine();
        }
        tulis.newLine();
        tulis.close();
      }
    } catch(Exception e){
      System.out.println("Terjadi ERROR");
    }
  }
}
