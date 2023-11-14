
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String



def static "vipreQA.CommonMethods.ClickNewObj"(
    	TestObject to	
     , 	int timeout	) {
    (new vipreQA.CommonMethods()).ClickNewObj(
        	to
         , 	timeout)
}


def static "vipreQA.CommonMethods.LoginToSalesforce"(
    	String URL	
     , 	String username	
     , 	String password	) {
    (new vipreQA.CommonMethods()).LoginToSalesforce(
        	URL
         , 	username
         , 	password)
}


def static "vipreQA.CommonMethods.LoginasUser"(
    	String Username	) {
    (new vipreQA.CommonMethods()).LoginasUser(
        	Username)
}


def static "vipreQA.CommonMethods.AccountCreation"(
    	String AccountRecordType	
     , 	String AccountName	
     , 	String BillingCountry	
     , 	String BillingStreet	
     , 	String BillingCity	
     , 	String PostalCode	
     , 	String RegNo	
     , 	String SalesTerritory	) {
    (new vipreQA.CommonMethods()).AccountCreation(
        	AccountRecordType
         , 	AccountName
         , 	BillingCountry
         , 	BillingStreet
         , 	BillingCity
         , 	PostalCode
         , 	RegNo
         , 	SalesTerritory)
}


def static "vipreQA.CommonMethods.ContactCreation"(
    	String Salutation	
     , 	String FirstName	
     , 	String LastName	
     , 	String Email	
     , 	String Ph	
     , 	String Title	
     , 	String AccountName	) {
    (new vipreQA.CommonMethods()).ContactCreation(
        	Salutation
         , 	FirstName
         , 	LastName
         , 	Email
         , 	Ph
         , 	Title
         , 	AccountName)
}
