package Assignments;

public class day19_xpathAxes2 {

	public static void main(String[] args) {
	
//1. find signup button from the reg form from facebook(child)
			
		//div[@id='reg_form_box']/child::div[11]/button
		
//2.Locate firstname field from signUp button  in facebook(Parent)
		
		//button[@id='u_0_s_g4']/parent::*/parent::*/child::div[1]/div/div[1]
		
//3.Identify the password from mobile number filled in facebook (Following)
		
		//input[@id='u_0_g_W4']/following::input
		
//4. Locate Mobile Number from new Password field in facebook(Preceding)
		//input[@id='password_step_input']/preceding::input[2]
		
//5. Locate surname from female radio button in facebook(Ancestor)
		//input[@id='u_0_2_ar']/ancestor::div[2]/div[1]/div/div[2]
		//input[@id='u_0_2_ar']/ancestor::div[2]//input[@id='u_0_d_t/']

//6. Identify the search text box from the google search button present in the Google Search home page (parent)

		//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']/parent::*/parent::*/parent::*/div[1]
		
//7. Identify today deals link from amazon search text box {Following]
		//input[@id='twotabsearchtextbox']/following::a[@href='/deals?ref_=nav_cs_gb']
		
//8. Identify Hello, signin  from aamzon search box [following]
		//input[@id='twotabsearchtextbox']/following::span[@id='nav-link-accountList-nav-line-1']		

//9. Identify mobile link  which is part of menu bar -amazon  {Descendant) 	
		//div[@id='nav-xshop']//descendant::a[normalize-space()='Mobiles']
		
	}

}
