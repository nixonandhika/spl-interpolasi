import java.util.Scanner;

public class MainSystem{
  MainSystem(){
  }

  public void welcome(){ //welcome message
    System.out.println("");
    System.out.println("****************************************************");
    System.out.println(" Selamat Datang di Program Aplikasi SPL-Interpolasi");
    System.out.println("****************************************************");
    System.out.println("Program ini digunakan untuk menyelesaikan");
    System.out.println("sistem persamaan linier menggunakan");
    System.out.println("Gauss Elimination, Gauss-Jordan,");
    System.out.println("Elimination dan juga Interpolasi.");
    System.out.println("");
    System.out.println("Untuk melanjutkan, silahkan ketik");
    System.out.println("suatu angka yang ada di menu");
    System.out.println("");
  }

  public int menu(){ //fungsi buat pilihan menu
    System.out.println("MENU:");
    System.out.println("1. Sistem persamaan Linier");
    System.out.println("2. Interpolasi Polinom");
    System.out.println("3. Keluar");
    System.out.println("");
    System.out.print("Input: ");
    Scanner in = new Scanner(System.in);
    int input = in.nextInt();
    while(input != 1 && input != 2 && input != 3){
      System.out.print("Masukkan salah. Silahkan input lagi: ");
      input = in.nextInt();
    }
    if(input == 3){
      return 0;
    } else{
      return input;
    }
  }

  public int source(){ //fungsi buat pilihan source input
    System.out.println("Pilih source program:");
    System.out.println("1. Keyboard");
    System.out.println("2. File");
    System.out.println("");
    System.out.print("Input: ");
    Scanner in = new Scanner(System.in);
    int input = in.nextInt();
    while(input != 1 && input != 2){
      System.out.print("Masukkan salah. Silahkan input lagi: ");
      input = in.nextInt();
    }
    return input;
  }

  public int choice(){ //Pilihan metode
    Scanner in = new Scanner(System.in);
    System.out.println("");
    System.out.println("Pilih metode yang ingin digunakan: ");
    System.out.println("1. Metode eliminasi Gauss");
    System.out.println("2. Metode eliminasi Gauss-Jordan");
    System.out.println("");
    System.out.print("Input: ");
    int input = in.nextInt();
    while(input != 1 && input != 2){
      System.out.print("Masukkan salah. Silahkan input lagi: ");
      input = in.nextInt();
    }
    System.out.println("");
    return input;
  }

  public void printhasil(double[] x, int col){ //Menuliskan hasil persamaan polinom ke layar
    for(int i = 0; i < col; i++){
      System.out.print("a");
      System.out.print(i);
      System.out.print(": ");
      System.out.println(x[i]);
    }
  }

  public void printpolinom(double[] x, int col){ //Menuliskan persamaan polinom berdasarkan hasil persamaan ke layar
    System.out.print("P(x) = ");
    for(int i = 0; i < col; i++){
      System.out.print(x[i]);
      if(i == 1){
        System.out.print("x");
      } else if(i > 1){
        System.out.print("x^");
        System.out.print(i);
      }
      if(i < col - 1){
        System.out.print(" + ");
      }
    }
  }
}
