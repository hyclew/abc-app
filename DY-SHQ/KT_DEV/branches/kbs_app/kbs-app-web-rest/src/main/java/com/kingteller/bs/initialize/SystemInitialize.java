package com.kingteller.bs.initialize;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.product.ProductCatalogue;
import com.kingteller.bs.framework.exception.AppException;
import com.kingteller.bs.framework.properties.InitializeProperties;
import com.kingteller.bs.service.CustomerOrderService;
import com.kingteller.bs.service.ProductCatalogueService;
import com.kingteller.bs.service.impl.CustomerOrderServiceImpl;

/**
 * 系统启动时的初始化参数
 * @author wangyafei
 *
 */
@Component("systemInitialize")
public class SystemInitialize implements
		ApplicationListener<ContextRefreshedEvent> {

	private static Logger logger = Logger.getLogger(SystemInitialize.class);

	@Autowired
	private ProductCatalogueService productCatalogueService;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initProductCatalogSerialize();
		initPropertiesFile();
	}

	private void initProductCatalogSerialize() {
		List<ProductCatalogue> productCatalogues = null;
		try {
			// 先更新数据库的序列号
			logger.info("<------------开始更新商品类别序列------------>");
			productCatalogues = this.productCatalogueService
					.updateProductCatalogSerialize();
			for (ProductCatalogue productCatalogue : productCatalogues) {
				Long serialize = productCatalogue.getSerialize();
				String code = productCatalogue.getCode();
				//如果序列超过8位数，则将此序列置1000重新开始
				if(serialize > 99999000){
					logger.info("获取到Code为 " + code + " 的商品类别的序列是 " + serialize);
					productCatalogue = this.productCatalogueService.resetSerialize(productCatalogue);
					serialize = productCatalogue.getSerialize();
					code = productCatalogue.getCode();
				}
				CustomerOrderServiceImpl.getNumberSerialize().put(code,
						new AtomicLong(serialize));
			}
			logger.info("商品类别序列加载完成" + CustomerOrderServiceImpl.getNumberSerialize());
		} catch (AppException ae) {
			logger.error("", ae);
			ae.printStackTrace();
		} catch (Exception e) {
			logger.error("加载商品类别序列出现异常,异常信息为:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 将系统配置文件中的属性加载到内存
	 */
	private void initPropertiesFile(){
		logger.info("开始加载系统初始化参数...");
		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("system_property.properties");
			Properties pro = new Properties();
			pro.load(is);
			@SuppressWarnings("unchecked")
			Enumeration<String> propertyNames = (Enumeration<String>) pro.propertyNames();
			while(propertyNames.hasMoreElements()){
				String key = propertyNames.nextElement();
				String value = (String) pro.get(key);
				InitializeProperties.putProperty(key, value);
			}
			logger.info("加载系统初始化参数结束,参数为:" + InitializeProperties.getProperties());
		} catch (Exception e) {
			logger.error("初始化配置文件异常,异常信息是:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
	}
	
	
	
}
