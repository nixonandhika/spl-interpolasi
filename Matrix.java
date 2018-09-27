import java.util.Scanner;

public class Matrix{
  float[][] matrix = new float[10][10];
  int baris;
  int kolom;

  Matrix(){ //konstruktor dan inisialisasi matrix
    for(int i = 0; i < 10; i++){
      for(int j = 0; j < 10; j++){
        this.matrix[i][j] = 0;
      }
    }
  }

  void addel(int i, int j, float el){ //prosedur buat menambahkan el sebagai elemen matrix
    this.matrix[i][j] = el;
  }

  float isiel(int i, int j){
    float el = this.matrix[i][j];
    return el;
  }

  void isimatrix(int m, int n){ //mengisi matrix
    Scanner in = new Scanner(System.in);
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        this.matrix[i][j] = in.nextFloat();
      }
    }
  }

  void tulismatrix(int m, int n){ //menulis isi matrix
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        System.out.print(this.matrix[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
