package by.epam.tasks.task4;

public class Ship {
    
    private int     payload, loading;
    private boolean download, inPort;
    
    public Ship(int payload, int loading, boolean download) {  
        this.payload  = payload;
        this.loading  = loading;
        this.download = download;
        this.inPort   = true;
    }
    
    public int getPayload() {
        return payload;       
    }
    
    public int getLoading() {
        return loading;       
    }
    
    public boolean getDownload() {
        return download;       
    }
    
    public boolean shipInPort() {
        return inPort;       
    }
    
    public void setLoading(int loading) {
        this.loading = loading;     
    }
    
    public void leaveThePort() {
        inPort = false;
    }
    
    @Override
    public String toString() {
        String download_unload = ((download == true) ? "Download" : "Unload");
        return "Payload: " + payload + "\t Loading: " + loading + "\t " + download_unload;
    }
    
}
