package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.codegen.dto.GenDto;
import com.sinogale.codegen.mapper.GenMapper;
import com.sinogale.codegen.query.GenQuery;
import com.sinogale.codegen.updater.GenUpdater;
import com.sinogale.codegen.vo.GenVo;
import com.sinogale.common.annotation.FieldDesc;
import com.sinogale.jpa.support.BaseJpaAggregate;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueSourceEnabledEnumConverter;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueSourceTypeEnumConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 线索来源。
 */
@Entity
@Table(name = "cf_clue_source")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.clue.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.clue.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.clue.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.clue.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.clue.updater")
public class ClueSource extends BaseJpaAggregate {

    @FieldDesc(name = "来源渠道编码，业务唯一。")
    @Column(name = "source_code", nullable = false, length = 64)
    private String sourceCode;

    @FieldDesc(name = "来源渠道名称，如电话举报、网上国网、用采分析。")
    @Column(name = "source_name", nullable = false, length = 128)
    private String sourceName;

    @FieldDesc(name = "来源类型：1.客户举报；2.系统推送；3.内部发现；4.其他专业移交。")
    @Column(name = "source_type", nullable = false)
    @Convert(converter = ClueSourceTypeEnumConverter.class)
    private ClueSourceTypeEnum sourceType;

    @FieldDesc(name = "外部来源系统编码；人工渠道可为空，不建立虚构系统表。")
    @Column(name = "system_code", nullable = true, length = 64)
    private String systemCode;

    @FieldDesc(name = "来源说明及渠道适用范围。")
    @Column(name = "description", nullable = true, length = 500)
    private String description;

    @FieldDesc(name = "是否启用：0.否；1.是。建议默认1。")
    @Column(name = "enabled_flag", nullable = false)
    @Convert(converter = ClueSourceEnabledEnumConverter.class)
    private ClueSourceEnabledEnum enabledFlag;
}
