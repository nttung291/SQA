///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package view;
//
//import javax.swing.JButton;
//import model.Account;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author habui
// */
//public class RegisterContractIT {
//
//    public RegisterContractIT() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testCase2_TestBlankInput(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0118000001");
//
//        JButton button = registerContractFrm.getjButton1();
//        boolean isEnabled=button.isEnabled();
//        assertEquals(isEnabled, false);
//    }
//
//    @Test
//    public void testCase3_TestBlankInput(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0118000001");
//
//        JButton button = registerContractFrm.getjButton1();
//        boolean isEnabled=button.isEnabled();
//        assertEquals(isEnabled, true);
//    }
//    @Test
//    public void testCase4_6_11_17_19_TestCorrectInput(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0118000001");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "No Message");
//    }
//    @Test
//    public void testCase5_TestInCorrectNameInput(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha$Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0118000001");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "This name field must not contain any special character, please check your input again");
//    }
//    @Test
//    public void testCase7_TestCorrectIDNumber_BoundaryTesting(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("000000000");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0118000001");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "No Message");
//    }
//    @Test
//    public void testCase8_TestCorrectIDNumber_BoundaryTesting(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("999999999");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0118000001");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "No Message");
//    }
//    @Test
//    public void testCase9_TestInCorrectIDNumber_BoundaryTesting(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("-000000001");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0118000001");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "This field must equal 9 integer numbers from 000000000 to 999999999, please check your input again");
//    }
//    @Test
//    public void testCase10_TestInCorrectIDNumber_BoundaryTesting(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("1000000000");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0118000001");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "This field must equal 9 integer numbers from 000000000 to 999999999, please check your input again");
//    }
//    @Test
//    public void testCase12_TestInCorrectSocialInsuranceNumber(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("1318000001");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "Two first number must represent for a specific provincial, please check your input again");
//    }
//    @Test
//    public void testCase13_TestCorrectSocialInsuranceNumber_BoundaryTesting(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0100000000");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "No Message");
//    }
//    @Test
//    public void testCase14_TestCorrectSocialInsuranceNumber_BoundaryTesting(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("9499999999");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "No Message");
//    }
//    @Test
//    public void testCase15_TestInCorrectSocialInsuranceNumber_BoundaryTesting(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("0099999999");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "This field must equal 10 integer numbers from 010000000 to 949999999, please check your input again");
//    }
//    @Test
//    public void testCase16_TestInCorrectSocialInsuranceNumber_BoundaryTesting(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha@gmail.com");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("9500000000");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "This field must equal 10 integer numbers from 010000000 to 949999999, please check your input again");
//    }
//
//    @Test
//    public void testCase18_TestInCorrectEmailInput(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("84858171297");
//        registerContractFrm.setTfSINumber("9500000000");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "This email field must match with an email domain name server or existed, please check your input again");
//    }
//
//    @Test
//    public void testCase20_TestInCorrectPhoneNumberInput(){
//        RegisterContractFrame registerContractFrm=new RegisterContractFrame();
//        registerContractFrm.setTfName("Ha Bui");
//        registerContractFrm.setTfEmail("hb.buimanhha");
//        registerContractFrm.setTfIDNumber("061092688");
//        registerContractFrm.setTfPhoneNumber("9185815064");
//        registerContractFrm.setTfSINumber("9500000000");
//        String msg=registerContractFrm.getLbMessage();
//        assertEquals(msg, "This phone number field is not in Vietnam telephone service, please check your input again");
//    }
//
//    @Test
//    public void testCase21_TestBlankInputCompulsoryFrm(){
//        CompulsoryFrame compulsoryFrm=new CompulsoryFrame();
//        compulsoryFrm.setTfCompany("0118000001");
//        compulsoryFrm.setTfSalary("50000");
//        compulsoryFrm.setTfTax("0118000001001");
//        JButton button = compulsoryFrm.getjButton1();
//        boolean isEnabled=button.isEnabled();
//        assertEquals(isEnabled, false);
//    }
//
//    @Test
//    public void testCase22_23_29_TestCorrectInputCompulsoryFrm(){
//        CompulsoryFrame compulsoryFrm=new CompulsoryFrame();
//        compulsoryFrm.setTfCompany("0118000001");
//        compulsoryFrm.setTfSalary("5000000");
//        compulsoryFrm.setTfTax("0118000001001");
//        JButton button = compulsoryFrm.getjButton1();
//        boolean isEnabled=button.isEnabled();
//        assertEquals(isEnabled, true);
//    }
//
//    @Test
//    public void testCase24_TestInCorrectTaxCodeNumber(){
//        CompulsoryFrame compulsoryFrm=new CompulsoryFrame();
//        compulsoryFrm.setTfCompany("0118000001");
//        compulsoryFrm.setTfSalary("5000000");
//        compulsoryFrm.setTfTax("1318000001001");
//        String msg=compulsoryFrm.getLbMessage();
//        assertEquals(msg, "Two first number must represent for a specific provincial and three last number from 001 to 999, please check your input again");
//    }
//
//    @Test
//    public void testCase25_TestCorrectTaxCodeNumber_BoundaryTesting(){
//        CompulsoryFrame compulsoryFrm=new CompulsoryFrame();
//        compulsoryFrm.setTfCompany("0118000001");
//        compulsoryFrm.setTfSalary("5000000");
//        compulsoryFrm.setTfTax("0100000000001");
//        String msg=compulsoryFrm.getLbMessage();
//        assertEquals(msg, "No message");
//    }
//    @Test
//    public void testCase26_TestCorrectTaxCodeNumber_BoundaryTesting(){
//        CompulsoryFrame compulsoryFrm=new CompulsoryFrame();
//        compulsoryFrm.setTfCompany("0118000001");
//        compulsoryFrm.setTfSalary("5000000");
//        compulsoryFrm.setTfTax("9499999999999");
//        String msg=compulsoryFrm.getLbMessage();
//        assertEquals(msg, "No message");
//    }
//    @Test
//    public void testCase27_TestInCorrectTaxCodeNumber_BoundaryTesting(){
//        CompulsoryFrame compulsoryFrm=new CompulsoryFrame();
//        compulsoryFrm.setTfCompany("0118000001");
//        compulsoryFrm.setTfSalary("5000000");
//        compulsoryFrm.setTfTax("0099999999999");
//        String msg=compulsoryFrm.getLbMessage();
//        assertEquals(msg, "This field must equal 13 integer numbers from 010000000001 to 949999999999 and contain two first number must represent for a specific provincial , please check your input again");
//    }
//    @Test
//    public void testCase28_TestInCorrectTaxCodeNumber_BoundaryTesting(){
//        CompulsoryFrame compulsoryFrm=new CompulsoryFrame();
//        compulsoryFrm.setTfCompany("0118000001");
//        compulsoryFrm.setTfSalary("5000000");
//        compulsoryFrm.setTfTax("9500000000000");
//        String msg=compulsoryFrm.getLbMessage();
//        assertEquals(msg, "This field must equal 13 integer numbers from 010000000001 to 949999999999 and contain two first number must represent for a specific provincial , please check your input again");
//    }
//    @Test
//    public void testCase46_TestCostOfCompulsoryInsurance(){
//        CompulsoryFrame compulsoryFrm=new CompulsoryFrame();
//        compulsoryFrm.setTfCompany("0118000001");
//        compulsoryFrm.setTfSalary("5000000");
//        compulsoryFrm.setTfTax("9500000000000");
//        ConfirmCompulsoryFrame confirmFrm=compulsoryFrm.getConfirmCompulsoryFrame();
////        confirmFrm.
////
////        String msg=compulsoryFrm.getLbMessage();
////        assertEquals(msg, "");
//    }
//}
