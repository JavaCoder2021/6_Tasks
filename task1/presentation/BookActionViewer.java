package by.epam.tasks.task1.presentation;

public class BookActionViewer {
	
	public static String bookViewAnswer(String result) {

		String response;

		if (result != "") {
			response = result;
		} else {
			response = "1 Data entry error";
		}

		return response;

	}

}
