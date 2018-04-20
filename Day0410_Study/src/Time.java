
public class Time {
	private int hour;
	private int minute;
	private int second;

	public Time() {}
	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public void setTime(int hour, int minute, int second) {
		if(!( (hour >= 0 && hour <= 24) )) {
			System.out.println("범위에 맞는 시간을 입력해주세요.");
			hour = 0;
		}
		if(!(minute >= 0 && minute <= 59)) {
			System.out.println("범위에 맞는 분을 입력해주세요.");
			minute = 0;
		}
		if(!(second >= 0 && second <= 59)) {
			System.out.println("범위에 맞는 초를 입력해주세요.");
			second = 0;
		}
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// getter , setter
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	// display 
	public void showTime() {
		System.out.printf(" %02d시 %02d분 %02d초 입니다.\n",hour,minute,second);
	}
	public String timeString() {
		String str = String.format(" %02d시 %02d분 %02d초 입니다.", this.hour,this.minute,this.second);
		return str;
	}
}