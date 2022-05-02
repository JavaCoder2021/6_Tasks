package by.epam.tasks.task4;

import java.io.Serializable;

public class Ship implements Serializable {

	private static final long serialVersionUID = 1L;
	private int capacity;
	private int loaded;
	private boolean loadingUnloading;

	public Ship() {
		super();
		capacity = 100;
		loaded = 0;
		loadingUnloading = true;
	}

	public Ship(int capacity, int loaded, boolean loadingUnloading) {
		super();
		this.capacity = capacity;
		this.loaded = loaded;
		this.loadingUnloading = loadingUnloading;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getLoaded() {
		return loaded;
	}

	public void setLoaded(int loaded) {
		this.loaded = loaded;
	}

	public boolean isLoadingUnloading() {
		return loadingUnloading;
	}

	public void setLoadingUnloading(boolean loadingUnloading) {
		this.loadingUnloading = loadingUnloading;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + loaded;
		result = prime * result + (loadingUnloading ? 1231 : 1237);
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
		Ship other = (Ship) obj;
		if (capacity != other.capacity)
			return false;
		if (loaded != other.loaded)
			return false;
		if (loadingUnloading != other.loadingUnloading)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Capacity: " + capacity + "\t Loaded: " + loaded + "\t "
				+ ((loadingUnloading == true) ? "Loading" : "Unloading");
	}

}