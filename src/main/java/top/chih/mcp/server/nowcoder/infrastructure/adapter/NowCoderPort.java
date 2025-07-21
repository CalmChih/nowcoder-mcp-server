package top.chih.mcp.server.nowcoder.infrastructure.adapter;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import top.chih.mcp.server.nowcoder.domain.adapter.INowCoderPort;
import top.chih.mcp.server.nowcoder.domain.model.FaceWarpSearchRequest;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.INowCoderCall;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.dto.FaceWarpSearchRequestDTO;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.dto.FaceWarpSearchResponseDTO;

import java.io.IOException;

/**
 * @author chih
 * @description 牛客请求端口
 * @date 2025/7/21 14:54
 */
@Component
public class NowCoderPort implements INowCoderPort {
    
    @Resource
    private INowCoderCall nowCoderCall;
    
    @Override
    public FaceWarpSearchResponseDTO faceWarpSearch(FaceWarpSearchRequest faceWarpSearchRequest) throws IOException {
        FaceWarpSearchRequestDTO faceWarpSearchRequestDTO = FaceWarpSearchRequestDTO.builder().query(faceWarpSearchRequest.getQuery())
                .page(faceWarpSearchRequest.getPage()).build();
        Call<FaceWarpSearchResponseDTO> faceWarpSearchResponseDTOCall = nowCoderCall.faceWarpSearch(
                faceWarpSearchRequestDTO);
        Response<FaceWarpSearchResponseDTO> response = faceWarpSearchResponseDTOCall.execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }
}
