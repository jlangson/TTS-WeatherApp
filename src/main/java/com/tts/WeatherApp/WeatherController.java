package com.tts.WeatherApp;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
        @Autowired
        private ZipCodeRepository zipCodeRepository;
	
	@GetMapping
	public String getIndex(Model model) {
		model.addAttribute("request", new Request());
                List<ZipCode> tenMostRecentZipCodes =  zipCodeRepository.findTenMostRecentZipCodes(); //what is this when there are no entries?
                model.addAttribute("zipcodes", tenMostRecentZipCodes);
		return "index";
	}
	
	@PostMapping
	public String postIndex(Request request, Model model) {
		Response data = weatherService.getForecast(request.getZipCode()); //this service also saves the zipcode. Bad practice.
		model.addAttribute("data", data);
                List<ZipCode> tenMostRecentZipCodes =  zipCodeRepository.findTenMostRecentZipCodes();
                model.addAttribute("zipcodes", tenMostRecentZipCodes);
		return "index";
	}
	
}
