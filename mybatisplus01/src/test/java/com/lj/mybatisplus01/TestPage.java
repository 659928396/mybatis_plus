package com.lj.mybatisplus01;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lj.mybatisplus01.entity.MpUser;
import com.lj.mybatisplus01.service.MpUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestPage {
    @Autowired
    private MpUserService mpUserService;
    @Test
    public void testPage() {
        // Step1：创建一个 Page 对象
        //Page<MpUser> page = new Page<>();
        Page<MpUser> page = new Page<>(2, 5);
        // Step2：调用 mybatis-plus 提供的分页查询方法
        mpUserService.page(page, null);
        // Step3：获取分页数据
        System.out.println(page.getCurrent()); // 获取当前页
        System.out.println(page.getTotal()); // 获取总记录数
        System.out.println(page.getSize()); // 获取每页的条数
        System.out.println(page.getRecords()); // 获取每页数据的集合
        System.out.println(page.getPages()); // 获取总页数
        System.out.println(page.hasNext()); // 是否存在下一页
        System.out.println(page.hasPrevious()); // 是否存在上一页
    }
}
