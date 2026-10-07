package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.codegen.dto.GenDto;
import com.sinogale.codegen.mapper.GenMapper;
import com.sinogale.codegen.query.GenQuery;
import com.sinogale.codegen.updater.GenUpdater;
import com.sinogale.codegen.vo.GenVo;
import com.sinogale.common.annotation.FieldDesc;
import com.sinogale.jpa.converter.InstantLongConverter;
import com.sinogale.jpa.support.BaseJpaAggregate;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueRoutingCurrentEnumConverter;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 线索归口记录。
 */
@Entity
@Table(name = "cf_clue_routing")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.clue.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.clue.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.clue.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.clue.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.clue.updater")
public class ClueRouting extends BaseJpaAggregate {

    @FieldDesc(name = "所属线索ID；范围1～9223372036854775807。\n关联：cf_clue.id。")
    @Column(name = "clue_id", nullable = false)
    private Long clueId;

    @FieldDesc(name = "线索内归口轮次，依次递增；范围1～2147483647。")
    @Column(name = "routing_round", nullable = false)
    private Integer routingRound;

    // 数据库允许 NULL；按当前要求使用 long，接入前请确认是否改为 Long。
    @FieldDesc(name = "上一轮归口记录ID；范围1～9223372036854775807；首轮为空。\n关联：cf_clue_routing.id。")
    @Column(name = "prev_routing_id", nullable = true)
    private Long prevRoutingId;

    @FieldDesc(name = "处理专业编码，外部专业字典引用；确认归口时必填。")
    @Column(name = "specialty_code", nullable = true, length = 64)
    private String specialtyCode;

    @FieldDesc(name = "处理单位编码，外部组织引用；确认归口时必填。")
    @Column(name = "handling_org_code", nullable = true, length = 64)
    private String handlingOrgCode;

    @FieldDesc(name = "责任岗位编码，外部岗位引用；确认归口时必填。")
    @Column(name = "responsible_post_code", nullable = true, length = 64)
    private String responsiblePostCode;

    @FieldDesc(name = "根据违约内容、地址、管辖范围及对象信息形成的归口依据。")
    @Column(name = "routing_basis", nullable = true, columnDefinition = "text")
    private String routingBasis;

    @FieldDesc(name = "归口确认人员编码，外部身份引用。")
    @Column(name = "confirmed_by", nullable = true, length = 64)
    private String confirmedBy;

    @FieldDesc(name = "本轮归口确认时间；暂存未确认时为空。")
    @Column(name = "confirmed_at", nullable = true)
    @Convert(converter = InstantLongConverter.class)
    private Instant confirmedAt;

    @FieldDesc(name = "是否当前有效归口：0.否；1.是；暂存、被退回或历史记录取0。")
    @Column(name = "is_current", nullable = false)
    @Convert(converter = ClueRoutingCurrentEnumConverter.class)
    private ClueRoutingCurrentEnum isCurrent;

    @FieldDesc(name = "立单前退回归口的人员编码，外部身份引用。")
    @Column(name = "returned_by", nullable = true, length = 64)
    private String returnedBy;

    @FieldDesc(name = "本轮归口被立单环节退回的时间。")
    @Column(name = "returned_at", nullable = true)
    @Convert(converter = InstantLongConverter.class)
    private Instant returnedAt;

    @FieldDesc(name = "归口退回原因；存在退回时间时必填。")
    @Column(name = "return_reason", nullable = true, length = 1000)
    private String returnReason;
}
