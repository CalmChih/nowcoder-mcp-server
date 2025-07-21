package top.chih.mcp.server.nowcoder.domain.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import top.chih.mcp.server.nowcoder.domain.adapter.INowCoderPort;
import top.chih.mcp.server.nowcoder.domain.model.FaceWarpSearchRequest;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.dto.FaceWarpSearchResponseDTO;

import java.io.IOException;

/**
 * @author chih
 * @description 牛客 mcp 服务
 * @date 2025/7/21 14:50
 */
@Slf4j
@Service
public class NowCoderService {
    
    @Resource
    private INowCoderPort nowCoderPort;
    
    @Tool(description = "牛客网面经搜索，根据用户想要查找的面经进行搜索，模糊匹配返回对应的文章")
    public FaceWarpSearchResponseDTO faceWarpSearch(FaceWarpSearchRequest faceWarpSearchRequest) throws IOException {
        return nowCoderPort.faceWarpSearch(faceWarpSearchRequest);
    }
    
}
