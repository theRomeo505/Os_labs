package OS.Test;

public class FunctionF {
    public static int start(int x) throws InterruptedException {
        return x*2;
    }
    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        if (args.length!=1) {
            System.out.println("No argument for Function F");
            System.exit(0);
        }
        System.exit(start(Integer.parseInt(args[0])));
    }
}
