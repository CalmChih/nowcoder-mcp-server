package top.chih.mcp.server.nowcoder.infrastructure.gateway.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chih
 * @description 面经查询返回
 * @date 2025/7/21 17:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FaceWarpSearchResponseDTO {
    
    @JsonPropertyDescription("请求是否成功返回")
    private Boolean success;
    
    @JsonPropertyDescription("返回码")
    private Integer code;
    
    @JsonPropertyDescription("描述信息")
    private String msg;
    
    @JsonPropertyDescription("返回数据")
    private Data data;
    
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Data {
        
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
        
        @lombok.Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        @JsonIgnoreProperties(ignoreUnknown = true)
        static class Record {
            
            private RecordData data;
            
            @lombok.Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            @JsonIgnoreProperties(ignoreUnknown = true)
            static class RecordData {
                
                @JsonProperty("momentData")
                @JsonAlias({"momentData", "contentData"})
                @JsonPropertyDescription("文章相关内容")
                private MomentData momentData;
                
                @lombok.Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                @JsonIgnoreProperties(ignoreUnknown = true)
                static class MomentData {
                    
                    @JsonPropertyDescription("文章标题，可能包含岗位以及公司名称")
                    private String title;
                    
                    @JsonPropertyDescription("文章内容，包含面试相关的问题，可能还有问题对应的答案")
                    private String content;
                    
                }
            }
        }
    }
    
}
