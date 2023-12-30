package foodcourt.dto;

public class User {
	private String name;
	private String gender;
	private int age;
	private long phno;
	private String email;
	private String pwd;
	private double wallet;
	public User(String name, String gender, int age, long phno, String email, String pwd, double wallet) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phno = phno;
		this.email = email;
		this.pwd = pwd;
		this.wallet = wallet;
	}
	
	public User(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "\nUser [name=" + name + ", gender=" + gender + ", age=" + age + ", phno=" + phno + ", email=" + email
				+ ", pwd=" + pwd + ", wallet=" + wallet + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
	
}
