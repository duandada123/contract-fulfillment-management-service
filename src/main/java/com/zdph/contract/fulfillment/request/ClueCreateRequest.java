package com.zdph.contract.fulfillment.request;

import com.sinogale.common.model.Request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class ClueCreateRequest implements Request {


    @ApiModelProperty("字典的key")
    private Integer sourceTypeValue;

    @ApiModelProperty("外部来源系统编码")
    private String systemCode;

    @ApiModelProperty("来源渠道业务单号或推送唯一编号")
    private String sourceBusinessNo;

    @ApiModelProperty("线索标题")
    private String title;

    @ApiModelProperty("疑似违约行为、发生情况及线索描述")
    private String content;

    @ApiModelProperty("现场地址")
    private String siteAddress;

    @ApiModelProperty("疑似调查对象描述")
    private String suspectedSubjectDesc;

    @ApiModelProperty("举报人或发现人联系方式")
    private String reporterContact;

    @ApiModelProperty("举报人或发现人姓名")
    private String reporterName;

    @ApiModelProperty("上传材料id")
    private List<Long> clueMaterialIds;

}
