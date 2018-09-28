import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TextReader{

  public Matrix readFile(String name){ //Fungsi buat baca matrix dari file
    try{
      File f = new File(name);
      Scanner in = new Scanner(f);
      Matrix M = new Matrix();
      int row = this.getbaris(name);
      int col = this.getkolom(name);
      int j = 0, k = 0;
      for(int i = 0; i < row * col; i++){
        if(k == col){
          k = 0;
          j++;
        }
        M.addel(j, k, in.nextFloat());
        k++;
      }
      in.close();
      return M;
    } catch(Exception e){
      return null;
    }
  }

  public int getbaris(String name){ //Selektor baris
    try{
      File f = new File(name);
      Scanner in = new Scanner(f);
      int row = 0;
      while(in.hasNextLine()){
        in.nextLine();
        row++;
      }
      in.close();
      return row;
    } catch(Exception e){
      return 999;
    }
  }

  public int getkolom(String name){ //Selektor kolom
    try{
      File f = new File(name);
      Scanner in = new Scanner(f);
      int col = 0;
      int row = getbaris(name);
      for(int i = 0; i < row; i++){
        Scanner readCol = new Scanner(in.nextLine());
        col = 0;
        while(readCol.hasNextFloat()){
          readCol.nextFloat();
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
