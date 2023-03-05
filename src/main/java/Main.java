
public class Main {
    public static void main(String[] args) {
        long startProgramTime = System.currentTimeMillis();
        if (args.length == 0) {
            args = new String[] {"lng.csv"};
        }

        System.out.printf("Execution time %d seconds", (System.currentTimeMillis() - startProgramTime) / 1000);
    }
}

