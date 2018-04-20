
public class SportsPlayer {
	protected String name;
	protected String teamName;
	protected String[] reward_Career;
	protected int age;
	protected int salary;
	private int reward_Count;
	
	public SportsPlayer(){
		reward_Count = 0;
		reward_Career = new String[0];
	}
	public SportsPlayer(String name, int age) {
		this.name = name;
		this.age = age;
		this.teamName = "무소속";
		reward_Count = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String[] getReward_Career() {
		return reward_Career;
	}
	public void AddReward_Career(String reward_Name) {
		String[] tmp = reward_Career;
		reward_Career = new String[reward_Count+1];
		
		for(int i = 0; i < tmp.length; i++ ) {
			reward_Career[i] = tmp[i];
		}
		reward_Career[reward_Count] = reward_Name;
		reward_Count++;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
