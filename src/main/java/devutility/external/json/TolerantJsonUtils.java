package devutility.external.json;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * TolerantJsonUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-04-17 17:11:07
 */
public class TolerantJsonUtils {
	/**
	 * ObjectMapper
	 */
	public static ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper.enable(Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	/**
	 * Serialize object to Json string.
	 * @param value Object need to be serialized.
	 * @return String Json string
	 * @throws JsonProcessingException
	 */
	public static String serialize(Object value) throws JsonProcessingException {
		return JsonUtils.serialize(objectMapper, value);
	}

	/**
	 * Deserialize Json string to object.
	 * @param value String need to be deserialized.
	 * @param clazz Class object
	 * @return {@code T}
	 * @throws IOException
	 */
	public static <T> T deserialize(String value, Class<T> clazz) throws IOException {
		return JsonUtils.deserialize(objectMapper, value, clazz);
	}

	/**
	 * Deserialize Json string to object.
	 * @param value String need to be deserialized.
	 * @param javaType JavaType object.
	 * @return {@code T}
	 * @throws IOException From readValue.
	 */
	public static <T> T deserialize(String value, JavaType javaType) throws IOException {
		return JsonUtils.deserialize(objectMapper, value, javaType);
	}

	/**
	 * Deserialize Json string value to List.
	 * @param value Json string value.
	 * @param collectionClass Class object for collection.
	 * @param elementClass Class object for element in collection.
	 * @return {@code List<T>}
	 * @throws IOException From readValue.
	 */
	public static <T> List<T> deserializeToList(String value, Class<?> collectionClass, Class<T> elementClass) throws IOException {
		return JsonUtils.deserializeToList(objectMapper, value, collectionClass, elementClass);
	}
}