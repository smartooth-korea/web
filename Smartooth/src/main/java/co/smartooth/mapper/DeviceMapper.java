package co.smartooth.mapper;
import org.apache.ibatis.annotations.Mapper;

import co.smartooth.vo.DeviceVO;


@Mapper
public interface DeviceMapper {

	// 장비 정보 입력
	public void insertDeviceInfo(DeviceVO deviceVO) throws Exception;
}
