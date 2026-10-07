package com.zdph.contract.fulfillment.domain.workorder;

import com.sinogale.codegen.dto.GenDto;
import com.sinogale.codegen.mapper.GenMapper;
import com.sinogale.codegen.query.GenQuery;
import com.sinogale.codegen.updater.GenUpdater;
import com.sinogale.codegen.vo.GenVo;
import com.sinogale.common.annotation.FieldDesc;
import com.sinogale.jpa.converter.InstantLongConverter;
import com.sinogale.jpa.support.BaseJpaAggregate;
import com.zdph.contract.fulfillment.domain.workorder.convert.WorkOrderStatusEnumConverter;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 合同履约工单。
 */
@Entity
@Table(name = "cf_work_order")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.workorder.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.workorder.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.workorder.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.workorder.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.workorder.updater")
public class WorkOrder extends BaseJpaAggregate {

    @FieldDesc(name = "工单编号；全局唯一，由业务编号规则生成。")
    @Column(name = "work_order_no", nullable = false, length = 64)
    private String workOrderNo;

    @FieldDesc(name = "来源线索ID；范围1～9223372036854775807；唯一且非空，实现一条线索最多一个工单。\n关联：cf_clue.id。")
    @Column(name = "clue_id", nullable = false)
    private Long clueId;

    @FieldDesc(name = "立单依据的归口记录ID；范围1～9223372036854775807；保留当时有效归口版本。\n关联：cf_clue_routing.id。")
    @Column(name = "initial_routing_id", nullable = false)
    private Long initialRoutingId;

    @FieldDesc(name = "本工单唯一调查对象ID；范围1～9223372036854775807；唯一且非空，按工单保留对象识别记录。\n关联：cf_subject.id。")
    @Column(name = "subject_id", nullable = false)
    private Long subjectId;

    @FieldDesc(name = "当前处理专业编码，引用专业字典；保留归口确认结果。")
    @Column(name = "profession_code", nullable = false, length = 64)
    private String professionCode;

    @FieldDesc(name = "当前处理单位编码，引用组织主数据，不在本模型复制组织表。")
    @Column(name = "handling_org_code", nullable = false, length = 64)
    private String handlingOrgCode;

    @FieldDesc(name = "当前责任岗位编码，引用岗位主数据。")
    @Column(name = "responsible_post_code", nullable = false, length = 64)
    private String responsiblePostCode;

    @FieldDesc(name = "初始调查范围及调查要求；重新派工的调整内容另存派工记录。")
    @Column(name = "initial_scope", nullable = false, columnDefinition = "text")
    private String initialScope;

    @FieldDesc(name = "工单状态：1.待分配；2.待调查；3.待认定；4.审批中；5.待处置结果；6.待归档；7.已归档。")
    @Column(name = "status", nullable = false)
    @Convert(converter = WorkOrderStatusEnumConverter.class)
    private WorkOrderStatusEnum status;

    @FieldDesc(name = "立单人员编码。")
    @Column(name = "opened_by", nullable = false, length = 64)
    private String openedBy;

    @FieldDesc(name = "正式立单业务时间，精确到毫秒；不同于记录生成时间created_at。")
    @Column(name = "opened_at", nullable = false)
    @Convert(converter = InstantLongConverter.class)
    private Instant openedAt;

    @FieldDesc(name = "工单补充说明。")
    @Column(name = "remark", nullable = true, columnDefinition = "text")
    private String remark;
}
