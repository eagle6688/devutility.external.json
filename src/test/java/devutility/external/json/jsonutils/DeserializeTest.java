package devutility.external.json.jsonutils;

import java.io.IOException;
import java.util.Map;

import devutility.external.json.JsonUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class DeserializeTest extends BaseTest {
	@Override
	public void run() {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> map = JsonUtils.deserialize("{\"asd\":\"qwe\"}", Map.class);
			println(map.getClass().getName());
			println(JsonUtils.serialize(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(DeserializeTest.class);
	}
}