import io.project.ClientOfBank;
import io.project.ObjectToJson;
import org.junit.jupiter.api.Test;

public class TestConvertor {

    @Test
    void test() {
        ClientOfBank client1 = new ClientOfBank("Mixa", "Byr", "Belarus", "2500");
        ClientOfBank client2 = new ClientOfBank("Serega", "Danilckevich", "Belarus", "3000");
        ClientOfBank client3 = new ClientOfBank("Egor", "Shulga", "Germany", "20000");
        ClientOfBank client4 = new ClientOfBank("Utya", "Byok", "Belarus", "1000");
        ObjectToJson objectToJson = new ObjectToJson();
        objectToJson.convertToJson(client1);
        objectToJson.convertToJson(client2);
        objectToJson.convertToJson(client3);
        objectToJson.convertToJson(client4);
    }

}
