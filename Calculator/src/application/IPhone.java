package application;

@SmartPhone
public class IPhone {

	String os;
	int version;

	public IPhone(String os, int version) {
		super();
		this.os = os;
		this.version = version;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
