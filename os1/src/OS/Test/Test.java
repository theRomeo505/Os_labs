package OS.Test;

import OS.Client;

import java.io.IOException;
// start the MyServer.java first

public class Test {
    public static void main(String[] args) throws IOException {


        Client c=new Client(),c1=new Client();
        // false for f and true for g
        int f= c.eval("OS.Test.FunctionF",76);
        int g=c1.eval("OS.Test.FunctionG",12);
        System.out.println(f+g);
    }
}


