package com.geek45.infra.dal.table;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TableConfigDODynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    public static final TableConfigDO tableConfigDO = new TableConfigDO();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.id")
    public static final SqlColumn<Long> id = tableConfigDO.id;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.gmt_create")
    public static final SqlColumn<Long> gmtCreate = tableConfigDO.gmtCreate;

    /**
     * Database Column Remarks:
     *   修改时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.gmt_modify")
    public static final SqlColumn<Long> gmtModify = tableConfigDO.gmtModify;

    /**
     * Database Column Remarks:
     *   创建用户
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.creator")
    public static final SqlColumn<String> creator = tableConfigDO.creator;

    /**
     * Database Column Remarks:
     *   修改用户
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.modifier")
    public static final SqlColumn<String> modifier = tableConfigDO.modifier;

    /**
     * Database Column Remarks:
     *   逻辑删除字段。1:未删除，0：已删除
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.deleted")
    public static final SqlColumn<Boolean> deleted = tableConfigDO.deleted;

    /**
     * Database Column Remarks:
     *   版本号，乐观锁
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.version")
    public static final SqlColumn<Integer> version = tableConfigDO.version;

    /**
     * Database Column Remarks:
     *   字段标识
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.name")
    public static final SqlColumn<String> name = tableConfigDO.name;

    /**
     * Database Column Remarks:
     *   展示名字
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.label")
    public static final SqlColumn<String> label = tableConfigDO.label;

    /**
     * Database Column Remarks:
     *   类型
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.type")
    public static final SqlColumn<String> type = tableConfigDO.type;

    /**
     * Database Column Remarks:
     *   排序
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: gk_table_config.sort")
    public static final SqlColumn<Integer> sort = tableConfigDO.sort;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    public static final class TableConfigDO extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> gmtCreate = column("gmt_create", JDBCType.BIGINT);

        public final SqlColumn<Long> gmtModify = column("gmt_modify", JDBCType.BIGINT);

        public final SqlColumn<String> creator = column("creator", JDBCType.VARCHAR);

        public final SqlColumn<String> modifier = column("modifier", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> deleted = column("deleted", JDBCType.TINYINT);

        public final SqlColumn<Integer> version = column("version", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> label = column("label", JDBCType.VARCHAR);

        public final SqlColumn<String> type = column("type", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sort = column("sort", JDBCType.INTEGER);

        public TableConfigDO() {
            super("gk_table_config");
        }
    }
}