package OS.ConjTest;

import OS.Client;

import java.io.IOException;

public class ConjTest {
    public static void main(String[] args) throws IOException {
    Client c=new Client(),c1=new Client();
    // false for f and true for g
    int f= c.eval("OS.ConjTest.ConjF",7);
    int g=c1.eval("OS.ConjTest.ConjG",8);
        System.out.println(f+g);
    }
}
