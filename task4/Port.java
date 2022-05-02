package by.epam.tasks.task4;

import java.io.Serializable;
import java.util.*;

public class Port implements Serializable {

	private static final long serialVersionUID = 1L;
	private final int capacity;
	private int loaded;
	private final int numberOfBerths;
	private List<Ship> ships = new ArrayList<Ship>();
	private List<ShipThread> shipThreads = new ArrayList<ShipThread>();

	public Port() {
		super();
		capacity = 1000;
		loaded = 500;
		numberOfBerths = 10;
	}

	public Port(int capacity, int loaded, int numberOfBerths) {
		super();
		this.capacity = capacity;
		this.loaded = loaded;
		this.numberOfBerths = numberOfBerths;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public synchronized int getLoaded() {
		return loaded;
	}

	public synchronized void setLoaded(int loaded) {
		this.loaded = loaded;
	}

	public int getNumberOfBerths() {
		return numberOfBerths;
	}

	public synchronized List<Ship> getShips() {
		return ships;
	}

	public synchronized List<ShipThread> getShipThreads() {
		return shipThreads;
	}

	public synchronized void addShip(Ship ship) {
		if (ship != null) {
			ShipThread shipThread = new ShipThread(this, ship);
			ships.add(ship);
			shipThreads.add(shipThread);
			shipThread.start();
		}
	}

	public synchronized void removeShip(Ship ship) {
		if (ship != null) {
			for (ShipThread shipThread : shipThreads)
				if (shipThread.getShip().equals(ship)) {
					shipThread.interrupt();
					shipThreads.remove(shipThread);
					ships.remove(ship);
					break;
				}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + loaded;
		result = prime * result + numberOfBerths;
		result = prime * result + ((shipThreads == null) ? 0 : shipThreads.hashCode());
		result = prime * result + ((ships == null) ? 0 : ships.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Port other = (Port) obj;
		if (capacity != other.capacity)
			return false;
		if (loaded != other.loaded)
			return false;
		if (numberOfBerths != other.numberOfBerths)
			return false;
		if (shipThreads == null) {
			if (other.shipThreads != null)
				return false;
		} else if (!shipThreads.equals(other.shipThreads))
			return false;
		if (ships == null) {
			if (other.ships != null)
				return false;
		} else if (!ships.equals(other.ships))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Port [ships=" + ships + ", portLoaded=" + loaded + ", portCapacity=" + capacity + ", numberOfBerths="
				+ numberOfBerths + "]";
	}

}