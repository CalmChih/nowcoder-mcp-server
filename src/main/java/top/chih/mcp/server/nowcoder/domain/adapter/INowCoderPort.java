package top.chih.mcp.server.nowcoder.domain.adapter;

import top.chih.mcp.server.nowcoder.domain.model.FaceWarpSearchRequest;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.dto.FaceWarpSearchResponseDTO;

import java.io.IOException;

/**
 * @author chih
 * @description 牛客接口
 * @date 2025/7/21 14:01
 */
public interface INowCoderPort {

    FaceWarpSearchResponseDTO faceWarpSearch(FaceWarpSearchRequest faceWarpSearchRequest) throws IOException;
    
}
