package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FileHandler {

	public FileHandler() {
		// TODO Auto-generated constructor stub
	}

	public void readObjectfromFile(String filename) {
		UserProfile userObject = new UserProfile();
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			userObject = (UserProfile) objectIn.readObject();
			System.out.println("The Object read from file is: " + userObject.toString());
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateObjectIntoFile(String filename, UserProfile userProfile) {
		try {
			deleteFile(filename);
			writeObjectIntoFile(filename, userProfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeObjectIntoFile(String filename, UserProfile userProfile) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(userProfile);
			objectOutputStream.close();
			System.out.println("File written...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserProfile readObjectFromFile(String fileName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			UserProfile userProfile = (UserProfile) objectInputStream.readObject();
			objectInputStream.close();
			return userProfile;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
			System.out.println("File deleted...");
		} else {
			System.out.println("File does not exists...");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayAllFiles(String directory) throws IOException {
		File f = new File(directory); // current directory
		File[] files = f.listFiles();

		Arrays.sort(files, new Comparator() {
			@Override
			public int compare(Object f1, Object f2) {
				return ((File) f1).getName().compareTo(((File) f2).getName());
			}
		});

		if (files.length > 0) {
			for (File file : files) {
				if (file.isFile()) {
					System.out.print("file:");
					System.out.println(file.getCanonicalPath());
				}
			}
		} else {
			System.out.println("No files found...");
		}
	}

	public void searForFilename(String directory, String filename) throws IOException {
		File f = new File(directory); // current directory
		File[] files = f.listFiles();
		if (files.length > 0) {
			for (File file : files) {
				if (file.isFile() && file.getName().contains(filename)) {
					System.out.print("file:");
					System.out.println(file.getCanonicalPath());
				}
			}
		} else {
			System.out.println("No files found...");
		}
	}

}
