/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.mybatisgen;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: QueryCodeGenerator
 * @Decription: 生成查询实体类
 * @Author: rubik
 *  rubik create QueryCodeGenerator.java of 2021/12/26 5:09 下午
 */
public class QueryCodeGenerator {

    /**
     * DO 实体类的类名
     */
    private static final String doClassName = "com.geek45.infra.dal.table.model.TableConfigDO";
    /**
     * 表名
     */
    private static final String tableName = "gk_table_config";

    /**
     * where条件中需要过滤掉的字段
     */
    private static final Set<String> whereIgnoreFields = new HashSet<>();
    private static final Set<String> updateIgnoreFields = new HashSet<>();
    private static final String tag = "@Generated(\"org.mybatis.generator.api.MyBatisGenerator\")";

    static {
        whereIgnoreFields.add("createTime");
        whereIgnoreFields.add("modifyTime");

        updateIgnoreFields.add("id");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        generatorCode();
    }

    private static class OrderByClass{
        private String orderBy;
        private Long limit;
    }

    /**
     * 生成代码
     */
    private static void generatorCode() throws ClassNotFoundException {
        Class<?> cls = Class.forName(doClassName);
        List<FieldInfo> fieldInfoList = getFieldInfoList(cls);
        List<FieldInfo> orderByList = getFieldInfoList(OrderByClass.class);
        System.out.println("===========================================");
        System.out.println(genQueryCode(fieldInfoList, orderByList));
        System.out.println("===========================================");
        System.err.println(genSelectSingleByQuerySql(cls, fieldInfoList, orderByList));
        System.err.println(genSelectMultiByQuerySql(cls, fieldInfoList, orderByList));
        System.err.println(genSelectCountByQuerySql(cls, fieldInfoList));
        System.err.println(genUpdateByQuerySql(cls, fieldInfoList));
        System.err.println(genUpdateWithNullByQuerySql(cls, fieldInfoList));
        System.err.println(genDeleteByQuerySql(cls, fieldInfoList));
        System.err.println("===========================================");

    }

    private static String genDeleteByQuerySql(Class<?> cls, List<FieldInfo> fieldInfoList) {
        StringBuilder sb = new StringBuilder();
        sb.append("@Delete({\r\n\"<script>\",\r\n\"delete from ")
                .append(tableName)
                .append(" \",\r\n");
        genWhere(fieldInfoList, null, sb, null);

        sb.append("\"</script>\"\r\n")
                .append("})\r\n");
        appendTag(sb);

        sb.append("long deleteByQuery(")
                .append(getQueryDoName(cls))
                .append(" query);\r\n");

        return sb.toString();
    }

    private static String genUpdateWithNullByQuerySql(Class<?> cls, List<FieldInfo> fieldInfoList) {
        StringBuilder sb = new StringBuilder();
        sb.append("@Update({\r\n")
                .append("\"<script>\",\r\n")
                .append("\"update ")
                .append(tableName)
                .append(" \",\r\n");

        genUpdateWithNull(fieldInfoList, sb, "data");
        genWhere(fieldInfoList, null, sb, "query");

        sb.append("\"</script>\"\r\n")
                .append("})\r\n");

        appendTag(sb);

        sb.append("long updateWithNullByQuery(@Param(\"data\") ")
                .append(cls.getSimpleName())
                .append(" data,@Param(\"query\") ")
                .append(getQueryDoName(cls))
                .append(" query);\r\n");
        return sb.toString();
    }

    private static void genUpdateWithNull(List<FieldInfo> fieldInfoList, StringBuilder sb, String dataPrefix) {
        dataPrefix = null != dataPrefix ? dataPrefix + "." : null;

        sb.append("\"<trim prefix='set' suffixOverrides=','>\",\r\n");

        for (FieldInfo info :
                fieldInfoList) {
            if (updateIgnoreFields.contains(info.getName())) {
                continue;
            }

            sb.append("\" ")
                    .append(info.getColumnName())
                    .append(" = ")
                    .append(String.format("#{%s, jdbcType=%s}", dataPrefix + info.getName(), info.getJdbcType()))
                    .append(",\",\r\n");
        }
        sb.append("\"</trim>\",\r\n");
    }

    private static String genSelectCountByQuerySql(Class<?> cls, List<FieldInfo> fieldInfoList) {
        StringBuilder sb = new StringBuilder();
        sb.append("@Select({\r\n")
                .append("\"<script>\",\r\n")
                .append("\"select \",\r\n")
                .append("\"count(*) \",\r\n")
                .append("\"from ")
                .append(tableName)
                .append(" \",\r\n");
        genWhere(fieldInfoList, null, sb, null);
        sb.append("\"</script>\"\r\n")
                .append("})\r\n");

        appendTag(sb);

        sb.append("long")
                .append(" ")
                .append("selectCountByQuery(")
                .append(getQueryDoName(cls))
                .append(" query")
                .append(");\r\n");

        return sb.toString();
    }

    private static String genUpdateByQuerySql(Class<?> cls, List<FieldInfo> fieldInfoList) {
        StringBuilder sb = new StringBuilder();
        sb.append("@Update({\r\n")
                .append("\"<script>\",\r\n")
                .append("\"update ")
                .append(tableName)
                .append(" \",\r\n");
        genUpdate(fieldInfoList, sb, "data");
        genWhere(fieldInfoList, null, sb, "query");

        sb.append("\"</script>\"\r\n")
                .append("})\r\n");

        appendTag(sb);

        sb.append("long ")
                .append("updateByQuery(")
                .append("@Param(\"data\") ")
                .append(cls.getSimpleName())
                .append(" data,@Param(\"query\") ")
                .append(getQueryDoName(cls))
                .append(" query);\r\n");

        return sb.toString();
    }

    private static void genUpdate(List<FieldInfo> fieldInfoList, StringBuilder sb, String dataPrefix) {
        dataPrefix = null != dataPrefix ? dataPrefix + "." : null;

        sb.append("\"<trim prefix='set' suffixOverrides=','>\", \r\n");
        for (FieldInfo info : fieldInfoList) {
            if (updateIgnoreFields.contains(info.getName())) {
                continue;
            }

            sb.append("\"<if test='")
                    .append(dataPrefix)
                    .append(info.getName())
                    .append(" != null'> ")
                    .append(info.getColumnName())
                    .append(" = ")
                    .append(String.format("#{%s, jdbcType=%s}", dataPrefix + info.getName(), info.getJdbcType()))
                    .append(",</if>\",\r\n");
        }

        sb.append("\"</trim>\",\r\n");

    }

    private static String genSelectMultiByQuerySql(Class<?> cls, List<FieldInfo> fieldInfoList, List<FieldInfo> orderByList) {
        StringBuilder sb = new StringBuilder();
        genASelect(sb, fieldInfoList, orderByList);
        genAResult(sb, fieldInfoList);

        appendTag(sb);

        sb.append("List<")
                .append(cls.getSimpleName())
                .append(">")
                .append("selectMultiByQuery(")
                .append(getQueryDoName(cls))
                .append(" ")
                .append("query")
                .append(");\r\n");
        return sb.toString();
    }

    private static String genSelectSingleByQuerySql(Class<?> cls, List<FieldInfo> fieldInfoList, List<FieldInfo> orderByList) {
        StringBuilder sb = new StringBuilder();
        genASelect(sb, fieldInfoList, orderByList);
        genAResult(sb, fieldInfoList);

        appendTag(sb);
        sb.append(cls.getSimpleName())
                .append(" ")
                .append("selectSingleByQuery(")
                .append(getQueryDoName(cls))
                .append(" ")
                .append("query")
                .append(");")
                .append("\r\n");

        return sb.toString();
    }

    private static String getQueryDoName(Class<?> cls) {
        return cls.getSimpleName() + "Query";
    }

    private static void genASelect(StringBuilder sb, List<FieldInfo> fieldInfoList, List<FieldInfo> orderByList) {
        sb.append("@Select({\r\n")
                .append("\"<script>\",\r\n")
                .append("\"select \",\r\n")
                .append("\"");
        genSelectColumn(fieldInfoList, sb);
        sb.append("\",\r\n")
                .append("\"from ")
                .append(tableName)
                .append(" \",\r\n");
        genWhere(fieldInfoList, orderByList, sb, null);

        sb.append("\"</script>\"\r\n")
                .append("})\r\n");
    }

    private static void genSelectColumn(List<FieldInfo> fieldInfoList, StringBuilder sb) {
        int maxIndex = fieldInfoList.size() - 1;
        for (int i = 0; i < fieldInfoList.size(); ++i) {
            FieldInfo info = fieldInfoList.get(i);
            sb.append(info.getColumnName());
            if (i != maxIndex) {
                sb.append(", ");
            } else {
                sb.append(" ");
            }
            if (i != maxIndex && (i + 1) % 5 == 0) {
                sb.append("\",\r\n\"");
            }
        }
    }

    private static void genWhere(List<FieldInfo> fieldInfoList, List<FieldInfo> orderByList, StringBuilder sb, String queryPrefix) {
        queryPrefix = null != queryPrefix ? queryPrefix + "." : "";
        sb.append("\"<where>\", \r\n");
        boolean nedAnd = false;
        for (FieldInfo info : fieldInfoList) {

            if (whereIgnoreFields.contains(info.getName())) {
                continue;
            }

            if (info.getTypeClass() == Date.class) {
                continue;
            }

            sb.append("\"<if test='")
                    .append(queryPrefix)
                    .append(info.getName())
                    .append(" != null'>");

            if (!nedAnd) {
                sb.append(" ");
                nedAnd = true;
            } else {
                sb.append(" and ");
            }

            sb.append(info.getColumnName())
                    .append(" = ")
                    .append(String.format("#{%s, jdbcType=%s}", queryPrefix + info.getName(), info.getJdbcType()))
                    .append("</if>\",\r\n");
        }
        sb.append("\"</where>\",\r\n");

        if (null == orderByList || orderByList.size() < 1) {
            return;
        }

        FieldInfo orderBy = orderByList.get(0);
        FieldInfo limit = orderByList.get(1);

        if (null == orderBy) {
            return;
        }

        sb.append("\"<if test='")
                .append(orderBy.getName())
                .append(" != null'>")
                .append(" order by ${")
                .append(orderBy.getName())
                .append("}")
                .append("</if>\", \r\n");

        if (null == limit) {
            return;
        }

        sb.append("\"<if test='")
                .append(orderBy.getName())
                .append(" != null and ")
                .append(limit.getName())
                .append(" != null'>")
                .append(" limit #{")
                .append(limit.getName())
                .append("}</if>\",\r\n");
    }

    private static void genAResult(StringBuilder sb, List<FieldInfo> fieldInfoList) {
        sb.append("@Results({\r\n");

        int len = fieldInfoList.size();
        for (int i = 0; i < len; i++) {
            FieldInfo info = fieldInfoList.get(i);

            sb.append("@Result(column = \"")
                    .append(info.getColumnName())
                    .append("\", property = \"")
                    .append(info.getName())
                    .append("\", jdbcType = JdbcType.")
                    .append(info.getJdbcType());

            if ("id".equals(info.getName())) {
                sb.append(", id = true");
            }

            if (i == len - 1) {
                sb.append(")\r\n");
            }else{
                sb.append("),\r\n");
            }
        }

        sb.append("})\r\n");
    }

    private static String genQueryCode(List<FieldInfo> fieldInfoList, List<FieldInfo> orderByList) {
        StringBuilder sb = new StringBuilder();
        List<FieldInfo> list = new ArrayList<>(fieldInfoList.size() + orderByList.size());
        list.addAll(fieldInfoList);
        list.addAll(orderByList);

        for (FieldInfo info : list) {
            String name = info.getName();
            if (whereIgnoreFields.contains(name)) {
                continue;
            }

            appendTag(sb);
            sb.append("private ")
                    .append(info.getTypeName())
                    .append(" ")
                    .append(name)
                    .append(";")
                    .append("\r\n\r\n");
        }
        return sb.toString();
    }

    private static void appendTag(StringBuilder sb) {
        if (null == sb) {
            return;
        }
        sb.append(tag)
                .append("\r\n");
    }

    private static List<FieldInfo> getFieldInfoList(Class<?> cls) {
        List<Field> list = new LinkedList<>();
        getFields(cls, list);
        return list.stream().map(FieldInfo::new).collect(Collectors.toList());
    }

    private static void getFields(Class<?> cls, List<Field> list) {
        Class<?> superClass = cls.getSuperclass();
        if (superClass != Object.class) {
            getFields(superClass, list);
        }
        Collections.addAll(list, cls.getDeclaredFields());
    }

    private static final class FieldInfo{
        private static final Map<Class<?>, Class<?>> fieldMap = new HashMap<>();
        private static final Map<Class<?>, String> jdbcMap = new HashMap<>();

        static {
            fieldMap.put(boolean.class, Boolean.class);
            fieldMap.put(byte.class, Byte.class);
            fieldMap.put(short.class, Short.class);
            fieldMap.put(char.class, Character.class);
            fieldMap.put(int.class, Integer.class);
            fieldMap.put(long.class, Long.class);
            fieldMap.put(float.class, Float.class);
            fieldMap.put(double.class, Double.class);

            jdbcMap.put(Boolean.class, "TINYINT");
            jdbcMap.put(Byte.class, "TINYINT");
            jdbcMap.put(Short.class, "TINYINT");
            jdbcMap.put(Character.class, "TINYINT");
            jdbcMap.put(Integer.class, "INTEGER");
            jdbcMap.put(Float.class, "DOUBLE");
            jdbcMap.put(Long.class, "BIGINT");
            jdbcMap.put(Double.class, "DOUBLE");
            jdbcMap.put(String.class, "VARCHAR");
            jdbcMap.put(byte[].class, "BINARY");
            jdbcMap.put(Byte[].class, "BINARY");
        }

        private final Class<?> typeClass;
        private final String typeName;
        private final String name;
        private final String columnName;
        private final String jdbcType;

        public FieldInfo(Field field) {
            this.typeClass = field.getType();
            this.typeName = getTypeName(field);
            this.name = field.getName();
            this.columnName = getColumnName(this.name);
            this.jdbcType = getJdbcType(field);
        }

        private static Class<?> getTypeClass(Field field) {
            Class<?> cls = field.getType();
            if (cls.isPrimitive()) {
                cls = fieldMap.get(cls);
                if (null == cls) {
                    throw new RuntimeException("un know field:" + field.getClass().getName());
                }
            }
            return cls;
        }

        private String getJdbcType(Field field) {
            Class<?> typeClass = getTypeClass(field);
            String jdbcType = jdbcMap.get(typeClass);
            return null != jdbcType ? jdbcType : "VARCHAR";
        }

        private String getColumnName(String name) {
            int len = name.length();
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                char c = name.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append("_");
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        private static String getTypeName(Field field) {
            return getTypeClass(field).getSimpleName();
        }

        public Class<?> getTypeClass() {
            return typeClass;
        }

        public String getTypeName() {
            return typeName;
        }

        public String getName() {
            return name;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getJdbcType() {
            return jdbcType;
        }
    }

}
