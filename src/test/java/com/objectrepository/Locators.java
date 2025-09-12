package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	 public static By homeLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/a");
	 public static By innerLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/div/div[2]/a");
	 public static By googleLoginBtn = By.xpath("//*[@id=\"my-signin2\"]/div/div");
	 public static By phonenumber = By.xpath("//*[@id=\"emailOrMobile\"]");
	 public static By nextbtn = By.id("btnStep1");
	 public static By captacha = By.xpath("//*[@id=\"captchaCodeSignIn\"]");
	 public static By otp1 = By.id("verify01");
	 public static By otp2 = By.id("verify02");
	 public static By otp3 = By.id("verify03");
	 public static By otp4 = By.id("verify04");
     public static By continuebtn = By.xpath("//*[@id=\"verifyOtpDiv\"]/div[2]/div[3]/button");
     public static By closepopup = By.xpath("//*[@id=\"userOnboardingWidget\"]/div/div[1]");
     
     // for enter the location
   
     public static By clickLocation = By.xpath("//*[@id=\"keyword\"]");
     public static By closedefault = By.xpath("//*[@id=\"keyword_autoSuggestSelectedDiv\"]/div/div[2]");
     public static By selectdropdownLocation = By.xpath("//*[@id=\"serachSuggest\"]/div[3]");
     
     // selecting propertytype
     public static By clearPropertyType = By.xpath("//*[@id=\"propType_buy\"]/div[2]/div/div/div[1]/div[2]/div[4]");
     public static By clickPropertType = By.id("propType_buy");
     public static By dropdownProperType = By.xpath("//*[@id=\"propType_buy\"]/div[1]");
     public static By selectPropertyType = By.id("10002_10003_10021_10022");
     public static By closePropertyType = By.xpath("//*[@id=\"buy_proertyTypeDefault\"]");
     
     //selecting budget
     public static By clickBudget = By.xpath("//*[@id=\"rent_budget_lbl\"]");
     public static By mindropdown=By.xpath("//*[@id=\"budgetMin\"]");
     public static By maxdropdown=By.xpath("//*[@id=\"budgetMax\"]");
     public static By closeBudget = By.xpath("//*[@id=\"rent_budget_lbl\"]");
     public static By searchButton = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[4]");
     
     //sort property
     public static By sortBy = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div");
     public static By mostrecent = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div/div[2]/ul/li[6]");
     
     //shortlist property
     public static By shortlistButton = By.xpath("//*[@id=\"cardid80311141\"]/div/div[1]/div[2]/span[2]");
     public static By mainshortlistbtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/span");
     public static By viewShortlistBtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/div/div/a");
     public static By shortlistedPropertyCard = By.xpath("//*[@id=\"cardid80311141\"]/div[2]");
     public static By shortlistTabHeader = By.xpath("//*[@id=\"m-tab-Shortlisted\"]");
     
     public static By contactagent = By.xpath("//*[@id=\"contactRightInfo\"]");
     
     public static By clickEmi = By.xpath("//*[@id=\"details\"]/div/div[1]/a[1]");
     public static By magicLoans = By.xpath("/html/body/div/div[4]/div[1]/div/div/div[1]/div");
     public static By clearAmount = By.xpath("//*[@id=\"amountRequiredEmiCal\"]");
     public static By loanAmount = By.xpath("//*[@id=\"amountRequiredEmiCal\"]");
     public static By loanTenure = By.xpath("/html/body/div/div[4]/div[1]/div/div/div[1]/form/div[2]/div[1]/div");
     public static By dropdownloanTenure = By.xpath("//*[@id=\"loan-tenure_Emi\"]/li[6]");
     public static By clearinterestRate = By.xpath("//*[@id=\"interestRateEmiCal\"]");
     public static By interestRate = By.xpath("//*[@id=\"interestRateEmiCal\"]");
     //public static By clickNo = By.xpath("/html/body/div/div[4]/div[1]/div/div/div[1]/form/div[3]/div[2]/div[2]/label");
     //public static By dropdownCity = By.xpath("/html/body/div/div[4]/div[1]/div/div/div[1]/form/div[4]/div[1]/label");
     //public static By selectCity = By.xpath("//*[@id=\"4320\"]");
     public static By recalculateEmi = By.xpath("//*[@id=\"submitbuttonEmiCalid\"]");
     public static By eligibleEmiAmount = By.xpath("//*[@id=\"emiResultSection\"]/div/div[1]/div[1]");
     
     public static By crossloc =By.xpath("//*[@id=\"keyword_autoSuggestSelectedDiv\"]/div/div[2]");
     
     //invalid emi calculator
     public static By clickHomenloan = By.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[4]/a");
     public static By clickEmicalculator = By.xpath("//*[@id=\"homeloanDrop\"]/div/div[3]/ul/li[1]/a");
     public static By clearAmount1 = By.xpath("//*[@id=\"amountRequiredEmiCal\"]");
     public static By loanAmount1 = By.xpath("//*[@id=\"amountRequiredEmiCal\"]");
     public static By loanAmountError = By.xpath("//*[@id=\"amountRequiredEmiCalError\"]");
     public static By interestRate1 = By.xpath("//*[@id=\"interestRateEmiCal\"]");
     public static By interestRateError = By.xpath("//*[@id=\"interestRateEmiCalError\"]");
     
     
}