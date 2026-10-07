package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.codegen.dto.GenDto;
import com.sinogale.codegen.mapper.GenMapper;
import com.sinogale.codegen.query.GenQuery;
import com.sinogale.codegen.updater.GenUpdater;
import com.sinogale.codegen.vo.GenVo;
import com.sinogale.common.annotation.FieldDesc;
import com.sinogale.jpa.converter.InstantLongConverter;
import com.sinogale.jpa.support.BaseJpaAggregate;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueSupplementStageEnumConverter;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 线索补充记录。
 */
@Entity
@Table(name = "cf_clue_supplement")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.clue.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.clue.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.clue.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.clue.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.clue.updater")
public class ClueSupplement extends BaseJpaAggregate {

    @FieldDesc(name = "所属线索ID；范围1～9223372036854775807。\n关联：cf_clue.id。")
    @Column(name = "clue_id", nullable = false)
    private Long clueId;

    @FieldDesc(name = "线索内补充轮次，依次递增；范围1～2147483647。")
    @Column(name = "supplement_round", nullable = false)
    private Integer supplementRound;

    @FieldDesc(name = "补充发起阶段：1.线索审核；2.专业归口。")
    @Column(name = "request_stage", nullable = false)
    @Convert(converter = ClueSupplementStageEnumConverter.class)
    private ClueSupplementStageEnum requestStage;

    // 数据库允许 NULL；按当前要求使用 long，接入前请确认是否改为 Long。
    @FieldDesc(name = "触发补充的审核意见ID；范围1～9223372036854775807；归口补充可为空。\n关联：cf_clue_review.id。")
    @Column(name = "review_id", nullable = true)
    private Long reviewId;

    @FieldDesc(name = "补充要求及信息缺口。")
    @Column(name = "supplement_requirement", nullable = false, columnDefinition = "text")
    private String supplementRequirement;

    @FieldDesc(name = "提出补充要求的人员编码，外部身份引用。")
    @Column(name = "requested_by", nullable = false, length = 64)
    private String requestedBy;

    @FieldDesc(name = "提出补充要求的时间。")
    @Column(name = "requested_at", nullable = false)
    @Convert(converter = InstantLongConverter.class)
    private Instant requestedAt;

    @FieldDesc(name = "本轮补充内容；材料通过线索材料表关联。")
    @Column(name = "supplement_content", nullable = true, columnDefinition = "text")
    private String supplementContent;

    @FieldDesc(name = "补充办理人员编码，外部身份引用。")
    @Column(name = "supplemented_by", nullable = true, length = 64)
    private String supplementedBy;

    @FieldDesc(name = "本轮补充提交时间；未提交时为空。")
    @Column(name = "submitted_at", nullable = true)
    @Convert(converter = InstantLongConverter.class)
    private Instant submittedAt;
}
