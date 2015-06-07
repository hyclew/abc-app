package com.kingteller.bs.domain;

public class BaseConstant {
    // 超级管理员员工编号
    public static final String SUPERVISOR_STAFF_NO = "ABC00000000";

    // 员工类型 对应码表STAFF_TYPE
    public static final String STAFF_TYPE_CUST_MANAGER = "0";// 客户经理账号
    public static final String STAFF_TYPE_OPERATOR = "1";// 运维人员账号

    // 状态类型 对应码表STAFF_STATUS
    public static final String STAFF_STATUS_UNACTIVATED = "0";// 未激活
    public static final String STAFF_STATUS_ACTIVATED = "1";// 已激活
    public static final String STAFF_STATUS_LOCKED = "1";// 锁定
    public static final String STAFF_STATUS_DELETED = "1";// 删除

    /** 字典类型 公用的产品类型 PRODUCT_CODE */
    public static final String DICT_CODE_TYPE_PRODUCT_CODE = "PRODUCT_CODE";
    /** 字典类型 发送时间是否受限制 TIME_FLAG */
    public static final String DICT_CODE_TYPE_MSG_TIME_FLAG = "MSG_TIME_FLAG";
    /** 字典类型 周末是否发送 TIME_FLAG */
    public static final String DICT_CODE_TYPE_WEEKEND_FLAG = "WEEKEND_FLAG";
    /** 字典类型 节假日是否发送 HOLIDAY_FLAG */
    public static final String DICT_CODE_TYPE_HOLIDAY_FLAG = "HOLIDAY_FLAG";
    /** 字典类型 消息级别 MSG_PRIORITY */
    public static final String DICT_CODE_TYPE_MSG_PRIORITY = "MSG_PRIORITY";
    /** 字典类型 消息启用停用标志 START_STOP_FLAG */
    public static final String DICT_CODE_TYPE_START_STOP_FLAG = "START_STOP_FLAG";
    /** 字典类型 公告类型 MSG_TYPE */
    public static final String DICT_CODE_TYPE_MSG_TYPE = "MSG_TYPE";
    /** 字典类型 发布状态 PUBLISH_STATUS */
    public static final String DICT_CODE_TYPE_PUBLISH_STATUS = "PUBLISH_STATUS";
    /** 字典类型 配置发送的方式 PUBLISH_CHANNEL */
    public static final String DICT_CODE_TYPE_PUBLISH_CHANNEL = "PUBLISH_CHANNEL";
    /** 字典类型 消息发送状态 MSG_STATUS */
    public static final String DICT_CODE_TYPE_MSG_STATUS = "MSG_STATUS";
    /** 字典类型 消息发送方式 MSG_CHANNEL */
    public static final String DICT_CODE_TYPE_MSG_CHANNEL = "MSG_CHANNEL";
    /** 字典类型 删除标志 否是可删除 DELETE_FLAG */
    public static final String DICT_CODE_TYPE_DELETE_FLAG = "DELETE_FLAG";
    /** 字典类型 编辑标志 否是可编辑 READ_FLAG */
    public static final String DICT_CODE_TYPE_READ_FLAG = "READ_FLAG";
    /** 字典类型 证件类型 IDENT_TYPE */
    public static final String DICT_CODE_TYPE_IDENT_TYPE = "IDENT_TYPE";
    /** 字典类型 企业需上传的文件类型 ENT_FILE_TYPE */
    public static final String DICT_CODE_TYPE_ENT_FILE_TYPE = "ENT_FILE_TYPE";
    /** 字典类型 个人需上传的文件类型 PEOPLE_FILE_TYPE */
    public static final String DICT_CODE_TYPE_PEOPLE_FILE_TYPE = "PEOPLE_FILE_TYPE";
    /** 字典类型 性别 GENDER */
    public static final String DICT_CODE_TYPE_GENDER = "GENDER";
    /** 字典类型 工作年限 WORK_YEAR */
    public static final String DICT_CODE_TYPE_WORK_YEAR = "WORK_YEAR";
    /** 字典类型 婚姻状况 MARRI_STATUS */
    public static final String DICT_CODE_TYPE_MARRI_STATUS = "MARRI_STATUS";
    /** 字典类型 收入范围 INCOME_SCOPE */
    public static final String DICT_CODE_TYPE_INCOME_SCOPE = "INCOME_SCOPE";
    /** 字典类型 企业/个人信息状态 ENT_INFO_STATUS */
    public static final String DICT_CODE_TYPE_ENT_INFO_STATUS = "ENT_INFO_STATUS";

    // 默认互联网银行机构编号 来源表CP_ORG
    public static final String ORG_CODE_LOAN_BUSINESS_CENTER = "011000";// 贷款运营中心
    // 系统创建员工默认密码
    public static final String DEFAULT_PASSWORD_FOR_NEW_STAFF = "staff";

    // 是否核心企业 CORE_FLAG
    public static final String CORE_FLAG_Y = "1";// 是核心企业
    public static final String CORE_FLAG_N = "0";// 不是核心企业

    // 是否圈内企业 BG_FLAG
    public static final String BG_FLAG_Y = "1";// 圈内企业
    public static final String BG_FLAG_N = "0";// 圈外企业
    
    //对个人个人客户跟企业进行资料审核后，给予审批是否通过的标志
    public static final String AUDIT_STATUS_PASS = "0";  //审核通过
    public static final String AUDIT_STATUS_FAIL = "1";  //审核不通过

    // 企业激活标记 ACTIVATE_STATUS
    public static final String ACTIVATE_STATUS_Y = "1";// 已激活
    public static final String ACTIVATE_STATUS_N = "0";// 未激活

    // 企业信息状态ENT_INFO_STATUS
    public static final String ENT_INFO_STATUS_NONE = "1";// 未提交
    public static final String ENT_INFO_STATUS_SUBMITED = "2";// 已提交待审核
    public static final String ENT_INFO_STATUS_APPROVED = "3"; // 审核通过
    public static final String ENT_INFO_STATUS_UNSANCTIONED = "4"; // 审核不通过

    // 企业必须上传文件类型 ENT_FILE_TYPE
    public static final String ENT_FILE_TYPE_E0 = "E0";// 企业其他资料
    public static final String ENT_FILE_TYPE_E1 = "E1";// 注册或登记证件
    public static final String ENT_FILE_TYPE_E2 = "E2";// 组织机构代码证
    public static final String ENT_FILE_TYPE_E3 = "E3";// 企业法人代表授权书
    public static final String ENT_FILE_TYPE_E4 = "E4";// 企业法人代表有效证件
    public static final String ENT_FILE_TYPE_E5 = "E5";// 企业营业执照

    // 贷款上传文件类型ENT_FILE_TYPE
    public static final String ENT_FILE_TYPE_L0 = "L0";// 其他
    public static final String ENT_FILE_TYPE_L1 = "L1";// 贷款卡
    public static final String ENT_FILE_TYPE_L2 = "L2";// 国税登记证
    public static final String ENT_FILE_TYPE_L3 = "L3";// 地税登记证
    public static final String ENT_FILE_TYPE_L4 = "L4";// 信用代码证
    public static final String ENT_FILE_TYPE_L5 = "L5";// 企业实际所有证有效证件
    public static final String ENT_FILE_TYPE_L6 = "L6";// 近两年财务报表
    public static final String ENT_FILE_TYPE_L7 = "L7";// 厂房地址证明

    // 个人必须上传文件类型PERSON_FILE_TYPE
    public static final String PERSON_FILE_TYPE_P0 = "P0";// 个人其他资料
    public static final String PERSON_FILE_TYPE_P1 = "P1";// 身份证正面复印件
    public static final String PERSON_FILE_TYPE_P2 = "P2";// 身份证反面复印件
    public static final String PERSON_FILE_TYPE_P3 = "P3";// 银行流水
    public static final String PERSON_FILE_TYPE_P4 = "P4";// 征信记录
    public static final String PERSON_FILE_TYPE_P5 = "P5";// 银行存储单
    public static final String PERSON_FILE_TYPE_P6 = "P6";// 收入证明
    public static final String PERSON_FILE_TYPE_P7 = "P7";// 个体营业执照

    // 文件状态 FILE_STATUS
    public static final String FILE_STATUS_SUBMITED = "0";// 已提交
    public static final String FILE_STATUS_APPROVED = "1"; // 审核通过
    public static final String FILE_STATUS_UNSANCTIONED = "2";// 审核未通过

    // 文件删除标记 DELETE_STATUS
    public static final String DELETE_STATUS_N = "0";// 未删除
    public static final String DELETE_STATUS_Y = "1"; // 删除

    // 上传文件大小限制
    public static final int UPLOAD_FILE_SIZE_MAX_LIMIT = 10 * 1024 * 1024;// 10MB

    // 客户经理类型 MANAGER_TYPE
    public static final String MANAGER_TYPE_ERP_CM = "1";// ERP客户经理
    public static final String MANAGER_TYPE_POSTLOAN_CM = "2";// 贷后客户经理
    public static final String MANAGER_TYPE_COREENT_CM = "3";// 核心企业客户经理

    // 贷款组客户经理指定角色编号
    public static final String CM_FIXED_ROLE_COREENT_CM = "LN003";// 核心企业客户经理岗
    public static final String CM_FIXED_ROLE_ERP_CM = "LN004";// ERP客户经理岗
    public static final String CM_FIXED_ROLE_POSTLOAN_CM = "LN005";// 贷后客户经理岗
    // 贷款审批岗
    public static final String LOAN_APPROVE_ROLE = "LN006";// 贷款审批岗
    
	//消息发送的渠道，对应数据库表CP_MSG中的MSG_CHANNEL字段
	public static final String MSG_CHANEL_SITENOTICE = "1";//站内通知
	public static final String MSG_CHANEL_SMS = "2";//短消息
	public static final String MSG_CHANEL_EMAIL = "3";//邮件
	public static final String MSG_CHANEL_SYSBROADCAST = "4";//系统广播
	
	
	//消息来源，对应数据库表CP_MSG中的SOURCE_FLAG字段
	public static final String MSG_SOURCE_IBANKWEB = "1";//互联网系统
	public static final String MSG_SOURCE_IBANKMANAGER = "2";//后台管理系统
}

