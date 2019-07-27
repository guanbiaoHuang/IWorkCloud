package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.BonusMapper;
import com.iworkcloud.pojo.Bonus;
import com.iworkcloud.pojo.Staff;
import com.iworkcloud.service.IBonusService;
import com.iworkcloud.utils.ExcelUtil;
import com.iworkcloud.utils.Str2Date;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

public class BonusService implements IBonusService {

    private BonusMapper bonusMapper;

    public void setBonusMapper(BonusMapper bonusMapper) {
        this.bonusMapper = bonusMapper;
    }

    /**
     * 添加奖金或补贴
     * @param bonus bonus实体类
     * @return
     */
    @Override
    public boolean addBonus(Bonus bonus) {
        return 1 == bonusMapper.insertBonus(bonus);
    }

    /**
     * 获取个人的所有奖金与补贴
     * @param staffId 员工号
     * @return
     */
    @Override
    public List<Bonus> queryAllBonus(String staffId) {
        return bonusMapper.queryAllBonus(staffId);
    }

    /**
     *根据Excel表格批量添加奖金与补贴信息
     * @param file 上传的Excel文件
     * @return
     */
    @Override
    public boolean addBonusByExcel(MultipartFile file) {
        //根据commons组件获取上传文件的输入流
        InputStream inputStream = null;
        //使用链表嵌套获取所有每一行的数据总集
        List<List<Object>> lists = null;
        try {
            inputStream = file.getInputStream();
            //调用Excel工具类填充数据到数据
            lists = new ExcelUtil().getBankListByExcel(inputStream, file.getOriginalFilename());
            //遍历集合填充到实体类信息
            for (int i = 0; i < lists.size(); i++) {
                List<Object> list = lists.get(i);
                Bonus bonus = new Bonus(String.valueOf(list.get(0)),
                        String.valueOf(list.get(1)),
                        new Timestamp(Str2Date.getTimeByStr(String.valueOf(list.get(3)))),
                        Double.parseDouble(String.valueOf(list.get(2))),
                        String.valueOf(list.get(4)));
                bonusMapper.insertBonus(bonus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * 按月份获取所有的奖金或补贴
     * @param tag 奖金或补贴
     * @return
     */
    @Override
    public Double queryBonusNumOrderByMonth(String tag) {
        return bonusMapper.queryBonusNumOrderByMonth(tag);
    }
}
