package it.olly.linkpreview.service;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.net.InternetDomainName;

@Service
public class LinkPreviewService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public Link getLinkPreviewInfo(String url) {
        Link link = null;
        try {
            link = extractLinkPreviewInfo(url);
        } catch (IOException e) {
            logger.error("Unable to connect to : {}", url);
        }
        return link;
    }

    private Link extractLinkPreviewInfo(String url) throws IOException {
        if (!url.startsWith("http")) {
            url = "http://" + url;
        }
        Document document = Jsoup.connect(url)
                .get();
        String title = getMetaTagContent(document, "meta[name=title]");
        String desc = getMetaTagContent(document, "meta[name=description]");
        String ogUrl = StringUtils.defaultIfBlank(getMetaTagContent(document, "meta[property=og:url]"), url);
        String ogTitle = getMetaTagContent(document, "meta[property=og:title]");
        String ogDesc = getMetaTagContent(document, "meta[property=og:description]");
        String ogImage = getMetaTagContent(document, "meta[property=og:image]");
        String ogImageAlt = getMetaTagContent(document, "meta[property=og:image:alt]");
        String domain = ogUrl;
        try {
            domain = InternetDomainName.from(new URL(ogUrl).getHost())
                    .topPrivateDomain()
                    .toString();
        } catch (Exception e) {
            logger.warn("Unable to connect to extract domain name from : {}", url);
        }
        return new Link(domain, url, StringUtils.defaultIfBlank(ogTitle, title), StringUtils
                .defaultIfBlank(ogDesc, desc), ogImage, ogImageAlt);
    }

    private String getMetaTagContent(Document document, String cssQuery) {
        Element elm = document.select(cssQuery)
                .first();
        if (elm != null) {
            return elm.attr("content");
        }
        return "";
    }
}
