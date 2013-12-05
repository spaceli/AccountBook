package model;

import java.io.Serializable;

public class Person implements Serializable{
	public String name;
	public double money;
	
	public Person(String name,double money){
		this.name = name;
		this.money = money;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Person p = (Person)arg0;
		if(this.name.equals(p.name)) return true;
		else return false;
	}
}
