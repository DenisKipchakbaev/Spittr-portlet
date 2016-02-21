package me.kipchakbaev.liferay.spittr.controller;

import javax.portlet.ActionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import me.kipchakbaev.liferay.spittr.Spittle;
import me.kipchakbaev.liferay.spittr.controller.keys.Views;
import me.kipchakbaev.liferay.spittr.data.SpittleRepository;

@Controller
@RequestMapping("VIEW")
@SessionAttributes(value="spittle")
public class SpittleController {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(SpittleController.class);
	
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	@RenderMapping(params = "render=spittles-view")
	public String spittles(Model model) {
		LOGGER.info("spittles-view");
		if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Spittles view");
        }
		model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		model.addAttribute("spittle", new Spittle());
		return Views.SPITTLES_VIEW;
	}
	
	/*@ModelAttribute("spittle")
	public Spittle getCommandObject() {
		LOGGER.info("modelattribute");
		return new Spittle();
	}*/
	
	/*@InitBinder("spittle")
	public void initBinder(WebDataBinder binder) {
		LOGGER.info("init binder");
		//binder.registerCustomEditor(Long.class, new LongNumberPropertyEditor());
	}*/
	
	@ActionMapping(params = "action=submit-spittle")
	public void saveSpittle(@ModelAttribute("spittle") Spittle spittle, 
			ActionResponse response, Model model, SessionStatus sessionStatus) {
		
		LOGGER.info("action save spittle");
		LOGGER.info(spittle.getMessage());
		
		spittleRepository.save(spittle);
		sessionStatus.setComplete();
		response.setRenderParameter("render", "spittles-view");
		
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Action one");
		}
	}

}
