package OS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    // false for f and true for g
    public int eval(String fun, int num) throws IOException{
        Socket socket = new Socket("localhost", 8085);

        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
        DataInputStream dIn = new DataInputStream(socket.getInputStream());
        dOut.writeUTF(fun);
        dOut.writeInt(num);
        dOut.flush();

        int x=(dIn.readInt());


        //
        dIn.close();
        dOut.close();
        return x;
    }
};
