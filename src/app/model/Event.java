package app.model;

import java.util.Vector;

import lib.IdentificatorBuilder;

public class Event {
	private String id;
	private String dayInNum;
	private String thingsToDo;
	
	public Event(String dayInNum, String thingsToDo) {
		this.id = IdentificatorBuilder.getUUID();
		this.dayInNum= dayInNum;
		this.thingsToDo=thingsToDo;
		System.out.println(id);
	}

	public String getId() {
		return id;
	}
	
	public String getDayInNum() {
		return dayInNum;
	}

	public void setDayInNum(String dayInNum) {
		this.dayInNum = dayInNum;
	}

	public String getThingsToDo() {
		return thingsToDo;
	}

	public void setThingsToDo(String thingsToDo) {
		this.thingsToDo = thingsToDo;
	}
	
	public Vector<String> toVector() {
		Vector<String> v= new Vector<String>();
		v.add(this.getId());
		v.add("May "+  this.getDayInNum());
		v.add(this.getThingsToDo());
		return v;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", dayInNum=" + dayInNum + ", thingsToDo=" + thingsToDo + "]";
	}
	
}
