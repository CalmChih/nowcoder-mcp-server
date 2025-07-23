package top.chih.mcp.server.nowcoder.domain.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import top.chih.mcp.server.nowcoder.domain.adapter.INowCoderPort;
import top.chih.mcp.server.nowcoder.domain.model.FaceWarpSearchRequest;
import top.chih.mcp.server.nowcoder.domain.model.FaceWarpSearchResponse;
import top.chih.mcp.server.nowcoder.infrastructure.gateway.dto.FaceWarpSearchResponseDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public FaceWarpSearchResponse faceWarpSearch(FaceWarpSearchRequest faceWarpSearchRequest) throws IOException {
        FaceWarpSearchResponseDTO responseDTO = nowCoderPort.faceWarpSearch(faceWarpSearchRequest);
        FaceWarpSearchResponseDTO.Data data = responseDTO.getData();
        FaceWarpSearchResponse.FaceWarpSearchResponseBuilder faceWarpSearchResponseBuilder = FaceWarpSearchResponse.builder()
                .current(data.getCurrent()).size(data.getSize()).total(data.getTotal()).totalPage(data.getTotalPage());
        List<FaceWarpSearchResponseDTO.Data.Record> records = data.getRecords();
        if (null != records && !records.isEmpty()) {
            List<FaceWarpSearchResponse.Record> list = records.stream()
                    .map(record -> FaceWarpSearchResponse.Record.builder()
                            .title(record.getData().getMomentData().getTitle())
                            .content(record.getData().getMomentData().getContent()).build()).toList();
            faceWarpSearchResponseBuilder.records(list);
        } else {
            faceWarpSearchResponseBuilder.records(new ArrayList<>());
        }
        return faceWarpSearchResponseBuilder.build();
    }
    
}
