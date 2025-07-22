package top.chih.mcp.server.nowcoder.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.chih.mcp.server.nowcoder.domain.model.FaceWarpSearchRequest;
import top.chih.mcp.server.nowcoder.domain.model.FaceWarpSearchResponse;
import top.chih.mcp.server.nowcoder.domain.service.NowCoderService;

import java.io.IOException;

/**
 * @author chih
 * @description
 * @date 2025/7/21 14:29
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiTest {
    
    @Resource
    private NowCoderService nowCoderService;
    
    @Test
    public void test_faceWarpSearch() throws IOException {
        String json = "{\"page\": 1," + "    \"query\": \"Java后端面经\"" + "  }";
        ObjectMapper objectMapper = new ObjectMapper();
        FaceWarpSearchRequest faceWarpSearchRequest = objectMapper.readValue(json, FaceWarpSearchRequest.class);
        FaceWarpSearchResponse responseDTO = nowCoderService.faceWarpSearch(faceWarpSearchRequest);
        log.info("结果：{}", responseDTO);
    }
    
    @Test
    public void test() {
        FaceWarpSearchRequest build = FaceWarpSearchRequest.builder().query("agvadf").page(1).build();
        log.info("结果：{}", build);
    }
    
    @Test
    public void test_CommonText() {
        String text = "Java\\u540e\\u7aef\\u9762\\u7ecf";
        String s = StringEscapeUtils.unescapeJava(text);
        log.info("结果：{}", s);
    }
}
