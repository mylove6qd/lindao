package com.ldx.web.controller.rudan;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.domain.export.invoice;
import com.ldx.domain.export.invoiceExample;
import com.ldx.utils.BarcodeUtil;
import com.ldx.utils.DownloadUtil;
import com.ldx.utils.PoiFill;
import com.ldx.web.controller.chaxun.huojian;
import com.ldx.web.controller.system.BaseController;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;

import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/rudan/fapiao")
@Transactional
public class fapiao extends BaseController {



    @Autowired
    private com.ldx.dao.export.invoiceDao invoiceDao;



    //提供下载
    @RequestMapping("/work")
    public String work(String invoiceId) throws IOException {

        invoice invoice = invoiceDao.selectByPrimaryKey(invoiceId);

        String msg = invoice.getFbaId();


        String contextPath = session.getServletContext().getRealPath("");

        File file = BarcodeUtil.generateFile(msg, contextPath+"\\a.png");


        // 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        //将图片读到BufferedImage
        BufferedImage bufferImg = ImageIO.read(file);

        ImageIO.write(bufferImg, "png", byteArrayOut);



        //文件名  FBA15FPMDPBM 美国 FBA 2 箱 泉州仓 林道(1).xlsx
        InputStream resourceAsStream = huojian.class.getClassLoader().getResourceAsStream("fapiao/fapiaoTest.xlsx");

        //模板地址生成类核心类
        PoiFill poiFill = new PoiFill(resourceAsStream);
        poiFill.setSheet(0);
        poiFill.fillStringData(1,2,invoice.getFbaId())
                .fillStringData(2,0,invoice.getRemark())
                .addStringData(4,0,invoice.getInvoiceFromCompany())
                .addStringData(13,0,"亚马逊仓库(warehouse of Amazon)")
                .addStringData(14,0,invoice.getToAdress());
        XSSFWorkbook workbook = poiFill.getWorkbook();


        // 利用HSSFPatriarch将图片写入EXCEL
        XSSFSheet sheet = poiFill.getSheet();
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();


        /**
         * 该构造函数有8个参数
         * 前四个参数是控制图片在单元格的位置，分别是图片距离单元格left，top，right，bottom的像素距离
         * 后四个参数，前连个表示图片左上角所在的cellNum和 rowNum，后天个参数对应的表示图片右下角所在的cellNum和 rowNum，
         * excel中的cellNum和rowNum的index都是从0开始的
         *
         */
        //图片一导出到单元格B2中
        XSSFClientAnchor anchor = new XSSFClientAnchor(5, 5, 5, 5,
                (short) 0, 3, (short) 1, 4);
        // 插入图片
        patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut
                .toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));


        //3.下载
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        workbook.write(baos); //将excel内容写入到baos中
        new DownloadUtil().download(baos,response,invoice.getFbaId()+invoice.getRemark()+".xlsx");
        invoice.setUserId("发票已下载打印");
        invoiceDao.updateByPrimaryKeySelective(invoice);


        file.delete();
        return "rudan/fapiao-list";
    }




    @RequestMapping("/list")
    public String list(@Param("query") String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size) {


        invoiceExample invoiceExample = new invoiceExample();
        com.ldx.domain.export.invoiceExample.Criteria criteria = invoiceExample.createCriteria();

        if (!StringUtils.isEmpty(query)) {
            //入仓数据(总重量 总体积)是空或者null
            criteria.andFbaIdLike("%" + query + "%");
            invoiceExample.setOrderByClause("`date` DESC");

            PageHelper.startPage(page, size);
            List<invoice> invoices = invoiceDao.selectByExample(invoiceExample);
            PageInfo<invoice> invoicePageInfo = new PageInfo<>(invoices);

            session.setAttribute("", invoicePageInfo);
            request.setAttribute("page", invoicePageInfo);
            request.setAttribute("query", query);

            return "rudan/fapiao-list";

        } else {
            criteria.andUserIdIsNull();
            invoiceExample.setOrderByClause("`date` DESC");

            PageHelper.startPage(page, size);
            List<invoice> invoices = invoiceDao.selectByExample(invoiceExample);
            PageInfo<invoice> invoicePageInfo = new PageInfo<>(invoices);

            session.setAttribute("", invoicePageInfo);
            request.setAttribute("page", invoicePageInfo);
            request.setAttribute("query", query);

            return "rudan/fapiao-list";
        }
    }
}
