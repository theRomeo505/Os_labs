package OS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {
    private static MyServer server;
    private ServerSocket serverSocket;
    private ExecutorService executorService = Executors.newFixedThreadPool(2);
//    private String f;
//    private String g;
    public static void main(String[] args) throws IOException {
        server = new MyServer();
        //server.initiateProcess("os.Test.FunctionF","os.Test.FunctionG");
        server.runServer();
    }

//    private void initiateProcess(String processf,String processg) throws IOException{
//        f=processf;
//        g=processg;
//    }
    private void runServer() {
        int serverPort = 8085;
        try {
            System.out.println("Starting Server");
            serverSocket = new ServerSocket(serverPort);
            while(true) {
                System.out.println("Waiting for request");
                try {
                    Socket s = serverSocket.accept();
                    System.out.println("Processing request");
                    executorService.submit(new ServiceRequest(s));
                } catch(IOException ioe) {
                    System.out.println("Error accepting connection");
                    ioe.printStackTrace();
                }
            }
        }catch(IOException e) {
            System.out.println("Error starting Server on "+serverPort);
            e.printStackTrace();
        }
    }
    private void stopServer() {
        executorService.shutdownNow();
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error in server shutdown");
            e.printStackTrace();
        }
        System.exit(0);
    }
    private int evaluateFunction(int x, String func) throws IOException, InterruptedException {
        List<String> args = Arrays.asList(String.valueOf(x));

        ProcessBuilder pb;
        pb = ProcessInitializer.Initialize(func, args);

        Process process = pb.start();
        process.waitFor();
        return process.exitValue();
    }

    class ServiceRequest implements Runnable {
        private Socket socket;
        public ServiceRequest(Socket connection) {
            this.socket = connection;
        }
        public void run() {

            try {
                DataInputStream dIn = new DataInputStream(socket.getInputStream());
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                String func; int x;

                func=dIn.readUTF();
                x=(dIn.readInt());
                dOut.writeInt(evaluateFunction(x,func));


                dOut.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
