package OS.DisjTest;

import OS.Client;

import java.io.IOException;

public class DisjTest {
    public static void main(String[] args) throws IOException {
        Client c=new Client(),c1=new Client();
        // false for f and true for g
        int f= c.eval("OS.DisjTest.DisjF",7);
        int g=c1.eval("OS.DisjTest.DisjG",8);
        System.out.println(f+g);
    }
}
