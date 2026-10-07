package com.zdph.contract.fulfillment.controller;

import com.sinogale.common.constants.ErrorCode;
import com.sinogale.common.model.OpenAPIResponse;
import com.sinogale.common.model.PageRequestWrapper;
import com.sinogale.common.model.PageResult;
import java.util.stream.Collectors;

import com.zdph.contract.fulfillment.domain.clue.application.IClueService;
import com.zdph.contract.fulfillment.domain.clue.domainservice.ClueDomainService;
import com.zdph.contract.fulfillment.domain.clue.dto.ClueDto;
import com.zdph.contract.fulfillment.domain.clue.mapper.ClueMapper;
import com.zdph.contract.fulfillment.domain.clue.mapper.ClueMaterialMapper;
import com.zdph.contract.fulfillment.domain.clue.query.ClueQuery;
import com.zdph.contract.fulfillment.domain.clue.updater.ClueMaterialUpdater;
import com.zdph.contract.fulfillment.domain.clue.updater.ClueUpdater;
import com.zdph.contract.fulfillment.domain.clue.vo.ClueVo;
import com.zdph.contract.fulfillment.infrastructure.util.WaterFlowUtils;
import com.zdph.contract.fulfillment.request.ClueCreateRequest;
import com.zdph.contract.fulfillment.request.ClueQueryRequest;
import com.zdph.contract.fulfillment.request.ClueResponse;
import com.zdph.contract.fulfillment.request.ClueUpdateRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gim
 */
@RestController
@RequestMapping(value = "clue/v1")
public class ClueController {

    private final ClueDomainService clueDomainService;

    public ClueController(ClueDomainService clueDomainService) {
        this.clueDomainService = clueDomainService;
    }

    @ApiOperation(value = "registerClue", notes = "线索登记")
    @PostMapping(value = "registerClue")
    public OpenAPIResponse<Long> registerClue(@RequestBody ClueCreateRequest request) {
        return OpenAPIResponse.success(clueDomainService.registerClue(request));
    }

    @ApiOperation(value = "updateClue", notes = "线索登记/线索保存")
    @PostMapping(value = "updateClue")
    public OpenAPIResponse<String> updateClue(@RequestBody ClueUpdateRequest request) {
        clueDomainService.updateClue(request);
        return OpenAPIResponse.success(ErrorCode.SUCCESS.getName());
    }

    /*@PostMapping(value = "findByPage")
    public OpenAPIResponse<PageResult<ClueResponse>> findByPage(
            @RequestBody PageRequestWrapper<ClueQueryRequest> request) {
        PageRequestWrapper<ClueQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(ClueMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
        Page<ClueVo> page = clueService.findByPage(wrapper);
        return OpenAPIResponse.success(
                PageResult.of(
                        page.getContent().stream()
                                .map(vo -> ClueMapper.INSTANCE.vo2ResponseCustom(vo))
                                .collect(Collectors.toList()),
                        page.getTotalElements(),
                        page.getSize(),
                        page.getNumber())
        );
    }

    @GetMapping(value = "findById/{id}")
    public OpenAPIResponse<ClueResponse> findById(@PathVariable Long id) {
        ClueVo vo = clueService.findById(id);
        ClueResponse response = ClueMapper.INSTANCE.vo2ResponseCustom(vo);
        return OpenAPIResponse.success(response);
    }*/

}