public class MainCalc{
  MainCalc(){
  }

  public Matrix gauss(Matrix M, String filename){
    /*Eliminasi Gauss dengan partial pivoting. Menghasilkan matriks eselon*/
    TextReader baca = new TextReader();
    int row = baca.getbaris(filename);
    int col = baca.getkolom(filename);
    double hold;

    //Cari baris yang akan dijadikan pivot dan menukarnya
    for(int p = 0; p < row; p++){
      int max = p;
      for(int i = p + 1; i < row; i++){
        if(Math.abs(M.content(i, p)) > Math.abs(M.content(max, p))){
          max = i;
        }
      }

      double[] temp = M.linecontent(p, col-1);
      M.addline(p, M.linecontent(max, col), col-1);
      M.addline(max, temp, col-1);

      double t = M.content(p, col-1);
      M.addel(p, col-1, M.content(max, col-1));
      M.addel(max, col-1, t);

      //Pivot
      for(int i = p + 1; i < row; i++){
        double alpha = M.content(i, p) / M.content(p, p);
        M.addel(i, col-1, (M.content(i, col-1) - (alpha * M.content(p, col-1))));
        for(int j = p; j < row; j++){
          M.addel(i, j, M.content(i,j) - (alpha * M.content(p, j)));
        }
      }
    }
    return M;
  }

  public void gaussjordan(){


  }

  public void interpolasi(){

  }

  public double[] satusolusi(Matrix M, String filename){
    TextReader baca = new TextReader();
    int row = baca.getbaris(filename);
    int col = baca.getkolom(filename);
    double[] result = new double[row];
    double[] augmented = new double[row];
    for(int i = 0; i < row; i++){
      augmented[i] = M.content(i, col - 1);
    }
    for(int i = row - 1; i >= 0; i--){
      double sum = 0;
      for(int j = i + 1; j < row; j++){
        sum += M.content(i,j) * result[j];
      }
      result[i] = (augmented[i] - sum) / M.content(i,i);
    }
    return result;
  }

  public String[] banyaksolusi(Matrix M){
    char alphabet = 'p';
    String[] solusi = new String[1];
    solusi[1] = "whyyyy";
    return solusi;
  }
}
