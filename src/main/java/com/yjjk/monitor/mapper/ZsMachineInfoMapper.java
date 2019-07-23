package com.yjjk.monitor.mapper;


import com.yjjk.monitor.entity.ZsMachineInfo;
import com.yjjk.monitor.entity.ZsManagerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZsMachineInfoMapper {
    int deleteByPrimaryKey(Integer machineId);

    int insert(ZsMachineInfo record);

    int insertSelective(ZsMachineInfo record);

    ZsMachineInfo selectByPrimaryKey(Integer machineId);

    int updateByPrimaryKeySelective(ZsMachineInfo record);

    int updateByPrimaryKey(ZsMachineInfo record);

    /**
     * insert---批量插入设备
     * @param machineInfo
     * @return
     */
    int insertByMachineNums(ZsMachineInfo machineInfo);

    /**
     * select---查询设备总数(machineId, usageState)
     * @param machineInfo
     * @return
     */
    int selectCount(ZsMachineInfo machineInfo);

    /**
     * select---分页查询设备信息(usageSate)
     * @param machineInfo
     * @return
     */
    List<ZsMachineInfo> selectByUsageState(ZsMachineInfo machineInfo);


}