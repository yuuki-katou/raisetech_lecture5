package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * BookManagerクラスは、書籍情報をCSVファイルから読み込む役割を持ちます。
 */
public class BookManager {

    // 読み込むCSVファイルのパス
    private String fileName;


    /**
     * BookManagerのコントラクタ
     *
     * @param filePath 読み込むCSVファイルのパス
     */
    public BookManager(String filePath) {
        this.fileName = filePath;
    }


    /**
     * CSVファイルから書籍情報を読み込み、Booksオブジェクトのリストとして返します。
     *
     * @return 書籍オブジェクトのリスト
     */
    public List<Books> readBooks() {
        List<Books> books = new ArrayList<>();

        //CSVファイルからデータを読み込む
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            //CSVのヘッダー行を読み飛ばす
            br.readLine();

            //各行を読み込み、書籍オブジェクトを作成してリストに追加する
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Books book = new Books(values[0], Integer.parseInt(values[1]), values[2], values[3], values[4]);
                books.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
