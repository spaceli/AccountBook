package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Log;
import model.Person;

public class FileAction {
	private static final String personFilename = "person.per";
	private static final String logfilename = "log.log";
	private static final String eventFilename = "event.txt";
	/**
	 * ´ÓÎÄ¼þ»ñÈ¡ÕË»§
	 * @return ÕË»§ÁÐ±í
	 */
	public static ArrayList<Person> getPersonListFromFile(){
		File personFile = new File(personFilename);
		return getPersonListFromFile(personFile);
	}
	public static ArrayList<Person> getPersonListFromFile(File personFile){
		if(!personFile.exists()){
			return new ArrayList<Person>();
		}
		ObjectInputStream oi = null;
		ArrayList<Person> list = null;
		try {
			oi = new ObjectInputStream(new FileInputStream(personFile));
			list = (ArrayList<Person>)(oi.readObject());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	/**
	 * ½«ÕË»§ÁÐ±í±£´æµ½ÎÄ¼þ
	 * @param list ÕË»§ÁÐ±í
	 * @throws IOException
	 */
	public static void savePersonList(List<Person> list) throws IOException{
		File personFile = new File(personFilename);
		if(!personFile.exists()){
			personFile.createNewFile();
		}
		ObjectOutputStream oo = null;
		try {
			oo = new ObjectOutputStream(new FileOutputStream(personFile));
			oo.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		
	}
	
	/**
	 * ´ÓÎÄ¼þ¶ÁÈ¡ÈÕÖ¾ÁÐ±í
	 * @return ÈÕÖ¾ÁÐ±í
	 */
	public static ArrayList<Log> getLogListFromFile(){
		File logFile = new File(logfilename);
		return getLogListFromFile(logFile);
	}
	public static ArrayList<Log> getLogListFromFile(File logFile){
		if(!logFile.exists()){
			return new ArrayList<Log>();
		}
		ObjectInputStream oi = null;
		ArrayList<Log> list = null;
		try {
			oi = new ObjectInputStream(new FileInputStream(logFile));
			list = (ArrayList<Log>)(oi.readObject());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	/**
	 * ±£´æÁÐ±íµ½ÎÄ¼þ
	 * @param list
	 * @throws IOException
	 */
	public static void saveLogList(List<Log> list) throws IOException{
		File logFile = new File(logfilename);
		if(!logFile.exists()){
			logFile.createNewFile();
		}
		ObjectOutputStream oo = null;
		try {
			oo = new ObjectOutputStream(new FileOutputStream(logFile));
			oo.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		
	}
	
	/**
	 * ´ÓÎÄ¼þ¶ÁÈ¡ÊÂ¼þÁÐ±í
	 * @return ÊÂ¼þÁÐ±í
	 */
	public static ArrayList<String> getEventListFromFile(){
		File eventFile = new File(eventFilename);
		ArrayList<String> list = new ArrayList<String>();
		if(!eventFile.exists()){
			return list;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(eventFile)));
			String s;
			while((s=br.readLine()) != null){
				list.add(s);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	
	public static void logPerson(Person p,String log){
		String folderName = "PersonLog";
		File folder = new File(folderName);
		if(!folder.exists()){
			folder.mkdir();
		}
		File logFile = new File(folderName+"/"+p.name+".txt");
		if(!logFile.exists()){
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(logFile);
			fw.write(log);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
