package devutility.external.json;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * TolerantJsonUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-04-17 17:11:07
 */
public class TolerantJsonUtils extends JsonUtils {
	static {
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
	}

	/**
	 * Deserialize object to string.
	 * @param value String need to be deserialized.
	 * @param clazz Class object
	 * @return {@code T}
	 * @throws IOException
	 */
	public static <T> T deserialize(String value, Class<T> clazz) throws IOException {
		return JsonUtils.deserialize(value, clazz);
	}

	/**
	 * Deserialize jsonParser object to Date object.
	 * @param jsonParser JsonParser object.
	 * @param dateFormat DateFormat object.
	 * @return Date
	 * @throws Exception
	 */
	public static Date deserializeToDate(JsonParser jsonParser, DateFormat dateFormat) throws Exception {
		return JsonUtils.deserializeToDate(jsonParser, dateFormat);
	}

	/**
	 * Deserialize string value to List.
	 * @param value Json string value.
	 * @param collectionClass Class object for collection.
	 * @param elementClasses Class object for element in collection.
	 * @return {@code List<T>}
	 * @throws IOException From readValue.
	 */
	public static <T> List<T> deserializeToList(String value, Class<?> collectionClass, Class<T> elementClasses) throws IOException {
		return JsonUtils.deserializeToList(value, collectionClass, elementClasses);
	}
}