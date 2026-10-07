package com.zdph.contract.fulfillment.infrastructure.util;

import cn.hutool.core.lang.*;
import cn.hutool.core.util.*;

public class WaterFlowUtils
{
    static final Snowflake snowflake;

    public static Long nextWaterFlow() {
        return WaterFlowUtils.snowflake.nextId();
    }

    static {
        snowflake = IdUtil.createSnowflake(1L, 1L);
    }
}
