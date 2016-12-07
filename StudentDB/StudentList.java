import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class StudentList {

	private static final String FILE_NAME = "studentdb.ser";

	public static void main(String[] args) throws IOException {
		List<Student> registeredStudents = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		int select;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		File fin = new File(FILE_NAME);
		if (fin.length() == 0) {
			System.err.println("FILE IS EMPTY");
		} else {
			fis = new FileInputStream(fin);
			ois = new ObjectInputStream(fis);
			try {

				registeredStudents = (List<Student>) ois.readObject();


				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException ce) {
				// this might be thrown by ois.readObject()
				ce.printStackTrace();
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		do {
			System.out.println("STUDENT DATABASE");
			System.out
					.println("Key in the corresponding number of the procedure you wanted: ");
			System.out.println("\t(1) Register\n\t"
					+ "(2) View Student Directory\n\t" + "(3) Deregister\n\t"
					+ "(4) Edit Student Info\n\t" + "(5) Student List View\n\t"
					+ "(6) SAVE \n\t" + "(7) Exit");
			select = sc.nextInt();

			if (select == 1) {
				System.out.println("Register");
				System.out.println("Enter student number(YYYYxxxxx format): ");
				String x = sc.nextLine();
				String studentNumber = sc.nextLine();
				System.out.println("Enter the following: ");
				System.out.print("* First Name: ");
				String fn = sc.nextLine();
				System.out.print("* Middle Initial: ");
				char mi = sc.nextLine().charAt(0);
				System.out.print("* Last Name: ");
				String ln = sc.nextLine();
				System.out.print("* Degree Program: ");
				String dp = sc.nextLine();
				System.out.print("* Year Level: ");
				int level = sc.nextInt();
				sc.nextLine();
				System.out.print("* Crush Name: ");
				String cn = sc.nextLine();
				System.out.print("* Favorite Course: ");
				String code = sc.nextLine();
				System.out.print("* Favorite Course Description: ");
				String desc = sc.nextLine();
				Course favSub = new Course(code, desc);
				Student student = new Student(studentNumber, fn, mi, ln, dp,
						level, cn, favSub);
				registeredStudents.add(student);
				System.out.println("NEW STUDENT");
				System.out.println(student);
			}

			if (select == 2) {
				System.out.println("Enter student number(YYYYxxxxx format): ");
				String x = sc.nextLine();
				String sn = sc.nextLine();
				boolean exists = false;
				for (int i = 0; i < registeredStudents.size(); i++) {
					if (registeredStudents.get(i).getStudentNumber().equals(sn)) {
						System.out.print(registeredStudents.get(i) + "\n\n");
						exists = true;
						break;
					}
				}
				if (exists == false) {
					System.out.print("Student not found.");
				}
			}

			if (select == 3) {
				System.out.println("Enter student number(YYYYxxxxx format): ");
				String x = sc.nextLine();
				String stn = sc.next();
				boolean existing = false;
				for (int i = 0; i < registeredStudents.size(); i++) {
					if (registeredStudents.get(i).getStudentNumber()
							.equals(stn)) {
						registeredStudents.remove(i);
						existing = true;
						System.out.println("SUCCESS!");
						break;
					}
				}
				if (existing == false) {
					System.out.println("Student not found.\n");
				}
			}

			if (select == 4) {
				System.out.print("Enter student number: ");
				String x = sc.nextLine();
				String stno = sc.nextLine();
				boolean uneditable = true;
				for (int i = 0; i < registeredStudents.size(); i++) {
					if (registeredStudents.get(i).getStudentNumber()
							.equals(stno)) {
						System.out.println("STUDENT PROFILE\n"
								+ registeredStudents.get(i));
						System.out.println("UPDATE FIELDS:\n");
						System.out.println("STUDENT NUMBER: "
								+ registeredStudents.get(i).getStudentNumber());
						System.out.print("Edit First Name: ");
						registeredStudents.get(i).setFirstName(sc.nextLine());
						System.out.print("Edit Middle Initial: ");
						registeredStudents.get(i).setMiddleInitial(
								sc.nextLine().charAt(0));
						System.out.print("Edit Last Name: ");
						registeredStudents.get(i).setLastName(sc.nextLine());
						System.out.print("Edit Degree Program: ");
						registeredStudents.get(i).setCourse(sc.nextLine());
						System.out.print("Edit Crush Name: ");
						registeredStudents.get(i).setCrushName(sc.nextLine());
						System.out.print("Edit Favorite Subject: ");
						registeredStudents.get(i).setCrushName(sc.nextLine());

						System.out
								.println("INFORMATION UPDATED!\nSTUDENT PROFILE\n"
										+ registeredStudents.get(i));
						uneditable = false;
						break;
					}
				}
				if (uneditable == true)
					System.out.println("Student not found");
			}

			if (select == 5) {
				System.out.println("STUDENT DIRECTORY");
				for (int i = 0; i < registeredStudents.size(); i++) {
					System.out.print(registeredStudents.get(i));
					System.out.println("-");
				}
			}

			if (select == 6) {
				FileOutputStream fos = null;
				ObjectOutputStream oos = null;

				File fout = new File(FILE_NAME);
				fos = new FileOutputStream(fout);
				oos = new ObjectOutputStream(fos);

				oos.writeObject(registeredStudents);

				oos.close();

			}
		} while (select != 7);
		System.out.println("Thank you! Program terminated.");
	}
}