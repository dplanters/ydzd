package com.gndc.common.api.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

/**
 * Created by guold on 2016/9/12. 一些处理结果集的实用代码
 */
public class TableDataUtil {

    /**
     * 结果集转成list
     *
     * @param rs
     * @return
     * @throws java.sql.SQLException
     */
    public static List resultSetToList(ResultSet rs) throws java.sql.SQLException {
        if (rs == null)
            return Collections.EMPTY_LIST;
        ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
        int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
        List list = new ArrayList();
        Map rowData = new HashMap();
        while (rs.next()) {
            rowData = new HashMap(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i).toLowerCase(), rs.getObject(i));
            }
            list.add(rowData);
            // System.out.println("list:" + list.toString());
        }
        rs.close();
        return list;
    }

    /**
     * 结果集转成table，精简版，带表头的
     *
     * @param rs
     * @return
     * @throws java.sql.SQLException
     */
    public static List resultSetToTable(ResultSet rs) throws java.sql.SQLException {
        if (rs == null)
            return Collections.EMPTY_LIST;
        ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
        int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
        List list = new ArrayList();
        List rowColumnName = new ArrayList();
        while (rs.next()) {
            List row = new ArrayList();
            for (int i = 1; i <= columnCount; i++) {
                if (rowColumnName.size() < columnCount) {
                    rowColumnName.add(md.getColumnName(i).toLowerCase());
                }
                row.add(rs.getObject(i));
            }
            list.add(row);
        }
        list.add(0, rowColumnName);
        rs.close();
        return list;
    }

    /**
     * 结果集转成纯行数据，最精简版，不带表头的
     *
     * @param rs
     * @return
     * @throws java.sql.SQLException
     */
    public static List resultSetToDataRows(ResultSet rs) throws java.sql.SQLException {
        if (rs == null)
            return Collections.EMPTY_LIST;
        ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
        int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
        List list = new ArrayList();
        while (rs.next()) {
            List row = new ArrayList();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getObject(i));
            }
            list.add(row);
        }
        rs.close();
        return list;
    }

    /**
     * 去结果集表中某行某列的数据
     *
     * @param tableData  带columnName的表格数据 resultSetToTable
     * @param rowIndex   行号，从1开始
     * @param columnName 列名，不区分大小写
     * @return
     */
    public static Object getCellData(List tableData, int rowIndex, String columnName) {
        try {
            if (tableData != null && tableData.size() >= rowIndex + 1 && rowIndex >= 1 && columnName != null) {
                List columnNames = (List) tableData.get(0);
                int columnIndex = -1;
                for (int i = 0; i < columnNames.size(); i++) {
                    if (columnName.equalsIgnoreCase(String.valueOf(columnNames.get(i)))) {
                        columnIndex = i;
                    }
                }
                if (columnIndex != -1) {
                    List rowData = (List) tableData.get(rowIndex);
                    return rowData.get(columnIndex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置结果集表中某行某列的数据
     *
     * @param tableData  带columnName的表格数据 resultSetToTable
     * @param rowIndex   行号，从1开始
     * @param columnName 列名，不区分大小写
     * @return
     */
    public static Object setCellData(List tableData, int rowIndex, String columnName, Object value) {
        try {
            if (tableData != null && tableData.size() >= rowIndex + 1 && rowIndex >= 1 && columnName != null) {
                List columnNames = (List) tableData.get(0);
                int columnIndex = -1;
                for (int i = 0; i < columnNames.size(); i++) {
                    if (columnName.equalsIgnoreCase(String.valueOf(columnNames.get(i)))) {
                        columnIndex = i;
                    }
                }
                if (columnIndex != -1) {
                    List rowData = (List) tableData.get(rowIndex);
                    return rowData.set(columnIndex, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object addCellData(List tableData, int rowIndex, String columnName, Object value) {
        try {
            if (tableData != null && tableData.size() >= rowIndex + 1 && rowIndex >= 1 && columnName != null) {
                List columnNames = (List) tableData.get(0);
                for (int i = 0; i < columnNames.size(); i++) {
                    List rowData = (List) tableData.get(i);
                    if (i == 0) {
                        rowData.add(columnName);
                    } else {
                        rowData.add(value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
