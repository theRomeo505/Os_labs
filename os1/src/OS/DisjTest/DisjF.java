package OS.DisjTest;

import os.lab1.compfuncs.basic.Disjunction;

import java.util.Optional;

public class DisjF {
    public static int start(int x) throws InterruptedException {
        Optional<Boolean> result = Disjunction.trialF(x);
        if (result.isPresent())
            return result.get()? 1:0;

        throw new IllegalArgumentException("F Computation can't be done");
    }
    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        if (args.length!=1) {
            System.out.println("No argument for Func G");
            System.exit(0);
        }
        try {
            System.exit(start(Integer.parseInt(args[0])));
        } catch (NumberFormatException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
