package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.codegen.dto.GenDto;
import com.sinogale.codegen.mapper.GenMapper;
import com.sinogale.codegen.query.GenQuery;
import com.sinogale.codegen.updater.GenUpdater;
import com.sinogale.codegen.vo.GenVo;
import com.sinogale.common.annotation.FieldDesc;
import com.sinogale.jpa.converter.InstantLongConverter;
import com.sinogale.jpa.support.BaseJpaAggregate;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueCompletenessEnumConverter;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueDuplicateEnumConverter;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueReviewResultEnumConverter;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueScopeEnumConverter;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueValidityEnumConverter;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 线索审核意见。
 */
@Entity
@Table(name = "cf_clue_review")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.clue.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.clue.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.clue.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.clue.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.clue.updater")
public class ClueReview extends BaseJpaAggregate {

    @FieldDesc(name = "所属线索ID；范围1～9223372036854775807。\n关联：cf_clue.id。")
    @Column(name = "clue_id", nullable = false)
    private Long clueId;

    @FieldDesc(name = "线索内审核轮次，依次递增；范围1～2147483647。")
    @Column(name = "review_round", nullable = false)
    private Integer reviewRound;

    @FieldDesc(name = "线索是否有效：0.否；1.是；未完成核查为空。")
    @Column(name = "valid_flag", nullable = true)
    @Convert(converter = ClueValidityEnumConverter.class)
    private ClueValidityEnum validFlag;

    @FieldDesc(name = "信息是否完整到可开展后续调查：0.否；1.是；未核查为空。")
    @Column(name = "complete_flag", nullable = true)
    @Convert(converter = ClueCompletenessEnumConverter.class)
    private ClueCompletenessEnum completeFlag;

    @FieldDesc(name = "是否重复线索：0.否；1.是；未核查为空。")
    @Column(name = "duplicate_flag", nullable = true)
    @Convert(converter = ClueDuplicateEnumConverter.class)
    private ClueDuplicateEnum duplicateFlag;

    @FieldDesc(name = "是否属于合同履约处置范围：0.否；1.是；未核查为空。")
    @Column(name = "in_scope_flag", nullable = true)
    @Convert(converter = ClueScopeEnumConverter.class)
    private ClueScopeEnum inScopeFlag;

    @FieldDesc(name = "疑似调查对象识别意见；无正式用电户但现场可定位时可以通过。")
    @Column(name = "subject_identification", nullable = true, length = 1000)
    private String subjectIdentification;

    @FieldDesc(name = "审核结果：1.通过；2.退回补充；3.关联有效线索；4.作废；5.转办；暂存为空。")
    @Column(name = "review_result", nullable = true)
    @Convert(converter = ClueReviewResultEnumConverter.class)
    private ClueReviewResultEnum reviewResult;

    @FieldDesc(name = "审核意见及通过、退回、关联、作废或转办依据。")
    @Column(name = "review_opinion", nullable = true, columnDefinition = "text")
    private String reviewOpinion;

    @FieldDesc(name = "审核人员编码，外部身份引用。")
    @Column(name = "reviewed_by", nullable = true, length = 64)
    private String reviewedBy;

    @FieldDesc(name = "审核完成时间；暂存时为空。")
    @Column(name = "reviewed_at", nullable = true)
    @Convert(converter = InstantLongConverter.class)
    private Instant reviewedAt;
}
