package com.mx.api.application.gis.model;

import java.math.BigDecimal;
import java.util.List;

public class Gis {
    private String sbId;
    private String ccbh;
    private String sblx;
    private String cqh;
    private String bhId;
    private String ywbs;
    private String cjbs;
    private String zhcq;
    private String xzqh;
    private String cwm;
    private String cwnr;
    private String sjnr;
    private String qyfw;
    private String gnxflx;
    private String status;
    private String count;
    private String sbmc;
    private String ddldzt;
    private String sjczbs;
    private String ddjdyxzt;
    private String ddjdycbz;
    private String ddjdyxzttjsj;
    private String Ddjdsjycbz;
    private String Ddjddlycbz;
    private String Ddjddyycbz;
    private String Ddjdglycbz;
    private String ddkzqbh;
    private String ddzcbh;
    private BigDecimal lng;
    private BigDecimal lat;
    private BigDecimal lng1BigDecimal;
    private BigDecimal lat1BigDecimal;
    private BigDecimal lng2BigDecimal;
    private BigDecimal lat2BigDecimal;
    private String cqsbzs;
    private String cqycsbzs;
    private String ldsbzs;
    private String wldsbzs;
    private String zhcqmc;
    private String zhcqjc;
    private String sunrise;
    private String sunset;
    private String lightOpen;
    private String lightClose;
    private String eventLevel;
    private String fssj;
    private String sjms;
    private String sjdd;
    private String jd;
    private String wd;
    private String yjbs;
    private String flag;
    private String sblxName;
    private String normal;//正常
    private String lose;//失联
    private String offLine;//离线
    private String fault;//告警
    private String other;//其他
    private String unknow;//未知
    private String fire;//起火
    private String dump;//倾倒
    private String overflow;//溢满
    private String lowPower;//点亮低
    private String filePath;
    private String fileId;
    private String picHead;
    private String azwz;
    private String systemId;
    private String dmflbz;
    private String xmbh;
    private String xmmc;
    private String fileType;
    private String xgrq;
    private Integer xsxh;//显示序号
    private String czrmc;
    private String title;
    private String urlData;
    private String occupationRatio;//设备占比
    private String numCount;//安装设备总数
    private String cjCount;//采集数
    private String cszlssCount;//城市治理（设施）
    private String csyyzsCount;//城市运营总数
    private String csglzxCount;//城市管理专项
    private String csglOtherCount;//城市管理其他
    private String cszlSysStr;//城市治理（设施）系统id
    private String cszlSblxStr;//城市治理（设施）设备类型
    private String csyySysStr;//城市运营总数系统id
    private String csyySblxStr;//城市运营设备类型
    private String csglzxSysStr;//城市管理专项系统id
    private String csglzxSblxStr;//城市管理专项设备类型
    private String csglqtSysStr;//城市管理其他系统id
    private String csglqtSblxStr;//城市管理其他设备类型
    private List<Object> infoList;
    private String[] systemArr;
    private String[] sblxArr;
    private String date;//日期
    private Integer index;
    private Integer blueCount;//蓝色警告数
    private Integer yellowCount;//黄色警告数
    private Integer orangeCount;//橙色警告数
    private Integer redCount;//红色警告数
    private String blueRatio;//蓝色警告占比
    private String yellowRatio;//黄色警告占比
    private String orangeRatio;//橙色警告占比
    private String redRatio;//红色警告占比
    private String completionCount;//处理完成
    private String waitingCount;//等待处理
    private String noNeedDeal;//无需处理
    private String month;//每月的预警数（一年）
    private String day;//每天的预警数（一月）
    private String hour;//每时的预警数（一天）
    private String current;
    private String floor;//楼层类型
    private String type;//楼层类型
    private String name;//楼层名称
    private String electricRatio;//电能表总功率
    private String leftSide;//写字楼定位
    private String top;//写字楼定位
    private String sbzsxs;//设备展示形式：1基于Gis，2基于图片
    private String pmtId;//平面图id
    private String pts;//写字楼设备定位
    private String camerLogin;//摄像头登录信息
    private String cqlx;//城区类型
    private String cd;//尺寸宽
    private String kd;//尺寸高
    private String jlrs;//当前积累人数
    private String xzrs;//新增人数
    private String rjrlmd;//日平均人流密度
    private String fzsj;//峰值时间
    private String fzrs;//峰值
    private String power;//功率
    private String energy;//电能
    private String electricity;//电流
    private String voltage;//电压
    private String powerFactor;//功率因数
    private String pch;//批次号
    private String hlh;//回路号
    private String zcbh;//资产编号
    private String cqdw;//产权单位
    private String gldw;//管理单位
    private String today;
    private String yesterday;
    private Integer maxValue;
    private Integer minValue;
    private String ldbId;
    private String ldbmc;

    public String getCqh() {
        return cqh;
    }
    public void setCqh(String cqh) {
        this.cqh = cqh;
    }
    public String getBhId() {
        return bhId;
    }
    public void setBhId(String bhId) {
        this.bhId = bhId;
    }
    public String getSbId() {
        return sbId;
    }
    public void setSbId(String sbId) {
        this.sbId = sbId;
    }
    public String getCcbh() {
        return ccbh;
    }
    public void setCcbh(String ccbh) {
        this.ccbh = ccbh;
    }
    public String getSblx() {
        return sblx;
    }
    public void setSblx(String sblx) {
        this.sblx = sblx;
    }
    public String getYwbs() {
        return ywbs;
    }
    public void setYwbs(String ywbs) {
        this.ywbs = ywbs;
    }
    public String getCjbs() {
        return cjbs;
    }
    public void setCjbs(String cjbs) {
        this.cjbs = cjbs;
    }
    public String getZhcq() {
        return zhcq;
    }
    public void setZhcq(String zhcq) {
        this.zhcq = zhcq;
    }
    public String getXzqh() {
        return xzqh;
    }
    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }
    public String getCwm() {
        return cwm;
    }
    public void setCwm(String cwm) {
        this.cwm = cwm;
    }
    public String getCwnr() {
        return cwnr;
    }
    public void setCwnr(String cwnr) {
        this.cwnr = cwnr;
    }
    public String getSjnr() {
        return sjnr;
    }
    public void setSjnr(String sjnr) {
        this.sjnr = sjnr;
    }
    public String getQyfw() {
        return qyfw;
    }
    public void setQyfw(String qyfw) {
        this.qyfw = qyfw;
    }
    public String getGnxflx() {
        return gnxflx;
    }
    public void setGnxflx(String gnxflx) {
        this.gnxflx = gnxflx;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getSbmc() {
        return sbmc;
    }
    public void setSbmc(String sbmc) {
        this.sbmc = sbmc;
    }
    public String getDdldzt() {
        return ddldzt;
    }
    public void setDdldzt(String ddldzt) {
        this.ddldzt = ddldzt;
    }
    public String getSjczbs() {
        return sjczbs;
    }
    public void setSjczbs(String sjczbs) {
        this.sjczbs = sjczbs;
    }
    public String getDdjdyxzt() {
        return ddjdyxzt;
    }
    public void setDdjdyxzt(String ddjdyxzt) {
        this.ddjdyxzt = ddjdyxzt;
    }
    public String getDdjdycbz() {
        return ddjdycbz;
    }
    public void setDdjdycbz(String ddjdycbz) {
        this.ddjdycbz = ddjdycbz;
    }
    public String getDdjdyxzttjsj() {
        return ddjdyxzttjsj;
    }
    public void setDdjdyxzttjsj(String ddjdyxzttjsj) {
        this.ddjdyxzttjsj = ddjdyxzttjsj;
    }
    public String getDdjdsjycbz() {
        return Ddjdsjycbz;
    }
    public void setDdjdsjycbz(String ddjdsjycbz) {
        Ddjdsjycbz = ddjdsjycbz;
    }
    public String getDdjddlycbz() {
        return Ddjddlycbz;
    }
    public void setDdjddlycbz(String ddjddlycbz) {
        Ddjddlycbz = ddjddlycbz;
    }
    public String getDdjddyycbz() {
        return Ddjddyycbz;
    }
    public void setDdjddyycbz(String ddjddyycbz) {
        Ddjddyycbz = ddjddyycbz;
    }
    public String getDdjdglycbz() {
        return Ddjdglycbz;
    }
    public void setDdjdglycbz(String ddjdglycbz) {
        Ddjdglycbz = ddjdglycbz;
    }
    public String getDdkzqbh() {
        return ddkzqbh;
    }
    public void setDdkzqbh(String ddkzqbh) {
        this.ddkzqbh = ddkzqbh;
    }
    public String getDdzcbh() {
        return ddzcbh;
    }
    public void setDdzcbh(String ddzcbh) {
        this.ddzcbh = ddzcbh;
    }
    public BigDecimal getLng() {
        return lng;
    }
    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }
    public BigDecimal getLat() {
        return lat;
    }
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
    public BigDecimal getLng1BigDecimal() {
        return lng1BigDecimal;
    }
    public void setLng1BigDecimal(BigDecimal lng1BigDecimal) {
        this.lng1BigDecimal = lng1BigDecimal;
    }
    public BigDecimal getLat1BigDecimal() {
        return lat1BigDecimal;
    }
    public void setLat1BigDecimal(BigDecimal lat1BigDecimal) {
        this.lat1BigDecimal = lat1BigDecimal;
    }
    public BigDecimal getLng2BigDecimal() {
        return lng2BigDecimal;
    }
    public void setLng2BigDecimal(BigDecimal lng2BigDecimal) {
        this.lng2BigDecimal = lng2BigDecimal;
    }
    public BigDecimal getLat2BigDecimal() {
        return lat2BigDecimal;
    }
    public void setLat2BigDecimal(BigDecimal lat2BigDecimal) {
        this.lat2BigDecimal = lat2BigDecimal;
    }
    public String getCqsbzs() {
        return cqsbzs;
    }
    public void setCqsbzs(String cqsbzs) {
        this.cqsbzs = cqsbzs;
    }
    public String getCqycsbzs() {
        return cqycsbzs;
    }
    public void setCqycsbzs(String cqycsbzs) {
        this.cqycsbzs = cqycsbzs;
    }
    public String getLdsbzs() {
        return ldsbzs;
    }
    public void setLdsbzs(String ldsbzs) {
        this.ldsbzs = ldsbzs;
    }
    public String getWldsbzs() {
        return wldsbzs;
    }
    public void setWldsbzs(String wldsbzs) {
        this.wldsbzs = wldsbzs;
    }
    public String getZhcqmc() {
        return zhcqmc;
    }
    public void setZhcqmc(String zhcqmc) {
        this.zhcqmc = zhcqmc;
    }
    public String getZhcqjc() {
        return zhcqjc;
    }
    public void setZhcqjc(String zhcqjc) {
        this.zhcqjc = zhcqjc;
    }
    public String getSunrise() {
        return sunrise;
    }
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
    public String getSunset() {
        return sunset;
    }
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    public String getLightOpen() {
        return lightOpen;
    }
    public void setLightOpen(String lightOpen) {
        this.lightOpen = lightOpen;
    }
    public String getLightClose() {
        return lightClose;
    }
    public void setLightClose(String lightClose) {
        this.lightClose = lightClose;
    }
    public String getEventLevel() {
        return eventLevel;
    }
    public void setEventLevel(String eventLevel) {
        this.eventLevel = eventLevel;
    }
    public String getFssj() {
        return fssj;
    }
    public void setFssj(String fssj) {
        this.fssj = fssj;
    }
    public String getSjms() {
        return sjms;
    }
    public void setSjms(String sjms) {
        this.sjms = sjms;
    }
    public String getSjdd() {
        return sjdd;
    }
    public void setSjdd(String sjdd) {
        this.sjdd = sjdd;
    }
    public String getJd() {
        return jd;
    }
    public void setJd(String jd) {
        this.jd = jd;
    }
    public String getWd() {
        return wd;
    }
    public void setWd(String wd) {
        this.wd = wd;
    }
    public String getYjbs() {
        return yjbs;
    }
    public void setYjbs(String yjbs) {
        this.yjbs = yjbs;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public String getSblxName() {
        return sblxName;
    }
    public void setSblxName(String sblxName) {
        this.sblxName = sblxName;
    }
    public String getNormal() {
        return normal;
    }
    public void setNormal(String normal) {
        this.normal = normal;
    }
    public String getLose() {
        return lose;
    }
    public void setLose(String lose) {
        this.lose = lose;
    }
    public String getOffLine() {
        return offLine;
    }
    public void setOffLine(String offLine) {
        this.offLine = offLine;
    }
    public String getFault() {
        return fault;
    }
    public void setFault(String fault) {
        this.fault = fault;
    }
    public String getOther() {
        return other;
    }
    public void setOther(String other) {
        this.other = other;
    }
    public String getUnknow() {
        return unknow;
    }
    public void setUnknow(String unknow) {
        this.unknow = unknow;
    }
    public String getFire() {
        return fire;
    }
    public void setFire(String fire) {
        this.fire = fire;
    }
    public String getDump() {
        return dump;
    }
    public void setDump(String dump) {
        this.dump = dump;
    }
    public String getOverflow() {
        return overflow;
    }
    public void setOverflow(String overflow) {
        this.overflow = overflow;
    }
    public String getLowPower() {
        return lowPower;
    }
    public void setLowPower(String lowPower) {
        this.lowPower = lowPower;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFileId() {
        return fileId;
    }
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
    public String getPicHead() {
        return picHead;
    }
    public void setPicHead(String picHead) {
        this.picHead = picHead;
    }
    public String getAzwz() {
        return azwz;
    }
    public void setAzwz(String azwz) {
        this.azwz = azwz;
    }
    public String getSystemId() {
        return systemId;
    }
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
    public String getDmflbz() {
        return dmflbz;
    }
    public void setDmflbz(String dmflbz) {
        this.dmflbz = dmflbz;
    }
    public String getXmbh() {
        return xmbh;
    }
    public void setXmbh(String xmbh) {
        this.xmbh = xmbh;
    }
    public String getXmmc() {
        return xmmc;
    }
    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public String getXgrq() {
        return xgrq;
    }
    public void setXgrq(String xgrq) {
        this.xgrq = xgrq;
    }
    public Integer getXsxh() {
        return xsxh;
    }
    public void setXsxh(Integer xsxh) {
        this.xsxh = xsxh;
    }
    public String getCzrmc() {
        return czrmc;
    }
    public void setCzrmc(String czrmc) {
        this.czrmc = czrmc;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrlData() {
        return urlData;
    }
    public void setUrlData(String urlData) {
        this.urlData = urlData;
    }
    public String getOccupationRatio() {
        return occupationRatio;
    }
    public void setOccupationRatio(String occupationRatio) {
        this.occupationRatio = occupationRatio;
    }
    public String getNumCount() {
        return numCount;
    }
    public void setNumCount(String numCount) {
        this.numCount = numCount;
    }
    public String getCjCount() {
        return cjCount;
    }
    public void setCjCount(String cjCount) {
        this.cjCount = cjCount;
    }
    public String getCszlssCount() {
        return cszlssCount;
    }
    public void setCszlssCount(String cszlssCount) {
        this.cszlssCount = cszlssCount;
    }
    public String getCsyyzsCount() {
        return csyyzsCount;
    }
    public void setCsyyzsCount(String csyyzsCount) {
        this.csyyzsCount = csyyzsCount;
    }
    public String getCsglzxCount() {
        return csglzxCount;
    }
    public void setCsglzxCount(String csglzxCount) {
        this.csglzxCount = csglzxCount;
    }
    public String getCsglOtherCount() {
        return csglOtherCount;
    }
    public void setCsglOtherCount(String csglOtherCount) {
        this.csglOtherCount = csglOtherCount;
    }
    public String getCszlSysStr() {
        return cszlSysStr;
    }
    public void setCszlSysStr(String cszlSysStr) {
        this.cszlSysStr = cszlSysStr;
    }
    public String getCszlSblxStr() {
        return cszlSblxStr;
    }
    public void setCszlSblxStr(String cszlSblxStr) {
        this.cszlSblxStr = cszlSblxStr;
    }
    public String getCsyySysStr() {
        return csyySysStr;
    }
    public void setCsyySysStr(String csyySysStr) {
        this.csyySysStr = csyySysStr;
    }
    public String getCsyySblxStr() {
        return csyySblxStr;
    }
    public void setCsyySblxStr(String csyySblxStr) {
        this.csyySblxStr = csyySblxStr;
    }
    public String getCsglzxSysStr() {
        return csglzxSysStr;
    }
    public void setCsglzxSysStr(String csglzxSysStr) {
        this.csglzxSysStr = csglzxSysStr;
    }
    public String getCsglzxSblxStr() {
        return csglzxSblxStr;
    }
    public void setCsglzxSblxStr(String csglzxSblxStr) {
        this.csglzxSblxStr = csglzxSblxStr;
    }
    public String getCsglqtSysStr() {
        return csglqtSysStr;
    }
    public void setCsglqtSysStr(String csglqtSysStr) {
        this.csglqtSysStr = csglqtSysStr;
    }
    public String getCsglqtSblxStr() {
        return csglqtSblxStr;
    }
    public void setCsglqtSblxStr(String csglqtSblxStr) {
        this.csglqtSblxStr = csglqtSblxStr;
    }
    public List<Object> getInfoList() {
        return infoList;
    }
    public void setInfoList(List<Object> infoList) {
        this.infoList = infoList;
    }
    public String[] getSystemArr() {
        return systemArr;
    }
    public void setSystemArr(String[] systemArr) {
        this.systemArr = systemArr;
    }
    public String[] getSblxArr() {
        return sblxArr;
    }
    public void setSblxArr(String[] sblxArr) {
        this.sblxArr = sblxArr;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }
    public Integer getBlueCount() {
        return blueCount;
    }
    public void setBlueCount(Integer blueCount) {
        this.blueCount = blueCount;
    }
    public Integer getYellowCount() {
        return yellowCount;
    }
    public void setYellowCount(Integer yellowCount) {
        this.yellowCount = yellowCount;
    }
    public Integer getOrangeCount() {
        return orangeCount;
    }
    public void setOrangeCount(Integer orangeCount) {
        this.orangeCount = orangeCount;
    }
    public Integer getRedCount() {
        return redCount;
    }
    public void setRedCount(Integer redCount) {
        this.redCount = redCount;
    }
    public String getBlueRatio() {
        return blueRatio;
    }
    public void setBlueRatio(String blueRatio) {
        this.blueRatio = blueRatio;
    }
    public String getYellowRatio() {
        return yellowRatio;
    }
    public void setYellowRatio(String yellowRatio) {
        this.yellowRatio = yellowRatio;
    }
    public String getOrangeRatio() {
        return orangeRatio;
    }
    public void setOrangeRatio(String orangeRatio) {
        this.orangeRatio = orangeRatio;
    }
    public String getRedRatio() {
        return redRatio;
    }
    public void setRedRatio(String redRatio) {
        this.redRatio = redRatio;
    }
    public String getCompletionCount() {
        return completionCount;
    }
    public void setCompletionCount(String completionCount) {
        this.completionCount = completionCount;
    }
    public String getWaitingCount() {
        return waitingCount;
    }
    public void setWaitingCount(String waitingCount) {
        this.waitingCount = waitingCount;
    }
    public String getNoNeedDeal() {
        return noNeedDeal;
    }
    public void setNoNeedDeal(String noNeedDeal) {
        this.noNeedDeal = noNeedDeal;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public String getHour() {
        return hour;
    }
    public void setHour(String hour) {
        this.hour = hour;
    }
    public String getCurrent() {
        return current;
    }
    public void setCurrent(String current) {
        this.current = current;
    }
    public String getFloor() {
        return floor;
    }
    public void setFloor(String floor) {
        this.floor = floor;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getElectricRatio() {
        return electricRatio;
    }
    public void setElectricRatio(String electricRatio) {
        this.electricRatio = electricRatio;
    }
    public String getLeftSide() {
        return leftSide;
    }
    public void setLeftSide(String leftSide) {
        this.leftSide = leftSide;
    }
    public String getTop() {
        return top;
    }
    public void setTop(String top) {
        this.top = top;
    }
    public String getSbzsxs() {
        return sbzsxs;
    }
    public void setSbzsxs(String sbzsxs) {
        this.sbzsxs = sbzsxs;
    }
    public String getPmtId() {
        return pmtId;
    }
    public void setPmtId(String pmtId) {
        this.pmtId = pmtId;
    }
    public String getPts() {
        return pts;
    }
    public void setPts(String pts) {
        this.pts = pts;
    }
    public String getCamerLogin() {
        return camerLogin;
    }
    public void setCamerLogin(String camerLogin) {
        this.camerLogin = camerLogin;
    }
    public String getCqlx() {
        return cqlx;
    }
    public void setCqlx(String cqlx) {
        this.cqlx = cqlx;
    }
    public String getCd() {
        return cd;
    }
    public void setCd(String cd) {
        this.cd = cd;
    }
    public String getKd() {
        return kd;
    }
    public void setKd(String kd) {
        this.kd = kd;
    }
    public String getJlrs() {
        return jlrs;
    }
    public void setJlrs(String jlrs) {
        this.jlrs = jlrs;
    }
    public String getXzrs() {
        return xzrs;
    }
    public void setXzrs(String xzrs) {
        this.xzrs = xzrs;
    }
    public String getRjrlmd() {
        return rjrlmd;
    }
    public void setRjrlmd(String rjrlmd) {
        this.rjrlmd = rjrlmd;
    }
    public String getFzsj() {
        return fzsj;
    }
    public void setFzsj(String fzsj) {
        this.fzsj = fzsj;
    }
    public String getFzrs() {
        return fzrs;
    }
    public void setFzrs(String fzrs) {
        this.fzrs = fzrs;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public String getEnergy() {
        return energy;
    }
    public void setEnergy(String energy) {
        this.energy = energy;
    }
    public String getElectricity() {
        return electricity;
    }
    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }
    public String getVoltage() {
        return voltage;
    }
    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }
    public String getPowerFactor() {
        return powerFactor;
    }
    public void setPowerFactor(String powerFactor) {
        this.powerFactor = powerFactor;
    }
    public String getPch() {
        return pch;
    }
    public void setPch(String pch) {
        this.pch = pch;
    }
    public String getHlh() {
        return hlh;
    }
    public void setHlh(String hlh) {
        this.hlh = hlh;
    }
    public String getZcbh() {
        return zcbh;
    }
    public void setZcbh(String zcbh) {
        this.zcbh = zcbh;
    }
    public String getCqdw() {
        return cqdw;
    }
    public void setCqdw(String cqdw) {
        this.cqdw = cqdw;
    }
    public String getGldw() {
        return gldw;
    }
    public void setGldw(String gldw) {
        this.gldw = gldw;
    }
    public String getToday() {
        return today;
    }
    public void setToday(String today) {
        this.today = today;
    }
    public String getYesterday() {
        return yesterday;
    }
    public void setYesterday(String yesterday) {
        this.yesterday = yesterday;
    }
    public Integer getMaxValue() {
        return maxValue;
    }
    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }
    public Integer getMinValue() {
        return minValue;
    }
    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }
    public String getLdbId() {
        return ldbId;
    }
    public void setLdbId(String ldbId) {
        this.ldbId = ldbId;
    }
    public String getLdbmc() {
        return ldbmc;
    }
    public void setLdbmc(String ldbmc) {
        this.ldbmc = ldbmc;
    }
}
