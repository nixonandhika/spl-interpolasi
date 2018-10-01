import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class TextWriter{
  public void writefile(double[] x, String filename, int row, int col){
    try{
      MainCalc calculation = new MainCalc();
      Scanner in = new Scanner(System.in);
      double taksiran = 0, input = 0;
      if(filename == "augmented.txt"){
        BufferedWriter tulis = new BufferedWriter(new FileWriter("hasilaugmented.txt"));
        System.out.println("Hasil persamaan:");
        tulis.write("Hasil persamaan");
        tulis.newLine();
        for(int i = 0; i < col; i++){
          System.out.print("a");
          tulis.write("a");
          System.out.print(i);
          tulis.write(i + "");
          System.out.print(": ");
          tulis.write(": ");
          System.out.println(x[i]);
          tulis.write(x[i] + "");
          tulis.newLine();
        }
        tulis.close();
      } else{
        BufferedWriter tulis = new BufferedWriter(new FileWriter("hasilinterpolasi.txt"));
        System.out.println("Hasil persamaan:");
        tulis.write("Hasil persamaan");
        tulis.newLine();
        for(int i = 0; i < col; i++){
          System.out.print("x");
          tulis.write("x");
          System.out.print(i+1);
          tulis.write(i+1+"");
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
        for(int i = 0; i < col; i++){
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
        input = in.nextDouble();
        taksiran = calculation.interpolasi(x, input, col);
        System.out.println();
        tulis.newLine();
        System.out.print("Hasil taksiran dari nilai ");
        tulis.write("Hasil taksiran dari nilai ");
        System.out.print(input);
        tulis.write(input + "");
        System.out.print(": ");
        tulis.write(": ");
        System.out.println(taksiran);
        tulis.write(taksiran + "");
        tulis.close();
      }
    } catch(Exception e){
      System.out.println("Terjadi ERROR");
    }
  }
}
