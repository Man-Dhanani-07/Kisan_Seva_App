package com.man.fapp.Model;

public class LogisticInfo {

String name,link,description;
    private boolean isExpanded;


    public LogisticInfo(String name, String link, String description) {
        this.name = name;
        this.link = link;
        this.description = description;
        this.isExpanded = false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
