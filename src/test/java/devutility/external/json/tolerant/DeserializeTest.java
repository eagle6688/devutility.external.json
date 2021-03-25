package devutility.external.json.tolerant;

import java.io.IOException;
import java.nio.charset.Charset;

import com.fasterxml.jackson.core.type.TypeReference;

import devutility.external.json.JsonUtils;
import devutility.external.json.TolerantJsonUtils;
import devutility.external.json.model.BaseResponse;
import devutility.internal.io.TextFileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class DeserializeTest extends BaseTest {
	private String textFile = "E:\\Downloads\\Test\\Json.txt";

	@Override
	public void run() {
		try {
			String value = TextFileUtils.read(textFile, Charset.forName("UTF-8"));
			println(value);

			BaseResponse<String> response = TolerantJsonUtils.objectMapper.readValue(value, new TypeReference<BaseResponse<String>>() {
			});
			
			println(JsonUtils.serialize(response));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(DeserializeTest.class);
	}
}