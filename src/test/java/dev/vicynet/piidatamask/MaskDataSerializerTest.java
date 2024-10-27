package dev.vicynet.piidatamask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class MaskDataSerializerTest {
    private ObjectMapper objectMapper;
    private TestPIIModel testPIIModel;

    @BeforeEach
    void setUp() {
        testPIIModel = new TestPIIModel();
        objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(TestPIIModel.class, new MaskDataSerializer());
        objectMapper.registerModule(simpleModule);
    }

    @AfterEach
    void tearDown() {
        objectMapper = null;
        testPIIModel = null;
    }

    @Test
    public void testMaskingSerialization() throws JsonProcessingException {
        String jsonResult = objectMapper.writeValueAsString(testPIIModel);
        log.info(jsonResult);
        assertTrue(jsonResult.contains("*****345678"));
        assertTrue(jsonResult.contains("ihedioha@gmail****"));
        assertTrue(jsonResult.contains("807******3453"));
        assertTrue(jsonResult.contains("**34-5678-9876-54321234-5678-9876-54**"));
    }
}