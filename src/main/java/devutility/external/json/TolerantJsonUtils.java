package devutility.external.json;

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
	{
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
	}
}