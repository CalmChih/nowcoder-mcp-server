package top.chih.mcp.server.nowcoder.test;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.chih.mcp.server.nowcoder.domain.model.FaceWarpSearchRequest;
import top.chih.mcp.server.nowcoder.domain.service.NowCoderService;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.dto.FaceWarpSearchResponseDTO;

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
        FaceWarpSearchResponseDTO responseDTO = nowCoderService.faceWarpSearch(
                FaceWarpSearchRequest.builder().query("java 后端开发 面经").page(2).build());
        log.info("结果：{}", responseDTO);
    }
    
    @Test
    public void test() {
        FaceWarpSearchRequest faceWarpSearchRequest = new FaceWarpSearchRequest();
        FaceWarpSearchRequest build = FaceWarpSearchRequest.builder().query("agvadf").page(1).build();
        log.info("结果：{}", build);
    }
}
