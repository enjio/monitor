/**
 * Copyright (C), 2019, 义金(杭州)健康科技有限公司
 * FileName: PatientRecordServiceImpl
 * Author:   CentreS
 * Date:     2019/7/22 11:41
 * Description: 历史记录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yjjk.monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.yjjk.monitor.entity.ZsPatientRecord;
import com.yjjk.monitor.entity.json.TemperatureHistory;
import com.yjjk.monitor.entity.vo.PatientTemperature;
import com.yjjk.monitor.entity.vo.RecordHistory;
import com.yjjk.monitor.entity.vo.UseMachine;
import com.yjjk.monitor.service.BaseService;
import com.yjjk.monitor.service.PatientRecordService;
import com.yjjk.monitor.utility.DateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 历史记录
 * @author CentreS
 * @create 2019/7/22
 */
@Service
public class PatientRecordServiceImpl extends BaseService implements PatientRecordService {


    @Override
    public int addPatientRecord(ZsPatientRecord patientRecord) {
        return super.ZsPatientRecordMapper.insertSelective(patientRecord);
    }

    @Override
    public int updateByPrimaryKey(ZsPatientRecord patientRecord) {
        return super.ZsPatientRecordMapper.updateByPrimaryKeySelective(patientRecord);
    }

    @Override
    public ZsPatientRecord selectByPrimaryKey(Long recordId) {
        return super.ZsPatientRecordMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public List<UseMachine> getMonitorsInfo() {
        return super.ZsPatientRecordMapper.getMonitorsInfo();
    }

    @Override
    public List<PatientTemperature> getMinitorsTemperature() {
        return super.ZsPatientRecordMapper.getMinitorsTemperature();
    }

    @Override
    public List<RecordHistory> getRecordHistory(RecordHistory recordHistory) {
        return super.ZsPatientRecordMapper.getRecordHistory(recordHistory);
    }

    @Override
    public int getRecordHistoryCount(RecordHistory recordHistory) {
        return super.ZsPatientRecordMapper.getRecordHistoryCount(recordHistory);
    }

    @Override
    public int stopMonitoring(Integer patientId) {
        List<TemperatureHistory> list = super.ZsPatientRecordMapper.selectTemperatureHistory(patientId);
        List<TemperatureHistory> resultList = new ArrayList<>();
        // 每隔十分钟取一条数据
        for (int i = 0; i < list.size(); i += 9) {
            resultList.add(list.get(i));
        }
        ZsPatientRecord patientRecord = new ZsPatientRecord();
        patientRecord.setPatientId(patientId);
        patientRecord.setTemperatureHistory(JSON.toJSONString(resultList));
        patientRecord.setUsageState(1);
        patientRecord.setEndTime(DateUtil.getCurrentTime());
        int i = super.ZsPatientRecordMapper.updateSelectiveByPatientId(patientRecord);
        return i;
    }

    @Override
    public List<TemperatureHistory> getCurrentTemperatureRecord(Integer patientId) {
        return super.ZsPatientRecordMapper.selectTemperatureHistory(patientId);
    }
}
