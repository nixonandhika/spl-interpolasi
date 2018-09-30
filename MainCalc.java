public class MainCalc{
  MainCalc(){
  }

  public Matrix gauss(Matrix M, int row, int col){
    /*Eliminasi Gauss dengan partial pivoting. Menghasilkan matriks eselon*/
    double hold, simpan = 1.0;
    boolean singular, first = true;
    int temporary = 0;
    //Cari baris yang akan dijadikan pivot dan menukarnya
    for(int p = 0; p < row; p++){ //Mencari baris matriks dengan nilai absolut pivot tertinggi
      int max = p;
      for(int i = p + 1; i < row; i++){
        if(Math.abs(M.content(i, p)) > Math.abs(M.content(max, p))){
          max = i;
        }
      }

      //Menukar baris p dengan baris dengan nilai absolut pivot tertinggi
      double[] temp = M.linecontent(p, col);
      M.addline(p, M.linecontent(max, col), col);
      M.addline(max, temp, col);

      //Jika diagonal utama pada baris p bukan nol
      if(M.content(p,p) != 0){
        for(int i = p + 1; i < row; i++){
          double alpha = M.content(i, p) / M.content(p, p);
          M.addel(i, col-1, (M.content(i, col-1) - (alpha * M.content(p, col-1)))); //Mengurangi elemen yang di-augmentasi
          for(int j = p; j < col-1; j++){
            M.addel(i, j, M.content(i,j) - (alpha * M.content(p, j))); //Mengurangi elemen pada matrix yang tidak di-augmentasi
          }
        }
      } else{ //Jika diagonal utama pada baris p adalah nol. Dibuat terpisah agar tidak terjadi pembagian dengan nol
        int i = 1;
        while(first && i < row){ //Looping untuk mencari elemen pivot pada baris p yang bukan nol
          if(M.content(p, p + i) != 0){
            first = false;
            simpan = M.content(p,p+i); //Menyimpan nilai pivot yang bukan nol
            temporary = p+i; //Menyimpan indeks ditemukannya nilai pivot yang bukan nol
          }
          i++;
        }
        for(i = p + 1; i < row; i++){
          double alpha = M.content(i, temporary) / simpan;
          M.addel(i, col-1, (Math.round((M.content(i, col-1) - alpha * M.content(p, col-1)) * 1000 / 1000))); //Mengurangi elemen yang di-augmentasi
          for(int j = temporary; j < col-1; j++){
            M.addel(i, j, M.content(i,j) - (alpha * M.content(p, j))); //Mengurangi elemen pada matrix yang tidak di-augmentasi
          }
        }
      }
    }
    for(int i = 0; i < row; i++){ //Loop untuk membuat pivot semua baris yang bukan nol menjadi satu
      first = true;
      simpan = 1;
      for(int j = 0; j < col; j++){
        if(M.content(i,j) != 0 && first){
          simpan = M.content(i,j);
          first = false;
        }
        M.addel(i, j, M.content(i, j) / simpan);
      }
    }
    return M;
  }

  public String checksolution(Matrix M, int row, int col){
    int countcol = 0, countzerorow = 0;
    for(int i = 0; i < row; i++){
      countcol = 0;
      for(int j = 0; j < col; j++){
        if(M.content(i,j) != 0){
          countcol++;
        }
        if(j == col - 1 && countcol == 0){
          countzerorow++;
        }
      }
    }

    if(countcol == 1){ //Jika elemen baris terakhir nol semua kecuali paling kanan
      return "inconsistent";
    } else if(col - 1 == row - countzerorow){
      return "unique";
    } else{
      return "infinite";
    }
  }

  public void gaussjordan(){

  }

  public double interpolasi(double[] x, double input, int col){
    double sum = 0, kali;
    for(int i = 0; i < col; i++){
      kali = 1;
      for(int j = 0; j < i; j++){
        kali *= input;
      }
      sum += x[i] * kali;
    }
    return sum;
  }

  public double[] satusolusi(Matrix M, int row, int col){
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
      if(i < col-1){
        result[i] = (augmented[i] - sum) / M.content(i,i);
      }
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
