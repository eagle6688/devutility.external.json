package devutility.external.json.compressutils;

import java.io.IOException;
import java.util.Date;

import devutility.external.json.CompressUtils;
import devutility.external.json.JsonUtils;
import devutility.external.json.models.User;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CompressAndDecompressTest extends BaseTest {
	@Override
	public void run() {
		User user = new User();
		user.setId(1);
		user.setAge(30);
		user.setName("Aldwin");
		user.setBirthday(new Date());

		try {
			String compressedValue = CompressUtils.compress(user);
			println(compressedValue);

			User originalUser = CompressUtils.decompress(compressedValue, User.class);
			println(JsonUtils.serialize(originalUser));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(CompressAndDecompressTest.class);
	}
}