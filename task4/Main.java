/*
 * �������  4.  
 * ���������������.  
 * ����.  ������� ������� � ���� ��� ���������/�������� �����������. 
 * ����� �����������, ����������� � ������� ������ �  �����  �  ��  �������,  
 * ������  ����  ���������������  �  �����������  �������� ���������������� ����� � ����������� �����. 
 * � ����� �������� ��������� ��������. 
 * � ������ ������� ����� ������ ���� �������. 
 * ������� ����� ����������� � ������� ��� ������������. 
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