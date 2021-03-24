package devutility.external.json.model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private int id;
	private String name;
	private int age;

	@JsonProperty("Countries")
	private String[] countries;

	private Date birthday;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String[] getCountries() {
		return countries;
	}

	public void setCountries(String[] countries) {
		this.countries = countries;
	}

	@Transient
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static List<User> list(int count) {
		List<User> list = new ArrayList<>(count);
		String[] countries = { "us", "uk", "cn" };

		for (int i = 0; i < count; i++) {
			User user = new User();
			user.setId(1000 + i + 1);
			user.setAge(i + 20);
			user.setBirthday(new Date());
			user.setCountries(countries);
			user.setName(String.format("Name_%s", i + 1));
			list.add(user);
		}

		return list;
	}

	public static String[][] arrays(int count) {
		String[][] arrays = new String[count][5];
		List<User> list = list(count);

		for (int i = 0; i < count; i++) {
			User user = list.get(i);
			arrays[i][0] = String.valueOf(user.getId());
			arrays[i][1] = String.valueOf(user.getAge());
			arrays[i][2] = String.valueOf(user.getBirthday().getTime());
			arrays[i][3] = String.join(",", user.getCountries());
			arrays[i][4] = user.getName();
		}

		return arrays;
	}
}