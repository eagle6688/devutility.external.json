package devutility.external.json.compress;

import java.io.IOException;
import java.util.Date;

import devutility.external.json.CompressUtils;
import devutility.external.json.JsonUtils;
import devutility.external.json.model.User;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CompressAndDecompressTest extends BaseTest {
	@Override
	public void run() {
		test2();
	}

	void test1() {
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

	void test2() {
		String[][] arrays = User.arrays(100);

		try {
			String compressedString = CompressUtils.compressDouble(arrays);
			println(compressedString.length());

			long start = System.currentTimeMillis();
			arrays = CompressUtils.decompressDouble(compressedString, String[][].class);
			println(String.format("Decompress %d products cost %d milliseconds!", arrays.length, System.currentTimeMillis() - start));
			println(arrays.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(CompressAndDecompressTest.class);
	}
}