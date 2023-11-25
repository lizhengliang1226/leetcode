package com.lzl.util;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 版权声明：本程序模块属于后台业务系统（FSPT）的一部分
 * 金证科技股份有限公司 版权所有<br>
 * <p>
 * 模块名称：期权业务-sql脚本比较工具<br>
 * 模块描述：期权业务-sql脚本比较工具<br>
 * 开发作者：李正良<br>
 * 创建日期：2023/01/13.<br>
 * 模块版本：1.0.0.0<br>
 * ----------------------------------------------------------------<br>
 * 修改日期      版本       作者      备注<br>
 * 2023/01/13   1.0.0.0   李正良      创建<br>
 * -----------------------------------------------------------------</p>
 */
public class CompareSqlFile {

    public static void main(String[] args) throws IOException {
        Map<String, Object> tableMap = new HashMap<>(16);
        File sql = new File("C:\\Users\\lzl1226\\Desktop\\fspt_tables.sql");
        InputStreamReader gbk = new InputStreamReader(new FileInputStream(sql), "GBK");
        BufferedReader br = new BufferedReader(gbk);
        int lineNo = 0;
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.contains(";")) {
                sb.append(line);
                sb.append("\n");
                startToParse(sb, tableMap);
                sb = new StringBuilder();
            } else {
                sb.append(line);
                sb.append("\n");
            }
        }
        String jsonString = JSON.toJSONString(tableMap);
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("D:\\Projects\\JavaProjects\\" + "a.txt")));
        writer.write(jsonString);
        writer.flush();
        writer.close();
        // System.out.println(jsonString);

        Map<String, Object> table1Map = new HashMap<>(16);

        File sql1 = new File("C:\\Users\\lzl1226\\Desktop\\fspt_tables_pdm.sql");
        InputStreamReader gbk1 = new InputStreamReader(new FileInputStream(sql1), "GBK");
        BufferedReader br1 = new BufferedReader(gbk1);
        int lineNo1 = 0;
        String line1 = "";
        StringBuilder sb1 = new StringBuilder();
        while ((line1 = br1.readLine()) != null) {
            if (line1.contains(";")) {
                sb1.append(line1);
                sb1.append("\n");
                startToParse(sb1, table1Map);
                sb1 = new StringBuilder();
            } else {
                sb1.append(line1);
                sb1.append("\n");
            }
        }
        String jsonString1 = JSON.toJSONString(table1Map);
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(new File("D:\\Projects\\JavaProjects\\" + "b.txt")));
        writer1.write(jsonString1);
        writer1.flush();
        writer1.close();
        // System.out.println(jsonString1);
        for (Map.Entry<String, Object> entry : tableMap.entrySet()) {
            String key = entry.getKey();
            Map<String, String> value = (Map<String, String>) entry.getValue();
            if (key.equals("dropView") || key.equals("dropIndex") || key.equals("dropTable") || key.equals("createView") || key.equals(
                    "createIndex")) {
                if (key.equals("createView")) {
                    check(table1Map, key, value, "视图在远程没有创建！", "视图");
                } else if (key.equals("createIndex")) {
                    check(table1Map, key, value, "索引在远程没有创建！", "索引");
                } else if (key.equals("dropView")) {
                    Map<String, String> map1 = (Map<String, String>) table1Map.get(key);
                    if (map1 == null) {
                        System.out.println("dropView节点不存在，没有删除脚本");
                    } else {
                        value.forEach((k, v) -> {
                            String rv = map1.get(k);
                            if (rv == null || rv.length() == 0) {
                                System.out.println("视图" + k + "在远程没有删除脚本");
                            } else {
                                if (!rv.equals(v)) {
                                    System.out.println("视图" + k + "的删除脚本不同！");
                                }
                            }
                        });
                    }
                } else if (key.equals("dropIndex")) {
                    Map<String, String> map1 = (Map<String, String>) table1Map.get(key);
                    if (map1 == null) {
                        System.out.println("dropIndex节点不存在，没有删除索引的脚本");
                    } else {
                        value.forEach((k, v) -> {
                            String rv = map1.get(k);
                            if (rv == null || rv.length() == 0) {
                                System.out.println("索引" + k + "在远程没有删除脚本");
                            } else {
                                if (!rv.equals(v)) {
                                    System.out.println("索引" + k + "的删除脚本不同！");
                                }
                            }
                        });
                    }
                } else if (key.equals("dropTable")) {
                    Map<String, String> map1 = (Map<String, String>) table1Map.get(key);
                    if (map1 == null) {
                        System.out.println("dropTable节点不存在，没有删除表的脚本");
                    } else {
                        value.forEach((k, v) -> {
                            String rv = map1.get(k);
                            if (rv == null || rv.length() == 0) {
                                System.out.println("表" + k + "在远程没有删除脚本");
                            } else {
                                if (!rv.equals(v)) {
                                    System.out.println("表" + k + "的删除脚本不同！");
                                }
                            }
                        });
                    }
                }
            } else {
                Map<String, String> map1 = (Map<String, String>) table1Map.get(key);
                if (map1 == null) {
                    System.out.println("表" + key + "在远程不存在");
                } else {
                    value.forEach((k, v) -> {
                        String s = map1.get(k);
                        if (s == null || s.length() == 0) {
                            System.out.println(key + "表的" + k + "字段在远程不存在,或者建表语句转化失败导致没有值");
                        } else {
                            if (!s.equals(v)) {
                                if (key.equals(k)) {
                                    System.out.println("表" + key + "的" + "注释与远程不相同");
                                } else {
                                    System.out.println("表" + key + "的" + k + "字段定义不相同或者列注释不同");
                                }
                            }
                        }
                    });
                }
            }
        }

    }

    private static void check(Map<String, Object> table1Map, String key, Map<String, String> value, String s2, String structName) {
        Map<String, String> map1 = (Map<String, String>) table1Map.get(key);
        if (map1 == null) {
            System.out.println(s2);
        } else {
            value.forEach((k, v) -> {
                String rv = map1.get(k);
                if (rv == null || rv.length() == 0) {
                    System.out.println(structName + k + "在远程未创建");
                } else {
                    if (!rv.equals(v)) {
                        System.out.println(structName + k + "的构建不同！");
                    }
                }
            });
        }
    }

    private static void startToParse(StringBuilder sb, Map<String, Object> tableMap) {
        // tableName dropIndex  dropTable createIndex createView dropView
        List<SQLStatement> sqlStatements = null;
        try {
            sqlStatements = SQLUtils.parseStatements(sb.toString(), JdbcConstants.ORACLE);
        } catch (Exception e) {
            System.out.println("SQL转化出现了错误！");
            spcialHandle(sb);
            System.out.println(sb.toString());
            return;
        }
        for (SQLStatement statement : sqlStatements) {
            if (statement instanceof SQLCommentStatement) {
                // System.out.println("注释语句");
                SQLCommentStatement commentStatement = (SQLCommentStatement) statement;
                SQLExpr comment = commentStatement.getComment();
                SQLExprTableSource on = commentStatement.getOn();
                SQLCommentStatement.Type type = commentStatement.getType();
                String tableName = on.toString().split("\\.")[0];
                // System.out.println(on);
                // 新增列注释
                Map<String, Object> map = (Map<String, Object>) tableMap.get(tableName);
                if (CollectionUtil.isNotEmpty(map)) {
                    map.put(on.toString(), comment.toString());
                    tableMap.put(tableName, map);
                } else {
                    map = new HashMap<>();
                    map.put(on.toString(), comment.toString());
                    tableMap.put(tableName, map);
                }
            } else if (statement instanceof SQLCreateTableStatement) {
                // System.out.println("建表语句");
                SQLCreateTableStatement tableStatement = (SQLCreateTableStatement) statement;
                // 新增表注释
                String tableName = tableStatement.getName().getSimpleName();
                Map<String, Object> map = (Map<String, Object>) tableMap.get(tableName);
                if (CollectionUtil.isNotEmpty(map)) {
                    for (SQLColumnDefinition definition : tableStatement.getColumnDefinitions()) {
                        String columnName = definition.getColumnName();
                        map.put(columnName, definition.toString());
                    }
                    tableMap.put(tableName, map);
                } else {
                    map = new HashMap<>();
                    for (SQLColumnDefinition definition : tableStatement.getColumnDefinitions()) {
                        String columnName = definition.getColumnName();
                        map.put(columnName, definition.toString());
                    }
                    tableMap.put(tableName, map);
                }
            } else if (statement instanceof SQLDropIndexStatement) {
                // System.out.println("删除索引语句");
                SQLDropIndexStatement dropIndexStatement = (SQLDropIndexStatement) statement;
                SQLName indexName = dropIndexStatement.getIndexName();
                Map<String, Object> map = (Map<String, Object>) tableMap.get("dropIndex");
                if (CollectionUtil.isNotEmpty(map)) {
                    map.put(indexName.toString(), dropIndexStatement.toString());
                    tableMap.put("dropIndex", map);
                } else {
                    map = new HashMap<>();
                    map.put(indexName.toString(), dropIndexStatement.toString());
                    tableMap.put("dropIndex", map);
                }
            } else if (statement instanceof SQLDropTableStatement) {
                // System.out.println("删除表语句");
                SQLDropTableStatement dropTableStatement = (SQLDropTableStatement) statement;
                List<SQLExprTableSource> sources = dropTableStatement.getTableSources();
                // System.out.println(dropTableStatement);
                Map<String, Object> map = (Map<String, Object>) tableMap.get("dropTable");
                if (CollectionUtil.isNotEmpty(map)) {
                    map.put(sources.toString(), dropTableStatement.toString());
                    tableMap.put("dropTable", map);
                } else {
                    map = new HashMap<>();
                    map.put(sources.toString(), dropTableStatement.toString());
                    tableMap.put("dropTable", map);
                }
            } else if (statement instanceof SQLCreateIndexStatement) {
                // System.out.println("建索引语句");
                SQLCreateIndexStatement indexStatement = (SQLCreateIndexStatement) statement;
                String indexName = indexStatement.getName().getSimpleName();
                Map<String, Object> map = (Map<String, Object>) tableMap.get("createIndex");
                if (CollectionUtil.isNotEmpty(map)) {
                    map.put(indexName, indexStatement.toString());
                    tableMap.put("createIndex", map);
                } else {
                    map = new HashMap<>();
                    map.put(indexName, indexStatement.toString());
                    tableMap.put("createIndex", map);
                }
            } else if (statement instanceof SQLCreateViewStatement) {
                SQLCreateViewStatement viewStatement = (SQLCreateViewStatement) statement;
                String viewName = viewStatement.getName().getSimpleName();
                Map<String, Object> map = (Map<String, Object>) tableMap.get("createView");
                if (CollectionUtil.isNotEmpty(map)) {
                    map.put(viewName, viewStatement.toString());
                    tableMap.put("createView", map);
                } else {
                    map = new HashMap<String, Object>();
                    map.put(viewName, viewStatement.toString());
                    tableMap.put("createView", map);
                }
            } else if (statement instanceof SQLDropViewStatement) {
                // System.out.println("删除视图语句");
                SQLDropViewStatement viewStatement = (SQLDropViewStatement) statement;
                List<SQLExprTableSource> sources = viewStatement.getTableSources();
                Map<String, Object> map = (Map<String, Object>) tableMap.get("dropView");
                if (CollectionUtil.isNotEmpty(map)) {
                    map.put(sources.toString(), viewStatement.toString());
                    tableMap.put("dropView", map);
                } else {
                    map = new HashMap<String, Object>();
                    map.put(sources.toString().toString(), viewStatement.toString());
                    tableMap.put("dropView", map);
                }
            } else {
                System.out.println("其他！！！！");
                System.out.println(statement.toString());
            }
        }
    }

    /**
     * 特殊处理
     *
     * @param sb
     */
    private static void spcialHandle(StringBuilder sb) {
        String s = sb.toString();
        System.out.println("特殊处理");
        String partitionField = s.split("PARTITION_FIELD")[0];
        String s1 = partitionField.trim();
        String s2 = s1.substring(0, s1.length() - 1);
        System.out.println(s2+");");
    }
}