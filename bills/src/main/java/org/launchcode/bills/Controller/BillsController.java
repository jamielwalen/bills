package org.launchcode.bills.Controller;

import org.launchcode.bills.Models.Bills;
import org.launchcode.bills.Models.BillsMonth;
import org.launchcode.bills.Models.Data.BillsDao;
import org.launchcode.bills.Models.Data.BillsMonthDao;
import org.launchcode.bills.Models.Data.MonthsDao;
import org.launchcode.bills.Models.Data.RecordsDao;
import org.launchcode.bills.Models.Months;
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
@RequestMapping(value = "bills")
public class BillsController {

        @Autowired
        private BillsDao billsDao;

        @Autowired
        private RecordsDao recordsDao;

        @Autowired
        private BillsMonthDao billsMonthDao;

        @Autowired
        private MonthsDao monthsDao;

        @RequestMapping(value = "", method = RequestMethod.GET)
        public String monthlyBillFormAdd(Model model) {

                model.addAttribute("title", "Bills");
                model.addAttribute("bills", billsDao.findAll());
                model.addAttribute(new BillsMonth());


                return "bills/index";
        }

        @RequestMapping(value = "", method = RequestMethod.POST)
        public String processAddMonthlyBillForm(@ModelAttribute @Valid BillsMonth monthlyBill,
                                         Errors errors, Model model) {


                if (errors.hasErrors()) {
                        model.addAttribute("title", "Bills");
                        return "bills/index";
                }

                model.addAttribute("monthlyBill", monthlyBill);
                billsMonthDao.save(monthlyBill);
                return "redirect:";
        }


        @RequestMapping(value = "add", method = RequestMethod.GET)
        public String displayAddBillForm(Model model) {
                model.addAttribute("title", "Add Bill");
                model.addAttribute(new Bills());
                return "bills/add";
        }

        @RequestMapping(value = "add", method = RequestMethod.POST)
        public String processAddBillForm(@ModelAttribute @Valid Bills newBill,
                                         Errors errors, Model model) {


                if (errors.hasErrors()) {
                        model.addAttribute("title", "Add Bill");
                        return "bills/add";
                }

                billsDao.save(newBill);
                return "redirect:";
        }

        @RequestMapping(value = "remove", method = RequestMethod.GET)
        public String displayRemoveBillForm(Model model) {
                model.addAttribute("bills", billsDao.findAll());
                model.addAttribute("title", "Remove Bill");
                return "bills/remove";
        }

        @RequestMapping(value = "remove", method = RequestMethod.POST)
        public String processRemoveBillForm(@RequestParam Integer[] billsIds) {

                for (Integer billId : billsIds) {
                        billsDao.deleteById(billId);
                }

                return "redirect:";
        }



}
