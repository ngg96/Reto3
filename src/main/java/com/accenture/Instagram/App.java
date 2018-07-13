package com.accenture.Instagram;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class App {

	public static AppiumDriver<MobileElement> driver; //Este driver es el que contralara los eventos de la automatizacion
	DesiredCapabilities capabilities = new DesiredCapabilities(); //caracteristicas de la automatizacion

	@BeforeMethod
	public void setUpAppium() throws MalformedURLException, InterruptedException {
		// package calculadora = "com.instagram.android"
		String packagename = "de.underflow.calc"; //Paquete principal de la aplicacion a automatizar
		String URL = "http://127.0.0.1:4723/wd/hub"; //IP y puerto de Appium
		// activity calculadora = "com.instagram.mainactivity.MainActivity"
		String activityname = "de.underflow.calc.CalculatorMainActivity"; //Nombre de la actividad (o vista) en donde empezara la automatizacion
		capabilities.setCapability("deviceName", "Moto G (5) Plus"); //No es obligatorio que este nombre coincida
		capabilities.setCapability("udid", "ZY224MR8QJ"); //Serial del dispositivo, se obtiene activando la depuración USB y con el comando adb devices
		capabilities.setCapability("platformVersion", "7.0"); //No es obligatorio que la version coincida
		capabilities.setCapability("platformName", "Android"); //Nombre del sistema operativo
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activityname);
		driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@AfterTest
	public void CleanUpAppium() {
		driver.quit();
	}

	@Test
	public void mytest() throws InterruptedException, IOException {
		String dataPath = "C:\\Users\\nicolas.a.gutierrez\\Desktop\\Folders\\Appium.xlsx";
		ArrayList<Transformation> IDs = NumericToId(dataPath);
		
		try {
				
			for(int i=0;i<IDs.size();i++) {
				Thread.sleep(2000);
				// hacer click boton2
				MobileElement val1 = driver.findElement(By.id(IDs.get(i).getValue1()));
				//System.out.println(IDs.get(i).getValue1());
				val1.click();
				
				// hacer click boton mas( +)
				MobileElement ope = driver.findElement(By.id(IDs.get(i).getOperation()));
				//System.out.println(IDs.get(i).getOperation());
				ope.click();
				
				
				// hacer click boton9
				MobileElement val2 = driver.findElement(By.id(IDs.get(i).getValue2()));
				//System.out.println(IDs.get(i).getValue2());
				val2.click();
	
				// hacer click boton mas( +)
				MobileElement igual = driver.findElement(By.id("de.underflow.calc:id/Equals"));
				igual.click();
			}

		} catch (Exception e) {
			System.out.print("Se presento Excepción " + e);
		}
	}
	
	public ArrayList<Transformation> NumericToId(String dataPath) throws IOException{
		
		ExcelData Excel = new ExcelData();
		ArrayList<Informacion> AllData = Excel.getData(dataPath);
		ArrayList<Transformation> IDs = new ArrayList<>(AllData.size());
		
		for(Informacion info : AllData) {
			
			Transformation transformation = new Transformation();
			
			transformation.setValue1(transformsVal((int)info.getValue1()));
			transformation.setValue2(transformsVal((int)info.getValue2()));
			transformation.setOperation(transformOpe(info.getOperation()));
			
			IDs.add(transformation);
		}
		
		return IDs;
		
	}
	
	public String transformsVal(int number) {
		
		String id = "";
		
		switch (number) {
			case 0:
				id = "de.underflow.calc:id/Zero";
				break;
			
			case 1:
				id = "de.underflow.calc:id/One";
				break;
			
			case 2:
				
				id ="de.underflow.calc:id/Two";
				
			break;
			
			case 3:
				
				id = "de.underflow.calc:id/Three";
				
			break;
			
			case 4:
				
				id = "de.underflow.calc:id/Four";
				
			break;
			
			case 5:
				
				id = "de.underflow.calc:id/Five";
				
			break;
			
			case 6:
				
				id = "de.underflow.calc:id/Six";
				
			break;
			
			case 7:
				
				id = "de.underflow.calc:id/Seven";
				
			break;
	
			case 8:
				
				id = "de.underflow.calc:id/Eight";
				
			break;
			
			case 9:
				
				id = "de.underflow.calc:id/Nine";
				
			break;
		}
		
		return id;
	}
	
	public String transformOpe(String ope) {
		
		String id = "";
		
		switch(ope) {
		
		case "+":
			
			id = "de.underflow.calc:id/Plus";
			
		break;
		
		case "-":
			
			id = "de.underflow.calc:id/Minus";
			
		break;
		
		case "*":
			
			id = "de.underflow.calc:id/Multiply";
			
		break;
		
		case "/":
			
			id = "de.underflow.calc:id/Divide";
			
		break;

	}
		
		
		return id;
		
	}
}
