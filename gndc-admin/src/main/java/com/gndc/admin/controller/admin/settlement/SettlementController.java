/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.controller.admin.settlement;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.admin.service.settlement.SettlementService;
import com.gndc.admin.util.FileNameUtil;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.admin.settlement.SettlementRecordInfoRequest;
import com.gndc.common.api.admin.settlement.SettlementReportRequest;
import com.gndc.common.dto.SettlementRecordInfoDTO;
import com.gndc.common.dto.SettlementReportDetailDTO;
import com.gndc.common.enums.product.SettlementModeEnum;
import com.gndc.common.model.Settlement;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/5/5  10:37
 */
@RestController
@RequestMapping("/settlement")
public class SettlementController {


    @Autowired
    private SettlementService settlementService;

    private final static String[] MONTHS=new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};

    @PostMapping("/getReportStatisticsData")
    public ResponseMessage getReportStatisticsData(@RequestBody @Validated SettlementReportRequest request){
        Map<String,Object> data=new HashMap<>();
        List<Object> feeList=new ArrayList<>();
        for (int i=0;i<MONTHS.length;i++){
            String month = MONTHS[i];
            String time = request.getYear() +"-"+ month;
            List<Settlement> settlementList = settlementService.sumFeeByCreateTimeGroupSettlementMode(time);
            List<Map<String,String>> feeData=new ArrayList<Map<String, String>>();
            settlementList.forEach(x->{
                Map<String,String> feeMap=new HashMap<>();
                feeMap.put(x.getSettlementMode().toString(),x.getFee().toString());
                feeData.add(feeMap);
            });
            feeList.add(feeData);
        }
        data.put("data",feeList);
        data.put("month",MONTHS);
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setData(data);
        return responseMessage;
    }


    @PostMapping("/getReportStatisticsDetail")
    public ResponseMessage getReportStatisticsDetail(@RequestBody @Validated SettlementReportRequest request){
        List<SettlementReportDetailDTO> data=new ArrayList<>();
        SettlementReportDetailDTO total=new SettlementReportDetailDTO();
        total.setMoth("总计");
        for (int i=0;i<MONTHS.length;i++){
            String month = MONTHS[i];
            String time = request.getYear() +"-"+ month;
            List<Settlement> settlementList = settlementService.sumFeeByCreateTimeGroupSettlementMode(time);
            Integer count = settlementService.countByCreateTime(time);

            SettlementReportDetailDTO settlementReportDetailDTO=new SettlementReportDetailDTO();
            settlementList.forEach(x->{
                SettlementModeEnum settlementModeEnum = SettlementModeEnum.valueOfCode(x.getSettlementMode());
                switch (settlementModeEnum){
                    case UV    :  settlementReportDetailDTO.setUvFee(x.getFee());    total.setUvFee(total.getUvFee()!=null?total.getUvFee().add(x.getFee()):x.getFee());      break;
                    case CPA   :  settlementReportDetailDTO.setCpaFee(x.getFee());   total.setCpaFee(total.getCpaFee()!=null?total.getCpaFee().add(x.getFee()):x.getFee());   break;
                    case CPS   :  settlementReportDetailDTO.setCpsFee(x.getFee());   total.setCpsFee(total.getCpsFee()!=null?total.getCpsFee().add(x.getFee()):x.getFee());   break;
                    default:break;
                }
            });
            total.setCount(total.getCount()!=null?(total.getCount()+count):count);
            settlementReportDetailDTO.setCount(count);
            settlementReportDetailDTO.setMoth(month);
            data.add(settlementReportDetailDTO);
        }
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setData(data);
        return responseMessage;
    }

    @PostMapping("/selectRecordInfoPage")
    public ResponseMessage selectRecordInfoPage(@RequestBody @Validated SettlementRecordInfoRequest request){
        ResponseMessage responseMessage=new ResponseMessage();

        PageHelper.startPage(request.getPageNum(),request.getPageSize());
        List<SettlementRecordInfoDTO>  data = settlementService.selectRecordInfoPage(request);
        PageInfo<SettlementRecordInfoDTO> pageInfo=new PageInfo<SettlementRecordInfoDTO>(data);

        responseMessage.setData(data);
        responseMessage.setPage(pageInfo);
        return responseMessage;
    }

    @PostMapping("/exportExcel")
    public void exportExcel(@RequestBody @Validated SettlementRecordInfoRequest settlementRecordInfoRequest, HttpServletRequest request,
                            HttpServletResponse response) throws Exception{

        List<SettlementRecordInfoDTO>  data = settlementService.selectRecordInfoPage(settlementRecordInfoRequest);

        Workbook wb = generateExcel(data);

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + FileNameUtil.processFileName(request, "结算详情.xls"));
        OutputStream os = response.getOutputStream();
        wb.write(os);
    }


    private Workbook generateExcel(List<SettlementRecordInfoDTO> data){
        Workbook wb = new HSSFWorkbook();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        wb.createSheet("结算详情");
        Sheet sheet = wb.getSheetAt(0);
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("序号");
        titleRow.createCell(1).setCellValue("结算时间");
        titleRow.createCell(2).setCellValue("用户姓名");
        titleRow.createCell(3).setCellValue("用户手机号");
        titleRow.createCell(4).setCellValue("产品名称");
        titleRow.createCell(5).setCellValue("机构名称");
        titleRow.createCell(6).setCellValue("结算价格");
        titleRow.createCell(7).setCellValue("计费模式");
        titleRow.createCell(8).setCellValue("备注");

        for(int i=0;i<data.size();i++){
            SettlementRecordInfoDTO dto = data.get(i);
            Row row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(i+1);
            row.createCell(1).setCellValue(DateUtil.format(dto.getSettlementTime(), "yyyy-MM-dd HH:mm:ss"));
            row.createCell(2).setCellValue(dto.getFirstName()+"."+dto.getMiddleName()+"."+dto.getLastName());
            row.createCell(3).setCellValue(dto.getPhone());
            row.createCell(4).setCellValue(dto.getProductName());
            row.createCell(5).setCellValue(dto.getPartnerName());
            row.createCell(6).setCellValue(dto.getFee().doubleValue());
            row.createCell(7).setCellValue(dto.getSettlementMode());
            row.createCell(8).setCellValue(dto.getRemarks());
        }
        return wb;
    }

}
