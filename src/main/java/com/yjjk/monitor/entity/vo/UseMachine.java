/**
 * Copyright (C), 2019, 义金(杭州)健康科技有限公司
 * FileName: UseMachine
 * Author:   CentreS
 * Date:     2019/7/19 9:39
 * Description: 启用设备
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yjjk.monitor.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 启用设备
 * @author CentreS
 * @create 2019/7/19
 */
@Data
@Accessors(chain = true)
public class UseMachine {
    /** patientInfo */
    private String patientName;
    private String caseNum;

    /** 病房信息 */
    private String departmentName;
    private String roomName;
    private String bedName;
    private Integer bedId;

    /** record */
    private Long recordId;
    private Integer machineId;
    /** 0：预热中 1：使用中 2：连接异常 */
    private Integer recordState;

    /** machine */
    private String machineNum;
    private String machineNo;


    /** temperature */
    private String temperature;
    private Integer pattery;
    private String temperatureStatus;
    private Long timestamp;
    private String useTimes;

    private String startTime;
    private String endTime;

}
