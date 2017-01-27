package org.intro;

public class FactoryDesignPatterns {

	interface Mobile {
		void getScreenSize();
	}

	class Android implements Mobile {
		
		public void getScreenSize() {
			System.out.println("400 by 600");
		}
	}
	
	class Apple implements Mobile {
		public void getScreenSize() {
			System.out.println("440 by 600");
		}		
	}

	class MobileFactory {
		
		public Mobile getMobile(String mobileType) {
			
			if(mobileType==null) {
				return null;
			}
			
			if(mobileType.equalsIgnoreCase("Android")) {
				return new Android();
			}
			
			if(mobileType.equalsIgnoreCase("Apple")) {
				return new Apple();
			}	
			
			return null;
		}
	}
	
	MobileFactory mobilefactory = new MobileFactory();
	
	public static void main(String[] args) {
		
		FactoryDesignPatterns app = new FactoryDesignPatterns();
		
		Mobile shape1 = app.mobilefactory.getMobile("Android");
		shape1.getScreenSize();
		
		Mobile shape2 = app.mobilefactory.getMobile("Apple");
		shape2.getScreenSize();
		
	}
}
