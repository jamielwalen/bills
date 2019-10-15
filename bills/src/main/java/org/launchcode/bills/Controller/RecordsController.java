package org.launchcode.bills.Controller;


import org.launchcode.bills.Models.Bills;
import org.launchcode.bills.Models.Data.BillsDao;
import org.launchcode.bills.Models.Data.RecordsDao;
import org.launchcode.bills.Models.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "records")
public class RecordsController {

    @Autowired
    private BillsDao billsDao;

    @Autowired
    private RecordsDao recordsDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Records");
        model.addAttribute("records", recordsDao.findAll());
        return "records/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddRecordForm(Model model) {
        model.addAttribute(new Records());
        model.addAttribute("title", "Add Record");
        return "records/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddRecordForm(@ModelAttribute @Valid Records newRecord,
                                     Errors errors, Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Record");
            return "records/add";
        }

        recordsDao.save(newRecord);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveRecordForm(Model model) {
        model.addAttribute("records", recordsDao.findAll());
        model.addAttribute("title", "Remove Record");
        return "records/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveBillForm(@RequestParam Integer[] recordsIds) {

        for (Integer recordId : recordsIds) {
            recordsDao.deleteById(recordId);
        }

        return "redirect:";
    }



}

