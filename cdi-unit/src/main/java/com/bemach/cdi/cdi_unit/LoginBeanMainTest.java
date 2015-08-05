package com.bemach.cdi.cdi_unit;

import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;

public class LoginBeanMainTest {
	private CdiContainer cdiContainer;
    private LoginBean loginBean;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    public void initBeanManager() {
        // this will give you a CdiContainer for Weld or OWB, depending on the jar you added
        cdiContainer = CdiContainerLoader.getCdiContainer();

        // now we gonna boot the CDI container. This will trigger the classpath scan, etc
        cdiContainer.boot();

        BeanManager beanManager = cdiContainer.getBeanManager();

        Set<Bean<?>> beans = beanManager.getBeans(LoginBean.class);
        Bean<?> bean = beanManager.resolve(beans);

        loginBean = (LoginBean) beanManager.getReference(bean, LoginBean.class, beanManager.createCreationalContext(bean));
    }

    public void closeBeanManager() {
        cdiContainer.shutdown();
    }
    
    public static void main (String[] args) {
    	LoginBeanMainTest main = new LoginBeanMainTest();
    	main.initBeanManager();
    	System.out.println("Testing ....");
    	main.closeBeanManager();
    }
}
