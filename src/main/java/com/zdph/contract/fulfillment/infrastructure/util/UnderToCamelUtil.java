package com.zdph.contract.fulfillment.infrastructure.util;

import java.util.Arrays;

/**
 * @ClassName UnderToCamelUtil
 * @Author duanchao
 * @Date 2022/7/7 10:35
 **/

public class UnderToCamelUtil {

    public static void main(String[] args) {
        String columnName = "table_id,appraise_result_id,standard_idx_id,idx_no,parent_idx_no,level,is_ need_auditing,appraise_result,appraise_score_auto,appraise_score_artificial,appraise_result_auto,appraise_result_artificial,create_ts,create_by,update_ts,update_by";
        Arrays.asList(columnName.split(",")).stream().map(str->camelName(str)).forEach(System.out::println);
    }

    public static String camelName(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            return name.toLowerCase();
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel :  camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
}
