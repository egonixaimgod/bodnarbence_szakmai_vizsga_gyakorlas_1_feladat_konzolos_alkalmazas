
// 2. Feladat: ---------------------------------------------------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Feladat {

    // 4. Feladat: -----------------------------------
    ArrayList<Jarmu> jarmuLista = new ArrayList<>();
    // -----------------------------------------------
    // 6. Feladat: -----------------------------------
    ArrayList<Jarmu> opel_lista = new ArrayList<>();

    // -----------------------------------------------
    public void readFile() {
        try {
            tryReadFile();
        } catch (Exception e) {
            System.err.println("Hiba! A fájl nem található!");
            System.err.println(e.getMessage());
        }
    }

    public void tryReadFile() throws FileNotFoundException {
        File file = new File("src/jarmuvek_opel.csv");
        Scanner sc = new Scanner(file);
        // 3. Feladat: ----------------------------------
        String elsoSor = sc.nextLine();
        // ----------------------------------------------
        // 4. Feladat ez is: ----------------------------
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(":");
            Jarmu jarmu = new Jarmu();
            jarmu.azonosito = Integer.parseInt(lineArray[0]);
            jarmu.rendszam = (lineArray[1]);
            jarmu.marka = (lineArray[2]);
            jarmu.urtartalom = Integer.parseInt(lineArray[3]);
            jarmu.ar = Double.parseDouble(lineArray[4]);
            jarmuLista.add(jarmu);
        }
        // ----------------------------------------------
    }

    // 5. Feladat: ----------------------
    public void kivonat() {
        // 6. Feladat: ------------------
        for (Jarmu jarmu : jarmuLista)
            if (jarmu.marka.equals("Opel")) {
                opel_lista.add(jarmu);
            }
        // --------------------------
    }

    // ----------------------------------
    // 7. Feladat: ----------------------------------
    public void write_file() {
        try {
            TryWrite_file();
        } catch (Exception e) {
            System.err.println("Hiba! A fájl nem írható!");
            System.err.println(e.getMessage());
        }
    }

    public void TryWrite_file() throws IOException {
        FileWriter fw = new FileWriter("onlyopel.csv");
        for (Jarmu jarmu : opel_lista) {
            fw.write(jarmu.azonosito.toString());
            fw.write(":");
            fw.write(jarmu.rendszam);
            fw.write(":");
            fw.write(jarmu.marka);
            fw.write(":");
            fw.write(jarmu.urtartalom.toString());
            fw.write(":");
            fw.write(jarmu.ar.toString());
            fw.write(":");
            fw.write("\n");
        }
        fw.close();
    }
    // ----------------------------------------------
}
// ---------------------------------------------------------------------------------------