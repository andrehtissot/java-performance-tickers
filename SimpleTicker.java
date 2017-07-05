package andretissot;

public class SimpleTicker {
    long lastTick = 0;

    public SimpleTicker(boolean start) {
        if(start)
            startTick();
    }
    public SimpleTicker() {
    }

    public void startTick(){
        lastTick = System.nanoTime();
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
}