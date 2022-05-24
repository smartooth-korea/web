package co.smartooth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.smartooth.mapper.DeviceMapper;
import co.smartooth.service.DeviceService;
import co.smartooth.vo.DeviceVO;


@Service
public class DeviceServiceImpl implements DeviceService{

	@Autowired(required = false)
	DeviceMapper deviceMapper;
	
	// 장비 정보 INSERT
	@Override
	public void insertDeviceInfo(DeviceVO deviceVO) throws Exception {
		deviceMapper.insertDeviceInfo(deviceVO);
	}

	
	
	
	
}
