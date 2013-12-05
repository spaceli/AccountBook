package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Log implements Serializable{
	private long time;
	public String event;
	public ArrayList<String> names;
	
	public Log(long time,String event,ArrayList<String> names){
		this.time = time;
		this.event = event;
		this.names = names;
	}

	public String getTime() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(c.getTime());
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public String getNames(){
		StringBuffer sb = new StringBuffer();
		for(String s:names){
			sb.append(s + " ");
		}
		return sb.toString();
	}
	public boolean incluePerson(Person p){
		for(String s:names){
			if(s.equals(p.name)){
				return true;
			}
		}
		return false;
	}
	public boolean olderThan(Log lg){
		if(this.time < lg.time) return true;
		else return false;
	}
}
