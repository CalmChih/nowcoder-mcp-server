package top.chih.mcp.server.nowcoder.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.text.StringEscapeUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author chih
 * @description
 * @date 2025/7/21 17:09
 */
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceWarpSearchRequest implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 6768297440167008468L;
    
    public FaceWarpSearchRequest(String query, Integer page) {
        this.query = StringEscapeUtils.unescapeJava(query);
        this.page = page;
    }
    
    @JsonIgnore
    @JsonPropertyDescription("默认为all，不需要变更")
    private final String type = "all";
    
    @Getter
    @JsonProperty(required = true)
    @JsonPropertyDescription("想要查询的消息，最好带上面经两个字，能够更加准确，例如：Java后端面经")
    private String query;
    
    @Getter
    @Setter
    @JsonProperty(required = true)
    @JsonPropertyDescription("当前页码，从1开始")
    private Integer page;
    
    @JsonIgnore
    @JsonPropertyDescription("""
            默认标签列表，列表内仅有一个Tag对象，为{"name": "面经","id": 818, "count": null}，对象字段必须完整，且值不允许变更
            """)
    private final List<Tag> tag = Collections.singletonList(new Tag());
    
    @JsonIgnore
    @JsonPropertyDescription("排序方式，默认为create，不需要变更")
    private final String order = "create";
    
    
    static final class Tag {
        
        private final String name = "面经";
        
        private final int id = 818;
        
        private final Integer count = null;
    }
    
    @JsonProperty(required = true)
    public void setQuery(String query) {
        this.query = StringEscapeUtils.unescapeJava(query);
    }
    
}
