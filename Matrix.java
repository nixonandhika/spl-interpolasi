import java.util.Scanner;

class Matrix{
  float[][] matrix = new float[10][10];

  Matrix(int m, int n){
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        this.matrix[i][j] = 0;
      }
    }
  }

  void isimatrix(int m, int n){
    Scanner in = new Scanner(System.in);
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        this.matrix[i][j] = in.nextFloat();
      }
    }
  }

  void tulismatrix(int m, int n){
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        System.out.print(this.matrix[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
