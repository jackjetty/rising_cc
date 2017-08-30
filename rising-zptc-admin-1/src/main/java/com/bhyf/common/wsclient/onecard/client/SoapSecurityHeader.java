package com.bhyf.common.wsclient.onecard.client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import com.bhyf.common.wsclient.onecard.SecurityHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.phase.Phase;


/**
 * 
 * <p>Title : SoapSecurityHeader</p>
 * <p>Description : 认证头对象 </p>
 * <p>Company : 杭州冉思科技有限公司</p>
 * @author : caoyang
 * @date : 2016年4月14日 下午2:09:02
 */
public class SoapSecurityHeader extends AbstractSoapInterceptor {
	
	private SecurityHeader securityHeader;

	public SoapSecurityHeader() {
		super(Phase.WRITE);
		addAfter(SoapPreProtocolOutInterceptor.class.getName());

	}

	public SecurityHeader getSecurityHeader() {
		return securityHeader;
	}

	public void setSecurityHeader(SecurityHeader securityHeader) {
		this.securityHeader = securityHeader;
	}
	
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		System.out.println("AddSoapSecurityHeader handleMessage invoked");

		List<Header> headers = new ArrayList<Header>();
		try {
			Header dummyHeader = new Header(new QName("http://www.hzsun.com/",
					"SecurityHeader"), securityHeader, new JAXBDataBinding(
					SecurityHeader.class));
			headers.add(dummyHeader);
			message.put(Header.HEADER_LIST, headers);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	

}
