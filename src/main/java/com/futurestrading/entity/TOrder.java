package com.futurestrading.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sensor
 * @since 2019-03-27
 */
@TableName("t_order")
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 交易时间
     */
    private LocalDateTime cTime;

    /**
     * 交易品种
     */
    private String trdvar;

    /**
     * 交易所代码
     */
    private String fdt001;

    /**
     * 交易策略
     */
    private String strategy;

    /**
     * 交易金额
     */
    private Double tradeNum;

    /**
     * 交易后账户余额
     */
    private Double accountNum;

    /**
     * 合约代码
     */
    @TableField("Agmtcd")
    private String Agmtcd;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public LocalDateTime getcTime() {
        return cTime;
    }

    public void setcTime(LocalDateTime cTime) {
        this.cTime = cTime;
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
    public String getAgmtcd() {
        return Agmtcd;
    }

    public void setAgmtcd(String Agmtcd) {
        this.Agmtcd = Agmtcd;
    }

    @Override
    public String toString() {
        return "TOrder{" +
        "orderId=" + orderId +
        ", userId=" + userId +
        ", cTime=" + cTime +
        ", trdvar=" + trdvar +
        ", fdt001=" + fdt001 +
        ", strategy=" + strategy +
        ", tradeNum=" + tradeNum +
        ", accountNum=" + accountNum +
        ", Agmtcd=" + Agmtcd +
        "}";
    }
}
