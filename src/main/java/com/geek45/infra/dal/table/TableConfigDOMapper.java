package com.geek45.infra.dal.table;

import static com.geek45.infra.dal.table.TableConfigDODynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.geek45.infra.dal.table.model.TableConfigDO;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import com.geek45.infra.dal.table.model.TableConfigDOQuery;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface TableConfigDOMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    BasicColumn[] selectList = BasicColumn.columnList(id, gmtCreate, gmtModify, creator, modifier, deleted, version, name, label, type, sort);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<TableConfigDO> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<TableConfigDO> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default int insertMultiple(MultiRowInsertStatementProvider<TableConfigDO> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TableConfigDOResult")
    Optional<TableConfigDO> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TableConfigDOResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier", property="modifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.TINYINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    List<TableConfigDO> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tableConfigDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tableConfigDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default int insert(TableConfigDO record) {
        return MyBatis3Utils.insert(this::insert, record, tableConfigDO, c ->
            c.map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModify).toProperty("gmtModify")
            .map(creator).toProperty("creator")
            .map(modifier).toProperty("modifier")
            .map(deleted).toProperty("deleted")
            .map(version).toProperty("version")
            .map(name).toProperty("name")
            .map(label).toProperty("label")
            .map(type).toProperty("type")
            .map(sort).toProperty("sort")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default int insertMultiple(Collection<TableConfigDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tableConfigDO, c ->
            c.map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModify).toProperty("gmtModify")
            .map(creator).toProperty("creator")
            .map(modifier).toProperty("modifier")
            .map(deleted).toProperty("deleted")
            .map(version).toProperty("version")
            .map(name).toProperty("name")
            .map(label).toProperty("label")
            .map(type).toProperty("type")
            .map(sort).toProperty("sort")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default int insertSelective(TableConfigDO record) {
        return MyBatis3Utils.insert(this::insert, record, tableConfigDO, c ->
            c.map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", record::getGmtModify)
            .map(creator).toPropertyWhenPresent("creator", record::getCreator)
            .map(modifier).toPropertyWhenPresent("modifier", record::getModifier)
            .map(deleted).toPropertyWhenPresent("deleted", record::getDeleted)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(label).toPropertyWhenPresent("label", record::getLabel)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(sort).toPropertyWhenPresent("sort", record::getSort)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default Optional<TableConfigDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tableConfigDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default List<TableConfigDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tableConfigDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default List<TableConfigDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tableConfigDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default Optional<TableConfigDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tableConfigDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    static UpdateDSL<UpdateModel> updateAllColumns(TableConfigDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModify).equalTo(record::getGmtModify)
                .set(creator).equalTo(record::getCreator)
                .set(modifier).equalTo(record::getModifier)
                .set(deleted).equalTo(record::getDeleted)
                .set(version).equalTo(record::getVersion)
                .set(name).equalTo(record::getName)
                .set(label).equalTo(record::getLabel)
                .set(type).equalTo(record::getType)
                .set(sort).equalTo(record::getSort);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TableConfigDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify)
                .set(creator).equalToWhenPresent(record::getCreator)
                .set(modifier).equalToWhenPresent(record::getModifier)
                .set(deleted).equalToWhenPresent(record::getDeleted)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(name).equalToWhenPresent(record::getName)
                .set(label).equalToWhenPresent(record::getLabel)
                .set(type).equalToWhenPresent(record::getType)
                .set(sort).equalToWhenPresent(record::getSort);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default int updateByPrimaryKey(TableConfigDO record) {
        return update(c ->
            c.set(gmtCreate).equalTo(record::getGmtCreate)
            .set(gmtModify).equalTo(record::getGmtModify)
            .set(creator).equalTo(record::getCreator)
            .set(modifier).equalTo(record::getModifier)
            .set(deleted).equalTo(record::getDeleted)
            .set(version).equalTo(record::getVersion)
            .set(name).equalTo(record::getName)
            .set(label).equalTo(record::getLabel)
            .set(type).equalTo(record::getType)
            .set(sort).equalTo(record::getSort)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: gk_table_config")
    default int updateByPrimaryKeySelective(TableConfigDO record) {
        return update(c ->
            c.set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
            .set(gmtModify).equalToWhenPresent(record::getGmtModify)
            .set(creator).equalToWhenPresent(record::getCreator)
            .set(modifier).equalToWhenPresent(record::getModifier)
            .set(deleted).equalToWhenPresent(record::getDeleted)
            .set(version).equalToWhenPresent(record::getVersion)
            .set(name).equalToWhenPresent(record::getName)
            .set(label).equalToWhenPresent(record::getLabel)
            .set(type).equalToWhenPresent(record::getType)
            .set(sort).equalToWhenPresent(record::getSort)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Select({
            "<script>",
            "select ",
            "id, gmt_create, gmt_modify, creator, modifier, ",
            "deleted, version, name, label, type, ",
            "sort ",
            "from gk_table_config ",
            "<where>",
            "<if test='id != null'> id = #{id, jdbcType=BIGINT}</if>",
            "<if test='gmtCreate != null'> and gmt_create = #{gmtCreate, jdbcType=BIGINT}</if>",
            "<if test='gmtModify != null'> and gmt_modify = #{gmtModify, jdbcType=BIGINT}</if>",
            "<if test='creator != null'> and creator = #{creator, jdbcType=VARCHAR}</if>",
            "<if test='modifier != null'> and modifier = #{modifier, jdbcType=VARCHAR}</if>",
            "<if test='deleted != null'> and deleted = #{deleted, jdbcType=TINYINT}</if>",
            "<if test='version != null'> and version = #{version, jdbcType=INTEGER}</if>",
            "<if test='name != null'> and name = #{name, jdbcType=VARCHAR}</if>",
            "<if test='label != null'> and label = #{label, jdbcType=VARCHAR}</if>",
            "<if test='type != null'> and type = #{type, jdbcType=VARCHAR}</if>",
            "<if test='sort != null'> and sort = #{sort, jdbcType=INTEGER}</if>",
            "</where>",
            "<if test='orderBy != null'> order by ${orderBy}</if>",
            "<if test='orderBy != null and limit != null'> limit #{limit}</if>",
            "</script>"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.BIGINT),
            @Result(column = "gmt_modify", property = "gmtModify", jdbcType = JdbcType.BIGINT),
            @Result(column = "creator", property = "creator", jdbcType = JdbcType.VARCHAR),
            @Result(column = "modifier", property = "modifier", jdbcType = JdbcType.VARCHAR),
            @Result(column = "deleted", property = "deleted", jdbcType = JdbcType.TINYINT),
            @Result(column = "version", property = "version", jdbcType = JdbcType.INTEGER),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "label", property = "label", jdbcType = JdbcType.VARCHAR),
            @Result(column = "type", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sort", property = "sort", jdbcType = JdbcType.INTEGER)
    })
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    TableConfigDO selectSingleByQuery(TableConfigDOQuery query);

    @Select({
            "<script>",
            "select ",
            "id, gmt_create, gmt_modify, creator, modifier, ",
            "deleted, version, name, label, type, ",
            "sort ",
            "from gk_table_config ",
            "<where>",
            "<if test='id != null'> id = #{id, jdbcType=BIGINT}</if>",
            "<if test='gmtCreate != null'> and gmt_create = #{gmtCreate, jdbcType=BIGINT}</if>",
            "<if test='gmtModify != null'> and gmt_modify = #{gmtModify, jdbcType=BIGINT}</if>",
            "<if test='creator != null'> and creator = #{creator, jdbcType=VARCHAR}</if>",
            "<if test='modifier != null'> and modifier = #{modifier, jdbcType=VARCHAR}</if>",
            "<if test='deleted != null'> and deleted = #{deleted, jdbcType=TINYINT}</if>",
            "<if test='version != null'> and version = #{version, jdbcType=INTEGER}</if>",
            "<if test='name != null'> and name = #{name, jdbcType=VARCHAR}</if>",
            "<if test='label != null'> and label = #{label, jdbcType=VARCHAR}</if>",
            "<if test='type != null'> and type = #{type, jdbcType=VARCHAR}</if>",
            "<if test='sort != null'> and sort = #{sort, jdbcType=INTEGER}</if>",
            "</where>",
            "<if test='orderBy != null'> order by ${orderBy}</if>",
            "<if test='orderBy != null and limit != null'> limit #{limit}</if>",
            "</script>"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.BIGINT),
            @Result(column = "gmt_modify", property = "gmtModify", jdbcType = JdbcType.BIGINT),
            @Result(column = "creator", property = "creator", jdbcType = JdbcType.VARCHAR),
            @Result(column = "modifier", property = "modifier", jdbcType = JdbcType.VARCHAR),
            @Result(column = "deleted", property = "deleted", jdbcType = JdbcType.TINYINT),
            @Result(column = "version", property = "version", jdbcType = JdbcType.INTEGER),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "label", property = "label", jdbcType = JdbcType.VARCHAR),
            @Result(column = "type", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sort", property = "sort", jdbcType = JdbcType.INTEGER)
    })
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    List<TableConfigDO>selectMultiByQuery(TableConfigDOQuery query);

    @Select({
            "<script>",
            "select ",
            "count(*) ",
            "from gk_table_config ",
            "<where>",
            "<if test='id != null'> id = #{id, jdbcType=BIGINT}</if>",
            "<if test='gmtCreate != null'> and gmt_create = #{gmtCreate, jdbcType=BIGINT}</if>",
            "<if test='gmtModify != null'> and gmt_modify = #{gmtModify, jdbcType=BIGINT}</if>",
            "<if test='creator != null'> and creator = #{creator, jdbcType=VARCHAR}</if>",
            "<if test='modifier != null'> and modifier = #{modifier, jdbcType=VARCHAR}</if>",
            "<if test='deleted != null'> and deleted = #{deleted, jdbcType=TINYINT}</if>",
            "<if test='version != null'> and version = #{version, jdbcType=INTEGER}</if>",
            "<if test='name != null'> and name = #{name, jdbcType=VARCHAR}</if>",
            "<if test='label != null'> and label = #{label, jdbcType=VARCHAR}</if>",
            "<if test='type != null'> and type = #{type, jdbcType=VARCHAR}</if>",
            "<if test='sort != null'> and sort = #{sort, jdbcType=INTEGER}</if>",
            "</where>",
            "</script>"
    })
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    long selectCountByQuery(TableConfigDOQuery query);

    @Update({
            "<script>",
            "update gk_table_config ",
            "<trim prefix='set' suffixOverrides=','>",
            "<if test='data.gmtCreate != null'> gmt_create = #{data.gmtCreate, jdbcType=BIGINT},</if>",
            "<if test='data.gmtModify != null'> gmt_modify = #{data.gmtModify, jdbcType=BIGINT},</if>",
            "<if test='data.creator != null'> creator = #{data.creator, jdbcType=VARCHAR},</if>",
            "<if test='data.modifier != null'> modifier = #{data.modifier, jdbcType=VARCHAR},</if>",
            "<if test='data.deleted != null'> deleted = #{data.deleted, jdbcType=TINYINT},</if>",
            "<if test='data.version != null'> version = #{data.version, jdbcType=INTEGER},</if>",
            "<if test='data.name != null'> name = #{data.name, jdbcType=VARCHAR},</if>",
            "<if test='data.label != null'> label = #{data.label, jdbcType=VARCHAR},</if>",
            "<if test='data.type != null'> type = #{data.type, jdbcType=VARCHAR},</if>",
            "<if test='data.sort != null'> sort = #{data.sort, jdbcType=INTEGER},</if>",
            "</trim>",
            "<where>",
            "<if test='query.id != null'> id = #{query.id, jdbcType=BIGINT}</if>",
            "<if test='query.gmtCreate != null'> and gmt_create = #{query.gmtCreate, jdbcType=BIGINT}</if>",
            "<if test='query.gmtModify != null'> and gmt_modify = #{query.gmtModify, jdbcType=BIGINT}</if>",
            "<if test='query.creator != null'> and creator = #{query.creator, jdbcType=VARCHAR}</if>",
            "<if test='query.modifier != null'> and modifier = #{query.modifier, jdbcType=VARCHAR}</if>",
            "<if test='query.deleted != null'> and deleted = #{query.deleted, jdbcType=TINYINT}</if>",
            "<if test='query.version != null'> and version = #{query.version, jdbcType=INTEGER}</if>",
            "<if test='query.name != null'> and name = #{query.name, jdbcType=VARCHAR}</if>",
            "<if test='query.label != null'> and label = #{query.label, jdbcType=VARCHAR}</if>",
            "<if test='query.type != null'> and type = #{query.type, jdbcType=VARCHAR}</if>",
            "<if test='query.sort != null'> and sort = #{query.sort, jdbcType=INTEGER}</if>",
            "</where>",
            "</script>"
    })
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    long updateByQuery(@Param("data") TableConfigDO data,@Param("query") TableConfigDOQuery query);

    @Update({
            "<script>",
            "update gk_table_config ",
            "<trim prefix='set' suffixOverrides=','>",
            " gmt_create = #{data.gmtCreate, jdbcType=BIGINT},",
            " gmt_modify = #{data.gmtModify, jdbcType=BIGINT},",
            " creator = #{data.creator, jdbcType=VARCHAR},",
            " modifier = #{data.modifier, jdbcType=VARCHAR},",
            " deleted = #{data.deleted, jdbcType=TINYINT},",
            " version = #{data.version, jdbcType=INTEGER},",
            " name = #{data.name, jdbcType=VARCHAR},",
            " label = #{data.label, jdbcType=VARCHAR},",
            " type = #{data.type, jdbcType=VARCHAR},",
            " sort = #{data.sort, jdbcType=INTEGER},",
            "</trim>",
            "<where>",
            "<if test='query.id != null'> id = #{query.id, jdbcType=BIGINT}</if>",
            "<if test='query.gmtCreate != null'> and gmt_create = #{query.gmtCreate, jdbcType=BIGINT}</if>",
            "<if test='query.gmtModify != null'> and gmt_modify = #{query.gmtModify, jdbcType=BIGINT}</if>",
            "<if test='query.creator != null'> and creator = #{query.creator, jdbcType=VARCHAR}</if>",
            "<if test='query.modifier != null'> and modifier = #{query.modifier, jdbcType=VARCHAR}</if>",
            "<if test='query.deleted != null'> and deleted = #{query.deleted, jdbcType=TINYINT}</if>",
            "<if test='query.version != null'> and version = #{query.version, jdbcType=INTEGER}</if>",
            "<if test='query.name != null'> and name = #{query.name, jdbcType=VARCHAR}</if>",
            "<if test='query.label != null'> and label = #{query.label, jdbcType=VARCHAR}</if>",
            "<if test='query.type != null'> and type = #{query.type, jdbcType=VARCHAR}</if>",
            "<if test='query.sort != null'> and sort = #{query.sort, jdbcType=INTEGER}</if>",
            "</where>",
            "</script>"
    })
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    long updateWithNullByQuery(@Param("data") TableConfigDO data,@Param("query") TableConfigDOQuery query);

    @Delete({
            "<script>",
            "delete from gk_table_config ",
            "<where>",
            "<if test='id != null'> id = #{id, jdbcType=BIGINT}</if>",
            "<if test='gmtCreate != null'> and gmt_create = #{gmtCreate, jdbcType=BIGINT}</if>",
            "<if test='gmtModify != null'> and gmt_modify = #{gmtModify, jdbcType=BIGINT}</if>",
            "<if test='creator != null'> and creator = #{creator, jdbcType=VARCHAR}</if>",
            "<if test='modifier != null'> and modifier = #{modifier, jdbcType=VARCHAR}</if>",
            "<if test='deleted != null'> and deleted = #{deleted, jdbcType=TINYINT}</if>",
            "<if test='version != null'> and version = #{version, jdbcType=INTEGER}</if>",
            "<if test='name != null'> and name = #{name, jdbcType=VARCHAR}</if>",
            "<if test='label != null'> and label = #{label, jdbcType=VARCHAR}</if>",
            "<if test='type != null'> and type = #{type, jdbcType=VARCHAR}</if>",
            "<if test='sort != null'> and sort = #{sort, jdbcType=INTEGER}</if>",
            "</where>",
            "</script>"
    })
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    long deleteByQuery(TableConfigDOQuery query);

}