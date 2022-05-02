package by.epam.tasks.task4;

public class PortView {

	public void print(Port port) {

		int i = 0;

		System.out.println("\nBusy berths: " + port.getShips().size() + " of " + port.getNumberOfBerths());
		System.out.println("Port loaded: " + port.getLoaded() + " of " + port.getCapacity());
		for (Ship ship : port.getShips()) {
			i++;
			System.out.println("Ship" + i + ":\t" + ship);
		}
		
	}

}