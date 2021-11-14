package controller.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.message.MessageVO;
import net.nurigo.java_sdk.api.Message;

@Controller
public class SMSController {
	
	@RequestMapping("/sendSMS.do")
	public String sendSMS(MessageVO vo,HttpServletRequest request,PrintWriter out,HttpSession session) {
		String callNum=request.getParameter("callNum");
		
		Random rand=new Random();
		int randNum=rand.nextInt();
		if(randNum<0) {
			randNum=randNum*-1;
		}
		String randStr=Integer.toString(randNum);
		System.out.println("rand: "+randNum);
		String smsMsg="[HJ Art Gallery] ������ȣ ["+randStr+"]";
		Message sms=new Message(vo.getApiKey(),vo.getApiSecret());
		System.out.println("callNum: "+callNum);
		System.out.println("smsMsg: "+smsMsg);
		HashMap<String,String> msg=new HashMap<String,String>();
		msg.put("to", callNum); // ���Ź�ȣ
		msg.put("from", "01051718893"); // �߽Ź�ȣ
		msg.put("type", "SMS"); // �߼�Ÿ��
		msg.put("text", smsMsg); // �߼۳���
		msg.put("app_version", "HJArtGallery app 1.3"); // ���� ����Ʈ�� �� ����
		
		try {
			JSONObject obj=(JSONObject)sms.send(msg);
			System.out.println(obj.toString());
			System.out.println("SMS Send Success");
		}catch(Exception e) {
			System.out.println("SMS Send Fail");
			e.printStackTrace();
		}
		out.print(randStr); // randStr
		return null;
	}
	
}
