import java.util.Scanner;
import java.io.*;

class Krauts {
    public static void main(String args[]) {
        File f;
        Scanner s;
        Interpreter b;
        String linhas[] = new String[2000]; // arquivo pode ter, no máximo, 2000 linhas.

        f = new File(args[0]);
        s = new Scanner(f);
        b = new Interpreter();
        variable[] = new var();

        int i = 0;
        while(s.hasNext()) {
            linhas[i] = s.nextLine();
            i++;
        }
        b.interpret(linhas);
    }
}
