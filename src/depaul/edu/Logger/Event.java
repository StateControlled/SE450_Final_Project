package depaul.edu.Logger;

import java.util.Date;

public class Event {
	//required parameters
	private Level level;
	private String message;
	private Date date;
	
	//optional parameters
	private String optionalMessage;

	private Event(EventBuilder builder) {
		this.level = builder.bLevel;
		this.date = builder.bDate;
		this.message = builder.bMessage;
		this.optionalMessage = builder.bOptionalMessage1;
	}
	
	public Level getLevel() {
		return level;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	public String getOptionalMessage1() {
		return optionalMessage;
	}

	@Override
	public String toString() {
		String thisString = String.format("%s %s %s", date.toString(), level.toString(), message);
		return (optionalMessage != null) ? (thisString + " " + optionalMessage) : thisString;
	}
	
	//Builder Class
	public static class EventBuilder{
		// required parameters
		private Level bLevel;
		private String bMessage;
		private Date bDate;

		// optional parameters
		private String bOptionalMessage1;
		
		public EventBuilder(Level level, Date date, String message){
			this.bLevel = level;
			this.bDate = date;
			this.bMessage = message;
		}

		public Event build(){
			return new Event(this);
		}

		public EventBuilder setbOptionalMessage1(String optionalMessage) {
			this.bOptionalMessage1 = optionalMessage;
			return this;
		}
	}

}
