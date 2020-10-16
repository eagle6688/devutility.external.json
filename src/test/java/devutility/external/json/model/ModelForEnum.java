package devutility.external.json.model;

public class ModelForEnum {
	private MyEnum myEnum;
	private String type;

	public ModelForEnum() {
		System.out.println(type);
	}

	public MyEnum getMyEnum() {
		return myEnum;
	}

	public void setMyEnum(MyEnum myEnum) {
		this.myEnum = myEnum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}