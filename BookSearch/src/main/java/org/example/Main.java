package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * メインクラス - CSVから書籍情報を読み込み、キーワードに基づいて検索する機能を提供します。
 */
public class Main {
    //定数の定義
    private static final String CSV_FILEPATH = "src\\main\\resources\\booklist.csv";
    private static final String EXIT_COMMAND = "終了";
    private static final String INPUT_PROMPT = "キーワードを入力してください：";
    private static final String CONTINUATION_PROMPT = "検索を続けますか？（続ける場合：Enter, 終了する場合：'終了'と入力）";
    private static final String NO_MATCH_MESSAGE = "関連する書籍は見つかりませんでした。";
    private static final String EXIT_MESSAGE = "プログラムを終了します。";


    /**
     * メインメソッド
     */
    public static void main(String[] args) {
        BookManager bookManager = new BookManager(CSV_FILEPATH);
        List<Books> booksList = bookManager.readBooks();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                String keyword = getUserInput(br);
                displaySearchResults(booksList, keyword);

                System.out.print(CONTINUATION_PROMPT);
                String decision = br.readLine();

                if (EXIT_COMMAND.equals(decision)) {
                    System.out.println(EXIT_MESSAGE);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * ユーザーからキーワード入力を受け取るためのメソッド
     *
     * @param br BufferedReader
     * @return ユーザーからの入力
     * @throws IOException 入力の読み取り中の例外
     */
    private static String getUserInput(BufferedReader br) throws IOException {
        System.out.print(INPUT_PROMPT);
        return br.readLine();
    }


    /**
     * 与えられたキーワードに基づいて書籍を検索し、結果を表示するメソッド
     *
     * @param books   CSVから読み取った書籍のリスト
     * @param keyword 　検索キーワード
     */
    private static void displaySearchResults(List<Books> books, String keyword) {
        List<Books> matchedBooks = books.stream()
                .filter(book -> book.getTitle().contains(keyword))
                .toList();

        if (matchedBooks.isEmpty()) {
            System.out.println(NO_MATCH_MESSAGE);
        } else {
            matchedBooks.forEach(book -> {
                System.out.printf("検索結果\n商品名：%s\n価格：%s円\n著者：%s\n出版日：%s\n詳細：%s\n", book.getTitle(), String.format("%,d", book.getPrice()), book.getAuthor(), book.getPublishDate(), book.getDescription());
                System.out.println();
            });
        }
    }
}