package com.zdph.contract.fulfillment.domain.workorder;

import com.sinogale.codegen.dto.GenDto;
import com.sinogale.codegen.mapper.GenMapper;
import com.sinogale.codegen.query.GenQuery;
import com.sinogale.codegen.updater.GenUpdater;
import com.sinogale.codegen.vo.GenVo;
import com.sinogale.common.annotation.FieldDesc;
import com.sinogale.jpa.converter.InstantLongConverter;
import com.sinogale.jpa.support.BaseJpaAggregate;
import com.zdph.contract.fulfillment.domain.workorder.convert.DispatchTypeEnumConverter;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 派工记录。
 */
@Entity
@Table(name = "cf_dispatch")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.workorder.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.workorder.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.workorder.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.workorder.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.workorder.updater")
public class Dispatch extends BaseJpaAggregate {

    @FieldDesc(name = "所属工单ID；范围1～9223372036854775807。\n关联：cf_work_order.id。")
    @Column(name = "work_order_id", nullable = false)
    private Long workOrderId;

    @FieldDesc(name = "派工轮次；范围1～2147483647，同一工单内递增。")
    @Column(name = "dispatch_round", nullable = false)
    private Integer dispatchRound;

    @FieldDesc(name = "派工类型：1.首次派工；2.重新派工。")
    @Column(name = "dispatch_type", nullable = false)
    @Convert(converter = DispatchTypeEnumConverter.class)
    private DispatchTypeEnum dispatchType;

    @FieldDesc(name = "本次承接处理单位编码。")
    @Column(name = "handling_org_code", nullable = false, length = 64)
    private String handlingOrgCode;

    @FieldDesc(name = "承接班组编码；组织未单独维护班组时可为空。")
    @Column(name = "team_code", nullable = true, length = 64)
    private String teamCode;

    @FieldDesc(name = "本次调查范围、要求及重新派工调整说明。")
    @Column(name = "investigation_scope", nullable = false, columnDefinition = "text")
    private String investigationScope;

    @FieldDesc(name = "派工人员编码。")
    @Column(name = "dispatched_by", nullable = false, length = 64)
    private String dispatchedBy;

    @FieldDesc(name = "派工完成时间，精确到毫秒。")
    @Column(name = "dispatched_at", nullable = false)
    @Convert(converter = InstantLongConverter.class)
    private Instant dispatchedAt;

    @FieldDesc(name = "本次派工被承接的业务时间，精确到毫秒。")
    @Column(name = "accepted_at", nullable = true)
    @Convert(converter = InstantLongConverter.class)
    private Instant acceptedAt;

    @FieldDesc(name = "退回人员编码；未发生退回时为空。")
    @Column(name = "returned_by", nullable = true, length = 64)
    private String returnedBy;

    @FieldDesc(name = "调查范围不匹配等导致退回派工的时间，精确到毫秒。")
    @Column(name = "returned_at", nullable = true)
    @Convert(converter = InstantLongConverter.class)
    private Instant returnedAt;

    @FieldDesc(name = "退回重新分配的具体原因；发生退回时必填。")
    @Column(name = "return_reason", nullable = true, columnDefinition = "text")
    private String returnReason;
}
