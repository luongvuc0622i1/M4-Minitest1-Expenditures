package com.codegym.controller;

import com.codegym.model.Expenditures;
import com.codegym.model.ExpendituresForm;
import com.codegym.service.expenditures.IExpendituresService;
import com.codegym.service.expenditures.ExpendituresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/expenditures")
public class ExpendituresController {
    @Autowired
    private IExpendituresService expendituresService;

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
                expendituresForm.getExpenditures_money(), expendituresForm.getExpenditures_description(), null, fileName);
        expendituresService.save(expenditures);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("expendituresForm", expendituresForm);
        modelAndView.addObject("message", "Created new expenditures successfully !");
        return modelAndView;
    }

    @GetMapping("/edit-expenditures/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Expenditures expenditures = expendituresService.findById(id);
        if (expenditures != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("expenditures", expenditures);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-expenditures")
    public ModelAndView updateCustomer(@ModelAttribute("expenditures") Expenditures expenditures) {
        expendituresService.save(expenditures);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("expenditures", expenditures);
        modelAndView.addObject("message", "Expenditures updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-expenditures/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Expenditures expenditures = expendituresService.findById(id);
        if (expenditures != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("expenditures", expenditures);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-expenditures")
    public String deleteCustomer(@ModelAttribute("expenditures") Expenditures expenditures) {
        expendituresService.remove(expenditures.getExpenditures_id());
        return "redirect:expenditures";
    }
}
