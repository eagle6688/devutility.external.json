package devutility.external.json;

import java.io.IOException;

import devutility.internal.data.codec.Base64Helper;
import devutility.internal.data.codec.GZipHelper;
import devutility.internal.data.codec.UTF8Helper;

public class CompressUtils {
	/**
	 * Compress object to string
	 * @param value: Object
	 * @return String
	 * @throws IOException
	 */
	public static String compress(Object value) throws IOException {
		String jsonValue = JsonUtils.serialize(value);
		byte[] utf8Bytes = UTF8Helper.encode(jsonValue);
		byte[] compressedBytes = GZipHelper.compress(utf8Bytes);
		return Base64Helper.encodeToString(compressedBytes);
	}

	/**
	 * Decompress string to object
	 * @param value: String value
	 * @param clazz: Class object
	 * @return {@code T}
	 * @throws IOException
	 */
	public static <T> T decompress(String value, Class<T> clazz) throws IOException {
		byte[] compressedBytes = Base64Helper.decodeByString(value);
		byte[] utf8Bytes = GZipHelper.deCompress(compressedBytes);
		String jsonValue = UTF8Helper.decode(utf8Bytes);
		return JsonUtils.deserialize(jsonValue, clazz);
	}
}