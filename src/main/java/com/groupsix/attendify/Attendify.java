package com.groupsix.attendify;

import com.google.zxing.WriterException;
import com.groupsix.attendify.ui.LoginFrame;
import java.io.IOException;

/**
 *
 * @author User
 */
public class Attendify {

    public static void main(String[] args) throws WriterException, IOException {
        LoginFrame loginObj = new LoginFrame();
        loginObj.show();
        
    }
}
