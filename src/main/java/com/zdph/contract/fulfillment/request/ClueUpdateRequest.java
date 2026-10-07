package com.zdph.contract.fulfillment.request;

import com.sinogale.common.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;


@Data
@ApiModel
public class ClueUpdateRequest {

    @ApiModelProperty("线索id")
    private Long id;

    @ApiModelProperty("线索标题")
    private String title;

    @ApiModelProperty("疑似违约行为、发生情况及线索描述")
    private String content;

    @ApiModelProperty("现场地址")
    private String siteAddress;

    @ApiModelProperty("疑似调查对象描述")
    private String suspectedSubjectDesc;

    @ApiModelProperty("上传材料id")
    private List<Long> clueMaterialIds;

    @FieldDesc(name = "线索编号，业务唯一。")
    private String clueNo;

}
