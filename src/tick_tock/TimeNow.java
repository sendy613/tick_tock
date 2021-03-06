package tick_tock;

import java.sql.Time;
import java.text.DecimalFormat;

public class TimeNow {
	private int hours;
	private int min;
	private int seconds;
	private Long currTime;

	public TimeNow() {
		currTime = System.currentTimeMillis();
		Time time = new Time(currTime);
		String s = time.toString();
		String[] array = s.split(":");
		hours = Integer.parseInt(array[0]);
		min = Integer.parseInt(array[1]);
		seconds = Integer.parseInt(array[2]);

	}

	public TimeNow(int hours, int min, int sec) {
		this.hours = hours;
		this.min = min;
		this.seconds = sec;
	}

	public int getHours() {
		return hours;
	}

	public int getMin() {
		return min;
	}

	public int getSeconds() {
		return seconds;
	}

	public Long getCurrTime() {
		return currTime;
	}

	public void setCurrTime(Long currTime) {
		this.currTime = currTime;
	}

	public boolean equals(TimeNow t) {
		if (t.getHours() == this.getHours() && t.getMin() == this.getMin()) {
			return true;
		}
		return false;
	}

	public void tick() {
		if (hours == 23 && min == 59 && seconds == 59) {
			hours = 0;
			min = 0;
			seconds = 0;
		} else if (min == 59 && seconds == 59) {
			hours++;
			min = 0;
			seconds = 0;
		} else if (seconds == 59) {
			min++;
			seconds = 0;
		} else {
			seconds++;
		}

	}

	public String toString() {
		DecimalFormat formatter = new DecimalFormat("00");
		return (formatter.format(getHours()) + ":" + formatter.format(getMin()));
	}

	public boolean isASecondPast(TimeNow currAlarm) {
		if (this.seconds == 0) {
			if (currAlarm.hours == 23 && currAlarm.min == 59 && this.hours == 0 && this.min == 0) {
				return true;
			} else if (currAlarm.min == 59 && this.min == 0 && this.hours - currAlarm.hours == 1) {
				return true;
			} else if (currAlarm.hours == this.hours && this.min - currAlarm.min == 1) {
				return true;
			}
		}
		return false;
	}

}
