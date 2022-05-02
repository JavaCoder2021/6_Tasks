package by.epam.tasks.task4;

public class ShipThread extends Thread {

	private Port port;
	private Ship ship;

	public ShipThread(Port port, Ship ship) {
		super();
		this.port = port;
		this.ship = ship;
	}

	public Ship getShip() {
		return ship;
	}

	public void run() {
		try {
			if (ship.isLoadingUnloading()) {
				while (ship.getLoaded() < ship.getCapacity() && port.getLoaded() > 0) {
					port.setLoaded(port.getLoaded() - 1);
					ship.setLoaded(ship.getLoaded() + 1);
					Thread.sleep(500);
				}
			} else if (!ship.isLoadingUnloading()) {
				while (ship.getLoaded() > 0 && port.getLoaded() < port.getCapacity()) {
					port.setLoaded(port.getLoaded() + 1);
					ship.setLoaded(ship.getLoaded() - 1);
					Thread.sleep(500);
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}