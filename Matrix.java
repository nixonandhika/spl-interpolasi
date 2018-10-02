import java.util.Scanner;
import java.text.DecimalFormat;

/*Kelas ini untuk mengurus semua hal yang berhubungan dengan matrix dan manipulasinya*/

public class Matrix{
  double[][] matrix = new double[15][15];
  int baris;
  int kolom;

  Matrix(){ //konstruktor dan inisialisasi matrix
    for(int i = 0; i < 10; i++){
      for(int j = 0; j < 10; j++){
        this.matrix[i][j] = 0;
      }
    }
  }

  public void addel(int i, int j, double el){ //prosedur untuk menambahkan el sebagai elemen matrix (menggantikan el lama)
    this.matrix[i][j] = el;
  }

  public void addline(int i, double[] k, int col){ //prosedur untuk menambahkan sebaris elemen matrix
    for(int j = 0; j < col; j++){
      this.matrix[i][j] = k[j];
    }
  }

  public double content(int i, int j){ //fungsi untuk mengeluarkan isi elemen matrix pada indeks tertentu
    double el = this.matrix[i][j];
    return el;
  }

  public double[] linecontent(int i, int col){ //fungsi untuk mengeluarkan isi sebaris elemen matrix
    double[] el = new double[col];
    for(int j = 0; j < col; j++){
      el[j] = this.matrix[i][j];
    }
    return el;
  }

  public void isimatrix(int m, int n){ //mengisi matrix
    Scanner in = new Scanner(System.in);
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        this.matrix[i][j] = in.nextDouble();
      }
    }
  }

  public void tulismatrix(int m, int n){ //menulis isi matrix
    //DecimalFormat df = new DecimalFormat("#.########");
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        System.out.print(/*df.format*/(this.matrix[i][j]));
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
