package cn.qingweico.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.qingweico.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zqw
 * @date 2020/11/8
 */
@RestController
public class ContentController {

    ContentService contentService;

    @Autowired
    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/search/{keyword}/{pageIndex}/{pageSize}")
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword,
                                            @PathVariable("pageIndex") int pageIndex,
                                            @PathVariable("pageSize") int pageSize) throws IOException, InterruptedException {
        List<Map<String, Object>> maps = contentService.searchPage(keyword, pageIndex, pageSize);
        if (CollectionUtils.isEmpty(maps)){
            contentService.hasSucceedParseContent(keyword);
            Thread.sleep(500);
            maps = contentService.searchPage(keyword, pageIndex, pageSize);
        }
        return maps;

    }
}
