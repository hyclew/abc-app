package com.kingteller.bs.domain.business;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BusinessDetailed {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column businessdetailed.id
     *
     * @ibatorgenerated Mon Apr 13 13:55:19 CST 2015
     */
    private Long id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column businessdetailed.businessid
     *
     * @ibatorgenerated Mon Apr 13 13:55:19 CST 2015
     */
    private Long businessid;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column businessdetailed.id
     *
     * @return the value of businessdetailed.id
     *
     * @ibatorgenerated Mon Apr 13 13:55:19 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column businessdetailed.id
     *
     * @param id the value for businessdetailed.id
     *
     * @ibatorgenerated Mon Apr 13 13:55:19 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column businessdetailed.businessid
     *
     * @return the value of businessdetailed.businessid
     *
     * @ibatorgenerated Mon Apr 13 13:55:19 CST 2015
     */
    public Long getBusinessid() {
        return businessid;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column businessdetailed.businessid
     *
     * @param businessid the value for businessdetailed.businessid
     *
     * @ibatorgenerated Mon Apr 13 13:55:19 CST 2015
     */
    public void setBusinessid(Long businessid) {
        this.businessid = businessid;
    }
}