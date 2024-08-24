package donation.dto;

public class DonationListDto {
	private int seq;
	private String title;
	private String categories;
	private String text;
	private String startDate;
	private String lastDate;
	private String points;
	private String targetAmount;
	private String filePath;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}

	public String getImagePath() {
		return filePath;
	}
	
	public void setImagePath(String filePath) {
		this.filePath = filePath;
		
	}
}
