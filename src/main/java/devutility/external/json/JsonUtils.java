package devutility.external.json;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import devutility.internal.lang.StringUtils;

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
		if (StringUtils.isNullOrEmpty(value)) {
			return null;
		}

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(value, clazz);
	}

	/**
	 * Deserialize jsonParser object to Date object.
	 * @param jsonParser: JsonParser object.
	 * @param dateFormat: DateFormat object.
	 * @return Date
	 * @throws Exception
	 */
	public static Date deserializeToDate(JsonParser jsonParser, DateFormat dateFormat) throws Exception {
		String text = jsonParser.getText();
		return dateFormat.parse(text);
	}
}