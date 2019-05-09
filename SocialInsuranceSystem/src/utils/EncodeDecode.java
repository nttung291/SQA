/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author nttungg
 */
public class EncodeDecode {
    
    public static String encodeString(String text)
           throws UnsupportedEncodingException {
       
       byte[] bytes = text.getBytes("UTF-8");
       
       String encodeString = Base64.encode(bytes);
       return encodeString;
   }
 
   // Giải mã hóa một đoạn text (Đã mã hóa trước đó).
   // Decode
   public static String decodeString(String encodeText)
           throws UnsupportedEncodingException {
       
       byte[] decodeBytes = Base64.decode(encodeText);
      
       String str = new String(decodeBytes, "UTF-8");
       return str;
   }
   
}
