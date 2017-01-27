package org.intro;

/* Java Bean design pattern */
class DesignPatternBean {
	private String designType;
	
	DesignPatternBean() {
	}
	
	public String getDesignPatternBean() {
		return designType;
	}
	
	public void setDesignPatternBean(String designType) {
		this.designType = designType;
	}
}



/* eager initialization */
class EagerSingletonObject {
	private static EagerSingletonObject instance = new EagerSingletonObject();
	
	private EagerSingletonObject() {
	}
	
	public static EagerSingletonObject getInstance() {
		return instance;
	}

	public String getDataBag() {
		return "Inside EagerSingletonObject";
	}
}

/* lazy initialization */
final class LazySingletonObject {
	private static LazySingletonObject instance = null;
	
	private LazySingletonObject() {
	}
	
	public static LazySingletonObject getInstance() {
		if(instance == null) {
			instance = new LazySingletonObject();
		}
		return instance;
	}
	
	public String getDataBag() {
		return "Inside LazySingletonObject";
	}
}

public class SingletonDesignPatterns {
	public static void main(String[] args) {
		DesignPatternBean bean = new DesignPatternBean();
		bean.setDesignPatternBean("Java bean");
		System.out.println("Design Pattern Bean is a "+bean.getDesignPatternBean());
		
		EagerSingletonObject eagerObj = EagerSingletonObject.getInstance();
		System.out.println("LazySingletonObject is a "+eagerObj.getDataBag());
		
		LazySingletonObject lazyObj = LazySingletonObject.getInstance();
		System.out.println("LazySingletonObject is a "+lazyObj.getDataBag());
	}
}
