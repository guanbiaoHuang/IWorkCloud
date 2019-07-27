package com.iworkcloud.controller;

import com.iworkcloud.pojo.Holiday;
import com.iworkcloud.pojo.Out;
import com.iworkcloud.service.IHolidayService;
import com.iworkcloud.service.IOutService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

/**
 * Holiday控制器
 */
@RequestMapping("page")
@Controller
public class HolidayController {
    @Autowired
    private IHolidayService holidayService;

    @Autowired
    private IOutService outService;

    /**
     * 请假
     * @param timeStart 请假开始时间
     * @param timeEnd 请假结束时间
     * @param content 请假的原因
     * @param session session域中存储的Id值
     * @return
     * @throws ParseException
     */
    @RequestMapping("/askForHoliday")
    public String addHoliday(String timeStart, String timeEnd, String content, HttpSession session) throws ParseException {
        //时间字符串处理
        timeStart = timeStart.replace('T', ' ');
        timeEnd = timeEnd.replace('T', ' ');
        holidayService.addHoliday(new Holiday(session.getAttribute("staff").toString(),
                new Timestamp(Str2Date.getTimeByStr(timeStart)),
                new Timestamp(Str2Date.getTimeByStr(timeEnd)),
                content, "waited"));
        return "redirect:schedule";
    }

    /**
     * 批准假期
     * @param holidayId 假期类的Id值
     * @return
     */
    @RequestMapping("/ratifyHoliday")
    public String ratify(String holidayId) {
        holidayService.ratifyHoliday(holidayId);
        return "redirect:excellentStaff";
    }

    /**
     * 拒绝假期
     * @param holidayId 假期的Id值
     * @return
     */
    @RequestMapping("/refuseHoliday")
    public String refuse(String holidayId) {
        holidayService.refuseHoliday(holidayId);
        return "redirect:excellentStaff";
    }

    /**
     * 优秀员工界面，携带信息至优秀员工界面
     * @param model 处理模型数据类
     * @return
     */
    @RequestMapping("/excellentStaff")
    public String holidayWaited(Model model) {
        //获取请假列表（未审核）
        List<Holiday> holidays = holidayService.getHolidayWaitedRatified();
        model.addAttribute("holidayList", holidays);
        List<Out> outs = outService.outToday();
        model.addAttribute("outList", outs);
        return "excellentStaff";
    }

}
