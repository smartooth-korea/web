package co.smartooth.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.smartooth.service.DeviceService;
import co.smartooth.service.UserService;
import co.smartooth.utils.AES256Util;
import co.smartooth.vo.DeviceVO;
import co.smartooth.vo.UserVO;


/*************************
	 RequestMapping 설정 시 
	 앱에서의 요청이 있을 경우 /app/*
	 웹에서의 요청이 있을 경우 /web/*
*************************/


@Controller
public class UserController {
	
	@Autowired(required = false)
	private UserService userService;
	
	@Autowired(required = false)
	private DeviceService deviceService;
	
	
	/**
	 * 기능   : 웹에서 요청한 유저에 대한...
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 27
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/user.do"}, method = {RequestMethod.GET})
	  public String userList(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("headerCategoriesName","회원관리");
		model.addAttribute("kategorieName", "회원관리 > 개인");
		System.out.println("user.do");
	    return "/user/userManageIndividual";
	  }
	
	
	
	/**
	 * 기능   : 웹에서 요청한 그룹에 대한 ...
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 27
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/group.do"}, method = {RequestMethod.GET})
	  public String groupList(HttpServletRequest request, Model model) throws Exception {
		String gubn = request.getParameter("gubn");
		model.addAttribute("headerCategoriesName","회원관리");
		model.addAttribute("title","usermanage");
		System.out.println("group.do");
		
		if(gubn.equals("A")) {
			model.addAttribute("headerCategoriesName", "회원관리 > 그룹 > A유치원");
			return "/user/userManageGroupA";
		}else if(gubn.equals("B")) {
			model.addAttribute("headerCategoriesName", "회원관리 > 그룹 > B유치원");
			return "/user/userManageGroupB";
		}else {
			model.addAttribute("headerCategoriesName", "회원관리 > 그룹 > C유치원");
			return "/user/userManageGroupC";
		}
	  }
	
	

	
	
	
	
	
	
/********************************************************************************************************/	
/**																						A P P																				  		 **/
/********************************************************************************************************/
	
	
	
	
	/**
	 *회원 ID 중복 확인
	 * */											
	@RequestMapping(value = {"/app/user/duplicateChkId.do"}, method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String,Object> duplicateChkId(@RequestBody HashMap<String, String> paramMap) {

		HashMap<String,Object> hm = new HashMap<String,Object>();
		int tmpIdCnt = 0;

		String userId = (String)paramMap.get("USER_ID");
		// Parameter = userId 값 검증 (Null 체크 및 공백 체크)
		if(userId == null || userId.equals("")) {
			hm.put("code", "401");
			hm.put("msg", "아이디 누락");
			return hm;
		}

		try {
			// 회원 ID 중복 확인
			tmpIdCnt =  userService.duplicateChkId(userId);
			if(tmpIdCnt == 0) { // 0일 경우 중복되지 않음
				hm.put("code", "000");
				hm.put("msg", "사용가능한 아이디입니다.");
			}else { // 0이 아닐 경우 등록되어 있는 아이디
				hm.put("code", "402");
				hm.put("msg", "이미 등록되어있는 아이디입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			hm.put("code", "500");
			hm.put("msg", "서버 오류");
		}
		
		return hm;
	}
	
	
	
	
	/**
	 * 기능   : 앱에서 요청한 회원가입 API 
	 * 			 JSON 형식의 값을 받아 Database 에 UPDATE
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 10
	 * param : req, model (userId)
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
	@RequestMapping(value = {"/app/user/register.do"}, method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String,Object> registerUser(@RequestBody HashMap<String, Object> paramMap) throws Exception{
		// 회원 번호
		String userSeqNo = null;
		// 회원 비밀번호
		String userPwd = null;
		// 회원 거주 - 국
		String userCountry = null;
		// 회원 거주 - 주
		String userState = null;
		// 회원 타입 (개인, 단체, 그룹)
		String userType = null;
		
		int seqNo = 0;
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		try {
			
			userPwd = (String)paramMap.get("USER_PWD");
			// 비밀번호 암호화
			AES256Util aes256Util = new AES256Util();
			userPwd = aes256Util.aesEncode(userPwd);
			
			// 회원번호 생성
			// 회원 번호 (회원번호 생성 전 SEQ_NO) 조회 - 회원번호 생성 시 +1 증감하여 별도의 테이블에 저장 (ST_SEQUENCE)
			seqNo = userService.selectUserSeqNo();
			// 회원 번호 +1 증가
			seqNo++;
			// 국가 이름
			userCountry= (String)paramMap.get("USER_COUNTRY");
			// 주 이름
			userState= (String)paramMap.get("USER_STATE");
			// 회원 타입 (개인, 그룹, 단체 등등)
			userType = (String)paramMap.get("USER_TYPE");
			
			// 회원 회원번호 생성 및 등록
			// I : 개인, G : 그룹, O : 단체
			// 예) KR-I-0001
			if(userState == null || userState.equals("")) { // 미국이 아닐 경우 주를 붙이지 않는다
				if(userCountry.equals("US")) {  // 미국일 경우 주를 붙인다 --------------------------------------> 국가 추가해줘야함
					userSeqNo = userCountry+"-"+userState+"-"+userType+"-"+String.format("%04d", seqNo);
				}else {
					userSeqNo = userCountry+"-"+userType+"-"+String.format("%04d", seqNo);
				}
			}
			
			// 회원번호 map에 넣어 회원 정보 업데이트 :: 회원가입 시 같이 전달
			paramMap.put("USER_NO", userSeqNo);
			paramMap.put("USER_PWD", userPwd);
			
			// 회원 등록
			userService.insertUser(paramMap);
			userService.insertUserTeethInfo(paramMap);
			
			// ST_SEQUENCE 테이블 SEQ_NO (회원번호 SeqNo)업데이트
			userService.updateUserSeqNo(seqNo);
			hm.put("code", "000");
			hm.put("msg", "성공");
			
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "서버 오류");
			e.printStackTrace();
		}
		
		return hm;
	}
	
	
	
	
	/**
	 * 기능   : 앱에서 JSON형식으로 전달 받은 회원의 TEETH_STATUS(상태 값) INSERT
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 20
	 * parameter : HashMap<String,Object>
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/app/user/insertTeethStatus.do"}, method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String,Object> insertTeethStatus(@RequestBody HashMap<String, Object> paramMap) {
		
		// JSON으로 들어온 USER_ID, USER_TEETH_STATUS MAP 파라미터로 받음
		HashMap<String,Object> hm = new HashMap<String,Object>();

		String userId = (String)paramMap.get("USER_ID");
		// Parameter = userId 값 검증 (Null 체크 및 공백 체크)
		if(userId == null || userId.equals("") || userId.equals(" ")) {
			hm.put("code", "401");
			hm.put("msg", "아이디 누락");
			return hm;
		}
		
		try {
			userService.insertTeethStatus(paramMap);

			hm.put("code", "000");
			hm.put("msg", "성공");
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "서버 오류");
			e.printStackTrace();
		}
		return hm;
	}
	
	
	
	
	/**
	 * 기능   : 앱에서 JSON형식으로 전달 받은 회원의 TEETH_STATUS(상태 값) 조회
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 20
	 * parameter : HashMap<String,Object>
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/app/user/selectTeethStatus.do"}, method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String,Object> selectTeethStatus(@RequestBody HashMap<String, Object> paramMap) {
		
		// JSON으로 들어온 USER_ID, USER_TEETH_STATUS MAP 파라미터로 받음
		HashMap<String,Object> hm = new HashMap<String,Object>();

		String userId = (String)paramMap.get("USER_ID");
		// Parameter = userId 값 검증 (Null 체크 및 공백 체크)
		if(userId == null || userId.equals("") || userId.equals(" ")) {
			hm.put("code", "401");
			hm.put("msg", "아이디 누락");
			return hm;
		}
		
		/**USER_AUTH_TOKEN을 받아야함**/
		
		List<UserVO> userInfo = new ArrayList<UserVO>();
		
		UserVO userVO = new UserVO();
		userVO.setUserId((String)paramMap.get("USER_ID"));
		userVO.setUserAuthToken((String)paramMap.get("USER_AUTH_TOKEN"));
		
		try {
			userInfo = userService.selectUserInfo(userVO);
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "서버 오류");
			e.printStackTrace();
		}
		hm.put("userInfo", userInfo);
		return hm;
	}

	
	
	
	/**
	 * 기능   : 앱에서 JSON형식으로 전달 받은 회원의 치아 측정 값을 INSERT 혹은 UPDATE
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 16
	 * parameter : HashMap<String,Object>
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/app/user/insertMeasureValue.do"}, method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String,Object> insertMeasureValue(@RequestBody HashMap<String, Object> paramMap) {
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		int cnt = 0;

		// 오늘 날짜 구하기 (SYSDATE)
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String compareDate = now.format(formatter);
		// 하드코딩
		paramMap.put("MEASURE_DT", compareDate);
		
		try {
			/* 전달받은 파라미터 USER_ID로 회원의 기록을 조회 한 후 측정 일자와 오늘 날짜를 비교하여
			최근 측정 일자와 오늘 날짜가 같을 경우 값을 UPDATE, 다를 경우 값을 INSERT*/
			cnt = userService.selectTeethMeasureValueByDate(paramMap);
			if(cnt == 0){ // 0일 경우는 Database에 값이 없는 경우 ::: INSERT
				userService.insertTeethMeasureValue(paramMap);
			}else { // 1이상일 경우 Database에 값이 있는 경우 ::: UPDATE
				userService.updateTeethMeasureValue(paramMap);
			}
			hm.put("code", "000");
			hm.put("msg", "성공");
			
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "서버 오류");
			e.printStackTrace();
		}
		return hm;
	}
	
	
	
	
	/**
	 * 기능   : 앱에서 JSON형식으로 전달 받은 파라미터로 회원의 치아 측정 값을 조회
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 16
	 * parameter : HashMap<String,Object>
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/app/user/selectMeasureValue.do"}, method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String,Object> selectMeasureValue(@RequestBody HashMap<String, Object> paramMap) {
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		int cnt = 0;

		// 오늘 날짜 구하기 (SYSDATE)
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String compareDate = now.format(formatter);
		// 하드코딩
		paramMap.put("MEASURE_DT", compareDate);
		
		try {
			/* 전달받은 파라미터 USER_ID로 회원의 기록을 조회 한 후 측정 일자와 오늘 날짜를 비교하여
			최근 측정 일자와 오늘 날짜가 같을 경우 값을 UPDATE, 다를 경우 값을 INSERT*/
			cnt = userService.selectTeethMeasureValueByDate(paramMap);
			if(cnt == 0){ // 0일 경우는 Database에 값이 없는 경우 ::: INSERT
				userService.insertTeethMeasureValue(paramMap);
			}else { // 1이상일 경우 Database에 값이 있는 경우 ::: UPDATE
				userService.updateTeethMeasureValue(paramMap);
			}
			hm.put("code", "000");
			hm.put("msg", "성공");
			
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "서버 오류");
			e.printStackTrace();
		}
		return hm;
	}
	
	
	
	/**
	 * 기능   : 앱에서의 요청한 회원의 정보를 JSON 형식으로 반환
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 19
	 * parameter : HashMap<String,Object>
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/app/user/selectUserInfo.do"}, method = {RequestMethod.GET})
	@ResponseBody
	public HashMap<String,Object> selectUserInfo(@RequestBody HashMap<String, Object> paramMap) throws Exception {
		/** 파라미터를 어떤걸 받아야할지 일단 기본적으로 USER_ID, USER_AUTH_TOKEN 을 받아야함 그 후 이것으로 맞는지 확인 **/
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		List<UserVO> data = new ArrayList<UserVO>();
		
		UserVO userVO = new UserVO();
		userVO.setUserId((String)paramMap.get("USER_ID"));
		userVO.setUserAuthToken((String)paramMap.get("USER_AUTH_TOKEN"));
		
		try {
			data = userService.selectUserInfo(userVO);
			hm.put("data", data);
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "서버 오류");
			e.printStackTrace();
		}
		return hm;
	}
	
	
	
	
	/**
	 * 기능   : 회원의 장비 정보를 INSERT
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 19
	 * parameter : HashMap<String,Object>
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/app/user/insertDeviceInfo.do"}, method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String,Object> insertDeviceInfo(@RequestBody HashMap<String, Object> paramMap) throws Exception {
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		DeviceVO deviceVO = new DeviceVO();
		deviceVO.setUserId((String)paramMap.get("USER_ID"));
		deviceVO.setUserNo((String)paramMap.get("USER_NO"));
		deviceVO.setDeviceNm((String)paramMap.get("DEVICE_NM"));
		deviceVO.setDeviceCode((String)paramMap.get("DEVICE_CODE"));
		deviceVO.setSerialNo((String)paramMap.get("SERIAL_NO"));
		deviceVO.setMacAddress((String)paramMap.get("MAC_ADDRESS"));
		
		try {
			deviceService.insertDeviceInfo(deviceVO);
			hm.put("code", "000");
			hm.put("msg", "등록 성공");
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "서버 오류");
			e.printStackTrace();
		}
		return hm;
	}
	
	
	
	
	
	
	
	
	/**
	 * 기능   : 앱에서의 요청한 회원의 정보를 삭제
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 24
	 * parameter : HashMap<String,Object>
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/app/user/deleteUser.do"}, method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String,Object> deleteUser(@RequestBody HashMap<String, Object> paramMap) throws Exception {
		
		String userId = (String)paramMap.get("USER_ID");

		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		try {
			userService.deleteUser(userId);
			hm.put("code", "000");
			hm.put("msg", "deleted");
		} catch (Exception e) {
			hm.put("code", "500");
			hm.put("msg", "Server error");
			e.printStackTrace();
		}
		return hm;
	}
}
