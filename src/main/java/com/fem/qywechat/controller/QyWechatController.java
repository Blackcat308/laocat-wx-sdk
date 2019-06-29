////package com.fem.qywechat.controller;
////
////import com.fem.qywechat.entity.Test;
////import com.fem.qywechat.service.TestService;
////import com.jeecg.qywx.api.base.JwAccessTokenAPI;
////import com.jeecg.qywx.api.base.JwParamesAPI;
////import com.jeecg.qywx.api.core.common.AccessToken;
////import com.jeecg.qywx.api.department.JwDepartmentAPI;
////import com.jeecg.qywx.api.department.vo.Department;
////import lombok.AllArgsConstructor;
////import lombok.extern.slf4j.Slf4j;
////import org.jeewx.api.core.exception.WexinReqException;
////import org.jeewx.api.wxbase.wxtoken.JwTokenAPI;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.ResponseBody;
////import org.springframework.web.bind.annotation.RestController;
////
////import java.util.List;
////
/////**
//// * 描述:
//// *  TODO 此类作废
//// * @author Jeazer
//// * @create 2019-06-26 9:34
//// */
////@Slf4j
////@RestController
////@AllArgsConstructor
////@RequestMapping("/haha")
////public class QyWechatController {
////
////    private final TestService testService;
////
//////    @GetMapping("/test")
//////    @ResponseBody
//////    public List<Test> test() {
//////
//////        Test test = new Test();
//////        test.setAge("1");
//////        test.setName("1");
//////        test.setSex("1");
//////        testService.save(test);
//////        List<Test> list = testService.list();
//////        return list;
//////    }
////
////    public static void main(String[] args) {
////        // 企业id
//////        String corpID = "ww3f86f24eb16f029e";
//////        String secret = "ZmWkRec4ZpxLylLQgAPnNgTIn2VxAVCAHFu5RrW0QoU";
//////        AccessToken accessToken = JwAccessTokenAPI.getAccessToken(corpID,secret);
//////        String access = "HEQUnBtWQF7HKR4LoRHrkBVHdAMZnE0miYNNyXaVgm_0eOfKrNiboYKJ7oZ6vqa8r8xtw3d6u0cZq5eitFzaad1o-HjXzCIV_f3eDTZta1L9l7Vu1l7jcanrsnl7_BPSqK3Qad7XJVrKSF4T7MXe-g_lZB2BjZIOkA4ZXuvm6XBzbDblXKdaNvMn0CVKAXTlYQEB1gH2iiaFF1dKQAzEhg";
//////        List<Department> allDepartment = JwDepartmentAPI.getAllDepartment(access);
//////        System.out.println(allDepartment);
//////        System.out.println(accessToken);
//////        String appID = "wx8f904aae8bb4a392";
//////        String appSecret = "5f61ba00ca3b56b6ab8c6aa352cfb36f";
//////        try {
//////            String accessToken = JwTokenAPI.getAccessToken(appID, appSecret);
//////            System.out.println(accessToken);
//////        } catch (WexinReqException e) {
//////            e.printStackTrace();
//////        }
////    }
////
////
////
////}
//package com.fem.qywechat.controller;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 描述:
// *  TODO 此类作废
// * @author Jeazer
// * @create 2019-06-26 9:34
// */
//@Slf4j
//@RestController
//@AllArgsConstructor
//@RequestMapping("/haha")
//public class QyWechatController {
//
//    public static void main(String[] args) {
//        // 企业id
////        String corpID = "ww3f86f24eb16f029e";
////        String secret = "ZmWkRec4ZpxLylLQgAPnNgTIn2VxAVCAHFu5RrW0QoU";
////        AccessToken accessToken = JwAccessTokenAPI.getAccessToken(corpID,secret);
////        String access = "HEQUnBtWQF7HKR4LoRHrkBVHdAMZnE0miYNNyXaVgm_0eOfKrNiboYKJ7oZ6vqa8r8xtw3d6u0cZq5eitFzaad1o-HjXzCIV_f3eDTZta1L9l7Vu1l7jcanrsnl7_BPSqK3Qad7XJVrKSF4T7MXe-g_lZB2BjZIOkA4ZXuvm6XBzbDblXKdaNvMn0CVKAXTlYQEB1gH2iiaFF1dKQAzEhg";
////        List<Department> allDepartment = JwDepartmentAPI.getAllDepartment(access);
////        System.out.println(allDepartment);
////        System.out.println(accessToken);
////        String appID = "wx8f904aae8bb4a392";
////        String appSecret = "5f61ba00ca3b56b6ab8c6aa352cfb36f";
////        try {
////            String accessToken = JwTokenAPI.getAccessToken(appID, appSecret);
////            System.out.println(accessToken);
////        } catch (WexinReqException e) {
////            e.printStackTrace();
////        }
//    }
//
//
//
//}
