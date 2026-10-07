package com.zdph.contract.fulfillment.controller;


import com.sinogale.common.constants.ErrorCode;
import com.sinogale.common.model.OpenAPIResponse;
import com.zdph.contract.fulfillment.domain.clue.application.IClueMaterialService;
import com.zdph.contract.fulfillment.domain.clue.dto.ClueMaterialDto;
import com.zdph.contract.fulfillment.domain.clue.mapper.ClueMaterialMapper;
import com.zdph.contract.fulfillment.domain.clue.updater.ClueMaterialUpdater;
import com.zdph.contract.fulfillment.domain.clue.vo.ClueMaterialVo;
import com.zdph.contract.fulfillment.request.ClueMaterialCreateRequest;
import com.zdph.contract.fulfillment.request.ClueMaterialResponse;
import com.zdph.contract.fulfillment.request.ClueMaterialUpdateRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author gim
 */
@RestController
@RequestMapping(value = "clueMaterial/v1")
public class ClueMaterialController {

    private final IClueMaterialService clueMaterialService;

    public ClueMaterialController(IClueMaterialService clueMaterialService) {
        this.clueMaterialService = clueMaterialService;
    }

    @PostMapping(value = "createClueMaterial")
    @ApiOperation(value = "createClueMaterial", notes = "材料上传")
    public OpenAPIResponse<Long> createClueMaterial(@RequestBody ClueMaterialCreateRequest request) {
        ClueMaterialDto dto = ClueMaterialMapper.INSTANCE.request2Dto(request);
        return OpenAPIResponse.success(clueMaterialService.createClueMaterial(dto));
    }


    @PostMapping(value = "updateClueMaterial")
    public OpenAPIResponse<String> updateClueMaterial(@RequestBody ClueMaterialUpdateRequest request) {
        ClueMaterialUpdater updater = ClueMaterialMapper.INSTANCE.request2Updater(request);
        clueMaterialService.updateClueMaterial(updater);
        return OpenAPIResponse.success(ErrorCode.SUCCESS.getName());
    }


    @GetMapping(value = "findById/{id}")
    public OpenAPIResponse<ClueMaterialResponse> findById(@PathVariable Long id) {
        ClueMaterialVo vo = clueMaterialService.findById(id);
        ClueMaterialResponse response = ClueMaterialMapper.INSTANCE.vo2ResponseCustom(vo);
        return OpenAPIResponse.success(response);
    }

}