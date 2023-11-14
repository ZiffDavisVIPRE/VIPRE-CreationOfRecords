package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object URL
     
    /**
     * <p></p>
     */
    public static Object Username
     
    /**
     * <p></p>
     */
    public static Object Password
     
    /**
     * <p></p>
     */
    public static Object min_timeout
     
    /**
     * <p></p>
     */
    public static Object max_timeout
     
    /**
     * <p></p>
     */
    public static Object AccountName
     
    /**
     * <p></p>
     */
    public static Object VIPRE_User
     
    /**
     * <p></p>
     */
    public static Object ExcelMicro_User
     
    /**
     * <p></p>
     */
    public static Object ExcelMicro_AccountType
     
    /**
     * <p></p>
     */
    public static Object VIPRE_AccountType
     
    /**
     * <p></p>
     */
    public static Object EXM_SalesTerritory
     
    /**
     * <p></p>
     */
    public static Object VIPRE_SalesTerritory
     
    /**
     * <p></p>
     */
    public static Object BillingCountry
     
    /**
     * <p></p>
     */
    public static Object BillingStreet
     
    /**
     * <p></p>
     */
    public static Object BillingCity
     
    /**
     * <p></p>
     */
    public static Object PostalCode
     
    /**
     * <p></p>
     */
    public static Object RegNo
     
    /**
     * <p></p>
     */
    public static Object Salutation
     
    /**
     * <p></p>
     */
    public static Object FirstName
     
    /**
     * <p></p>
     */
    public static Object LastName
     
    /**
     * <p></p>
     */
    public static Object Email
     
    /**
     * <p></p>
     */
    public static Object Phone
     
    /**
     * <p></p>
     */
    public static Object Title
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            URL = selectedVariables['URL']
            Username = selectedVariables['Username']
            Password = selectedVariables['Password']
            min_timeout = selectedVariables['min_timeout']
            max_timeout = selectedVariables['max_timeout']
            AccountName = selectedVariables['AccountName']
            VIPRE_User = selectedVariables['VIPRE_User']
            ExcelMicro_User = selectedVariables['ExcelMicro_User']
            ExcelMicro_AccountType = selectedVariables['ExcelMicro_AccountType']
            VIPRE_AccountType = selectedVariables['VIPRE_AccountType']
            EXM_SalesTerritory = selectedVariables['EXM_SalesTerritory']
            VIPRE_SalesTerritory = selectedVariables['VIPRE_SalesTerritory']
            BillingCountry = selectedVariables['BillingCountry']
            BillingStreet = selectedVariables['BillingStreet']
            BillingCity = selectedVariables['BillingCity']
            PostalCode = selectedVariables['PostalCode']
            RegNo = selectedVariables['RegNo']
            Salutation = selectedVariables['Salutation']
            FirstName = selectedVariables['FirstName']
            LastName = selectedVariables['LastName']
            Email = selectedVariables['Email']
            Phone = selectedVariables['Phone']
            Title = selectedVariables['Title']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
