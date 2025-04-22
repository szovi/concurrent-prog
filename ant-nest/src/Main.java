import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Nest nest;

    private static Integer size;

    public static void main(String[] args) throws IOException {

        init();
        for (int i = 0; i < nest.getNestFields().length; i++) {
            for (int j = 0; j < nest.getNestFields()[i].length; j++) {
                System.out.print(nest.getNestFields()[i][j].toString());
            }
            System.out.println();
        }
    }

    private static void init() {
        nest = new Nest();
    }


}