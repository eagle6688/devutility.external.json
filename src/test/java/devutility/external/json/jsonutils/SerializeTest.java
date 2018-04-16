package devutility.external.json.jsonutils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.devutility.test.json.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import devutility.external.json.JsonUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SerializeTest extends BaseTest {
	@Override
	public void run() {
		try {
			println(JsonUtils.serialize(new String[0]));

			List<String> list = new ArrayList<>();
			list.add("1");
			String[] array = list.stream().filter(i -> "2".equals(i)).collect(Collectors.toList()).toArray(new String[0]);
			println(JsonUtils.serialize(array));

			User user = new User();
			user.setCountries(new String[0]);
			println(JsonUtils.serialize(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(SerializeTest.class);
	}
}