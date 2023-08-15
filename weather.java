package wlx.soap;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.hutool.http.webservice.SoapClient;

public class weather {

	@Test
	public void testGetWeather() {
		String wsdlUrl = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl";
        String cityCode = "广州";
        String userID = "11111111111111111111";

        // 创建soap客户端
        SoapClient soapClient = SoapClient.create(wsdlUrl);
        // 设置要请求的方法名称，并传入对应的命名空间
        soapClient.setMethod("getWeather","http://WebXml.com.cn/");
        // 设置参数名称及参数值
        soapClient.setParam("theCityCode",cityCode);
        soapClient.setParam("theUserID",userID);

        // 发送请求，参数true表示返回一个格式化后的XML内容
        String res = soapClient.send(true);
        // 打印
        System.out.println(res);
	}

}
