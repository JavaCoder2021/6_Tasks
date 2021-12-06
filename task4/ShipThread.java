package by.epam.tasks.task4;

public class ShipThread extends Thread {
    
    private int     index;
    private boolean isActive;
         
    ShipThread(int index) {     
        super();
        this.index = index;
        isActive   = true;      
    }
      
    void disable() {       
        isActive = false;      
    }
      
    public void run() {
        try {
            if (Main.ships.get(index).getDownload())
                while (Main.ships.get(index).getLoading() < Main.ships.get(index).getPayload() && Main.portLoading > 0) {
                    Thread.sleep(500);
                    Main.ships.get(index).setLoading(Main.ships.get(index).getLoading() + 1);
                    Main.portLoading--;
                }
            if (!Main.ships.get(index).getDownload())
                while (Main.ships.get(index).getLoading() > 0 && Main.portLoading < Main.portCapacity) {
                    Thread.sleep(500);
                    Main.ships.get(index).setLoading(Main.ships.get(index).getLoading() - 1);
                    Main.portLoading++;
                }
        }
        catch(InterruptedException e) {
            System.out.println("Thread has been interrupted!");
        }       
    }
    
}
