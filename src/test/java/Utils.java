import com.fasterxml.jackson.databind.ObjectMapper;
import Homework5.dto.GetCategoryResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Utils {

    @Test
    void test() throws IOException {
        GetCategoryResponse getCategoryResponse = new GetCategoryResponse();
        getCategoryResponse.setId(1);
        getCategoryResponse.setTitle("myTitle");

        StringWriter writer = new StringWriter();

        //Объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();

        //Сериализация: 1-куда, 2-что
        mapper.writeValue(writer, getCategoryResponse);

        //Преобразование все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println(result);

        StringReader reader = new StringReader("{\"id\":1,\"title\":\"myTitle\",\"products\":[]}");

        GetCategoryResponse getCategoryResponseReader = mapper.readValue(reader, GetCategoryResponse.class);
    }
}