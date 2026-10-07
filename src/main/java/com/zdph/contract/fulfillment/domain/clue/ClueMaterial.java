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
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 线索材料。
 */
@Entity
@Table(name = "cf_clue_material")
@Data
@GenDto(pkgName = "com.zdph.contract.fulfillment.domain.clue.dto")
@GenVo(pkgName = "com.zdph.contract.fulfillment.domain.clue.vo")
//@GenMapper(pkgName = "com.zdph.contract.fulfillment.domain.clue.mapper")
@GenQuery(pkgName = "com.zdph.contract.fulfillment.domain.clue.query")
@GenUpdater(pkgName = "com.zdph.contract.fulfillment.domain.clue.updater")
public class ClueMaterial extends BaseJpaAggregate {

    @FieldDesc(name = "所属线索ID；范围1～9223372036854775807。\n关联：cf_clue.id。")
    @Column(name = "clue_id", nullable = false)
    private Long clueId;

    // 数据库允许 NULL；按当前要求使用 long，接入前请确认是否改为 Long。
    @FieldDesc(name = "所属补充记录ID；范围1～9223372036854775807；首次登记材料为空。\n关联：cf_clue_supplement.id。")
    @Column(name = "supplement_id", nullable = true)
    private Long supplementId;

    @FieldDesc(name = "材料名称。")
    @Column(name = "material_name", nullable = false, length = 255)
    private String materialName;

    @FieldDesc(name = "上传原始文件名，含扩展名。")
    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    @FieldDesc(name = "外部文件服务存储键或永久资源标识。")
    @Column(name = "file_storage_key", nullable = false, length = 512)
    private String fileStorageKey;

    // 数据库允许 NULL；按当前要求使用 long，接入前请确认是否改为 Long。
    @FieldDesc(name = "文件大小，单位字节；范围0～9223372036854775807。")
    @Column(name = "file_size", nullable = true)
    private Long fileSize;

    @FieldDesc(name = "材料内容与说明。")
    @Column(name = "material_description", nullable = true, length = 1000)
    private String materialDescription;

    @IgnoreUpdater
    @FieldDesc(name = "上传人员或服务账号编码，外部身份引用。")
    @Column(name = "uploaded_by", nullable = false, length = 64)
    private String uploadedBy;

    @IgnoreUpdater
    @FieldDesc(name = "材料上传时间。")
    @Column(name = "uploaded_at", nullable = false)
    @Convert(converter = InstantLongConverter.class)
    private Instant uploadedAt;
}
