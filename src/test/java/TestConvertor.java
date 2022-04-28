import io.project.ClientOfBank;
import io.project.ObjectToJson;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestConvertor {

    @Test
    void test() {
        ClientOfBank client1 = new ClientOfBank("Nik", "Brown", "USA", "50000");
        ClientOfBank client2 = new ClientOfBank("Michael", "Ballcak", "Germany", "40000");
        ClientOfBank client3 = new ClientOfBank("Aleks", "Hamilton", "USA", "45000");
        ClientOfBank client4 = new ClientOfBank("Donald", "Trump", "USA", "1000000");

        ObjectToJson objectToJson = new ObjectToJson();
        List<String> allClients = Arrays.asList(
                objectToJson.convertToJson(client1),
                objectToJson.convertToJson(client2),
                objectToJson.convertToJson(client3),
                objectToJson.convertToJson(client4)
        );
        objectToJson.write(allClients);
    }
}
