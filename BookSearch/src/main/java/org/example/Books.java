package org.example;

/**
 * 書籍を表すクラス
 * タイトル、価格、著者、出版日、説明を属性として持つ。
 */
public class Books {

    //書籍のタイトル
    private String title;

    //書籍の価格
    private int price;

    //書籍の著者
    private String author;

    //書籍の出版日
    private String publishDate;

    //書籍の説明
    private String description;


    /**
     *
     * @param title        書籍のタイトル
     * @param price        書籍の価格
     * @param author       書籍の著者
     * @param publishDate  書籍の出版日
     * @param description  書籍の説明
     */
    public Books(String title, int price, String author, String publishDate, String description) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.publishDate = publishDate;
        this.description = description;
    }

    //タイトルを取得する
    public String getTitle() {
        return title;
    }

    //価格を取得する
    public int getPrice() {
        return price;
    }

    //著者を取得する
    public String getAuthor() {
        return author;
    }

    //出版日を取得する
    public String getPublishDate() {
        return publishDate;
    }

    //書籍の説明を取得する
    public String getDescription() {
        return description;
    }

}

