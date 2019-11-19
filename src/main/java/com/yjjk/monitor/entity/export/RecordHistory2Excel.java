/**
 * Copyright (C), 2019, 寻央大人留书
 * FileName: RecordHistory2Excel
 * Author:   CentreS
 * Date:     2019/11/19 16:31
 * Description: 体温记录历史导出Excel
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yjjk.monitor.entity.export;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 体温记录历史导出Excel
 * @author CentreS
 * @create 2019/11/19
 */
@Data
@Accessors(chain = true)
public class RecordHistory2Excel {

    private String patientName;
    private String caseNum;
    private String departmentName;
    private String room;
    private String bed;
    private String time;
    private String temperature;
}