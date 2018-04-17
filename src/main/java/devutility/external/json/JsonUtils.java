package devutility.external.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import devutility.internal.lang.StringHelper;

public class JsonUtils {
	/**
	 * Serialize string to object.
	 * @param value: Object need serialize
	 * @return String: Json string
	 * @throws JsonProcessingException
	 */
	public static String serialize(Object value) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(value);
	}

	/**
	 * Deserialize object to string.
	 * @param value: String need to be deserialized.
	 * @param clazz: Class object
	 * @return {@code T}
	 * @throws IOException
	 */
	public static <T> T deserialize(String value, Class<T> clazz) throws IOException {
		if (StringHelper.isNullOrEmpty(value)) {
			return null;
		}

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(value, clazz);
	}
}