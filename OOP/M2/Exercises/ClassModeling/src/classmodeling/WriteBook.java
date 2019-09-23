/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmodeling;

/**
 *
 * @author seanking
 */
public class WriteBook {
    private String title;
    private String authorName;
    private String publishingCompany;
    private int numberOfChapters;
    private int numberOfPages;
    private String coverType;
    private boolean tableOfContents;
    private String characters;
    private String plot;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public int getNumberOfChapters() {
        return numberOfChapters;
    }

    public void setNumberOfChapters(int numberOfChapters) {
        this.numberOfChapters = numberOfChapters;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public boolean isTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(boolean tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
    
    
}
