package bean;

public class university {

	private int universityId;
	private String eName;
	private String aName;
	private String website;

	public university(int universityId, String eName, String aName, String website) {
		super();
		this.universityId = universityId;
		this.eName = eName;
		this.aName = aName;
		this.website = website;
	}

	public university(String eName, String aName, String website) {
		super();
		this.eName = eName;
		this.aName = aName;
		this.website = website;
	}
	public university() {
		// TODO Auto-generated constructor stub
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "university [universityId=" + universityId + ", eName=" + eName + ", aName=" + aName + ", website="
				+ website + "]";
	}

}
