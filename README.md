Sistem Persamaan Linear - Interpolasi\
\
Program untuk menyelesaikan persoalan sistem persamaan linear (SPL) dengan menggunakan eliminasi gauss/gauss-jordan yang kemudian digunakan untuk menyelesaikan persoalan interpolasi

Program ini dibuat dengan menggunakan bahasa Java.
Byte code terdiri dari 6 Class dengan MainProgram sebagai driver/program utama untuk dijalankan.
Kegunaan dari masing-masing Class:
1. MainProgram = sebagai driver dan program utama
2. MainSystem = sebagai interface awal dari program serta berisi method untuk pilihan mode dari user
3. MainCalc = sebagai kelas yang berisi logika dari program. Mengatur semua perhitungan (Gauss, Gauss-Jordan, Interpolasi, dll)
4. Matrix = sebagai kelas yang mengatur pembuatan, akses, manipulasi, dan menampilkan matrix
5. TextReader = sebagai kelas untuk membaca isi matrix dari file eksternal
6. TextWriter = sebagai kelas untuk menuliskan hasil operasi dari program ke file eksternal

--Lakukanlah kompilasi terlebih dahulu terhadap source code agar didapat byte code--

Penggunaan program:
1. Run MainProgram.class (command: java MainProgram)
2. Pilih antara mode SPL / Interpolasi
3. Pilih pembacaan input dari keyboard/file
4. Masukkan data-data yang ingin diolah
5. Jika matrix memiliki solusi, akan ditampilkan
6. Selesai

Contoh di bawah ini menghitung hasil matrix yang infinite:\
Contoh masukan mode SPL:\
1 3 -2  0  2  0  0\
2 6 -5 -2  4 -3 -1\
0 0  5  10 0  15 5\
2 6  0  8  4  18 6

Keluaran:\
Hasil matrix:\
1.0 3.0 -2.5 -1.0 2.0 -1.5 -0.5\
0.0 0.0  1.0  2.0 0.0  3.0  1.0\
0.0 0.0  0.0  0.0 0.0  1.0  0.3333333333333333\
0.0 0.0  0.0  0.0 0.0  0.0  0.0

Hasil persamaan\
x1: (-3.0*r) + (2.5*(-2.0*p)) + (1.0*p) + (-2.0*q)\
x2: r\
x3: (-2.0*p)
x4: p\
x5: q\
x6: 0.3333333333333333

Versi Java yang digunakan:\
java version "10.0.2" 2018-07-17\
Java(TM) SE Runtime Environment 18.3 (build 10.0.2+13)\
Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10.0.2+13, mixed mode)
