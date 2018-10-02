/*Kelas ini mengatur segala macam operasi perhitungan*/

public class MainCalc{
  MainCalc(){
  }

  public Matrix gauss(Matrix M, int row, int col){
    /*Fungsi ini merupakan Eliminasi Gauss dengan partial pivoting. Akan menghasilkan matriks eselon*/
    double hold, simpan = 1.0;
    boolean first = true;
    int temporary = 0;

    //Cari baris yang akan dijadikan pivot dan menukarnya
    for(int p = 0; p < row; p++){ //Mencari baris matriks dengan nilai absolut pivot tertinggi
      int max = p;
      for(int i = p + 1; i < row; i++){
        if(Math.abs(M.content(i, p)) > Math.abs(M.content(max, p))){
          max = i; //Menyimpan indeks baris tertinggi
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
          M.addel(i, col-1, ((M.content(i, col-1) - (alpha * M.content(p, col-1))))); //Mengurangi elemen yang di-augmentasi
          for(int j = p; j < col-1; j++){
            M.addel(i, j, M.content(i,j) - (alpha * M.content(p, j))); //Mengurangi elemen pada matrix yang tidak di-augmentasi
          }
        }
      } else{ //Jika diagonal utama pada baris p adalah nol. Dibuat terpisah agar tidak terjadi pembagian dengan nol
        int i = 1;
        while(first && p+i < row){ //Looping untuk mencari elemen pivot pada baris p yang bukan nol
          if(M.content(p, p + i) != 0){
            first = false;
            simpan = M.content(p,p+i); //Menyimpan nilai pivot yang bukan nol
            temporary = p+i; //Menyimpan indeks ditemukannya nilai pivot yang bukan nol
          }
          i++;
        }
        for(i = p + 1; i < row; i++){
          double alpha = M.content(i, temporary) / simpan;
          M.addel(i, col-1, (Math.round((M.content(i, col-1) - alpha * M.content(p, col-1))*100000000d)/100000000d)); //Mengurangi elemen yang di-augmentasi
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

    int i = row - 1; //Untuk mengatasi suatu bug
    for(int j = 0; j < col; j++){
      if(M.content(i,j) != 0){
        double[] temp = M.linecontent(i-1, col);
        M.addline(i-1, M.linecontent(i, col), col);
        M.addline(i, temp, col);
      }
    }
    return M;
  }

  public String checksolution(Matrix M, int row, int col){ //Fungsi untuk mengirimkan tipe solusi
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

  public Matrix gaussjordan(Matrix M, int row, int col){ //Fungsi ini merupakan Eliminasi Gauss-Jordan. Menghasilkan matriks eselon tereduksi
    Matrix N = gauss(M, row, col);
    int i = 0, j = 1, k = 0, temp1 = 0, temp2 = 0;
    int[] pivot = new int[row];
    int last = 0;

    pivot = searchsatu(N, row, col-1); //menyimpan letak baris semua pivot
    last = pivot.length - 1; //indeks terakhir pivot
    temp1 = pivot[last]; //menyimpan nilai pivot pada indeks terakhir

    while(j < col-1){
      k = 0;
      if(j <= temp1){
        i = j;
        temp2 = pivot[j];
      }
      while(i < row && k < temp2){
        if(N.content(i, j) != 0){
          N = kurangBrs(N, k, i, j, col); //Mengurangi satu baris dengan baris lainnya
        }
        k++;
      }
      j++;
    }

    return N;
  }

  public int[] searchsatu(Matrix M, int row, int col){
    //Mencari index leading point(pivot) dari matriks M
    int i = 0, j = 0, temp = 0;
    int[] idxSatu = new int[col];
    boolean found = false;
    int last = 0;

    for(i = 0; i < col; i++){ //inisialisasi nilai
      idxSatu[i] = 0;
    }

    i = 0;
    while(i < col){
      j = row - 1;
      while(j > -1 && found == false){
        if(M.content(j,i) == 1 && j >= temp){
          temp = j;
          idxSatu[last] = j;
          last++;
          found = true;
        }
        j--;
      }
      found = false;
      i++;
    }

    int[] idx = new int[last];
    for(i = 0; i < last; i++){
      idx[i] = idxSatu[i];
    }

    return idx;
  }

  public Matrix kurangBrs(Matrix M, int idxRow, int targetRow, int idxCol, int Nkol){
    //Mengurangi elemen pada baris idxRow dengan elemen pada baris targetRow * alpha
    double alpha = M.content(idxRow, idxCol) / M.content(targetRow, idxCol);
    for(int j = 0; j < Nkol; j++){
      M.addel((idxRow), j, ((M.content(idxRow, j) - (alpha * M.content(targetRow, j)))));
    }
    return M;
  }

  public double interpolasi(double[] x, double input, int col){
    //Fungsi untuk menghitung hasil taksiran (polinom)
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
    //Fungsi untuk mengirimkan solusi Matriks jika hasilnya unique
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

  public String[] banyaksolusi(Matrix M, int row, int col){
    //Fungsi untuk mengirimkan solusi Matriks jika hasilnya infinite/parametrik
    char[] daftar;
    daftar = new char[] {'p','q','r','s','t','u','v','w'}; //array of char untuk menyimpan karakter yang akan diassign ke variabel
    String[] solusi = new String[col]; //String untuk di-output. Menyimpan hasil persamaan dalam parametrik
    int[] k = new int[col]; //Menyimpan indeks dari variabel konstanta
    int indeksK = 0; //menyimpan indeks dari k
    int indekssolusi = 0; //Menyimpan indeks dari variabel yang tidak diassign karakter
    int temp = indeksK; //menyimpan indeks maksimal k
    int indeksdaftar = 0; //sebagai indeks untuk assign suatu variabel dengan karakter
    int hitungvar = 0; //Variabel untuk menghitung banyaknya variabel yang sudah dilalui dalam suatu baris
    double[] konstanta = new double[col]; //Menyimpan nilai dari variabel konstanta
    for(int j = 0; j < col; j++){
      konstanta[j] = -999; //Simpan konstanta
      k[j] = -999; //Simpan indeks
      solusi[j]  = "zzz"; //Simpan string solusi
    }

    for(int i = 0; i < row; i++){
      if(singlevar(M,i,col)){
        for(int j = 0; j < col-1; j++){
          if(M.content(i,j) != 0){
            konstanta[j] = M.content(i, col - 1) / M.content(i,j); //Simpan nilai konstanta
            k[indeksK] = j; //Simpan indeks konstanta
            indeksK++;
          }
        }
      }
    }

    temp = indeksK;
    for(int i = row - 1; i >= 0; i--){ //Loop untuk Mengoperasikan variabel dengan konstanta dan assign huruf
      indeksK = 0;
      hitungvar = 0; //Menghitung berapa banyak variabel yang sudah dilalui dalam sebaris
      int banyakvar = countvar(M, i, col); //Menyimpan banyaknya jumlah variabel dalam suatu baris
      if(banyakvar > 1){ //Jika baris memiliki variable bukan nol melebihi 1 baru dijalankan
        int j = col-2;
        while(j >= i){
          if(indeksK < temp && M.content(i, k[indeksK]) != 0){ //Mengoperasikan variable yang memiliki konstanta
            M.addel(i, col-1, M.content(i, col - 1) - (M.content(i, k[indeksK]) * konstanta[k[indeksK]])); //Melakukan operasi terhadap augmentasi
            M.addel(i, k[indeksK], 0);
            hitungvar++;
            indeksK++;
          } else{
            if(M.content(i,j) != 0){
              if(solusi[j] == "zzz" && hitungvar < banyakvar - 1){
                solusi[j] = daftar[indeksdaftar] + "";
                indeksdaftar++;
              } else if(solusi[j] == "zzz" && hitungvar == banyakvar - 1){
                solusi[j] = "aaa"; //Mengisi dengan "aaa" untuk membedakan yang kosong dengan yang tidak diassign karakter
              }
              hitungvar++;
            }
          }
          j--;
        }
      }
    }

    for(int i = 0; i < temp; i++){ //Loop untuk menggabungkan variable hasil operasi dan assignment biasa
      solusi[k[i]] = konstanta[k[i]] + "";
    }

    for(int i = row - 1; i >= 0; i--){ //Loop untuk mengisi array solusi yang masih kosong karena membutuhkan operasi variabel parametrik
      int banyakvar = countvar(M, i, col); //Menyimpan banyak variabel dalam suatu baris
      hitungvar = 0;
      if(banyakvar > 1){
        for(int j = i; j < col - 1; j++){
          if(solusi[j] == "aaa"){ //Jika merupakan variabel yang tidak diassign karakter
            if(M.content(i, col-1) != 0){
              solusi[j] = M.content(i, col-1) + " + ";
            } else{
              solusi[j] = "";
            }
            indekssolusi = j; //Menyimpan indeks dari variabel yang tidak diassign karakter
          } else if(M.content(i,j) != 0){
            solusi[indekssolusi] += -M.content(i,j) + "*" + solusi[j];
            if(hitungvar < banyakvar - 2){
              solusi[indekssolusi] += " + ";
            }
            hitungvar++;
          }
        }
      }
      indekssolusi = 0;
    }

    return solusi;
  }

  public boolean singlevar(Matrix M, int row, int col){
    //Menghasilkan true jika di sebaris, hanya terdapat 1 variabel yang bukan nol
    int count = 0;
    for(int i = 0; i < col-1; i++){
      if(M.content(row, i) != 0){
        count++;
      }
    }
    return count == 1;
  }

  public int countvar(Matrix M, int row, int col){
    //Mengirimkan banyaknya variabel pada suatu baris
    int count = 0;
    for(int i = 0; i < col-1; i++){
      if(M.content(row, i) != 0){
        count++;
      }
    }
    return count;
  }
}
