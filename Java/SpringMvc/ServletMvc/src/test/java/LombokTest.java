import org.junit.jupiter.api.Test;
import org.zerock.servletmvc.property.MariaDBProperty;

import static org.junit.jupiter.api.Assertions.*;

public class LombokTest {
    @Test
    void LombokTest(){
        MariaDBProperty mariaDBProperty = new MariaDBProperty();
        String result = null;
        result = mariaDBProperty.getUrl();
        assertNotNull(result);
    }
}
