package com.futurestrading.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sensor
 * @since 2019-03-24
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 交易时间
     */
    private LocalDateTime time;

    /**
     * 交易品种
     */
    private String trdvar;

    /**
     * 交易所代码
     */
    private String fdt001;

    /**
     * 选择的策略
     */
    private String strategy;

    /**
     * 交易金额
     */
    private Double tradeNum;

    /**
     * 交易后账户余额（元）
     */
    private Double accountNum;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public String getTrdvar() {
        return trdvar;
    }

    public void setTrdvar(String trdvar) {
        this.trdvar = trdvar;
    }
    public String getFdt001() {
        return fdt001;
    }

    public void setFdt001(String fdt001) {
        this.fdt001 = fdt001;
    }
    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
    public Double getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(Double tradeNum) {
        this.tradeNum = tradeNum;
    }
    public Double getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Double accountNum) {
        this.accountNum = accountNum;
    }

    @Override
    public String toString() {
        return "Order{" +
        "orderId=" + orderId +
        ", uId=" + uId +
        ", time=" + time +
        ", trdvar=" + trdvar +
        ", fdt001=" + fdt001 +
        ", strategy=" + strategy +
        ", tradeNum=" + tradeNum +
        ", accountNum=" + accountNum +
        "}";
    }
}
