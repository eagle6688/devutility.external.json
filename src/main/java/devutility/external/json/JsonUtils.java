package devutility.external.json;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import devutility.internal.lang.StringUtils;

/**
 * 
 * JsonUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-04-17 16:57:11
 */
public class JsonUtils {
	/**
	 * ObjectMapper
	 */
	protected static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Serialize object to Json string.
	 * @param objectMapper ObjectMapper object.
	 * @param value Object need to be serialized.
	 * @return String Json string.
	 * @throws JsonProcessingException From writeValueAsString.
	 */
	public static String serialize(ObjectMapper objectMapper, Object value) throws JsonProcessingException {
		if (value == null) {
			return null;
		}

		return objectMapper.writeValueAsString(value);
	}

	/**
	 * Serialize object to Json string.
	 * @param value Object need to be serialized.
	 * @return String Json string
	 * @throws JsonProcessingException
	 */
	public static String serialize(Object value) throws JsonProcessingException {
		return serialize(objectMapper, value);
	}

	/**
	 * Deserialize Json string to object.
	 * @param objectMapper ObjectMapper object.
	 * @param value String need to be deserialized.
	 * @param clazz Class object.
	 * @return {@code T}
	 * @throws IOException From readValue.
	 */
	public static <T> T deserialize(ObjectMapper objectMapper, String value, Class<T> clazz) throws IOException {
		if (StringUtils.isNullOrEmpty(value)) {
			return null;
		}

		return objectMapper.readValue(value, clazz);
	}

	/**
	 * Deserialize Json string to object.
	 * @param value String need to be deserialized.
	 * @param clazz Class object.
	 * @return {@code T}
	 * @throws IOException From readValue.
	 */
	public static <T> T deserialize(String value, Class<T> clazz) throws IOException {
		return deserialize(objectMapper, value, clazz);
	}

	/**
	 * Deserialize jsonParser object to Date object.
	 * @param jsonParser JsonParser object.
	 * @param dateFormat DateFormat object.
	 * @return Date
	 * @throws Exception
	 */
	public static Date deserializeToDate(JsonParser jsonParser, DateFormat dateFormat) throws Exception {
		String text = jsonParser.getText();
		return dateFormat.parse(text);
	}

	/**
	 * Deserialize Json string value to List.
	 * @param objectMapper ObjectMapper object.
	 * @param value Json string value.
	 * @param collectionClass Class object for collection.
	 * @param elementClasses Class object for element in collection.
	 * @return {@code List<T>}
	 * @throws IOException From readValue.
	 */
	public static <T> List<T> deserializeToList(ObjectMapper objectMapper, String value, Class<?> collectionClass, Class<T> elementClasses) throws IOException {
		if (StringUtils.isNullOrEmpty(value)) {
			return null;
		}

		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
		return objectMapper.readValue(value, javaType);
	}

	/**
	 * Deserialize Json string value to List.
	 * @param value Json string value.
	 * @param collectionClass Class object for collection.
	 * @param elementClasses Class object for element in collection.
	 * @return {@code List<T>}
	 * @throws IOException From readValue.
	 */
	public static <T> List<T> deserializeToList(String value, Class<?> collectionClass, Class<T> elementClasses) throws IOException {
		return deserializeToList(objectMapper, value, collectionClass, elementClasses);
	}
}