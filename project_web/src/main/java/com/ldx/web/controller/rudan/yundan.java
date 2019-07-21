package com.ldx.web.controller.rudan;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.invoice;
import com.ldx.domain.export.invoiceExample;
import com.ldx.web.controller.system.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rudan/yundan")
@Transactional
public class yundan extends BaseController {



    @Autowired
    private com.ldx.dao.export.invoiceDao invoiceDao;


    //处理数据 添加运单号
    @RequestMapping("/work")
    public String work(String text){

        //联邦-FBA123456-1
        //联邦-FBA123456-12
        //联邦-FBA123456-123
        //联邦-FBA123456-1234
        //联邦-FBA123456-12345
        //联邦-FBA123456-1
        //联邦-FBA123456-12
        //联邦-FBA123456-123

        //  \r\n
        String[] split = text.split("\\r\\n");
        for (String s : split) {
            String[] split1 = s.split("-");
            invoice invoice = new invoice();
            invoice.setFbaId(split1[1]);
            invoice.setQueryId(split1[0]+"-"+split1[2]);
            invoiceExample invoiceExample = new invoiceExample();
            invoiceExample.createCriteria().andFbaIdEqualTo(invoice.getFbaId());
            invoiceDao.updateByExampleSelective(invoice,invoiceExample);
        }
        return "home/home";
    }




    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size) {

            return "rudan/yundan-list";
        }
    }
