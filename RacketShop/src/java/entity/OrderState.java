package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERSTATE")
public class OrderState implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;			// 注文ごとにIDを割り振る
    @OneToOne
    private	RacketData racketData;	// RacketDataとOneToOneで関連付ける
    private	Integer	quantity=0;	// 数量を保持する（デフォルト値は0）

    /**********************************************
    * パラメーターなしのコンストラクター
    **********************************************/
    public	OrderState(){}

    /**********************************************
    * コンストラクター
    * @param racketData     RacketDataオブジェクト
    * @param quantity     数量（Integer）
    **********************************************/
    public	OrderState(RacketData racketData, Integer quantity){
            this.racketData	=	racketData;
            this.quantity	=	quantity;
    }

    /**********************************************
    * quantity（数量）を加算する
    * @return  加算後の数量（Integer）
    **********************************************/
    public	int	adding(){
            ++quantity;
            return	quantity;
    }

    /**********************************************
    * quantity（数量）を減算する
    * @return  減算後の数量（Integer）
    **********************************************/
    public int subtraction(){
            if(quantity>0) --quantity;
            return	quantity;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public RacketData getRacketData() {
        return racketData;
    }

    public void setRacketData(RacketData racketData) {
        this.racketData = racketData;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
