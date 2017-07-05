package andretissot;

public class Ticker {
    long lastTick = 0;
    long lastCurrentMemory = 0;

    public Ticker(boolean start) {
        if(start){
            startMemory();
            startTick();
        }
    }
    public Ticker() {
    }

    public void startTick(){
        System.gc();
        lastTick = System.nanoTime();
    }

    public void startMemory(){
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        lastCurrentMemory = runtime.totalMemory() - runtime.freeMemory();
    }

    public long diffTick(){
        return System.nanoTime() - lastTick;
    }

    public String diffTickVerbose(int decimals, String decPoint){
        return String.format("%."+decimals+"f", (((float) diffTick()) / 1000000000)).replace(".", decPoint)+" sec.";
    }

    public String diffTickVerbose(int decimals){
        return String.format("%."+decimals+"f", (((float) diffTick()) / 1000000000))+" sec.";
    }

    public String diffTickVerbose(){
        return String.format("%.2f", (((float) diffTick()) / 1000000000))+" sec.";
    }

    public void echoTick(String messageBefore, String messageAfter, int decimals, String decPoint){
        System.out.print(messageBefore + diffTickVerbose(decimals, decPoint) + messageAfter);
        startTick();
    }

    public void echoTick(String messageBefore, String messageAfter, int decimals){
        System.out.print(messageBefore + diffTickVerbose(decimals) + messageAfter);
        startTick();
    }

    public void echoTick(String messageBefore, String messageAfter){
        System.out.print(messageBefore + diffTickVerbose() + messageAfter);
        startTick();
    }

    public void echoTick(String messageBefore){
        echoTick(messageBefore, "\n");
    }

    public long diffMemory(){
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        return runtime.totalMemory() - runtime.freeMemory() - lastCurrentMemory;
    }

    public String diffMemoryVerbose(int decimals, String decPoint){
        return String.format("%."+decimals+"f", (((float) diffMemory()) / 1048576)).replace(".", decPoint)+" MB.";
    }

    public String diffMemoryVerbose(int decimals){
        return String.format("%."+decimals+"f", (((float) diffMemory()) / 1048576))+" MB.";
    }

    public String diffMemoryVerbose(){
        return String.format("%.2f", (((float) diffMemory()) / 1048576))+" MB.";
    }

    public void echoMemory(String messageBefore, String messageAfter, int decimals, String decPoint){
        System.out.print(messageBefore + diffMemoryVerbose(decimals, decPoint) + messageAfter);
        startMemory();
    }

    public void echoMemory(String messageBefore, String messageAfter, int decimals){
        System.out.print(messageBefore + diffMemoryVerbose(decimals) + messageAfter);
        startMemory();
    }

    public void echoMemory(String messageBefore, String messageAfter){
        System.out.print(messageBefore + diffMemoryVerbose() + messageAfter);
        startMemory();
    }

    public void echoMemory(String messageBefore){
        echoMemory(messageBefore, "\n");
    }
}
