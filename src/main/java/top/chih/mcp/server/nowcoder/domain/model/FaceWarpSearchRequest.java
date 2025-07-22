package top.chih.mcp.server.nowcoder.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chih
 * @description
 * @date 2025/7/21 17:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceWarpSearchRequest {

    @JsonProperty(required = true)
    @JsonPropertyDescription("想要查询的消息，最好带上面经两个字，能够更加准确，例如：Java后端面经。")
    private String query;
    
    @JsonProperty(required = true)
    @JsonPropertyDescription("当前页码，从1开始")
    private Integer page;
    
}
