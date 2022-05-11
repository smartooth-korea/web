package co.smartooth.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

@Controller
public class UserController {
	
	@Autowired(required = false)
	private UserService userService;
	
	
	/**
	 * 기능   : 앱에서의 요청한 유저목록(userList)을 JSON 형식으로 return
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 27
	 * return : HashMap<String,Object>
	 */
//	@RequestMapping(value = "/app/api/userList")
//	@ResponseBody
//	public HashMap<String,Object> userList() {
//		
//		List<UserVO> userList = null;
//		HashMap<String,Object> hm = new HashMap<String,Object>();
//		
//		try {
//			userList = userService.selectUserList();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		hm.put("data", userList);
//		return hm;
//
//	}
	
	/**
	 * 기능   : 앱에서의 요청한 유저목록(userList)을 JSON 형식으로 return
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 27
	 * return : HashMap<String,Object>
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
//	@RequestMapping(value = "/app/api/userList2")
//	public ModelAndView userList2(){
//		
//		ModelAndView mv = new ModelAndView("st/jsonForm");
//		List<UserVO> userList = null;
//		HashMap<String,Object> map = new HashMap<String,Object>();
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		
//		
//		try {
//			userList = userService.selectUserList();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		map.put("userList", userList);
//		map.put("userList2", userList);
//		list.add(map);
//		mv.addObject("data", map);
//		
//		return mv;
//		
//	}
	
	
//	@RequestMapping(value = "/app/api/userList2")
//	public ModelAndView userList2(){
//		
//		ModelAndView mv = new ModelAndView("st/jsonForm");
//		List<UserVO> userList = null;
//		HashMap<String,Object> map = new HashMap<String,Object>();
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		
//		
//		try {
//			userList = userService.selectUserList();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		map.put("userList", userList);
//		map.put("userList2", userList);
//		list.add(map);
//		mv.addObject("data", map);
//		
//		return mv;
//	}
	
	
	
	/**
	 * 기능   : 웹에서 요청한 유저에 대한...
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 27
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = {"/user.do"}, method = {RequestMethod.GET})
	  public String userList(HttpServletRequest request, Model model) throws Exception {
//	    LoginVO loginVo = (LoginVO)OpHelper.getSession(request, BaseConfig.MGR_SESSION_KEY);
//	    model.addAttribute("domainList", this.mainService.getMyDomainList(loginVo));
		model.addAttribute("headerCategoriesName","사용자관리");
		model.addAttribute("kategorieName", "사용자관리 > 개인");
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
//	    LoginVO loginVo = (LoginVO)OpHelper.getSession(request, BaseConfig.MGR_SESSION_KEY);
//	    model.addAttribute("domainList", this.mainService.getMyDomainList(loginVo));
		String gubn = request.getParameter("gubn");
		model.addAttribute("headerCategoriesName","사용자관리");
		model.addAttribute("title","usermanage");
		System.out.println("group.do");
		
		if(gubn.equals("A")) {
			model.addAttribute("headerCategoriesName", "사용자관리 > 그룹 > A유치원");
			return "/user/userManageGroupA";
		}else if(gubn.equals("B")) {
			model.addAttribute("headerCategoriesName", "사용자관리 > 그룹 > B유치원");
			return "/user/userManageGroupB";
		}else {
			model.addAttribute("headerCategoriesName", "사용자관리 > 그룹 > C유치원");
			return "/user/userManageGroupC";
		}
	  }
	
	

	
	
	
	
	
	
	
	
/********************************** APP **********************************/
	
	
	
	/**
	 * 기능   : 앱에서의 요청한 유저목록(userList)을 JSON 형식으로 return
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 27
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/app/user/userList")
	@ResponseBody
	public HashMap<String,Object> userList(HttpServletRequest req) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("UTF-8");
		String userId = (String)req.getAttribute("userId");
		
		List<UserVO> userList = null;
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		try {
			userList = userService.selectUserList(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		hm.put("data", userList);
		return hm;

	}
	
	
	
	/**
	 * 기능   : 앱에서의 요청한 회원가입 API , JSON 형식으로 값을 받아 Database 에 UPDATE한다.
	 * 			  이메일 인증번호 생성 당시 ID로 ROW를 생성하였기 때문에 JSON으로 Paramter를 받아 UPDATE 
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 5. 10
	 * param : req, model (userId)
	 * return : HashMap<String,Object>
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
//	@RequestMapping(value = "/app/user/register")
	@RequestMapping(value = {"/app/user/register"}, method = {RequestMethod.GET})
	@ResponseBody
	public HashMap<String,Object> insertUser(Map<String, Object> param) throws UnsupportedEncodingException, ParseException {
		
		String userCountry = null;
		String userGroup = null;
		String userState = null;
		String tmpSeqNo = null;
		int seqNo = 0;

//		String pramamUserBirthday = (String)param.get("USER_BIRTHDAY");
		String pramamUserBirthday = "2022-05-10 15:25:30";

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date userBirthday = transFormat.parse(pramamUserBirthday);



		UserVO userVO = new UserVO();
		// Setter로 Parameter를 UserVO 값을 입력
//		userVO.setUserId((String)param.get("USER_ID"));
		userVO.setUserId("jungjuhyun12@gmail.com");
//		userVO.setUserPwd((String)param.get("USER_PWD"));
		userVO.setUserPwd("1234");
//		userVO.setUserNm((String)param.get("USER_NM"));
		userVO.setUserNm("관리자");
//		userVO.setUserNickname((String)param.get("USER_NICKNAME"));
		userVO.setUserNickname("프론트맨");
		userVO.setUserBirthday(userBirthday);
		/**국가를 넣을때 어떻게 날라오는지 확인해봐야할듯 (파라미터에 국가가 날라와야함)
		//userVO.setUserCountry((String)param.get("USER_COUNTRY"));
		//하드코딩**/
		userVO.setUserCountry("KR");
//		userVO.setUserState((String)param.get("USER_STATE"));
//		userVO.setUserState("NY");
//		userVO.setUserAddress((String)param.get("USER_ADDRESS"));
		userVO.setUserAddress("서울특별시 양천구 신정동 1004-11");
//		userVO.setUserTelNo((String)param.get("USER_TEL_NO"));
		userVO.setUserTelNo("010-9937-4921");
//		userVO.setUserSex((String)param.get("USER_SEX"));
		userVO.setUserSex("M");
//		userVO.setUserPushToken((String)param.get("USER_PUSH_TOKEN"));
		userVO.setUserPushToken("testToken");
//		userVO.setUserId((String)param.get("USER_EMAIL_YN"));

		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		try {
			// 회원번호 생성 시 외국(미국일 경우) - 주를 붙여준다.
			// 사용자 번호 (회원번호 생성 전 SEQ_NO) 조회
			seqNo = userService.selectUserSeqNo();
			// 사용자 번호 +1 증가
			seqNo++;
			// 국가 이름
			userCountry= userVO.getUserCountry();
			// 주 이름
			userState = userVO.getUserState();
			// 그룹 이름 :: 치과로 하드코딩
			userGroup = "DENT";
			
			// 사용자 회원번호 생성 및 등록 -- KR-DENT-000001
			if(userState == null || userState.equals("")) { // 미국이 아닐 경우 주를 붙이지 않는다
				tmpSeqNo = userCountry+"-"+userGroup+"-"+String.format("%06d", seqNo);
			}else { // 미국일 경우 주를 붙인다
				tmpSeqNo = userCountry+"-"+userState+"-"+userGroup+"-"+String.format("%06d", seqNo);
			}
			userVO.setUserNo(tmpSeqNo);
			
			// 사용자 업데이트
			userService.updateUser(userVO);

			// ST_USER_SEQ 테이블 SEQ_NO (회원번호 SeqNo)업데이트
			userService.updateUserSeqNo(seqNo);
			
			hm.put("result", "success");
			
		} catch (Exception e) {
			hm.put("result", "failed");
			e.printStackTrace();
		}
		
		return hm;

	}
	
	
	
	
	
}
