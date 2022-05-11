package co.smartooth.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.smartooth.service.UserService;
import co.smartooth.vo.MailAuthVO;
import co.smartooth.vo.UserVO;

/**
	 RequestMapping 설정 시 
	 앱에서의 요청이 있을 경우 /app/*
	 앱에서 api 요청이 있을 경우 /app/api/* 
	 웹에서의 요청이 있을 경우 /web/*
	 웹에서 api 요청이 있을 경우 /web/api/*
**/

@RestController
//@RequestMapping("/app")
public class ApiController {
	
	@Autowired(required = false)
	private UserService userService;
	
	
//	/**
//	 * 기능   : 앱에서의 요청한 유저목록(userList)을 JSON 형식으로 return
//	 * 작성자 : 정주현 
//	 * 작성일 : 2022. 4. 27
//	 * return : HashMap<String,Object>
//	 * @throws UnsupportedEncodingException 
//	 */
//	@RequestMapping(value = "/app/api/userList")
//	@ResponseBody
//	public HashMap<String,Object> userList(HttpServletRequest req) throws UnsupportedEncodingException {
//		
//		req.setCharacterEncoding("UTF-8");
//		String userId = (String)req.getAttribute("userId");
//		
//		List<UserVO> userList = null;
//		HashMap<String,Object> hm = new HashMap<String,Object>();
//		
//		try {
//			userList = userService.selectUserList(userId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		hm.put("data", userList);
//		return hm;
//
//	}
//	
//	
//	/**
//	 * 기능   : 앱에서의 요청한 회원가입 API , JSON 형식으로 값을 받아 Database 에 INSERT
//	 * 작성자 : 정주현 
//	 * 작성일 : 2022. 5. 4
//	 * param : req, model (userId)
//	 * return : HashMap<String,Object>
//	 * @throws UnsupportedEncodingException 
//	 */
//	@RequestMapping(value = "/api/insertUser")
//		public HashMap<String,Object> insertUser(@RequestBody Map<String, Object> param) throws UnsupportedEncodingException {
//		
//		int seqNo = 0;
//		String userCountry = null;
//		String userGroup = null;
//		
//		UserVO userVO = new UserVO();
//		userVO.setUserId((String)param.get("USER_ID"));
//		userVO.setUserPwd((String)param.get("USER_PWD"));
//		userVO.setUserNm((String)param.get("USER_NM"));
//		userVO.setUserNickname((String)param.get("USER_NICKNAME"));
////		userVO.setUserBirthday((String)param.get("USER_BIRTHDAY"));
//		userVO.setUserCountry((String)param.get("USER_COUNTRY"));
//		userVO.setUserState((String)param.get("USER_STATE"));
//		userVO.setUserAddress((String)param.get("USER_ADDRESS"));
//		userVO.setUserTelNo((String)param.get("USER_TEL_NO"));
//		userVO.setUserSex((String)param.get("USER_SEX"));
////		userVO.setUserRgstDt((String)param.get("USER_RGST_DT"));
//		userVO.setUserPushToken((String)param.get("USER_PUSH_TOKEN"));
////		userVO.setUserId((String)param.get("USER_DELETE_YN"));
////		userVO.setUserId((String)param.get("USER_DELETE_DT"));
////		userVO.setUserId((String)param.get("USER_EMAIL_YN"));
////		국가를 넣을때 어떻게 날라오는지 확인해봐야할듯
//		userVO.setUserCountry("KR");
//		
//
//		
//		
//		HashMap<String,Object> hm = new HashMap<String,Object>();
//		
//		try {
//
//			// 사용자 번호 (회원번호 생성 전 SEQ_NO) 조회
//			seqNo = userService.selectUserSeqNo();
//			// 국가 이름
//			userCountry= userVO.getUserCountry();
//			// 그룹 이름 :: 치과로
//			userGroup = "DENT";
//			
//			// 사용자 회원번호 생성 및 등록
//			System.out.println(userCountry+userGroup+seqNo);
//			
//			
//			userService.updateUserNoBySeq(userVO);
//
//			// 사용자 등록 Insert Mapper 
//			userService.insertUser(userVO);
//			
//			hm.put("data", "success");
//			
//		} catch (Exception e) {
//			hm.put("data", "fail");
//			e.printStackTrace();
//		}
//		
//		return hm;
//
//	}
	
}
