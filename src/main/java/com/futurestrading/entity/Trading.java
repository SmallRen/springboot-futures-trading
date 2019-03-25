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
 * @since 2019-03-25
 */
public class Trading implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "trading_id", type = IdType.AUTO)
    private Integer tradingId;

    /**
     * 交易日期

     */
    private LocalDateTime trddt;

    /**
     * 合约代码

     */
    private String agmtcd;

    /**
     * 交易品种

     */
    private String trdvar;

    /**
     * 交易所代码

     */
    private String fdt001;

    /**
     * 日开盘价

     */
    private Double fdt003;

    /**
     * 日最高价

     */
    private Double fdt004;

    /**
     * 日最低价

     */
    private Double fdt005;

    /**
     * 日收盘价

     */
    private Double fdt006;

    /**
     * 日结算价

     */
    private Double fdt007;

    /**
     * 成交量

     */
    private Integer fdt010;

    /**
     * 持仓量
     */
    private Integer fdt011;

    /**
     * 成交金额
     */
    private Double fdt013;

    public Integer getTradingId() {
        return tradingId;
    }

    public void setTradingId(Integer tradingId) {
        this.tradingId = tradingId;
    }
    public LocalDateTime getTrddt() {
        return trddt;
    }

    public void setTrddt(LocalDateTime trddt) {
        this.trddt = trddt;
    }
    public String getAgmtcd() {
        return agmtcd;
    }

    public void setAgmtcd(String agmtcd) {
        this.agmtcd = agmtcd;
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
    public Double getFdt003() {
        return fdt003;
    }

    public void setFdt003(Double fdt003) {
        this.fdt003 = fdt003;
    }
    public Double getFdt004() {
        return fdt004;
    }

    public void setFdt004(Double fdt004) {
        this.fdt004 = fdt004;
    }
    public Double getFdt005() {
        return fdt005;
    }

    public void setFdt005(Double fdt005) {
        this.fdt005 = fdt005;
    }
    public Double getFdt006() {
        return fdt006;
    }

    public void setFdt006(Double fdt006) {
        this.fdt006 = fdt006;
    }
    public Double getFdt007() {
        return fdt007;
    }

    public void setFdt007(Double fdt007) {
        this.fdt007 = fdt007;
    }
    public Integer getFdt010() {
        return fdt010;
    }

    public void setFdt010(Integer fdt010) {
        this.fdt010 = fdt010;
    }
    public Integer getFdt011() {
        return fdt011;
    }

    public void setFdt011(Integer fdt011) {
        this.fdt011 = fdt011;
    }
    public Double getFdt013() {
        return fdt013;
    }

    public void setFdt013(Double fdt013) {
        this.fdt013 = fdt013;
    }

    @Override
    public String toString() {
        return "Trading{" +
        "tradingId=" + tradingId +
        ", trddt=" + trddt +
        ", agmtcd=" + agmtcd +
        ", trdvar=" + trdvar +
        ", fdt001=" + fdt001 +
        ", fdt003=" + fdt003 +
        ", fdt004=" + fdt004 +
        ", fdt005=" + fdt005 +
        ", fdt006=" + fdt006 +
        ", fdt007=" + fdt007 +
        ", fdt010=" + fdt010 +
        ", fdt011=" + fdt011 +
        ", fdt013=" + fdt013 +
        "}";
    }
}
