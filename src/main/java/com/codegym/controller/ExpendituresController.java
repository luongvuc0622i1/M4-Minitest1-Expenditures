package com.codegym.controller;

import com.codegym.model.Expenditures;
import com.codegym.model.ExpendituresForm;
import com.codegym.service.expenditures.IExpendituresService;
import com.codegym.service.expenditures.ExpendituresService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/expenditures")
public class ExpendituresController {
    private final IExpendituresService expendituresService = new ExpendituresService();

    @GetMapping("")
    public String index(Model model) {
        List<Expenditures> expenditures = expendituresService.findAll();
        model.addAttribute("expenditures", expenditures);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("expendituresForm", new ExpendituresForm());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ExpendituresForm expendituresForm) {
        MultipartFile multipartFile = expendituresForm.getExpenditures_image();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(expendituresForm.getExpenditures_image().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Expenditures expenditures = new Expenditures(expendituresForm.getExpenditures_id(), expendituresForm.getExpenditures_name(),
                expendituresForm.getExpenditures_money(), expendituresForm.getExpenditures_description(), expendituresForm.getListExpenditure(), fileName);
        expendituresService.save(expenditures);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("expendituresForm", expendituresForm);
        modelAndView.addObject("message", "Created new expenditures successfully !");
        return modelAndView;
    }
}
