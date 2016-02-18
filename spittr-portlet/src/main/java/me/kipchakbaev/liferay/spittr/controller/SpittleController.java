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
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import me.kipchakbaev.liferay.spittr.Spittle;
import me.kipchakbaev.liferay.spittr.controller.keys.Views;
import me.kipchakbaev.liferay.spittr.data.SpittleRepository;

@Controller
@RequestMapping("VIEW")
@SessionAttributes(value="book")
public class SpittleController {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(HomeController.class);
	
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
		return Views.SPITTLES_VIEW;
	}
	
	@ModelAttribute("spittle")
	public Spittle getCommandObject() {
		return new Spittle();
	}
	
	@InitBinder("spittle")
	public void initBinder(WebDataBinder binder) {
		//binder.registerCustomEditor(Long.class, new LongNumberPropertyEditor());
	}
	
	/*@RequestMapping(method=RequestMethod.POST)
	public String saveSpittle(SpittleForm form, Model model) throws Exception {
		spittleRepository.save(new Spittle(null, form.getMessage(), new Date(), 
				form.getLongitude(), form.getLatitude()));
		return "redirect:/spittles";
	}*/
	
	@ActionMapping(params = "action=submit-spittle")
	public void saveSpittle(@ModelAttribute(value="spittle") Spittle spittle, BindingResult bindingResult, ActionResponse response) {
		LOGGER.info("action save spittle");
		LOGGER.info(spittle);
		spittleRepository.save(spittle);
		response.setRenderParameter("render", "spittles-view");
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Action one");
		}
	}

}
