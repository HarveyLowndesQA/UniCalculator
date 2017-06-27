import java.util.ArrayList;
import java.util.List;

public class Course {

	private int totalCredits;
	private List<Result> resultsList;
	public static int currentTotalCredits;
	
	public Course(int totalCredits) {
		this.setTotalCredits(totalCredits);
		this.setResultsList(new ArrayList<Result>(0));
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		if(totalCredits >= 15) { //Add more validation so that only multpiles of 5 or 10 can be added.
			this.totalCredits = totalCredits;
		} else {
			throw new IllegalArgumentException("Credits must have a minimum of 15 credits and a maximum of 120.");
		}
	}

	public List<Result> getResultsList() {
		return resultsList;
	}

	public void setResultsList(List<Result> resultsList) {
		this.resultsList = resultsList;
	}
	
	public void addResultToList(Result result){
		resultsList.add(result);
	}
	
	public int getOverallModulesMARWeight() {
		int weight = 0;
		for(Result result : resultsList){
			weight += result.getModule().getOverallWeight();
		}
		return weight;
	}
	
	public int getOverallWeightedMark() {
		int weight = 0;
		for(Result result : resultsList){
			weight += result.getWeightedMark();
		}
		return weight;
	}
	
	public float getOverallOverallAwardMark() {
		return getOverallWeightedMark() / getOverallModulesMARWeight();
	}
}
