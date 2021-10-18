package OS.Test;

public class FunctionG {
    public static int start(int x) throws InterruptedException {
        return x*x;

    }
    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        if (args.length!=1) {
            System.out.println("No argument for Func G");
            System.exit(0);
        }
        System.exit(start(Integer.parseInt(args[0])));
    }
}
