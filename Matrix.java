import java.util.Scanner;

public class Matrix{
  double[][] matrix = new double[10][10];
  int baris;
  int kolom;

  Matrix(){ //konstruktor dan inisialisasi matrix
    for(int i = 0; i < 10; i++){
      for(int j = 0; j < 10; j++){
        this.matrix[i][j] = 0;
      }
    }
  }

  void addel(int i, int j, double el){ //prosedur buat menambahkan el sebagai elemen matrix
    this.matrix[i][j] = el;
  }

  void addline(int i, double[] k, int col){
    for(int j = 0; j < col; j++){
      this.matrix[i][j] = k[j];
    }
  }

  double content(int i, int j){
    double el = this.matrix[i][j];
    return el;
  }

  double[] linecontent(int i, int col){
    double[] el = new double[col];
    for(int j = 0; j < col; j++){
      el[j] = this.matrix[i][j];
      //System.out.println(this.matrix[i][j]);
    }
    return el;
  }

  double[] colcontent(int j, int row){
    double[] el = new double[row];
    for(int i = 0; i < row; i++){
      el[i] = this.matrix[i][j];
    }
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

  void tulisline(int i, int col){
    for(int j = 0; j < col; j++){
      System.out.print(this.matrix[i][j]);
      System.out.print(" ");
    }
    System.out.println();
  }

  void tuliscontent(int i, int j){
    System.out.println(this.matrix[i][j]);
  }
}
