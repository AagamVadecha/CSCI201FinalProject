package classes;

import java.util.Vector;

public class QueueManager {
	public static void startQueue(int courseID) {
//		QueueDBM.makeTable(courseID);
		return;
	}

	public static void addQuestion(int courseID, int studentID, String text) {
		QueueDBM.insertEntry(courseID, studentID, text);
	}

	public static Vector<Vector<String>> printQueue(int courseID) {
		return QueueDBM.selectQueue(courseID);
	}

	public static void cancelQuestion(int courseID, int studentID) {
		QueueDBM.deleteEntry(courseID, studentID);
	}

	public static void stopQueue(int courseID) {
		QueueDBM.deleteQueue(courseID);
	}

//	public static void promoteQuestion(int courseID, int studentID) {
//		QueueDBM.promoteEntry(courseID, studentID);
//	}

	public static void ejectQuestion(int courseID, int studentID) {
		QueueDBM.deleteEntry(courseID, studentID);
	}

	public static void blacklist(int studentID) {
		QueueDBM.addStrike(studentID);
	}

}


