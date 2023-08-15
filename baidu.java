package wlx.restful;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.Test;

public class baidu {
	
	public static void main(String[] args) {
		baidu wlx = new baidu();
		wlx.getLatitude();
	}
	
	//返回输入地址的经纬度坐标 key lng(经度),lat(纬度)
	@Test
	public void getLatitude() {
		String address = "南京 南京航空大学将军路校区";
		try {
			// 将地址转换成utf-8的16进制
			address = URLEncoder.encode(address, "UTF-8");
 
			URL resjson = new URL("http://api.map.baidu.com/geocoder?address="
					+ address + "&output=json&key=" + "111");
			//存储从URL获取的内容
			BufferedReader in = new BufferedReader(new InputStreamReader(
					resjson.openStream()));
			String res;
			StringBuilder sb = new StringBuilder("");
			while ((res = in.readLine()) != null) {
				sb.append(res.trim());
			}
			in.close();
			String str = sb.toString();
			// 读取经纬度以及结束标记
			if(str!=null&&!str.equals("")){
				int lngStart = str.indexOf("lng\":");
				int lngEnd = str.indexOf(",\"lat");
				int latEnd = str.indexOf("},\"precise");
				if (lngStart > 0 && lngEnd > 0 && latEnd > 0) {
					String lng = str.substring(lngStart + 5, lngEnd);
					String lat = str.substring(lngEnd + 7, latEnd);
					System.out.println(lng + "," + lat);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
