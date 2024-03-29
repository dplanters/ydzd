package com.bbjh.common.mybatis;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

/**
 * @author fwb
 * @date 2019/2/2
 */
public class CustomSelectProvider extends MapperTemplate {

    public CustomSelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**Ba
     * 根据属性查询，只能有一个返回值，有多个结果时抛出异常，查询条件使用等号
     *
     * @param ms
     * @return
     */
    public String selectOneByProperty(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        //修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append("<where>\n");
        sql.append("<if test=\"");
        sql.append("value != null");
        if (isNotEmpty()) {
            sql.append(" and ");
            sql.append(" value != '' ");
        }
        sql.append("\">\n");
        String name = entityClass.getName();
        String propertyHelper = PropertyHelper.class.getName();
        //通过实体类名获取运行时属性对应的字段
        String ognl = new StringBuilder("${@")
                .append(propertyHelper)
                .append("@getColumnByProperty(@java.lang.Class@forName(\"")
                .append(name)
                .append("\"), @tk.mybatis.mapper.weekend.reflection.Reflections@fnToFieldName(fn))}").toString();
        sql.append(ognl + " = #{value}\n");
        sql.append("</if>\n");
        // 逻辑删除的未删除查询条件
        sql.append(SqlHelper.whereLogicDelete(entityClass, false));
        sql.append("</where>");
        return sql.toString();
    }

    /**
     * 根据属性查询，查询条件使用等号
     *
     * @param ms
     * @return
     */
    public String selectByProperty(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        //修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append("<where>\n");
        sql.append("<if test=\"");
        sql.append("value != null");
        if (isNotEmpty()) {
            sql.append(" and ");
            sql.append(" value != '' ");
        }
        sql.append("\">\n");
        String name = entityClass.getName();
        String propertyHelper = PropertyHelper.class.getName();
        //通过实体类名获取运行时属性对应的字段
        String ognl = new StringBuilder("${@")
                .append(propertyHelper)
                .append("@getColumnByProperty(@java.lang.Class@forName(\"")
                .append(name)
                .append("\"), @tk.mybatis.mapper.weekend.reflection.Reflections@fnToFieldName(fn))}").toString();
        sql.append(ognl + " = #{value}\n");
        sql.append("</if>\n");
        // 逻辑删除的未删除查询条件
        sql.append(SqlHelper.whereLogicDelete(entityClass, false));
        sql.append("</where>");
        return sql.toString();
    }

    /**
     * 根据属性查询总数，查询条件使用等号
     *
     * @param ms
     * @return
     */
    public String existsWithProperty(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);

        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectCountExists(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append("<where>\n");
        sql.append("<if test=\"");
        sql.append("value != null");
        if (isNotEmpty()) {
            sql.append(" and ");
            sql.append(" value != '' ");
        }
        sql.append("\">\n");
        String name = entityClass.getName();
        String propertyHelper = PropertyHelper.class.getName();
        //通过实体类名获取运行时属性对应的字段
        String ognl = new StringBuilder("${@")
                .append(propertyHelper)
                .append("@getColumnByProperty(@java.lang.Class@forName(\"")
                .append(name)
                .append("\"), @tk.mybatis.mapper.weekend.reflection.Reflections@fnToFieldName(fn))}").toString();
        sql.append(ognl + " = #{value}\n");
        sql.append("</if>\n");
        // 逻辑删除的未删除查询条件
        sql.append(SqlHelper.whereLogicDelete(entityClass, false));
        sql.append("</where>");
        return sql.toString();
    }

    /**
     * 根据属性查询总数，查询条件使用等号
     *
     * @param ms
     * @return
     */
    public String selectCountByProperty(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);

        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectCount(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append("<where>\n");
        sql.append("<if test=\"");
        sql.append("value != null");
        if (isNotEmpty()) {
            sql.append(" and ");
            sql.append(" value != '' ");
        }
        sql.append("\">\n");
        String name = entityClass.getName();
        String propertyHelper = PropertyHelper.class.getName();
        //通过实体类名获取运行时属性对应的字段
        String ognl = new StringBuilder("${@")
                .append(propertyHelper)
                .append("@getColumnByProperty(@java.lang.Class@forName(\"")
                .append(name)
                .append("\"), @tk.mybatis.mapper.weekend.reflection.Reflections@fnToFieldName(fn))}").toString();
        sql.append(ognl + " = #{value}\n");
        sql.append("</if>\n");
        // 逻辑删除的未删除查询条件
        sql.append(SqlHelper.whereLogicDelete(entityClass, false));
        sql.append("</where>");
        return sql.toString();
    }
}
