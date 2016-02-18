package me.kipchakbaev.liferay.spittr.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import me.kipchakbaev.liferay.spittr.controller.keys.Views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

/**
 * 
 * @author <a href="mailto:kipchakbaev@gmail.com">Denis Kipchakbaev</a>
 *
 */
@Controller
@RequestMapping("VIEW")
public class HomeController {
    private static final Log LOGGER = LogFactoryUtil.getLog(HomeController.class);

    @RenderMapping
    public String defaultView() {
    	if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Default View");
        }

        return Views.DEFAULT_VIEW;
    }
    
    @RenderMapping(params = "render=registration-view")
    public String registrationView() {
    	LOGGER.info("Registration-view");
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Registration view");
        }

        return Views.REGISTRATION_VIEW;
    }
}