package top.chih.mcp.server.nowcoder.domain.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author chih
 * @description 面经返回
 * @date 2025/7/22 15:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FaceWarpSearchResponse implements Serializable {
    
    @Serial
    private static final long serialVersionUID = -663478107169397238L;
    
    @JsonPropertyDescription("当前页码")
    private Integer current;
    
    @JsonPropertyDescription("当页文章数量")
    private Integer size;
    
    @JsonPropertyDescription("文章总数")
    private Integer total;
    
    @JsonPropertyDescription("总页数")
    private Integer totalPage;
    
    @JsonPropertyDescription("文章列表")
    private List<Record> records;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Record {
        
        @JsonPropertyDescription("文章标题，可能包含岗位以及公司名称")
        private String title;
        
        @JsonPropertyDescription("文章内容，包含面试相关的问题，可能还有问题对应的答案")
        private String content;
        
    }
}
