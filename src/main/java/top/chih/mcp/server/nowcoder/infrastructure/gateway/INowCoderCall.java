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
    
    @Headers({
            "Cookie: acw_tc=0a18aad417531631019061947e3d472f0a5e4cb3ffb0d6fc80113ba1def661; NOWCODERCLINETID=987A72146E34F8F0C79816E58DAF8008; NOWCODERUID=721bfaaf6d864a34abf3851e882e3a70",
            "Content-Type: application/json", "Accept: */*", "Host: gw-c.nowcoder.com", "Connection: keep-alive"})
    @POST("pc/search")
    Call<FaceWarpSearchResponseDTO> faceWarpSearch(@Body FaceWarpSearchRequestDTO request);
    
}
