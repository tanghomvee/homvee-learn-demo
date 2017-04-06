package com.homvee.web.common;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * @Package: com.homvee.web.common
 * @Description: TODO
 * @date:2016/11/4
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class VelocityToolboxLayoutView extends VelocityLayoutView {

    private static ToolContext toolContext = null;

    @Override
    protected  Context createVelocityContext(Map model, HttpServletRequest request, HttpServletResponse response) {
        if(toolContext == null) {
           initToolContext();
        }
        VelocityContext context = new VelocityContext(toolContext);
        if(model != null) {
            for(Map.Entry<String, Object> entry : (Set<Map.Entry<String, Object>>)model.entrySet()) {
                context.put(entry.getKey(), entry.getValue());
            }
        }
        return context;
    }

    private synchronized void initToolContext(){
        if(toolContext == null) {
            ToolManager velocityToolManager = new ToolManager();
            String toolPath = getToolboxConfigLocation();
            velocityToolManager.configure(toolPath);
            toolContext = velocityToolManager.createContext();
        }
    }
}
