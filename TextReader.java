import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TextReader{

  public Matrix readFile(String filename){ //Fungsi buat baca matrix dari file
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      Matrix M = new Matrix();
      int row = this.getbaris(filename); //jumlah baris yang ada di file
      int col = this.getkolom(filename); //jumlah kolom yang ada di file
      int j = 0, k = 0;
      for(int i = 0; i < row * col; i++){
        if(k == col){
          k = 0;
          j++;
        }
        M.addel(j, k, in.nextDouble()); //Mengisi matrix M dengan nilai elemen yang ada di file
        k++;
      }
      in.close();
      return M;
    } catch(Exception e){
      return null;
    }
  }

  public int getbaris(String filename){ //Selektor baris
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      int row = 0;
      while(in.hasNextLine()){ //Looping untuk mendapatkan jumlah baris yang ada di file
        in.nextLine();
        row++;
      }
      in.close();
      return row;
    } catch(Exception e){
      return 999;
    }
  }

  public int getkolom(String filename){ //Selektor kolom
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      int col = 0;
      int row = getbaris(filename);
      for(int i = 0; i < row; i++){ //Looping untuk mendapatkan jumlah kolom yang ada di file
        Scanner readCol = new Scanner(in.nextLine());
        col = 0;
        while(readCol.hasNextDouble()){
          readCol.nextDouble();
          col++;
        }
      }
      in.close();
      return col;
    } catch(Exception e){
      return 999;
    }
  }

  public void tulisFile(String var, float hasil){

  }
}
