package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="RACKET")
@NamedQueries ({
	// ラケットデータを全件取り出し、id順（昇順）で並べる。
	@NamedQuery(
            name  = RacketData.FAIND_BY_ID,
            query ="select b from RacketData b ORDER BY b.id"),
	// ラケットデータを全件取り出し、本体価格順（昇順）で並べる。
	@NamedQuery(
            name  = RacketData.FAIND_BY_PRICE,
            query = "select b from RacketData b ORDER BY b.price"),
	// ラケットデータを全件取り出し、本体価格順（降順）で並べる。
	@NamedQuery(
            name  = RacketData.FAIND_BY_PRICE_DESC,
            query = "select b from RacketData b ORDER BY b.price DESC"),
	// ラケットデータの件数を数える。
	@NamedQuery(
            name  = RacketData.COUNT_ALL,
            query = "select COUNT(b) from RacketData b"),
	// 指定したジャンルのラケットデータの件数を数える。
	@NamedQuery(
            name  = RacketData.COUNT_GENRE,
            query = "select COUNT(b) from RacketData b where b.genre=:genreItem"),
	// 指定したジャンルのラケットデータを取出し、id順（昇順）で並べる。
	@NamedQuery(
            name   =RacketData.FAIND_GENRE,
            query = "select b from RacketData b where b.genre=:genreItem ORDER BY b.id"),
	// 指定したジャンルのラケットデータを取り出し、本体価格順（昇順）で並べる。
	@NamedQuery(
            name  = RacketData.GENRE_BY_PRICE,
            query = "select b from RacketData b where b.genre=:genreItem ORDER BY b.price"),
    // 指定したジャンルのラケットデータを取り出し、本体価格順（降順）で並べる。
	@NamedQuery(
            name  = RacketData.GENRE_BY_PRICE_DESC,
            query = "select b from RacketData b where b.genre=:genreItem ORDER BY b.price DESC")
})

public class RacketData implements Serializable {
	// クエリ名を格納した定数を定義
	public static final String FAIND_BY_ID         = "RacketData.findById";
	public static final String FAIND_BY_PRICE      = "RacketData.findByPrice";
	public static final String FAIND_BY_PRICE_DESC = "RacketData.findByPriceDESC";
	public static final String COUNT_ALL           = "RacketData.countAll";
	public static final String COUNT_GENRE         = "RacketData.countGenre";
	public static final String FAIND_GENRE         = "RacketData.findGenre";
	public static final String GENRE_BY_PRICE      = "RacketData.genreByPrice";
	public static final String GENRE_BY_PRICE_DESC = "RacketData.genreByPriceDESC";
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;                //自動的に割り振られる連番を格納するフィールド
	private	String	title;          // タイトル用のフィールド
	private	Integer	price;          // 本体価格用のフィールド
	@Enumerated(EnumType.STRING)
	private	Genre	genre;          // Genre列挙型のフィールド
	@Lob
	private	String	exp;            // 説明文用のフィールド
	@Lob
	@Basic(fetch=FetchType.LAZY)	
	private	byte[]	img1;           // サムネイル用のフィールド
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private	byte[]	img2;           // 拡大画像用のフィールド
	
	/**********************************************
	* パラメーターなしのコンストラクター
	**********************************************/
	public	RacketData(){}

	/**********************************************
	* コンストラクター
	* @param title  ラケットタイトル
	* @param price  本体価格
	* @param genre  ラケットのジャンル
	* @param exp    紹介文
	* @param img1   サムネイル用のイメージ（バイナリ）
	* @param img2   拡大表示用のイメージ  （バイナリ）
	**********************************************/
	public	RacketData(
            String  title,
            Integer price,
            Genre   genre,
            String  exp,
            byte[]  img1,
            byte[]  img2
	){
            this.title	=	title;
            this.price	=	price;
            this.genre	=	genre;
            this.exp	=	exp;
            this.img1	=	img1;
            this.img2	=	img2;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public byte[] getImg1() {
        return img1;
    }

    public void setImg1(byte[] img1) {
        this.img1 = img1;
    }

    public byte[] getImg2() {
        return img2;
    }

    public void setImg2(byte[] img2) {
        this.img2 = img2;
    }
}
