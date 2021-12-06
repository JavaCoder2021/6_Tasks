/*
 * Задание  4.  
 * Многопоточность.  
 * Порт.  Корабли заходят в порт для разгрузки/загрузки контейнеров. 
 * Число контейнеров, находящихся в текущий момент в  порту  и  на  корабле,  
 * должно  быть  неотрицательным  и  превышающим  заданную грузоподъемность судна и вместимость порта. 
 * В порту работает несколько причалов. 
 * У одного причала может стоять один корабль. 
 * Корабль может загружаться у причала или разгружаться. 
 */
package by.epam.tasks.task4;

import java.util.*;

public class Main {
    
    public static int portCapacity, numberOfBerths, portLoading;
    public static ArrayList<Ship> ships = new ArrayList();
    public static ArrayList<ShipThread> shipThreads = new ArrayList();
    public static int shipsInPort = 0;    
    
    public static void main(String[] args) {
                       
        Random random = new Random();
    
        //Input
        portCapacity   = scannerInt("Port capacity: ");
        numberOfBerths = scannerInt("Number of berths: ");   
        portLoading    = random.nextInt(portCapacity);
        if (portLoading < 500) portLoading = 500;
        
        final Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                 
                //Ships are entering the port
                if (shipsInPort < numberOfBerths) {
                    int rnd = random.nextInt(35) + 35;
                    boolean downloadNow = (rnd >= 50 ? false : true); 
                    if (downloadNow) rnd = 0;
                    ships.add(new Ship(100, rnd, downloadNow));
                    int index = shipThreads.size();                    
                    shipThreads.add(new ShipThread(index));
                    shipThreads.get(index).start();
                    shipsInPort++;
                }
                
                //Ships leave the port
                for (int i = 0; i < ships.size(); i++) {
                    if ((ships.get(i).getDownload() && ships.get(i).getLoading() == ships.get(i).getPayload()) || 
                            (!ships.get(i).getDownload() && ships.get(i).getLoading() == 0)) 
                        if (ships.get(i).shipInPort()) {
                            shipThreads.get(i).disable();
                            ships.get(i).leaveThePort();
                            shipsInPort--;
                    }                
                }

                //Output
                System.out.println("\nBusy berths: " + shipsInPort + " of " + numberOfBerths);                
                System.out.println("Port capacity: " + portLoading + " of " + portCapacity);
                for (Ship nowShip : ships)
                    if (nowShip.shipInPort())
                        System.out.println(nowShip.toString());                    
                
            }
        }, 0, 1000);
        
    }
    
    private static int scannerInt(String str) {
        
        Scanner input = new Scanner(System.in);
        int num = -1;
        
        do {
            System.out.print(str);
            if (input.hasNextInt()) {
                num = input.nextInt();
            } 
            else {
                input.next();
            }
        } while (num <= 0);

        return num;
        
    }
    
}
