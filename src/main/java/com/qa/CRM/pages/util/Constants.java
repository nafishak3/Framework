package com.qa.CRM.pages.util;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String LOGIN_PAGE_TITLE="Free CRM - CRM software for customer relationship management, sales, and support.";
    public static final String ALL_PAGE_TITLE ="CRMPRO";
    public static final String HOME_PAGE_CONTACTS= "CONTACTS";
    public static final String HOME_PAGE_SETUPICON= "  Setup   ";
    public static final int LEFT_PAGE_HEADER = 23;
    public static final String ELEMENT_NOT_FOUND_ERROR_MESSG = "Element not found";
    public static final List<String> LIST_OF_HEADERS(){
        List<String> headerList = new ArrayList<>();
      headerList.add("no company loaded");
      headerList.add("Add Boxes»");
      headerList.add("«Shortlist");
      headerList.add("Quick Create»");
      headerList.add("Pipeline");
        return headerList;
    }
    public static final String DEEPTI_COMPANY_NAME = "Amazon";
    public static final String DEEPTI_MOBILE_NUMBER = "76589234";

    public static final String EXCEL_FILE_SHEET = "registration data";



//    public static List<String> leftHeaderList(){
//        List<String> headerList = new ArrayList<>();
//        headerList.add("no company loaded");
//        headerList.add("Add Boxes»");
//        headerList.add("«Shortlist");
//        headerList.add("Quick Create»");
//        headerList.add("Pipeline");
//        headerList.add("Timeline");
//        headerList.add("Alerts");
//        headerList.add("Messages");
//        headerList.add("Custom Views");
//        headerList.add("Schedule Call");
//        headerList.add("Call List");
//        headerList.add("Mail Accounts");
//        headerList.add("Products");
//        headerList.add("Promotions");
//        headerList.add("Resources");
//        headerList.add("Knowledge Base");
//        headerList.add("Team View");
//        headerList.add("Import");
//        headerList.add("Export");
//        headerList.add("Sales Targets");
//        headerList.add("Preferences");
//        headerList.add("Audit Trail");
//        headerList.add("Blog");
//        return headerList;
//    }



}
