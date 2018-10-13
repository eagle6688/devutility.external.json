package devutility.external.json.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MyEnum {
	UNKNOW(10), ASD(11), QWE(12);

	public int value;

	MyEnum(int value) {
		this.value = value;
	}

	@JsonCreator
	public static MyEnum parse(int value) {
		MyEnum[] array = MyEnum.values();

		for (int i = 0; i < array.length; i++) {
			if (value == array[i].value) {
				return array[i];
			}
		}

		return MyEnum.UNKNOW;
	}
}