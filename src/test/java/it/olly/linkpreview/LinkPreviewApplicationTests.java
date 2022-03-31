package it.olly.linkpreview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.olly.linkpreview.service.Link;
import it.olly.linkpreview.service.LinkPreviewService;

@SpringBootTest
class LinkPreviewApplicationTests {

    @Autowired
    LinkPreviewService linkPreviewService;

    @Test
    void doTest() {
        String url = "https://neo4j.com/docs/cypher-manual/current/syntax/patterns/#cypher-pattern-related-nodes";
        Link link = linkPreviewService.getLinkPreviewInfo(url);
        System.out.println(url + " > " + link);
    }

}
