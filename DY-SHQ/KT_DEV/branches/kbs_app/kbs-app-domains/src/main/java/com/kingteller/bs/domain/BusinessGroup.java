package com.kingteller.bs.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author
 * 
 */
public class BusinessGroup implements Serializable {
    /**
     * 商圈领域模型序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商圈编码
     */
    @NotNull(message = "商圈编号不能为空")
    @Size(min = 1, max = 10, message = "商圈编号长度应为1~10个字符")
    private String busiGroupCode;

    /**
     * 商圈名称
     */
    @NotNull(message = "商圈编名称能为空")
    @Size(min = 1, max = 60, message = "商圈名称长度应为1~60个字符")
    private String busiGroupName;

    /**
     * 商圈核心企业编码
     */
    @NotNull(message = "商圈核心企业编码不能为空")
    @Size(min = 1, max = 32, message = "商圈核心企业编码长度应为1~32个字符")
    private String headEntNo;

    /**
     * 行业编码
     */
    @Size(max = 5, message = "行业编码最大长度不能超过5个字符")
    private String tradeCode;

    /**
     * 
     */
    private Long upLcAmt;

    /**
     * 
     */
    private Long upUcAmt;

    /**
     * 
     */
    @Size(max = 8, message = "上游授信额度有效期最大长度不能超过8个字符")
    private String upLcValiddate;

    /**
     * 
     */
    private Long downLcAmt;

    /**
     * 
     */
    private Long downUcAmt;

    /**
     * 
     */
    @Size(max = 8, message = "下游授信额度有效期最大长度不能超过8个字符")
    private String downLcValiddate;

    /**
     * 
     */
    @Size(max = 32, message = "客户经理编码最大长度不能超过32个字符")
    private String custManager;

    /**
     * 创建时间
     */
    @NotNull(message = "创建时间不能为空")
    @Size(min = 1, max = 8, message = "创建时间不长度应为1~8个字符")
    private String createDate;

    /**
     * 近一年核心企业年销售收入（万元）
     */
    private BigDecimal coreEntSaleAmtPerYear;
    /**
     * 近一年核心企业销售增长率（%）
     */
    private BigDecimal coreEntSaleGrowthRate;
    /**
     * 近一年核心企业销售毛利率（%）
     */
    private BigDecimal saleGrossProfitRate;
    /**
     * 近一年核心企业资产负债率（%）
     */
    private BigDecimal assetLiabRate;
    /**
     * 是否上市企业 0：非上市企业 1:上市企业
     */
    @Size(max = 1, message = "是否上市企业长度应为1个字符")
    private String listFlag;
    /**
     * 上年度对核心企业进货成本（万元）
     */
    private BigDecimal lyToCoreEntGoodsCost;
    /**
     * 上年度对核心企业销售收入（万元）
     */
    private BigDecimal lyToCoreEntSaleIncome;

    // 查询条件
    private Long upLcAmtStart;
    private Long upLcAmtEnd;
    private Long downLcAmtStart;
    private Long downLcAmtEnd;
    private String upLcValiddateStart;
    private String upLcValiddateEnd;
    private String endLcValiddateStart;
    private String endLcValiddateEnd;

    public String getBusiGroupCode() {
        return busiGroupCode;
    }

    public void setBusiGroupCode(String busiGroupCode) {
        this.busiGroupCode = busiGroupCode == null ? null : busiGroupCode
                .trim();
    }

    public String getBusiGroupName() {
        return busiGroupName;
    }

    public void setBusiGroupName(String busiGroupName) {
        this.busiGroupName = busiGroupName == null ? null : busiGroupName
                .trim();
    }

    public String getHeadEntNo() {
        return headEntNo;
    }

    public void setHeadEntNo(String headEntNo) {
        this.headEntNo = headEntNo == null ? null : headEntNo.trim();
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode == null ? null : tradeCode.trim();
    }

    public Long getUpLcAmt() {
        return upLcAmt;
    }

    public void setUpLcAmt(Long upLcAmt) {
        this.upLcAmt = upLcAmt;
    }

    public Long getUpUcAmt() {
        return upUcAmt;
    }

    public void setUpUcAmt(Long upUcAmt) {
        this.upUcAmt = upUcAmt;
    }

    public String getUpLcValiddate() {
        return upLcValiddate;
    }

    public void setUpLcValiddate(String upLcValiddate) {
        this.upLcValiddate = upLcValiddate == null ? null : upLcValiddate
                .trim();
    }

    public Long getDownLcAmt() {
        return downLcAmt;
    }

    public void setDownLcAmt(Long downLcAmt) {
        this.downLcAmt = downLcAmt;
    }

    public Long getDownUcAmt() {
        return downUcAmt;
    }

    public void setDownUcAmt(Long downUcAmt) {
        this.downUcAmt = downUcAmt;
    }

    public String getDownLcValiddate() {
        return downLcValiddate;
    }

    public void setDownLcValiddate(String downLcValiddate) {
        this.downLcValiddate = downLcValiddate == null ? null : downLcValiddate
                .trim();
    }

    public String getCustManager() {
        return custManager;
    }

    public void setCustManager(String custManager) {
        this.custManager = custManager == null ? null : custManager.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public BigDecimal getCoreEntSaleAmtPerYear() {
        return coreEntSaleAmtPerYear;
    }

    public void setCoreEntSaleAmtPerYear(BigDecimal coreEntSaleAmtPerYear) {
        this.coreEntSaleAmtPerYear = coreEntSaleAmtPerYear;
    }

    public BigDecimal getCoreEntSaleGrowthRate() {
        return coreEntSaleGrowthRate;
    }

    public void setCoreEntSaleGrowthRate(BigDecimal coreEntSaleGrowthRate) {
        this.coreEntSaleGrowthRate = coreEntSaleGrowthRate;
    }

    public BigDecimal getSaleGrossProfitRate() {
        return saleGrossProfitRate;
    }

    public void setSaleGrossProfitRate(BigDecimal saleGrossProfitRate) {
        this.saleGrossProfitRate = saleGrossProfitRate;
    }

    public BigDecimal getAssetLiabRate() {
        return assetLiabRate;
    }

    public void setAssetLiabRate(BigDecimal assetLiabRate) {
        this.assetLiabRate = assetLiabRate;
    }

    public String getListFlag() {
        return listFlag;
    }

    public void setListFlag(String listFlag) {
        this.listFlag = listFlag;
    }

    public BigDecimal getLyToCoreEntGoodsCost() {
        return lyToCoreEntGoodsCost;
    }

    public void setLyToCoreEntGoodsCost(BigDecimal lyToCoreEntGoodsCost) {
        this.lyToCoreEntGoodsCost = lyToCoreEntGoodsCost;
    }

    public BigDecimal getLyToCoreEntSaleIncome() {
        return lyToCoreEntSaleIncome;
    }

    public void setLyToCoreEntSaleIncome(BigDecimal lyToCoreEntSaleIncome) {
        this.lyToCoreEntSaleIncome = lyToCoreEntSaleIncome;
    }

    public Long getUpLcAmtStart() {
        return upLcAmtStart;
    }

    public void setUpLcAmtStart(Long upLcAmtStart) {
        this.upLcAmtStart = upLcAmtStart;
    }

    public Long getUpLcAmtEnd() {
        return upLcAmtEnd;
    }

    public void setUpLcAmtEnd(Long upLcAmtEnd) {
        this.upLcAmtEnd = upLcAmtEnd;
    }

    public Long getDownLcAmtStart() {
        return downLcAmtStart;
    }

    public void setDownLcAmtStart(Long downLcAmtStart) {
        this.downLcAmtStart = downLcAmtStart;
    }

    public Long getDownLcAmtEnd() {
        return downLcAmtEnd;
    }

    public void setDownLcAmtEnd(Long downLcAmtEnd) {
        this.downLcAmtEnd = downLcAmtEnd;
    }

    public String getUpLcValiddateStart() {
        return upLcValiddateStart;
    }

    public void setUpLcValiddateStart(String upLcValiddateStart) {
        this.upLcValiddateStart = upLcValiddateStart;
    }

    public String getUpLcValiddateEnd() {
        return upLcValiddateEnd;
    }

    public void setUpLcValiddateEnd(String upLcValiddateEnd) {
        this.upLcValiddateEnd = upLcValiddateEnd;
    }

    public String getEndLcValiddateStart() {
        return endLcValiddateStart;
    }

    public void setEndLcValiddateStart(String endLcValiddateStart) {
        this.endLcValiddateStart = endLcValiddateStart;
    }

    public String getEndLcValiddateEnd() {
        return endLcValiddateEnd;
    }

    public void setEndLcValiddateEnd(String endLcValiddateEnd) {
        this.endLcValiddateEnd = endLcValiddateEnd;
    }
}