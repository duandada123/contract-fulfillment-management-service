package com.zdph.contract.fulfillment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel
public class ClueResponse {

    @ApiModelProperty("材料名称。")
    private String materialName;

    @ApiModelProperty("上传原始文件名，含扩展名。")
    private String fileName;

    @ApiModelProperty("外部文件服务存储键或永久资源标识。")
    private String fileStorageKey;

    @ApiModelProperty("文件大小，单位字节；范围0～9223372036854775807。")
    private Long fileSize;

    @ApiModelProperty("材料内容与说明。")
    private String materialDescription;
}
