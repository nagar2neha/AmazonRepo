package TestDataClass;

import BaseClass.TestBase;

public class DataFile extends TestBase{
	
	Xls_Reader r = new Xls_Reader("C:\\QA\\Testing\\SignupTestData.xlsx");
	public String Name = r.getCellData("Sheet1", "Name", 3);
	public String PhoneorEmail = r.getCellData("Sheet1", "Mobile No or email", 3);
	public String password = r.getCellData("Sheet1", "Password", 4);
	public String passwordagain = r.getCellData("Sheet1", "Password Again", 4);
    public String passwordErr = r.getCellData("Sheet1", "Error", 3);
    public String mismatchErr = r.getCellData("Sheet1", "Error", 4);
    public String userExistErr = r.getCellData("Sheet1", "Error",5);
}
