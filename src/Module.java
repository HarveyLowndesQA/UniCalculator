
public class Module {
	
	public static final int MARWeight = 3;
	
	private String name;
	private int credits;
	
	public Module() {
	}
	
	public Module(String name, int credits) {
		this.setName(name);
		this.setCredits(credits);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		switch(credits) {
		case 10:
		case 15:
		case 20:
		case 30:
		case 40:
		case 45:
		case 50:
		case 60:
			Course.currentTotalCredits += credits;
			this.credits = credits;
			break;
		default:
			throw new IllegalArgumentException("Invalid credit amount.");
		}
	}
	
	public int getOverallWeight() {
		return this.credits * MARWeight;
	}

}
