package by.epam.tasks.task1.presentation;

public class UserActionViewer {

	public static String loginationAnswer(boolean result) {

		String response;

		if (result) {
			response = "0 User hello";
		} else {
			response = "1 Data entry error";
		}

		return response;

	}
	
	public static String registrationAnswer(boolean result) {

		String response;

		if (result) {
			response = "0 User hello";
		} else {
			response = "1 Data entry error";
		}

		return response;

	}

}