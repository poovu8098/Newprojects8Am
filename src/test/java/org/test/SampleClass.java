package org.test;

public class SampleClass extends BaseClass {
	public static void main(String[] args) {
		 launchBrowser("chrome");
		  urlLaunch("https://www.facebook.com/");
		  implicitlywait(20);
		  LoginPagee l=new  LoginPagee();
		  sendkeys(l.getTxtUser(),"poosumi" );
		  sendkeys(l.getTxtPass(),"4858");
		click(l.getBtnLogin());
		  refresh();
		  sendkeys(l.getTxtUser(),"enthangam");
	}
	

}
