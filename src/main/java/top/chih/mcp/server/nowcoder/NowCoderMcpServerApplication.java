package top.chih.mcp.server.nowcoder;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import top.chih.mcp.server.nowcoder.domain.service.NowCoderService;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.INowCoderCall;

/**
 * @author chih
 * @description 牛客 mcp server
 * @date 2025/7/21 13:29
 */
@SpringBootApplication
public class NowCoderMcpServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(NowCoderMcpServerApplication.class, args);
    }
    
    @Bean
    public INowCoderCall nowCoderCall() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gw-c.nowcoder.com/api/sparta/")
                .addConverterFactory(JacksonConverterFactory.create()).build();
        return retrofit.create(INowCoderCall.class);
    }
    
    @Bean
    public ToolCallbackProvider nowCoderTools(NowCoderService nowCoderService) {
        return MethodToolCallbackProvider.builder().toolObjects(nowCoderService).build();
    }
    
}
