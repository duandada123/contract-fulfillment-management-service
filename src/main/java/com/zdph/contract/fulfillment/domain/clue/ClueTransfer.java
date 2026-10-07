package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.codegen.dto.GenDto;
import com.sinogale.codegen.mapper.GenMapper;
import com.sinogale.codegen.query.GenQuery;
import com.sinogale.codegen.updater.GenUpdater;
import com.sinogale.codegen.vo.GenVo;
import com.sinogale.common.annotation.FieldDesc;
import com.sinogale.jpa.converter.InstantLongConverter;
import com.sinogale.jpa.support.BaseJpaAggregate;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 线索转办记录。
 */
@Entity
@Table(name = "cf_clue_transfer")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.clue.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.clue.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.clue.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.clue.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.clue.updater")
public class ClueTransfer extends BaseJpaAggregate {

    @FieldDesc(name = "所属线索ID；范围1～9223372036854775807。\n关联：cf_clue.id。")
    @Column(name = "clue_id", nullable = false)
    private Long clueId;

    @FieldDesc(name = "转办依据审核意见ID；范围1～9223372036854775807。\n关联：cf_clue_review.id。")
    @Column(name = "review_id", nullable = false)
    private Long reviewId;

    @FieldDesc(name = "转办原因及业务范围判断依据。")
    @Column(name = "transfer_reason", nullable = false, length = 1000)
    private String transferReason;

    @FieldDesc(name = "接收专业编码，外部专业字典引用。")
    @Column(name = "target_specialty_code", nullable = false, length = 64)
    private String targetSpecialtyCode;

    @FieldDesc(name = "接收单位编码，外部组织引用。")
    @Column(name = "target_org_code", nullable = false, length = 64)
    private String targetOrgCode;

    @FieldDesc(name = "承接系统编码，外部系统引用；线下转办可为空。")
    @Column(name = "target_system_code", nullable = true, length = 64)
    private String targetSystemCode;

    @FieldDesc(name = "外部接收业务单号或转办回执编号。")
    @Column(name = "external_business_no", nullable = true, length = 128)
    private String externalBusinessNo;

    @FieldDesc(name = "转办人员编码，外部身份引用。")
    @Column(name = "transferred_by", nullable = false, length = 64)
    private String transferredBy;

    @FieldDesc(name = "转办完成时间。")
    @Column(name = "transferred_at", nullable = false)
    @Convert(converter = InstantLongConverter.class)
    private Instant transferredAt;

    @FieldDesc(name = "转办办理说明、交接情况及回执信息。")
    @Column(name = "handling_note", nullable = true, length = 1000)
    private String handlingNote;
}
