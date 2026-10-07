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
 * 线索关联关系。
 */
@Entity
@Table(name = "cf_clue_link")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.clue.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.clue.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.clue.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.clue.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.clue.updater")
public class ClueLink extends BaseJpaAggregate {

    @FieldDesc(name = "本条重复线索ID；范围1～9223372036854775807。\n关联：cf_clue.id。")
    @Column(name = "duplicate_clue_id", nullable = false)
    private Long duplicateClueId;

    @FieldDesc(name = "已有有效线索ID；范围1～9223372036854775807；不得指向自身。\n关联：cf_clue.id。")
    @Column(name = "effective_clue_id", nullable = false)
    private Long effectiveClueId;

    @FieldDesc(name = "关联依据审核意见ID；范围1～9223372036854775807。\n关联：cf_clue_review.id。")
    @Column(name = "review_id", nullable = false)
    private Long reviewId;

    @FieldDesc(name = "重复判断及目标线索能够承接后续办理的依据。")
    @Column(name = "link_basis", nullable = false, length = 1000)
    private String linkBasis;

    @FieldDesc(name = "关联确认人员编码，外部身份引用。")
    @Column(name = "linked_by", nullable = false, length = 64)
    private String linkedBy;

    @FieldDesc(name = "关联确认时间。")
    @Column(name = "linked_at", nullable = false)
    @Convert(converter = InstantLongConverter.class)
    private Instant linkedAt;
}
