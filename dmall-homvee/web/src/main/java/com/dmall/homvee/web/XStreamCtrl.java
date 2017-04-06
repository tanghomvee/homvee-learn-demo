package com.dmall.homvee.web;

import com.thoughtworks.xstream.XStream;

/**
 * @Package: com.dmall.homvee.web
 * @Description: TODO
 * @date:2016/4/12
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class XStreamCtrl extends BaseController {

    public static void main(String[] args) {
        String xml="<data><a><a1></a1><a2></a2></a><b><b1></b1><b2></b2></b></data>";
        XStream xStream =new XStream();
    }
}
