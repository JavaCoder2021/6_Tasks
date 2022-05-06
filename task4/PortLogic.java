package by.epam.tasks.task4;

import java.util.*;

public class PortLogic {

	private Random random = new Random();
	private Ship ship;
	private int shipCapacity = 50;

	public Ship addShipInPort(Port port) {

		if (port.getShips().size() < port.getNumberOfBerths()) {

			if (random.nextInt(2) == 1)
				ship = new Ship(shipCapacity, 0, true);
			else
				ship = new Ship(shipCapacity, shipCapacity, false);

			return ship;

		}

		return null;

	}

	public Ship removeShipFromPort(Port port) {

		for (ShipThread shipThread : port.getShips()) {
			ship = shipThread.getShip();
			if (ship.isLoadingUnloading() && ship.getLoaded() == ship.getCapacity())
				return ship; 
			else if (!ship.isLoadingUnloading() && ship.getLoaded() == 0)
				return ship;
		}
		
		return null;

	}

}
