
public class Result {

	private Module module;
	private int mark;
	
	public Result() {
		
	}
	
	public Result(Module module, int mark) {
		this.setModule(module);
		this.setMark(mark);
	}

	public Module getModule() {
		return module;
	}

	public Result setModule(Module module) {
		this.module = module;
		return this;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		if(mark > -1 && mark < 101)
			this.mark = mark;
		else
			throw new IllegalArgumentException("Mark must be between 0-100.");
	}
	
	public int getWeightedMark() {
		return mark * module.getOverallWeight();
	}
	
}
