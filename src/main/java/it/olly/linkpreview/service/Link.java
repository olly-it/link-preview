package it.olly.linkpreview.service;

public class Link {

    public Link(String domain, String url, String title, String desc, String image, String imageAlt) {
        this.domain = domain;
        this.url = url;
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.imageAlt = imageAlt;
    }

    private String domain;

    private String url;

    private String title;

    private String desc;

    private String image;

    private String imageAlt;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Link [domain=");
        builder.append(domain);
        builder.append(", url=");
        builder.append(url);
        builder.append(", title=");
        builder.append(title);
        builder.append(", desc=");
        builder.append(desc);
        builder.append(", image=");
        builder.append(image);
        builder.append(", imageAlt=");
        builder.append(imageAlt);
        builder.append("]");
        return builder.toString();
    }

}