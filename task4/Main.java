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

	public static void main(String[] args) {

		Port port = new Port(1000, 500, 10);
		PortLogic portLogic = new PortLogic();
		PortView portView = new PortView();

		final Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {

				port.addShip(portLogic.addShipInPort(port));

				port.removeShip(portLogic.removeShipFromPort(port));

				portView.print(port);

			}
			
		}, 0, 1000);

	}

}