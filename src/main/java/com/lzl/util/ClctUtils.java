package com.lzl.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 采集构建
 *
 * @author LZL
 * @date 2023/1/5-17:08
 */
public class ClctUtils {
    /*任务代码*/
    private static final String TASK_CODE = "[TASK_CODE]";
    /*采集任务名*/
    private static final String CLCT_NAME = "[CLCT_NAME]";
    /*采集数据代码*/
    private static final String CLCT_DATA_CODE = "[CLCT_DATA_CODE]";
    /*视图名*/
    private static final String VIEW_NAME = "[VIEW_NAME]";
    /*表名*/
    private static final String TABLE_NAME = "[TABLE_NAME]";
    /*分片字段，以逗号分割*/
    private static final String SPLIT_FIELD = "[SPLIT_FIELD]";
    /*分片字段类型，以逗号分割*/
    private static final String FILED_TYPE = "[FILED_TYPE]";
    /*采集字段，以逗号分割*/
    private static final String CLCT_FIELDS = "[CLCT_FIELDS]";
    /*字段映射id*/
    private static final String FILED_MAPPING_ID = "[FILED_MAPPING_ID]";
    private static final Map<String, String> REPLACE_MAP = new HashMap<>();
    private static final String srcPath = "C:\\Users\\lzl1226\\Desktop";
    private static String clctDataCode = "";
    private static String line = "";
    private static String clctFields = "";
    private static String fieldMappingId = "";

    static {
        REPLACE_MAP.put("TASK_CODE", TASK_CODE);
        REPLACE_MAP.put("CLCT_NAME", CLCT_NAME);
        REPLACE_MAP.put("CLCT_DATA_CODE", CLCT_DATA_CODE);
        REPLACE_MAP.put("VIEW_NAME", VIEW_NAME);
        REPLACE_MAP.put("TABLE_NAME", TABLE_NAME);
        REPLACE_MAP.put("SPLIT_FIELD", SPLIT_FIELD);
        REPLACE_MAP.put("FILED_TYPE", FILED_TYPE);
        REPLACE_MAP.put("CLCT_FIELDS", CLCT_FIELDS);
        REPLACE_MAP.put("FILED_MAPPING_ID", FILED_MAPPING_ID);
    }

    private static String template = "-- 新增清算任务种类\n" +
            "INSERT INTO FSPT.SETT_TASK_SET\n" +
            "(SETT_PHASE_TYPE, SETT_TASK_CODE, SETT_TASK_NAME, SETT_SEL_FLAG, SETT_TASK_TYPE, DFLT_EXE_MODE, AFT_TASK, FUNC_CLASS_NAME, FUNC_METHOD_NAME, FUNC_ROLLBACK_METHOD_NAME, ROLLBACK_TYPE, EXE_SEQ_NO, RTBAK_PERMIT_FLAG, MUTEX_FLAG, UPDATE_TIME)\n" +
            "VALUES('D0', '[TASK_CODE]', '[CLCT_NAME]采集', '0', '5', '1', ' ', 'com.szkingdom.fspt.batch.collect.entry.DefaultCollectEntry', 'start', ' ', '0', [TASK_CODE], '1', '0', systimestamp);\n" +
            "-- 清算批次任务定义新增\n" +
            "INSERT INTO FSPT.SETT_BAT_TASK_CFG\n" +
            "(SETT_BAT_NO, SETT_PHASE_CODE, SETT_TASK_CODE, PRE_TASK_CODES, AUTO_EFFECTIVE_TIME, AUTO_INEFFECTIVE_TIME, SPECIFIED_RANGE_FLAG, EXE_MODE, EXE_ORDER, UPDATE_TIME)\n" +
            "VALUES('999', '59', '[TASK_CODE]', '100', '180000', '235959', '0', '0', [TASK_CODE], systimestamp);\n" +
            "-- 新增采集数据模板\n" +
            "INSERT INTO FSPT.SETT_CLCT_DATA_TMPL\n" +
            "(DATA_TYPE_ID, CLCT_DATA_CODE, CLCT_DATA_NAME, SETT_TASK_CODE, INTFC_FLAG, CLCT_NODE_FLAG, CLCT_MODE, MIN_CLCT_INTERVALS, EFFECTIVE_TIME_POINT, SUBSYS, RELY_DATA_CODE, UPDATE_CLASS_NAME, UPDATE_CLASS_METHOD, REDO_FLAG, RELY_TASK_CODES, UPDATE_TIME)\n" +
            "VALUES('[CLCT_DATA_CODE]', '[CLCT_DATA_CODE]', '[CLCT_NAME]', '[TASK_CODE]', '3', '0', '0', 5, '000000', 18, ' ', 'CommonUpdate', 'updateCollectData', '1', ' ', systimestamp);\n" +
            "-- 新增数据库表采集配置\n" +
            "INSERT INTO FSPT.SETT_CLCT_HANDLE_CFG\n" +
            "(CLCT_DATA_CODE, SRC_SUBSYS, SRC_TABLE_CODE, TAG_TABLE_CODE, PTN_HANDLE_SIZE, SPLIT_FIELDS, SPLIT_FIELDS_TYPE, PAGE_SIZE, CLCT_FILED_SET, CLCT_DATA_WHERE, CLCT_VIEW_SCRIPT, CLCT_MODE, COMPARE_FIELD_SET, TRANS_TYPE, FIELDS_MAPPING_ID, UPDATE_TIME)\n" +
            "VALUES('[CLCT_DATA_CODE]', 18, '[VIEW_NAME]', '[TABLE_NAME]', 20000, '[SPLIT_FIELD]', '[FILED_TYPE]', 10000, '[CLCT_FIELDS]', ' ', ' ', '1', ' ', '0', '[FILED_MAPPING_ID]', systimestamp);\n" +
            "-- 新增采集数据定义\n" +
            "INSERT INTO FSPT.SETT_CLCT_DATA_CFG\n" +
            "(SETT_BAT_NO, CLCT_DATA_CODE, SETT_PHASE_CODE, SETT_TASK_CODE, SUBSYS, DEF_SOURCE, UPDATE_TIME, SUBSYS_TYPES)\n" +
            "VALUES('999', '[CLCT_DATA_CODE]', '59', '[TASK_CODE]', 18, '1', systimestamp, '@');\n" +
            "-- 目标\n" +
            "SELECT * FROM [TABLE_NAME];\n" +
            "-- 视图脚本\n" +
            "IF  EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID('[VIEW_NAME]'))\n" +
            "   DROP VIEW [VIEW_NAME] \n" +
            "GO\n" +
            "create view [VIEW_NAME] AS\n" +
            "       select * from [TABLE_NAME]\n" +
            "GO\n";
    private static final String viewSql = "-- [TABLE_NAME]\n" +
            "IF  EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID('[VIEW_NAME]'))\n" +
            "   DROP VIEW [VIEW_NAME] \n" +
            "GO\n" +
            "create view [VIEW_NAME] AS\n" +
            "       select * from [TABLE_NAME]\n" +
            "GO\n";
    private static StringBuilder sb = new StringBuilder();
    private static String src = new String(template.getBytes(StandardCharsets.UTF_8));

    public static void main(String[] args) {
        createViewSql();
    }

    private static void createViewSql() {
        String[] tables = new String[]{"STK_RIGHT_PLAN", "HOLIDAY_INFO", "STRATEGY_SCOPE", "MARGIN_RATE_PARAM", "MARGIN_TEMPLATE", "CUST_MARGIN_CFG"};
        for (String table : tables) {
            String a = new String(viewSql.getBytes(StandardCharsets.UTF_8));
            a = a.replace("[VIEW_NAME]", "V_CLCT_" + table).replace("[TABLE_NAME]", table);
            System.out.println(a);
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(srcPath + "\\V_CLCT_" +  table + ".sql"));
                bw.write(a);
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createSql() {
        File file = new File(srcPath + "\\采集sql配置.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                if (line.equals("----------")) {
                    createFieldMapping(clctFields, sb, fieldMappingId);
                    System.out.println(src);
                    System.out.println(sb);
                    writeFile();
                    clear();
                    continue;
                }
                String[] info = line.split("=");
                if (info[0].equals("CLCT_FIELDS")) {
                    clctFields = info[1];
                }
                if (info[0].equals("FILED_MAPPING_ID")) {
                    fieldMappingId = info[1];
                }
                if (info[0].equals("CLCT_DATA_CODE")) {
                    clctDataCode = info[1];
                }
                src = src.replace(REPLACE_MAP.get(info[0]), info[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clear() {
        sb = new StringBuilder();
        src = new String(template.getBytes(StandardCharsets.UTF_8));
        clctDataCode = "";
        clctFields = "";
        fieldMappingId = "";
    }

    private static void writeFile() {
        System.out.println("开始写入文件");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(srcPath + "\\" + clctDataCode + ".txt"));
            writer.write(src);
            writer.write(sb.toString());
            writer.flush();
            System.out.println("脚本生成成功！");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFieldMapping(String clctFields, StringBuilder sb, String fieldMappingId) {
        sb.append("-- 新增采集字段转换配置\n");
        sb.append("INSERT ALL\n");
        String[] fields = clctFields.split(",");
        for (String field : fields) {
            String c = "INTO FSPT.SETT_CLCT_FIELDS_MAPPING(FIELDS_MAPPING_ID, FIELD_SN, SRC_FIELD, TGT_FIELD, TGT_DFT_VAL, TRANS_RULE_ID, UPDATE_TIME) VALUES('" + fieldMappingId + "', 0, '" + field + "', '" + field + "', ' ', 0, systimestamp)\n";
            sb.append(c);
        }
        sb.append("SELECT 1 FROM DUAL;");
    }
}