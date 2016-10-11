package test.domain;

public class Education {
    private Integer id;

    private String school;

    private String major;

    private String degree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

	@Override
	public String toString() {
		return "Education [id=" + id + ", school=" + school + ", major=" + major + ", degree=" + degree + "]";
	}
	
}