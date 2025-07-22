package top.chih.mcp.server.nowcoder.infrastructure.gateway;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.dto.FaceWarpSearchRequestDTO;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.dto.FaceWarpSearchResponseDTO;

/**
 * @author chih
 * @description 请求发送
 * @date 2025/7/21 14:56
 */
public interface INowCoderCall {
    
    @Headers({"Content-Type: application/json; charset=UTF-8"})
    @POST("pc/search")
    Call<FaceWarpSearchResponseDTO> faceWarpSearch(@Body FaceWarpSearchRequestDTO request);
    
}
