package devutility.external.json.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import devutility.external.json.JsonUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class HashMapTest extends BaseTest {
	@Override
	public void run() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("asd", "123");
		map.put("qwe", "456");

		try {
			println(JsonUtils.serialize(map));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(HashMapTest.class);
	}
}