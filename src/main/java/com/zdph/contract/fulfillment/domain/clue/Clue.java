package com.zdph.contract.fulfillment.domain.clue;

import com.sinogale.codegen.dto.GenDto;
import com.sinogale.codegen.mapper.GenMapper;
import com.sinogale.codegen.query.GenQuery;
import com.sinogale.codegen.updater.GenUpdater;
import com.sinogale.codegen.updater.IgnoreUpdater;
import com.sinogale.codegen.vo.GenVo;
import com.sinogale.common.annotation.FieldDesc;
import com.sinogale.jpa.converter.InstantLongConverter;
import com.sinogale.jpa.support.BaseJpaAggregate;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueSourceTypeEnumConverter;
import com.zdph.contract.fulfillment.domain.clue.convert.ClueStatusEnumConverter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.zdph.contract.fulfillment.domain.clue.event.ClueCreatedEvent;
import com.zdph.contract.fulfillment.domain.clue.event.ClueSavedEvent;
import lombok.Data;

/**
 * 违约线索。
 */
@Entity
@Table(name = "cf_clue")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.clue.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.clue.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.clue.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.clue.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.clue.updater")
public class Clue extends BaseJpaAggregate {

    @FieldDesc(name = "线索编号，业务唯一。")
    @Column(name = "clue_no", nullable = false, length = 64)
    private String clueNo;


    @IgnoreUpdater
    @FieldDesc(name = "来源类型：1.客户举报；2.系统推送；3.内部发现；4.其他专业移交。")
    @Column(name = "source_type", nullable = false)
    @Convert(converter = ClueSourceTypeEnumConverter.class)
    private ClueSourceTypeEnum sourceType;

    @IgnoreUpdater
    @FieldDesc(name = "外部来源系统编码；人工渠道可为空。")
    @Column(name = "system_code", nullable = true, length = 64)
    private String systemCode;

    @IgnoreUpdater
    @FieldDesc(name = "来源渠道业务单号或推送唯一编号；人工登记可为空。")
    @Column(name = "source_business_no", nullable = true, length = 128)
    private String sourceBusinessNo;

    @FieldDesc(name = "线索标题；草稿允许为空。")
    @Column(name = "title", nullable = true, length = 200)
    private String title;

    @FieldDesc(name = "疑似违约行为、发生情况及线索描述；提交审核时必填。")
    @Column(name = "content", nullable = true, columnDefinition = "text")
    private String content;

    @FieldDesc(name = "现场地址；无档案对象应提供可定位现场的信息。")
    @Column(name = "site_address", nullable = true, length = 500)
    private String siteAddress;

    @FieldDesc(name = "疑似调查对象描述；尚未核实身份的信息不得当作正式认定。")
    @Column(name = "suspected_subject_desc", nullable = true, length = 500)
    private String suspectedSubjectDesc;

    @FieldDesc(name = "外部客户档案编码；未匹配到客户时为空。")
    @Column(name = "customer_code", nullable = true, length = 64)
    private String customerCode;

    @FieldDesc(name = "外部用电户编号；无正式用电户时为空。")
    @Column(name = "power_account_no", nullable = true, length = 64)
    private String powerAccountNo;

    @FieldDesc(name = "举报人或发现人姓名，按业务需要记录并控制可见范围。")
    @Column(name = "reporter_name", nullable = true, length = 128)
    private String reporterName;

    @FieldDesc(name = "举报人或发现人联系方式；作为文本保存，不使用数值类型。")
    @Column(name = "reporter_contact", nullable = true, length = 64)
    private String reporterContact;

    @FieldDesc(name = "线索实际接收时间。")
    @Column(name = "received_at", nullable = false)
    @Convert(converter = InstantLongConverter.class)
    private Instant receivedAt;

    @FieldDesc(name = "登记人员或服务账号编码，外部身份引用。")
    @Column(name = "registered_by", nullable = false, length = 64)
    private String registeredBy;

    @FieldDesc(name = "登记单位编码，外部组织引用。")
    @Column(name = "registered_org_code", nullable = true, length = 64)
    private String registeredOrgCode;

    @FieldDesc(name = "最近一次提交审核时间；未提交为空，补充提交历史见补充记录。")
    @Column(name = "submitted_at", nullable = true)
    @Convert(converter = InstantLongConverter.class)
    private Instant submittedAt;

    @FieldDesc(name = "线索状态：0.草稿；1.待补充；2.待审核；3.待归口；4.待生成工单；5.已转工单；6.已关联；7.已作废；8.已转办。")
    @Column(name = "clue_status", nullable = false)
    @Convert(converter = ClueStatusEnumConverter.class)
    private ClueStatusEnum clueStatus;

    @Transient
    private List<Long> clueMaterialIds = new ArrayList<>() ;

    //线索创建
    public void init() {
        this.setCreatedAt(Instant.now());
        this.setClueStatus(ClueStatusEnum.DRAFT);
        this.registerEvent(new ClueCreatedEvent(this.getId(),this.getClueMaterialIds()));
    }

    //线索保存
    public void update() {
        this.setUpdatedAt(Instant.now());
        this.registerEvent(new ClueSavedEvent(this.getId(),this.getClueMaterialIds()));

    }
}
