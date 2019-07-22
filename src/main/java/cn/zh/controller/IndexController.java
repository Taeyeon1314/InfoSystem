package cn.zh.controller;


import cn.zh.pojo.Info;
import cn.zh.service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Resource
    private InfoService infoService;

    @RequestMapping("/")
    public String idex(Model model) {
        List<Info> infoList = infoService.findAll();
        model.addAttribute("infoList", infoList);
        return "index";

    }
    @RequestMapping("/index")
    public String getAllInfo(Model model) {
        List<Info> infoList = infoService.findAll();
        model.addAttribute("infoList", infoList);
        return "index";

    }

    @RequestMapping("/delInfo.do")
    @ResponseBody
    public Map delInfoById(@RequestParam(value = "id") Integer id) {
        Map<String, String> map = new HashMap();
        if (id != null) {
            boolean flag = infoService.delInfoById(id);
            if (flag) {
                map.put("result", "success");
            } else {
                map.put("result", "fail");
            }
        } else {
            map.put("result", "nodata");
        }
        return map;
    }

    @RequestMapping("/addInfo")
    public String addInfo() {
        return "add";
    }

    @RequestMapping("/addInfo.do")
    @ResponseBody
    public Map addInfoSave(Info info) {
        Map<String, String> map = new HashMap();
        if (info != null) {
            if(info.getSex().equals("1")){
                info.setSex("男");
            }else{
                info.setSex("女");
            }

            boolean flag = infoService.addInfo(info);
            if (flag) {
                map.put("result", "success");
            } else {
                map.put("result", "fail");
            }
        } else {
            map.put("result", "nodata");
        }
        return map;
    }

    @RequestMapping("updateInfo")
    public String updateInfo(@RequestParam("id") Integer id, Model model){
        Info info=infoService.findInfoById(id);
        model.addAttribute("info",info);
        return "update";
    }

    @RequestMapping("/updateInfo.do")
    @ResponseBody
    public Map updateInfoSave(Info info) {
        Map<String, String> map = new HashMap();

        if (info != null) {
            if(info.getSex().equals("1")){
                info.setSex("男");
            }else{
                info.setSex("女");
            }

            boolean flag = infoService.updateInfo(info);
            if (flag) {
                map.put("result", "success");
            } else {
                map.put("result", "fail");
            }
        } else {
            map.put("result", "nodata");
        }
        return map;
    }
}