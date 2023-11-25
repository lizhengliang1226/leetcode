package com.lzl.util;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.util.JdbcConstants;

/**
 * 版权声明：本程序模块属于后台业务系统（FSPT）的一部分
 * 金证科技股份有限公司 版权所有<br>
 * <p>
 * 模块名称：期权业务-<br>
 * 模块描述：期权业务-<br>
 * 开发作者：李正良<br>
 * 创建日期：2023/01/13.<br>
 * 模块版本：1.0.0.0<br>
 * ----------------------------------------------------------------<br>
 * 修改日期      版本       作者      备注<br>
 * 2023/01/13   1.0.0.0   李正良      创建<br>
 * -----------------------------------------------------------------</p>
 */
public class TestParse {
    public static void main(String[] args) {
        String a="create table OPT_UNDL_PREPAY_DETAIL\n" +
                "(\n" +
                "    EXERCISE_DATE   NUMBER(10)                     not null,\n" +
                "    SETT_DATE       NUMBER(10)                     not null,\n" +
                "    CUST_CODE       VARCHAR2(20)                   not null,\n" +
                "    CUACCT_CODE     VARCHAR2(20)                   not null,\n" +
                "    CURRENCY        CHAR(2)                           not null,\n" +
                "    INT_ORG         NUMBER(5)                      not null,\n" +
                "    MARKET          CHAR                           not null,\n" +
                "    BOARD           CHAR(2)                        not null,\n" +
                "    TRDACCT         VARCHAR2(20)                   not null,\n" +
                "    SUBACCT_CODE    VARCHAR2(8)                    not null,\n" +
                "    OPT_UNDL_CODE   VARCHAR2(32)                   not null,\n" +
                "    OPT_UNDL_NAME   VARCHAR2(80)                   not null,\n" +
                "    OPT_UNDL_TYPE   CHAR(1)                        not null,\n" +
                "    STK_NET_PAY_QTY NUMBER(19, 2)                  not null,\n" +
                "    APP_PREPAY_QTY  NUMBER(19, 2)                  not null,\n" +
                "    ACT_PREPAY_QTY  NUMBER(19, 2)                  not null,\n" +
                "    APP_RETURN_QTY  NUMBER(19, 2)                  not null,\n" +
                "    ACT_RETURN_QTY  NUMBER(19, 2)                  not null,\n" +
                "    CLOSE_FLAG      CHAR(1)                        NOT NULL,\n" +
                "    LEGAL_ID        NUMBER(5)                      not null,\n" +
                "    UPDATE_TIME     TIMESTAMP default systimestamp not null\n" +
                ");";
        SQLStatement sqlStatement = SQLUtils.parseSingleStatement(a,JdbcConstants.ORACLE);
    }
}