package devutility.external.json;

import java.io.IOException;

import devutility.internal.data.codec.Base64Utils;
import devutility.internal.data.codec.GzipUtils;
import devutility.internal.data.codec.Utf8Utils;

public class CompressUtils {
	/**
	 * Compress object to string
	 * @param value Object
	 * @return String
	 * @throws IOException
	 */
	public static String compress(Object value) throws IOException {
		String jsonValue = JsonUtils.serialize(value);
		byte[] utf8Bytes = Utf8Utils.encode(jsonValue);
		byte[] compressedBytes = GzipUtils.compress(utf8Bytes);
		return Base64Utils.encodeToString(compressedBytes);
	}

	/**
	 * Decompress string to object
	 * @param value String value
	 * @param clazz Class object
	 * @return {@code T}
	 * @throws IOException
	 */
	public static <T> T decompress(String value, Class<T> clazz) throws IOException {
		byte[] compressedBytes = Base64Utils.decode(value);
		byte[] utf8Bytes = GzipUtils.deCompress(compressedBytes);
		String jsonValue = Utf8Utils.decode(utf8Bytes);
		return JsonUtils.deserialize(jsonValue, clazz);
	}
}