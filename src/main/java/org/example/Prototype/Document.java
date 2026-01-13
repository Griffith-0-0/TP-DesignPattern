package org.example.Prototype;

public class Document implements Cloneable {
    private String title;
    private String content;
    private String author;

    public Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        System.out.println("Document créé (construction coûteuse)");
    }

    // Méthode clone pour créer une copie
    @Override
    public Document clone() {
        try {
            System.out.println("Document cloné (rapide)");
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // Getters et Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
